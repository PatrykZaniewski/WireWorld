package gui.logic;

import java.util.ArrayList;

public class Simulation {
    private int [] [] basicArray;
    private static int amount;
    private static ArrayList<int [][]> lista = new ArrayList<>();
    public static int [] [] firstGen = new int [BoardSize.getHeight()+2][BoardSize.getWidth()+2];
    private boolean borderType;


    public static int getAmount() {
        return amount;
    }

    public static ArrayList<int[][]> getLista() {
        return lista;
    }

    public Simulation(int [][] basicArray, int amount, boolean borderType) {
        this.borderType = borderType;
        this.borderType = BoardSize.getBorder();
        this.basicArray = basicArray;
        Simulation.amount = amount;
        firstGen = new int [BoardSize.getHeight()+2][BoardSize.getWidth()+2];
        for(int i = 0; i<=BoardSize.getHeight()+1; i++)
            System.arraycopy(basicArray[i], 0, firstGen[i], 0, BoardSize.getWidth() + 1 + 1);
        if(!borderType){
            for (int i = 1; i <= BoardSize.getWidth(); i++)
            {
                basicArray[0][i] = basicArray[BoardSize.getHeight()][i];
                basicArray[BoardSize.getHeight()+1][i] =basicArray [1][i];
            }
            for (int i = 1; i<= BoardSize.getHeight(); i++)
            {
                basicArray[i][0] = basicArray[i][BoardSize.getWidth()];
                basicArray[i][BoardSize.getWidth()+1] = basicArray[i][1];
            }
            basicArray[0][0] = basicArray[BoardSize.getHeight()][BoardSize.getWidth()];
            basicArray[0][BoardSize.getWidth()+1] = basicArray[BoardSize.getHeight()][1];
            basicArray[BoardSize.getHeight()+1][0] = basicArray[1][BoardSize.getWidth()];
            basicArray[BoardSize.getHeight()+1][BoardSize.getWidth()+1] = basicArray[1][1];
        }
        lista.clear();
        lista.add(firstGen);
        firstGen[0][0] = 5;
    }

    public void startSim() {
        for (int k = 1; k<=amount; k++) {
            int[][] tempArray = new int[basicArray.length][basicArray[0].length];
            for (int i = 1; i <= BoardSize.getHeight(); i++) {
                for (int j = 1; j <= BoardSize.getWidth(); j++) {
                    int count = 0;
                    if (basicArray[i][j] == 1) {
                        if (basicArray[i][j] == 1) {
                            if (basicArray[i - 1][j] == 3) count++;
                            if (basicArray[i - 1][j + 1] == 3) count++;
                            if (basicArray[i][j + 1] == 3) count++;
                            if (basicArray[i + 1][j + 1] == 3) count++;
                            if (basicArray[i + 1][j] == 3) count++;
                            if (basicArray[i + 1][j - 1] == 3) count++;
                            if (basicArray[i][j - 1] == 3) count++;
                            if (basicArray[i - 1][j - 1] == 3) count++;
                            if (count == 1 || count == 2) tempArray[i][j] = 3;
                            else tempArray[i][j] = 1;
                        }
                    } else if (basicArray[i][j] == 2) tempArray[i][j] = 1;
                    else if (basicArray[i][j] == 3) tempArray[i][j] = 2;
                }
            }
            if(!borderType){
                for (int i = 1; i <= BoardSize.getWidth(); i++)
                {
                    tempArray[0][i] = tempArray[BoardSize.getHeight()][i];
                    tempArray[BoardSize.getHeight()+1][i] =tempArray [1][i];
                }
                for (int i = 1; i<= BoardSize.getHeight(); i++)
                {
                    tempArray[i][0] = tempArray[i][BoardSize.getWidth()];
                    tempArray[i][BoardSize.getWidth()+1] = tempArray[i][1];
                }
                tempArray[0][0] = tempArray[BoardSize.getHeight()][BoardSize.getWidth()];
                tempArray[0][BoardSize.getWidth()+1] = tempArray[BoardSize.getHeight()][1];
                tempArray[BoardSize.getHeight()+1][0] = tempArray[1][BoardSize.getWidth()];
                tempArray[BoardSize.getHeight()+1][BoardSize.getWidth()+1] = tempArray[1][1];
            }
            lista.add(tempArray);

            for(int i = 0; i<=BoardSize.getHeight()+1; i++)
                System.arraycopy(tempArray[i], 0, basicArray[i], 0, BoardSize.getWidth() + 1 + 1);
        }
    }
}
