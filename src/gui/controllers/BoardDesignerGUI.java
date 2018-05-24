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
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.IOException;

public class BoardDesignerGUI {

    public TilePane playgroundTP;
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
    private boolean borderType = BoardSize.getBorder();

    @FXML
    void initialize()
    {
        int [][] Array = new int [height][width];
        playgroundTP.setPrefSize(17*width, 17*height);
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                Color c = Color.BLACK;
                Rectangle r = new Rectangle(15, 15, c);
                r.setX(j*15);
                r.setY(i*15);
                r.setStroke(Color.GREY);
                r.setStrokeWidth(2);
                r.setOnMouseClicked(e -> {


                    if(andCB.isSelected())
                    {

                    }
                    else if (orCB.isSelected())
                    {

                    }
                    else if (diodeCB.isSelected())
                    {

                    }
                    else if (bigGeneratorCB.isSelected())
                    {

                    }
                    else if (smallGeneratorCB.isSelected())
                    {
                        int row = playgroundTP.getChildren().indexOf(r)/height;
                        int column = playgroundTP.getChildren().indexOf(r)%width;
                        DiodeGateFactory object = new DiodeGateFactory(row, column, Array, borderType);
                        object.smallGen(playgroundTP);
                    }
                    else
                    {
                        if(r.getFill()==Color.BLACK)
                        {
                            r.setFill(Color.YELLOW);
                        }
                        else if(r.getFill()==Color.YELLOW)
                        {
                            r.setFill(Color.RED);
                        }
                        else if(r.getFill()==Color.RED)
                        {
                            r.setFill(Color.BLUE);
                        }
                        else if(r.getFill()==Color.BLUE)
                        {
                            r.setFill(Color.BLACK);
                        }
                    }
                });
                playgroundTP.getChildren().add(r);
            }
        }
        generationsTF.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                generationsTF.setText(newValue.replaceAll("[^\\d]", ""));

            }
            if (generationsTF.getText().length() > 2) {
                if(Integer.parseInt(oldValue) == 100)
                {
                    generationsTF.setText("100");
                }
                if(Integer.parseInt(generationsTF.getText())!=100) {
                    String s = generationsTF.getText().substring(0, 2);
                    generationsTF.setText(s);
                }
            }
        });
        positionCoB.getItems().addAll("Z prawej", "Z lewej", "Od góry", "Od dołu");
        positionCoB.getSelectionModel().select(0);
    }

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
