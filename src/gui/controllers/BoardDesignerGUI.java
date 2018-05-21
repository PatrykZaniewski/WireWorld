package gui.controllers;

import gui.logic.BoardSize;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;

public class BoardDesignerGUI {


    public GridPane playgroundGP;
    public ScrollPane playgroundSP;
    public CheckBox andCB;
    public CheckBox orCB;
    private int height = BoardSize.getHeight();
    private int width = BoardSize.getWidth();

    @FXML
    void initialize()
    {

        int [][] Array = new int [height][width];

        for (int i = 0 ; i < width ; i++) {
            ColumnConstraints colConstraints = new ColumnConstraints();
            colConstraints.setHgrow(Priority.SOMETIMES);
            playgroundGP.getColumnConstraints().add(colConstraints);
        }

        for (int i = 0 ; i < height ; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.SOMETIMES);
            playgroundGP.getRowConstraints().add(rowConstraints);
        }

        for (int i = 0 ; i < width ; i++) {
            for (int j = 0; j < height; j++) {
                addPane(i, j, Array);
            }
        }
    }

    private void addPane(int colIndex, int rowIndex, int Array [][]) {
        Pane pane = new Pane();
        pane.setPrefSize(20, 20);
        pane.setMinSize(20,20);
        pane.setMaxSize(20,20);
        pane.setStyle("-fx-border-color: white; -fx-background-color: black");


        pane.setOnMouseClicked(e -> {
            if(Array[rowIndex][colIndex] == 0)
            {
                pane.setStyle("-fx-background-color: yellow");
                Array[rowIndex][colIndex] = 1;
            }
            else if(Array[rowIndex][colIndex] == 1)
            {
                pane.setStyle("-fx-background-color: red");
                Array[rowIndex][colIndex] = 2;
            }
            else if(Array[rowIndex][colIndex] == 2)
            {
                pane.setStyle("-fx-background-color: blue");
                Array[rowIndex][colIndex] = 3;
            }
            else if(Array[rowIndex][colIndex] == 3)
            {
                pane.setStyle("-fx-background-color: black; -fx-border-color: white");
                Array[rowIndex][colIndex] = 0;
            }
            if(andCB.isSelected())
            {
                pane.setStyle("-fx-background-color: white");
                Pane change = (Pane) playgroundGP.getChildren().get(colIndex * height + rowIndex);
                change.setStyle("-fx-background-color: green");
            }
        });
        playgroundGP.add(pane, colIndex, rowIndex);
    }


}
