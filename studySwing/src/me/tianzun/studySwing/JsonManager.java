package me.tianzun.studySwing;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class JsonManager {
    private static URL url;
    static{
try {
            url = new URL("https://api.lolicon.app/setu/v2");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    public static String getURL(){
        String stringJSON = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            //创建连接
            URLConnection urlConnection = url.openConnection();
            //打开输入
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            //一行数据
            String inputLine;
            while((inputLine = in.readLine()) != null){
                //将一行数据追加
                stringBuilder.append(inputLine);
            }
            stringJSON = stringBuilder.toString();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject mainJSON = JSON.parseObject(stringJSON);
        JSONArray data = mainJSON.getJSONArray("data");
        return ((JSONObject)data.get(0)).getJSONObject("urls").getString("original").replace("i.pixiv.cat","i.pixiv.re");
    }
}
