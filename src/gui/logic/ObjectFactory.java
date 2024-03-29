package gui.logic;

import javafx.scene.layout.Pane;

public class ObjectFactory {

    private int row;
    private int column;
    private boolean borderType;
    private Pane playgroundTP;


    public ObjectFactory(int row, int column, boolean borderType, Pane playgroundTP)
    {
        this.row = row;
        this.column = column;
        this.borderType = borderType;
        this.playgroundTP = playgroundTP;
    }

    public void smallGenDisplay (int orientation)     //Orientation, 0 - right, 1 -left, 2 - up, 3- down
    {
        ChangeColor paneColor = new ChangeColor(playgroundTP, borderType);

        if(orientation == 0) {
            paneColor.makeYellow(row, column);
            paneColor.makeYellow(row - 1, column + 1);
            paneColor.makeYellow(row - 1, column + 2);
            paneColor.makeBlue(row, column + 3);
            paneColor.makeRed(row + 1, column + 2);
            paneColor.makeYellow(row + 1, column + 1);
        }
        else if (orientation == 1)
        {
            paneColor.makeYellow(row, column);
            paneColor.makeYellow(row - 1, column - 1);
            paneColor.makeYellow(row - 1, column - 2);
            paneColor.makeBlue(row, column - 3);
            paneColor.makeRed(row + 1, column - 2);
            paneColor.makeYellow(row + 1, column - 1);
        }
        else if (orientation == 2)
        {
            paneColor.makeYellow(row, column);
            paneColor.makeYellow(row - 1, column - 1);
            paneColor.makeYellow(row - 2, column - 1);
            paneColor.makeBlue(row - 3 , column);
            paneColor.makeRed(row - 2, column + 1);
            paneColor.makeYellow(row - 1, column + 1);
        }
        else if (orientation == 3)
        {
            paneColor.makeYellow(row, column);
            paneColor.makeYellow(row + 1, column - 1);
            paneColor.makeYellow(row + 2, column - 1);
            paneColor.makeBlue(row + 3, column);
            paneColor.makeRed(row + 2, column + 1);
            paneColor.makeYellow(row + 1, column + 1);
        }
    }

    public void bigGenDisplay (int orientation)
    {
        ChangeColor paneColor = new ChangeColor(playgroundTP, borderType);

        if(orientation == 0) {
            paneColor.makeYellow(row, column);
            paneColor.makeYellow(row - 1, column + 1);
            paneColor.makeYellow(row - 1, column + 2);
            paneColor.makeYellow(row - 1, column + 3);
            paneColor.makeYellow(row - 1, column + 4);
            paneColor.makeYellow(row - 1, column + 5);
            paneColor.makeBlue(row, column + 6);
            paneColor.makeRed(row + 1, column + 5);
            paneColor.makeYellow(row + 1, column + 4);
            paneColor.makeYellow(row + 1, column + 3);
            paneColor.makeYellow(row + 1, column + 2);
            paneColor.makeYellow(row + 1, column + 1);
        }
        else if (orientation == 1)
        {
            paneColor.makeYellow(row, column);
            paneColor.makeYellow(row - 1, column - 1);
            paneColor.makeYellow(row - 1, column - 2);
            paneColor.makeYellow(row - 1, column - 3);
            paneColor.makeYellow(row - 1, column - 4);
            paneColor.makeYellow(row - 1, column - 5);
            paneColor.makeBlue(row, column - 6);
            paneColor.makeRed(row + 1, column - 5);
            paneColor.makeYellow(row + 1, column - 4);
            paneColor.makeYellow(row + 1, column - 3);
            paneColor.makeYellow(row + 1, column - 2);
            paneColor.makeYellow(row + 1, column - 1);
        }
        else if (orientation == 2)
        {
            paneColor.makeYellow(row, column);
            paneColor.makeYellow(row - 1, column - 1);
            paneColor.makeYellow(row - 2, column - 1);
            paneColor.makeYellow(row - 3, column - 1);
            paneColor.makeYellow(row - 4, column - 1);
            paneColor.makeYellow(row - 5, column - 1);
            paneColor.makeBlue(row - 6, column);
            paneColor.makeRed(row - 5, column + 1);
            paneColor.makeYellow(row - 4, column + 1);
            paneColor.makeYellow(row - 3, column + 1);
            paneColor.makeYellow(row - 2, column + 1);
            paneColor.makeYellow(row - 1, column + 1);
        }
        else if (orientation == 3)
        {
            paneColor.makeYellow(row, column);
            paneColor.makeYellow(row + 1, column - 1);
            paneColor.makeYellow(row + 2, column - 1);
            paneColor.makeYellow(row + 3, column - 1);
            paneColor.makeYellow(row + 4, column - 1);
            paneColor.makeYellow(row + 5, column - 1);
            paneColor.makeBlue(row + 6, column);
            paneColor.makeRed(row + 5, column + 1);
            paneColor.makeYellow(row + 4, column + 1);
            paneColor.makeYellow(row + 3, column + 1);
            paneColor.makeYellow(row + 2, column + 1);
            paneColor.makeYellow(row + 1, column + 1);
        }
    }

