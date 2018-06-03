package gui.controllers;

import gui.logic.BoardSize;
import gui.logic.Simulation;
import gui.logic.TemplateSelection;
import gui.logic.Theme;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;


public class TemplateSelectionGUI {

    public ListView<String> templateLV;
    public ImageView templatePicIV;
    public TextField generationsTF;
    public ScrollPane playgroundSP;
    public TilePane playgroundTP;
    private TemplateSelection temp;
    private int [][] Array;

    @FXML
    void initialize()
    {
        generationsTF.textProperty().addListener((observable, oldValue, newValue) -> {
                    if (!newValue.matches("\\d*")) {
                        generationsTF.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                    int number;
                    try {
                        number = Integer.parseInt(generationsTF.getText());
                    } catch (NumberFormatException e) {
                        if (!generationsTF.getText().equals(""))
                            generationsTF.setText(oldValue);
                        else generationsTF.setText("");
                        number = 0;
                    }
                    if (number > 1000 && generationsTF.getText().length() > 3) generationsTF.setText(oldValue);
                    if (number == 0 && !generationsTF.getText().equals("")) generationsTF.setText(oldValue);
                });
        templateLV.getItems().addAll("Szablon 1", "Szablon 2", "Szablon 3", "Szablon 4", "Szablon 5", "Szablon 6", "Szablon 7", "Szablon 8", "Szablon 9", "Szablon 10",
                "Szablon 11", "Szablon 12", "Szablon 13", "Szablon 14", "Szablon 15", "Szablon 16", "Szablon 17", "Szablon 18", "Szablon 19", "Szablon 20", "Szablon 21",
                "Szablon 22", "Szablon 23", "Szablon 24", "Szablon 25");
        templateLV.getSelectionModel().select(0);

        temp = new TemplateSelection();
        drawTemplate(0);
    }


    public void onTemplateClick(MouseEvent mouseEvent){
        int templateID = templateLV.getSelectionModel().getSelectedIndex();
        drawTemplate(templateID);
    }


    public void onQuitButton(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void onBackACtion(ActionEvent actionEvent) throws IOException {
        Parent nextSceneParent = FXMLLoader.load(getClass().getResource("/gui/fxml/SelectionOfBoard.fxml"));
        Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        nextSceneParent.setStyle("-fx-background-color: " + Theme.getColorName());
        window.setScene(new Scene(nextSceneParent));
    }

    private void drawTemplate(int index)
    {
        playgroundTP.getChildren().clear();
        Array = temp.getTemplate(index);
        playgroundTP.setPrefSize(10*(Array[0].length-2), 10*(Array.length-2));
        Color c;
        for(int i = 1; i <= Array.length-2; i++) {
            for (int j = 1; j <= Array[0].length-2; j++) {
                if (Array[i][j] == 0) c = Color.BLACK;
                else if (Array[i][j] == 1) c = Color.YELLOW;
                else if (Array[i][j] == 2) c = Color.RED;
                else c = Color.BLUE;

                Rectangle r = new Rectangle(9, 9, c);
                r.setX(j * 9);
                r.setY(i * 9);
                r.setStroke(Color.GREY);
                r.setStrokeWidth(1);
                playgroundTP.getChildren().add(r);
            }
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
            int amount = Integer.parseInt(generationsTF.getText());
            BoardSize.setHeight(Array.length-2);
            BoardSize.setWidth(Array[0].length-2);
            Simulation simulation = new Simulation(Array, amount, BoardSize.getBorder());
            simulation.startSim();
            Parent DesignerSceneParent = FXMLLoader.load(getClass().getResource("/gui/fxml/Simulation.fxml"));
            DesignerSceneParent.setStyle("-fx-background-color: " + Theme.getColorName());
            Stage stage = new Stage();
            stage.setScene(new Scene(DesignerSceneParent, 650, 600));
            stage.setResizable(false);
            stage.show();
            ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
        }
    }
}
