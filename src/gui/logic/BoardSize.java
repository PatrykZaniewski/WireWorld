package gui.logic;

public class BoardSize {

    private static int height;
    private static int width;
    private static boolean border;

    public static boolean getBorder() {
        return border;
    }

    public static void setBorder(boolean border) {
        BoardSize.border = border;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        BoardSize.height = height;
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        BoardSize.width = width;
    }
}
