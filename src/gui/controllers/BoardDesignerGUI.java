package gui.controllers;

import gui.logic.*;
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
    private int [][] Array;

    @FXML
    void initialize()
    {
        Array = new int [height+2][width+2];
        playgroundTP.setPrefSize(20*width, 20*height);
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                Color c = Color.BLACK;
                Rectangle r = new Rectangle(18, 18, c);
                r.setX(j*18);
                r.setY(i*18);
                r.setStroke(Color.GREY);
                r.setStrokeWidth(2);
                r.setOnMouseClicked(e -> {

                    int row = playgroundTP.getChildren().indexOf(r)/width;
                    int column = playgroundTP.getChildren().indexOf(r)%width;

                    if(andCB.isSelected())
                    {
                        DiodeGateFactory andGate = new DiodeGateFactory(row, column, borderType, playgroundTP);
                        andGate.andGateDisplay();
                    }
                    else if (orCB.isSelected())
                    {
                        DiodeGateFactory orGate = new DiodeGateFactory(row, column, borderType, playgroundTP);
                        orGate.orGateDisplay();
                    }
                    else if (diodeCB.isSelected())
                    {
                        DiodeGateFactory diode = new DiodeGateFactory(row, column, borderType, playgroundTP);
                        diode.diodeDisplay();
                    }
                    else if (bigGeneratorCB.isSelected())
                    {
                        DiodeGateFactory bigGen = new DiodeGateFactory(row, column, borderType, playgroundTP);
                        bigGen.bigGenDisplay();
                    }
                    else if (smallGeneratorCB.isSelected())
                    {
                        DiodeGateFactory smallGen = new DiodeGateFactory(row, column, borderType, playgroundTP);
                        smallGen.smallGenDisplay();
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
        if(Simulation.firstGen[0][0] == 5)
        {
            generationsTF.setText(String.valueOf(Simulation.getAmount()));
            ChangeColor paneColor = new ChangeColor(playgroundTP);
            for (int j = 1; j <= BoardSize.getHeight(); j++) {
                for (int k = 1; k <= BoardSize.getWidth(); k++) {
                    if (Simulation.firstGen[j][k] == 1) paneColor.makeYellow(j-1, k-1);
                    if (Simulation.firstGen[j][k] == 2) paneColor.makeRed(j-1, k-1);
                    if (Simulation.firstGen[j][k] == 3) paneColor.makeBlue(j-1, k-1);
                }
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
        Simulation.firstGen[0][0] = 0;
        playgroundTP.getChildren().removeAll();
        Parent DesignerSceneParent = FXMLLoader.load(getClass().getResource("/gui/fxml/SelectionOfBoard.fxml"));
        DesignerSceneParent.setStyle("-fx-background-color: " + Theme.getColorName());
        Stage stage = new Stage();
        stage.setScene(new Scene(DesignerSceneParent, 600, 400));
        stage.setResizable(false);
        stage.show();
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void onGenerateAction(ActionEvent actionEvent) throws IOException {
        if(generationsTF.getText().equals("")) {
            Alert fieldNotFilled = new Alert(Alert.AlertType.WARNING);
            fieldNotFilled.setTitle("Ostrzeżenie");
            fieldNotFilled.setHeaderText("");
            fieldNotFilled.setContentText("Nie podano liczby generacji.");
            fieldNotFilled.showAndWait();
        }
        else {
            Rectangle r;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    r = (Rectangle) playgroundTP.getChildren().get((i) * BoardSize.getWidth() + (j));
                    if (r.getFill() == Color.BLACK) Array[i + 1][j + 1] = 0;
                    else if (r.getFill() == Color.YELLOW) Array[i + 1][j + 1] = 1;
                    else if (r.getFill() == Color.RED) Array[i + 1][j + 1] = 2;
                    else Array[i + 1][j + 1] = 3;
                }
            }
            int amount = Integer.parseInt(generationsTF.getText());
            Simulation simulation = new Simulation(Array, amount);
            simulation.startSim();
            Parent DesignerSceneParent = FXMLLoader.load(getClass().getResource("/gui/fxml/Simulation.fxml"));
            DesignerSceneParent.setStyle("-fx-background-color: " + Theme.getColorName());
            Stage stage = new Stage();
            stage.setScene(new Scene(DesignerSceneParent, 650, 600));
            stage.setResizable(false);
            stage.show();
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        }
    }

    public void onClearButton(ActionEvent actionEvent) {
        Rectangle r;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                r = (Rectangle) playgroundTP.getChildren().get((i) * BoardSize.getWidth() + (j));
                r.setFill(Color.BLACK);
            }
        }
    }
}
