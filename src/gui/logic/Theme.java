package gui.logic;

public class Theme {

    public static int getColorID() {
        return colorID;
    }

    public static void setColorID(int colorID) {
        Theme.colorID = colorID;
        Theme.returnTheme();
    }

    public static String getColorName() {
        return colorName;
    }


    private static int colorID;
    private static String colorName;

    public Theme(int colorID) {
        Theme.colorID = colorID;
    }


    private static void returnTheme()
    {
        if(colorID == 0) colorName = "pink";
        else if (colorID == 1) colorName = "black";
        else if (colorID == 2) colorName = "white";
        else if (colorID == 3) colorName = "blue";
        else if (colorID == 4) colorName = "gray";
        else colorName = null;
    }
}
