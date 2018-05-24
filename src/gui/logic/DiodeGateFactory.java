package gui.logic;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class DiodeGateFactory {

    private int row;
    private int column;
    private int Array [][];
    private boolean borderType;

    public DiodeGateFactory(int row, int column, int Array [][], boolean borderType)
    {
        this.row = row;
        this.column = column;
        this.Array = Array;
        this.borderType = borderType;
    }


    public void AndGate (GridPane playgroundGP)
    {
        Pane change;
        change = (Pane) playgroundGP.getChildren().get(column * Array.length + row);
        change.setStyle("-fx-background-color: white");
        Array[row][column] = 2;
    }

    public void OrGate (GridPane playgroundGP)
    {
        Pane change;
        change = (Pane) playgroundGP.getChildren().get(column * Array.length + row);
        change.setStyle("-fx-background-color: pink");
        Array[row][column] = 2;
    }



}
