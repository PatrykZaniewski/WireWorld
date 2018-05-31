package gui.logic;

import java.util.ArrayList;

public class TemplateSelection {

    private ArrayList<int [][]> templateList = new ArrayList<>();
    private int [][] Array;

    public int [] [] getTemplate (int i)
    {
        return templateList.get(i);
    }

    public TemplateSelection()
    {
        Array = new int [28][31];

        String stringArray = "00000000000000000000000000000\n" +
                "01100111110011111001111100110\n" +
                "10031000003100000310000031003\n" +
                "01200111120011112001111200120\n" +
                "00000000000000000000000000000\n" +
                "01100111110011111001111100110\n" +
                "10031000003100000310000031003\n" +
                "01200111120011112001111200120\n" +
                "00000000000000000000000000000\n" +
                "01100111110011111001111100110\n" +
                "10031000003100000310000031003\n" +
                "01200111120011112001111200120\n" +
                "00000000000000000000000000000\n" +
                "01100111110011111001111100110\n" +
                "10031000003100000310000031003\n" +
                "01200111120011112001111200120\n" +
                "00000000000000000000000000000\n" +
                "01100111110011111001111100110\n" +
                "10031000003100000310000031003\n" +
                "01200111120011112001111200120\n" +
                "00000000000000000000000000000\n" +
                "01100111110011111001111100110\n" +
                "10031000003100000310000031003\n" +
                "01200111120011112001111200120\n" +
                "00000000000000000000000000000\n" +
                "00000000000000000000000000000\n";
                int pos = 0;
                for (int i = 1; i <= 26; i++)
                {
                    for (int j = 1; j <= 29; j++)
                    {
                        if(stringArray.charAt(pos) == '\n')pos++;
                        Array[i][j] = Integer.parseInt(String.valueOf(stringArray.charAt(pos)));
                        pos++;
                    }
                }
                templateList.add(Array);
    }


}
