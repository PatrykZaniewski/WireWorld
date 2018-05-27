package gui.logic;

import java.util.ArrayList;

public class Simulation {
    private int [] [] basicArray;
    private static int amount;
    private static ArrayList<int [][]> lista = new ArrayList<>();
    private int [] [] tempArray;

    public static int getAmount() {
        return amount;
    }

    public static ArrayList<int[][]> getLista() {
        return lista;
    }

    public Simulation(int [][] basicArray, int amount) {
        this.basicArray = basicArray;
        Simulation.amount = amount;
        int [] [] firstGen = new int [basicArray.length][basicArray[0].length];
        for(int i = 0; i<=BoardSize.getHeight()+1; i++)
            System.arraycopy(basicArray[i], 0, firstGen[i], 0, BoardSize.getWidth() + 1 + 1);
        lista.add(firstGen);
    }

    public void startSim() {
        for (int k = 1; k<=amount; k++) {
            tempArray = new int [basicArray.length][basicArray[0].length];
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
            lista.add(tempArray);

            for(int i = 0; i<=BoardSize.getHeight()+1; i++)
                System.arraycopy(tempArray[i], 0, basicArray[i], 0, BoardSize.getWidth() + 1 + 1);
        }
    }
}
