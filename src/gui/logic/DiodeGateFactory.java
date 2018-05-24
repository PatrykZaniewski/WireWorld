package gui.logic;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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


    public void andGate (Pane playgroundTP)
    {
        Rectangle r;
        r = (Rectangle) playgroundTP.getChildren().get( 1 * BoardSize.getHeight()+ 1);
        r.setFill(Color.RED);
        Array[row][column] = 2;
    }

    public void orGate (Pane playgroundTP)
    {
        Pane change;
        change = (Pane) playgroundTP.getChildren().get(column * Array.length + row);
        change.setStyle("-fx-background-color: pink");
        Array[row][column] = 2;
    }

    public void smallGen (Pane playgroundTP)
    {
        Rectangle r;
        r = (Rectangle) playgroundTP.getChildren().get( (row) * Array.length + (column));
        r.setFill(Color.YELLOW);
        r = (Rectangle) playgroundTP.getChildren().get( (row-1) * Array.length + (column+1));
        r.setFill(Color.YELLOW);
        r = (Rectangle) playgroundTP.getChildren().get( (row-1) * Array.length + (column+2));
        r.setFill(Color.YELLOW);
        r = (Rectangle) playgroundTP.getChildren().get( (row) * Array.length + (column+3));
        r.setFill(Color.BLUE);
        r = (Rectangle) playgroundTP.getChildren().get( (row+1) * Array.length + (column+2));
        r.setFill(Color.RED);
        r = (Rectangle) playgroundTP.getChildren().get( (row+1) * Array.length + (column+1));
        r.setFill(Color.YELLOW);
    }



}
