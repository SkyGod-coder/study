package me.tianzun.studySwing;

public class Main {
    private static boolean flag = true;

    public static void setFlag(boolean flag) {
        Main.flag = flag;
    }

    public static boolean getFlag() {
        return flag;
    }

    public static void main(String[] args) {
        Window window = new Window("图片加载中...");
        window.setSize(500, 500);
        window.setVisible(true);
        while (flag) {
            flag = false;
            window.setStringURL(JsonManager.getURL());
            window.loadPhoto();
        }
        flag = true;
        window.setTitle("欣赏美图，心情愉悦");
    }
}
