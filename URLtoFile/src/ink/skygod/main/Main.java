package ink.skygod.main;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("输入网址：");
            String URLStr = scanner.next().replace("i.pximg.net", "i.pixiv.re");
            //输入stop关闭程序
            if (URLStr.equalsIgnoreCase("stop")) {
                break;
            }

            System.out.println("开始下载...");
            try {
                downLoadFromURL(URLStr, System.getProperty("user.dir"));
            } catch (IOException e) {
                System.out.println("出错了！");
                throw new RuntimeException(e);
            }
            System.out.println("下载完成！");
        }
        System.out.println("已退出");
    }

    public static void downLoadFromURL(String urlStr, String savePath) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //超时时间3s
        conn.setConnectTimeout(3 * 1000);
        //防止因屏蔽程序抓取而返回403
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //输入流
        InputStream inputStream = conn.getInputStream();
        //获取文件名
        String[] strs = urlStr.split("/");
        String fileName = strs[strs.length - 1];
        System.out.println("文件：" + fileName);
        //获取数据
        byte[] getData = readInputStream(inputStream);

        //保存文件
        File file = new File(savePath + File.separator + fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if (fos != null) {
            fos.flush();
            fos.close();
        }
        if (inputStream != null) {
            inputStream.close();
            ;
        }
    }

    private static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
}
