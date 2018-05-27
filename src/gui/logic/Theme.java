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


    private static void returnTheme()
    {
        if(colorID == 0) colorName = "gray";
        else if (colorID == 1) colorName = "black";
        else if (colorID == 2) colorName = "white";
        else if (colorID == 3) colorName = "blue";
        else if (colorID == 4) colorName = "pink";
        else colorName = null;
    }
}
