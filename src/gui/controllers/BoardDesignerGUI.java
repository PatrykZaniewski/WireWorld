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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

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
            ChangeColor paneColor = new ChangeColor(playgroundTP, borderType);
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
            int number;
            try
            {
                number = Integer.parseInt(generationsTF.getText());
            }
            catch (NumberFormatException e)
            {
                if(!generationsTF.getText().equals(""))
                    generationsTF.setText(oldValue);
                else generationsTF.setText("");
                number = 0;
            }
            if(number>1000 && generationsTF.getText().length() > 3)generationsTF.setText(oldValue);
            if(number == 0 && !generationsTF.getText().equals(""))generationsTF.setText(oldValue);
        });
        positionCoB.getItems().addAll("Z prawej", "Z lewej", "Od góry", "Od dołu");
        positionCoB.getSelectionModel().select(0);
    }

    public void onAndAction(ActionEvent actionEvent) {
        if(andCB.isSelected())disableAll(andCB);
        else positionCoB.setDisable(true);
    }

    public void onOrAction(ActionEvent actionEvent) {
        if(orCB.isSelected())disableAll(orCB);
        else positionCoB.setDisable(true);
    }

    public void onDiodeAction(ActionEvent actionEvent) {
        if(diodeCB.isSelected())disableAll(diodeCB);
        else positionCoB.setDisable(true);
    }

    public void onBigGenAction(ActionEvent actionEvent) {
        if(bigGeneratorCB.isSelected())disableAll(bigGeneratorCB);
        else positionCoB.setDisable(true);
    }

    public void onSmallGenAction(ActionEvent actionEvent) {
        if(smallGeneratorCB.isSelected())disableAll(smallGeneratorCB);
        else positionCoB.setDisable(true);
    }

    private void disableAll(CheckBox notDisabled)
    {
        smallGeneratorCB.setSelected(false);
        andCB.setSelected(false);
        orCB.setSelected(false);
        diodeCB.setSelected(false);
        bigGeneratorCB.setSelected(false);

        notDisabled.setSelected(true);
        positionCoB.setDisable(false);
    }

    public void onQuitButton(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void onBackAction(ActionEvent actionEvent) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Ostrzeżenie");
        alert.setHeaderText("");
        alert.setContentText("Powrót do okna z rozmiarem spowoduje utratę aktualnej planszy.");

        ButtonType buttonTypeGo = new ButtonType("Cofnij");
        ButtonType buttonTypeCancel = new ButtonType("Anuluj", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeGo, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeGo){
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
            Simulation simulation = new Simulation(Array, amount, borderType);
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

    public void onSaveAction(ActionEvent actionEvent) throws FileNotFoundException {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Choose location To Save Report");
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            chooser.getExtensionFilters().add(extFilter);
            File file = chooser.showSaveDialog(((Node) actionEvent.getSource()).getScene().getWindow());
            PrintWriter printFile = new PrintWriter(file);
            Rectangle r;
                for(int i = 0; i<height; i++) {
                    for (int j = 0; j < width; j++) {
                        r = (Rectangle) playgroundTP.getChildren().get((i) * BoardSize.getWidth() + (j));
                        if (r.getFill() == Color.BLACK) {
                            printFile.print("0");
                        }
                        else if (r.getFill() == Color.YELLOW) {
                            printFile.print("1");
                        }
                        else if (r.getFill() == Color.RED) {
                            printFile.print("2");
                        }
                        else {
                            printFile.print("3");
                        }
                    }
                    printFile.println("");
                }
                printFile.close();
    }
}