    public void diodeDisplay(int orientation)
    {
        ChangeColor paneColor = new ChangeColor(playgroundTP, borderType);

        if (orientation == 0) {
            paneColor.makeYellow(row, column);
            paneColor.makeYellow(row, column + 1);
            paneColor.makeYellow(row - 1, column + 1);
            paneColor.makeYellow(row - 1, column + 2);
            paneColor.makeYellow(row, column + 3);
            paneColor.makeYellow(row + 1, column + 2);
            paneColor.makeYellow(row + 1, column + 1);
        }
        else if (orientation == 1)
        {
            paneColor.makeYellow(row, column);
            paneColor.makeYellow(row, column - 1);
            paneColor.makeYellow(row - 1, column - 1);
            paneColor.makeYellow(row - 1, column - 2);
            paneColor.makeYellow(row, column - 3);
            paneColor.makeYellow(row + 1, column - 2);
            paneColor.makeYellow(row + 1, column - 1);
        }
        else if (orientation == 2)
        {
            paneColor.makeYellow(row, column);
            paneColor.makeYellow(row - 1, column);
            paneColor.makeYellow(row - 1, column - 1);
            paneColor.makeYellow(row - 2, column - 1);
            paneColor.makeYellow(row - 3, column);
            paneColor.makeYellow(row - 2, column + 1);
            paneColor.makeYellow(row - 1, column + 1);
        }
        else if (orientation == 3)
        {
            paneColor.makeYellow(row, column);
            paneColor.makeYellow(row + 1, column);
            paneColor.makeYellow(row + 1, column + 1);
            paneColor.makeYellow(row + 2, column + 1);
            paneColor.makeYellow(row + 3, column);
            paneColor.makeYellow(row + 2, column - 1);
            paneColor.makeYellow(row + 1, column - 1);
        }
    }

