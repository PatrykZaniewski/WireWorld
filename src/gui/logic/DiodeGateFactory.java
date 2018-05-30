package gui.logic;

import javafx.scene.layout.Pane;

public class DiodeGateFactory {

    private int row;
    private int column;
    private boolean borderType;
    private Pane playgroundTP;


    public DiodeGateFactory(int row, int column, boolean borderType, Pane playgroundTP)
    {
        this.row = row;
        this.column = column;
        this.borderType = borderType;
        this.playgroundTP = playgroundTP;
    }

    public void smallGenDisplay ()
    {
        ChangeColor paneColor = new ChangeColor(playgroundTP, borderType);

        paneColor.makeYellow(row, column);
        paneColor.makeYellow(row-1, column+1);
        paneColor.makeYellow(row-1, column+2);
        paneColor.makeBlue(row, column+3);
        paneColor.makeRed(row+1, column+2);
        paneColor.makeYellow(row+1, column+1);
    }



    public void bigGenDisplay ()
    {
        ChangeColor paneColor = new ChangeColor(playgroundTP, borderType);

        paneColor.makeYellow(row, column);
        paneColor.makeYellow(row-1, column+1);
        paneColor.makeYellow(row-1, column+2);
        paneColor.makeYellow(row-1, column+3);
        paneColor.makeYellow(row-1, column+4);
        paneColor.makeYellow(row-1, column+5);
        paneColor.makeBlue(row, column+6);
        paneColor.makeRed(row+1, column+5);
        paneColor.makeYellow(row+1, column+4);
        paneColor.makeYellow(row+1, column+3);
        paneColor.makeYellow(row+1, column+2);
        paneColor.makeYellow(row+1, column+1);
    }

    public void diodeDisplay()
    {
        ChangeColor paneColor = new ChangeColor(playgroundTP, borderType);

        paneColor.makeYellow(row, column);
        paneColor.makeYellow(row, column+1);
        paneColor.makeYellow(row-1, column+1);
        paneColor.makeYellow(row-1, column+2);
        paneColor.makeYellow(row, column+3);
        paneColor.makeYellow(row+1, column+2);
        paneColor.makeYellow(row+1, column+1);
    }

    public void orGateDisplay()
    {
        ChangeColor paneColor = new ChangeColor(playgroundTP, borderType);

        paneColor.makeRed(row, column);
        paneColor.makeBlue(row, column+1);
        paneColor.makeYellow(row, column+2);
        paneColor.makeYellow(row-1, column+3);
        paneColor.makeYellow(row-1, column+4);
        paneColor.makeYellow(row, column+5);
        paneColor.makeYellow(row+1, column+5);
        paneColor.makeYellow(row+1, column+4);
        paneColor.makeYellow(row+1, column+6);
        paneColor.makeYellow(row+1, column+7);
        paneColor.makeYellow(row+1, column+8);
        paneColor.makeYellow(row+2, column+5);
        paneColor.makeYellow(row+3, column+4);
        paneColor.makeYellow(row+3, column+3);
        paneColor.makeYellow(row+2, column+2);
        paneColor.makeBlue(row+2, column+1);
        paneColor.makeRed(row+2, column);
    }

    public void andGateDisplay()
    {
        ChangeColor paneColor = new ChangeColor(playgroundTP, borderType);

        paneColor.makeRed(row, column);
        paneColor.makeBlue(row, column+1);
        paneColor.makeYellow(row, column+2);
        paneColor.makeYellow(row-1, column+3);
        paneColor.makeYellow(row-2, column+4);
        paneColor.makeYellow(row-3, column+5);
        paneColor.makeYellow(row-3, column+6);
        paneColor.makeYellow(row-3, column+7);
        paneColor.makeYellow(row-3, column+8);
        paneColor.makeYellow(row-2, column+9);
        paneColor.makeYellow(row-2, column+10);
        paneColor.makeYellow(row-2, column+11);
        paneColor.makeYellow(row-1, column+12);
        paneColor.makeYellow(row, column+12);
        paneColor.makeYellow(row+1, column+12);
        paneColor.makeYellow(row+3, column+12);
        paneColor.makeYellow(row+3, column+13);
        paneColor.makeYellow(row+3, column+14);
        paneColor.makeYellow(row+2, column+11);
        paneColor.makeYellow(row+2, column+10);
        paneColor.makeYellow(row+3, column+10);
        paneColor.makeYellow(row+1, column+10);
        paneColor.makeYellow(row+2, column+9);
        paneColor.makeYellow(row+1, column+8);
        paneColor.makeYellow(row, column+7);
        paneColor.makeYellow(row-1, column+8);
        paneColor.makeYellow(row, column+6);
        paneColor.makeYellow(row-1, column+6);
        paneColor.makeYellow(row+1, column+6);
        paneColor.makeYellow(row, column+5);
        paneColor.makeYellow(row+1, column+4);
        paneColor.makeYellow(row+2, column+4);
        paneColor.makeYellow(row+3, column+4);
        paneColor.makeYellow(row+4, column+4);
        paneColor.makeYellow(row+5, column+3);
        paneColor.makeYellow(row+4, column+2);
        paneColor.makeYellow(row+3, column+2);
        paneColor.makeBlue(row+2, column+1);
        paneColor.makeRed(row+2, column);
    }
}

