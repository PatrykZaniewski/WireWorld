package gui.logic;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChangeColor {

    private Pane playgroundTP;
    private Rectangle r;
    private boolean borderType;

    public ChangeColor(Pane playgroundTP, boolean borderType) {
        this.playgroundTP = playgroundTP;
        this.borderType = borderType;
    }

    public ChangeColor(Pane playgroundTP) {
        this.playgroundTP = playgroundTP;
    }

    public void makeRed(int row, int column)
    {
        if(checkBorder(row, column)) {
            r = (Rectangle) playgroundTP.getChildren().get((row) * BoardSize.getWidth() + (column));
            r.setFill(Color.RED);
        }
        else if (!borderType)
        {
            row = overRow(row);
            column = overColumn(column);
            r = (Rectangle) playgroundTP.getChildren().get((row) * BoardSize.getWidth() + (column));
            r.setFill(Color.RED);
        }
    }
    public void makeBlue(int row, int column)
    {
        if(checkBorder(row, column)) {
            r = (Rectangle) playgroundTP.getChildren().get((row) * BoardSize.getWidth() + (column));
            r.setFill(Color.BLUE);
        }
        else if (!borderType)
        {
            row = overRow(row);
            column = overColumn(column);
            r = (Rectangle) playgroundTP.getChildren().get((row) * BoardSize.getWidth() + (column));
            r.setFill(Color.BLUE);
        }
    }
    public void makeYellow(int row, int column)
    {
        if(checkBorder(row, column)) {
            r = (Rectangle) playgroundTP.getChildren().get((row) * BoardSize.getWidth() + (column));
            r.setFill(Color.YELLOW);
        }
        else if (!borderType)
        {
            row = overRow(row);
            column = overColumn(column);
            r = (Rectangle) playgroundTP.getChildren().get((row) * BoardSize.getWidth() + (column));
            r.setFill(Color.YELLOW);
        }
    }

    private boolean checkBorder(int row, int column)
    {
        return row >= 0 && row < BoardSize.getHeight() && column >= 0 && column < BoardSize.getWidth();
    }

    private int overRow (int row)
    {
        if(row >= 0) {
            return row % BoardSize.getHeight();
        }
        else
            return (Math.abs(row) + BoardSize.getHeight()-2)  % BoardSize.getHeight();
    }

    private int overColumn (int column)
    {
        if(column >= 0)
            return column % BoardSize.getWidth();
        else
            return (Math.abs(column) + BoardSize.getWidth()-2) % BoardSize.getWidth();
    }

}