    public void orGateDisplay(int orientation)
    {
        ChangeColor paneColor = new ChangeColor(playgroundTP, borderType);

        if(orientation == 0) {
            paneColor.makeRed(row, column);
            paneColor.makeBlue(row, column + 1);
            paneColor.makeYellow(row, column + 2);
            paneColor.makeYellow(row - 1, column + 3);
            paneColor.makeYellow(row - 1, column + 4);
            paneColor.makeYellow(row, column + 5);
            paneColor.makeYellow(row + 1, column + 5);
            paneColor.makeYellow(row + 1, column + 4);
            paneColor.makeYellow(row + 1, column + 6);
            paneColor.makeYellow(row + 1, column + 7);
            paneColor.makeYellow(row + 1, column + 8);
            paneColor.makeYellow(row + 2, column + 5);
            paneColor.makeYellow(row + 3, column + 4);
            paneColor.makeYellow(row + 3, column + 3);
            paneColor.makeYellow(row + 2, column + 2);
            paneColor.makeBlue(row + 2, column + 1);
            paneColor.makeRed(row + 2, column);
        }
        else if (orientation == 1)
        {
            paneColor.makeRed(row, column);
            paneColor.makeBlue(row, column - 1);
            paneColor.makeYellow(row, column - 2);
            paneColor.makeYellow(row - 1, column - 3);
            paneColor.makeYellow(row - 1, column - 4);
            paneColor.makeYellow(row, column - 5);
            paneColor.makeYellow(row + 1, column - 5);
            paneColor.makeYellow(row + 1, column - 4);
            paneColor.makeYellow(row + 1, column - 6);
            paneColor.makeYellow(row + 1, column - 7);
            paneColor.makeYellow(row + 1, column - 8);
            paneColor.makeYellow(row + 2, column - 5);
            paneColor.makeYellow(row + 3, column - 4);
            paneColor.makeYellow(row + 3, column - 3);
            paneColor.makeYellow(row + 2, column - 2);
            paneColor.makeBlue(row + 2, column - 1);
            paneColor.makeRed(row + 2, column);
        }
        else if (orientation == 2)
        {
            paneColor.makeRed(row, column);
            paneColor.makeBlue(row - 1, column);
            paneColor.makeYellow(row - 2, column);
            paneColor.makeYellow(row - 3, column - 1);
            paneColor.makeYellow(row - 4, column - 1);
            paneColor.makeYellow(row - 5, column);
            paneColor.makeYellow(row - 5, column + 1);
            paneColor.makeYellow(row - 4, column + 1);
            paneColor.makeYellow(row - 6, column + 1);
            paneColor.makeYellow(row - 7, column + 1);
            paneColor.makeYellow(row - 8, column + 1);
            paneColor.makeYellow(row - 5, column + 2);
            paneColor.makeYellow(row - 4, column + 3);
            paneColor.makeYellow(row - 3, column + 3);
            paneColor.makeYellow(row - 2, column + 2);
            paneColor.makeBlue(row - 1, column + 2);
            paneColor.makeRed(row, column + 2);
        }
        else if (orientation == 3)
        {
            paneColor.makeRed(row, column);
            paneColor.makeBlue(row + 1, column);
            paneColor.makeYellow(row + 2, column);
            paneColor.makeYellow(row + 3, column - 1);
            paneColor.makeYellow(row + 4, column - 1);
            paneColor.makeYellow(row + 5, column);
            paneColor.makeYellow(row + 5, column + 1);
            paneColor.makeYellow(row + 4, column + 1);
            paneColor.makeYellow(row + 6, column + 1);
            paneColor.makeYellow(row + 7, column + 1);
            paneColor.makeYellow(row + 8, column + 1);
            paneColor.makeYellow(row + 5, column + 2);
            paneColor.makeYellow(row + 4, column + 3);
            paneColor.makeYellow(row + 3, column + 3);
            paneColor.makeYellow(row + 2, column + 2);
            paneColor.makeBlue(row + 1, column + 2);
            paneColor.makeRed(row, column + 2);
        }
    }

