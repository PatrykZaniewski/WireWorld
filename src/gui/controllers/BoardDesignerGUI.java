package gui.controllers;

import gui.logic.BoardSize;
import gui.logic.DiodeGateFactory;
import gui.logic.Theme;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class BoardDesignerGUI {

    private boolean borderType;
    public GridPane playgroundGP;
    public ScrollPane playgroundSP;
    public CheckBox andCB;
    public CheckBox orCB;
    public CheckBox diodeCB;
    public CheckBox bigGeneratorCB;
    public CheckBox smallGeneratorCB;
    public ComboBox<String> positionCoB;
    public TextField generationsTF;
    public Button quitButton;
    public Button backBT;
    public Button generateBT;
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

        generationsTF.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                generationsTF.setText(newValue.replaceAll("[^\\d]", ""));

            }
            if (generationsTF.getText().length() > 2) {
                if(Integer.parseInt(generationsTF.getText())!=100) {
                    String s = generationsTF.getText().substring(0, 2);
                    generationsTF.setText(s);
                }
                if(Integer.parseInt(oldValue) == 100)
                {
                    generationsTF.setText("100");
                }
            }
        });

        positionCoB.getItems().addAll("Z prawej", "Z lewej", "Od góry", "Od dołu");
        positionCoB.getSelectionModel().select(0);
    }

    private void addPane(int colIndex, int rowIndex, int Array [][]) {
        Pane pane = new Pane();
        pane.setPrefSize(10, 10);
        pane.setMinSize(10,10);
        pane.setMaxSize(10,10);
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
                DiodeGateFactory Gate = new DiodeGateFactory(rowIndex, colIndex, Array, borderType);
                Gate.AndGate(playgroundGP);
               // System.out.print(Array.length);//wys
               // System.out.print(Array[0].length);//szer
            }
        });
        playgroundGP.add(pane, colIndex, rowIndex);
    }

    /*public void andGate(int row, int column, int Array [][])
    {
        Pane change;
        change = (Pane) playgroundGP.getChildren().get(column * height + row);
        change.setStyle("-fx-background-color: red");
        change = (Pane) playgroundGP.getChildren().get((column+1) * height + row);
        change.setStyle("-fx-background-color: blue");
        change = (Pane) playgroundGP.getChildren().get((column+2) * height + row);
        change.setStyle("-fx-background-color: yellow");
        change = (Pane) playgroundGP.getChildren().get((column+3) * height + (row-1));
        change.setStyle("-fx-background-color: yellow");
        change = (Pane) playgroundGP.getChildren().get((column+4) * height + (row-2));
        change.setStyle("-fx-background-color: yellow");
        change = (Pane) playgroundGP.getChildren().get((column+5) * height + (row-2));
        change.setStyle("-fx-background-color: yellow");
        change = (Pane) playgroundGP.getChildren().get((column+6) * height + (row-2));
        change.setStyle("-fx-background-color: yellow");
        change = (Pane) playgroundGP.getChildren().get((column+7) * height + (row-2));
        change.setStyle("-fx-background-color: yellow");
    }*/

    public void onAndAction(ActionEvent actionEvent) {
        if(andCB.isSelected())disableAll(andCB);
        else enableAll();
    }

    public void onOrAction(ActionEvent actionEvent) {
        if(orCB.isSelected())disableAll(orCB);
        else enableAll();
    }

    public void onDiodeAction(ActionEvent actionEvent) {
        if(diodeCB.isSelected())disableAll(diodeCB);
        else enableAll();
    }

    public void onBigGenAction(ActionEvent actionEvent) {
        if(bigGeneratorCB.isSelected())disableAll(bigGeneratorCB);
        else enableAll();
    }

    public void onSmallGenAction(ActionEvent actionEvent) {
        if(smallGeneratorCB.isSelected())disableAll(smallGeneratorCB);
        else enableAll();
    }

    private void disableAll(CheckBox notDisabled)
    {
        andCB.setDisable(true);
        orCB.setDisable(true);
        diodeCB.setDisable(true);
        bigGeneratorCB.setDisable(true);
        smallGeneratorCB.setDisable(true);

        notDisabled.setDisable(false);
        positionCoB.setDisable(false);
    }

    private void enableAll()
    {
        andCB.setDisable(false);
        orCB.setDisable(false);
        diodeCB.setDisable(false);
        bigGeneratorCB.setDisable(false);
        smallGeneratorCB.setDisable(false);

        positionCoB.setDisable(true);
    }

    public void onQuitButton(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void onBackAction(ActionEvent actionEvent) throws IOException {
        Parent nextSceneParent = FXMLLoader.load(getClass().getResource("/gui/fxml/SelectionOfBoard.fxml"));
        Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        nextSceneParent.setStyle("-fx-background-color: " + Theme.getColorName());
        window.setScene(new Scene(nextSceneParent));
    }

    public void onGenerateAction(ActionEvent actionEvent) throws IOException {
        Parent nextSceneParent = FXMLLoader.load(getClass().getResource("/gui/fxml/SelectionOfBoard.fxml"));
        Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        nextSceneParent.setStyle("-fx-background-color: " + Theme.getColorName());
        window.setScene(new Scene(nextSceneParent));
    }
}
