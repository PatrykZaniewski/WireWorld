package gui.logic;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChangeColor {

    private Pane playgroundTP;
    private Rectangle r;

    public ChangeColor(Pane playgroundTP) {
        this.playgroundTP = playgroundTP;
    }

    public void makeRed(int row, int column)
    {
        r = (Rectangle) playgroundTP.getChildren().get( (row) * BoardSize.getWidth() + (column));
        r.setFill(Color.RED);
    }
    public void makeBlue(int row, int column)
    {
        r = (Rectangle) playgroundTP.getChildren().get( (row) * BoardSize.getWidth() + (column));
        r.setFill(Color.BLUE);
    }
    public void makeYellow(int row, int column)
    {
        r = (Rectangle) playgroundTP.getChildren().get( (row) * BoardSize.getWidth() + (column));
        r.setFill(Color.YELLOW);
    }

    public boolean checkBorder (int row, int column)
    {
        return row >= 0 && row < BoardSize.getHeight() && column >= 0 && column < BoardSize.getWidth();
    }

}