    public void andGateDisplay(int orientation)
    {
        ChangeColor paneColor = new ChangeColor(playgroundTP, borderType);

        if(orientation == 0) {
            paneColor.makeRed(row, column);
            paneColor.makeBlue(row, column + 1);
            paneColor.makeYellow(row, column + 2);
            paneColor.makeYellow(row - 1, column + 3);
            paneColor.makeYellow(row - 2, column + 4);
            paneColor.makeYellow(row - 3, column + 5);
            paneColor.makeYellow(row - 3, column + 6);
            paneColor.makeYellow(row - 3, column + 7);
            paneColor.makeYellow(row - 3, column + 8);
            paneColor.makeYellow(row - 2, column + 9);
            paneColor.makeYellow(row - 2, column + 10);
            paneColor.makeYellow(row - 2, column + 11);
            paneColor.makeYellow(row - 1, column + 12);
            paneColor.makeYellow(row, column + 12);
            paneColor.makeYellow(row + 1, column + 12);
            paneColor.makeYellow(row + 3, column + 12);
            paneColor.makeYellow(row + 3, column + 13);
            paneColor.makeYellow(row + 3, column + 14);
            paneColor.makeYellow(row + 2, column + 11);
            paneColor.makeYellow(row + 2, column + 10);
            paneColor.makeYellow(row + 3, column + 10);
            paneColor.makeYellow(row + 1, column + 10);
            paneColor.makeYellow(row + 2, column + 9);
            paneColor.makeYellow(row + 1, column + 8);
            paneColor.makeYellow(row, column + 7);
            paneColor.makeYellow(row - 1, column + 8);
            paneColor.makeYellow(row, column + 6);
            paneColor.makeYellow(row - 1, column + 6);
            paneColor.makeYellow(row + 1, column + 6);
            paneColor.makeYellow(row, column + 5);
            paneColor.makeYellow(row + 1, column + 4);
            paneColor.makeYellow(row + 2, column + 4);
            paneColor.makeYellow(row + 3, column + 4);
            paneColor.makeYellow(row + 4, column + 4);
            paneColor.makeYellow(row + 5, column + 3);
            paneColor.makeYellow(row + 4, column + 2);
            paneColor.makeYellow(row + 3, column + 2);
            paneColor.makeBlue(row + 2, column + 1);
            paneColor.makeRed(row + 2, column);
        }
        else if (orientation == 1)
        {
            paneColor.makeRed(row, column);
            paneColor.makeBlue(row, column - 1);
            paneColor.makeYellow(row, column - 2);
            paneColor.makeYellow(row - 1, column - 3);
            paneColor.makeYellow(row - 2, column - 4);
            paneColor.makeYellow(row - 3, column - 5);
            paneColor.makeYellow(row - 3, column - 6);
            paneColor.makeYellow(row - 3, column - 7);
            paneColor.makeYellow(row - 3, column - 8);
            paneColor.makeYellow(row - 2, column - 9);
            paneColor.makeYellow(row - 2, column - 10);
            paneColor.makeYellow(row - 2, column - 11);
            paneColor.makeYellow(row - 1, column - 12);
            paneColor.makeYellow(row, column - 12);
            paneColor.makeYellow(row + 1, column - 12);
            paneColor.makeYellow(row + 3, column - 12);
            paneColor.makeYellow(row + 3, column - 13);
            paneColor.makeYellow(row + 3, column - 14);
            paneColor.makeYellow(row + 2, column - 11);
            paneColor.makeYellow(row + 2, column - 10);
            paneColor.makeYellow(row + 3, column - 10);
            paneColor.makeYellow(row + 1, column - 10);
            paneColor.makeYellow(row + 2, column - 9);
            paneColor.makeYellow(row + 1, column - 8);
            paneColor.makeYellow(row, column - 7);
            paneColor.makeYellow(row - 1, column - 8);
            paneColor.makeYellow(row, column - 6);
            paneColor.makeYellow(row - 1, column - 6);
            paneColor.makeYellow(row + 1, column - 6);
            paneColor.makeYellow(row, column - 5);
            paneColor.makeYellow(row + 1, column - 4);
            paneColor.makeYellow(row + 2, column - 4);
            paneColor.makeYellow(row + 3, column - 4);
            paneColor.makeYellow(row + 4, column - 4);
            paneColor.makeYellow(row + 5, column - 3);
            paneColor.makeYellow(row + 4, column - 2);
            paneColor.makeYellow(row + 3, column - 2);
            paneColor.makeBlue(row + 2, column - 1);
            paneColor.makeRed(row + 2, column);
        }
        else if (orientation == 2)
        {
            paneColor.makeRed(row, column);
            paneColor.makeBlue(row - 1, column);
            paneColor.makeYellow(row - 2, column);
            paneColor.makeYellow(row - 3, column - 1);
            paneColor.makeYellow(row - 4, column - 2);
            paneColor.makeYellow(row - 5, column - 3);
            paneColor.makeYellow(row - 6, column - 3);
            paneColor.makeYellow(row - 7, column - 3);
            paneColor.makeYellow(row - 8, column - 3);
            paneColor.makeYellow(row - 9, column - 2);
            paneColor.makeYellow(row - 10, column - 2);
            paneColor.makeYellow(row - 11, column - 2);
            paneColor.makeYellow(row - 12, column - 1);
            paneColor.makeYellow(row - 12, column);
            paneColor.makeYellow(row - 12, column + 1);
            paneColor.makeYellow(row - 12, column + 3);
            paneColor.makeYellow(row - 13, column + 3);
            paneColor.makeYellow(row - 14, column + 3);
            paneColor.makeYellow(row - 11, column + 2);
            paneColor.makeYellow(row - 10, column + 2);
            paneColor.makeYellow(row - 10, column + 3);
            paneColor.makeYellow(row - 10, column + 1);
            paneColor.makeYellow(row - 9, column + 2);
            paneColor.makeYellow(row - 8, column + 1);
            paneColor.makeYellow(row - 7, column);
            paneColor.makeYellow(row - 8, column - 1);
            paneColor.makeYellow(row - 6, column);
            paneColor.makeYellow(row - 6, column - 1);
            paneColor.makeYellow(row - 6, column + 1);
            paneColor.makeYellow(row - 5, column);
            paneColor.makeYellow(row - 4, column + 1);
            paneColor.makeYellow(row - 4, column + 2);
            paneColor.makeYellow(row - 4, column + 3);
            paneColor.makeYellow(row - 4, column + 4);
            paneColor.makeYellow(row - 3, column + 5);
            paneColor.makeYellow(row - 2, column + 4);
            paneColor.makeYellow(row - 2, column + 3);
            paneColor.makeBlue(row - 1, column + 2);
            paneColor.makeRed(row, column + 2);
        }
        else if (orientation == 3)
        {
            paneColor.makeRed(row, column);
            paneColor.makeBlue(row + 1, column);
            paneColor.makeYellow(row + 2, column);
            paneColor.makeYellow(row + 3, column - 1);
            paneColor.makeYellow(row + 4, column - 2);
            paneColor.makeYellow(row + 5, column - 3);
            paneColor.makeYellow(row + 6, column - 3);
            paneColor.makeYellow(row + 7, column - 3);
            paneColor.makeYellow(row + 8, column - 3);
            paneColor.makeYellow(row + 9, column - 2);
            paneColor.makeYellow(row + 10, column - 2);
            paneColor.makeYellow(row + 11, column - 2);
            paneColor.makeYellow(row + 12, column - 1);
            paneColor.makeYellow(row + 12, column);
            paneColor.makeYellow(row + 12, column + 1);
            paneColor.makeYellow(row + 12, column + 3);
            paneColor.makeYellow(row + 13, column + 3);
            paneColor.makeYellow(row + 14, column + 3);
            paneColor.makeYellow(row + 11, column + 2);
            paneColor.makeYellow(row + 10, column + 2);
            paneColor.makeYellow(row + 10, column + 3);
            paneColor.makeYellow(row + 10, column + 1);
            paneColor.makeYellow(row + 9, column + 2);
            paneColor.makeYellow(row + 8, column + 1);
            paneColor.makeYellow(row + 7, column);
            paneColor.makeYellow(row + 8, column - 1);
            paneColor.makeYellow(row + 6, column);
            paneColor.makeYellow(row + 6, column - 1);
            paneColor.makeYellow(row + 6, column + 1);
            paneColor.makeYellow(row + 5, column);
            paneColor.makeYellow(row + 4, column + 1);
            paneColor.makeYellow(row + 4, column + 2);
            paneColor.makeYellow(row + 4, column + 3);
            paneColor.makeYellow(row + 4, column + 4);
            paneColor.makeYellow(row + 3, column + 5);
            paneColor.makeYellow(row + 2, column + 4);
            paneColor.makeYellow(row + 2, column + 3);
            paneColor.makeBlue(row + 1, column + 2);
            paneColor.makeRed(row, column + 2);
        }
    }
}

