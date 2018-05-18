package gui.controllers;

import gui.logic.Theme;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class TemplateSelectionGUI {

    public ListView<String> templateLV;
    public ImageView templatePicIV;
    public TextField generationTF;

    @FXML
    void initialize()
    {
        generationTF.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                generationTF.setText(newValue.replaceAll("[^\\d]", ""));
            }
            if (generationTF.getText().length() > 2) {
                if(Integer.parseInt(generationTF.getText())!=100) {
                    String s = generationTF.getText().substring(0, 2);
                    generationTF.setText(s);
                }
                if(Integer.parseInt(oldValue) == 100)
                {
                    generationTF.setText("100");
                }
            }
        });
        templateLV.getItems().addAll("Szablon 1", "Szablon 2", "Szablon 3", "Szablon 4", "Szablon 5", "Szablon 6", "Szablon 7", "Szablon 8", "Szablon 9", "Szablon 10");
    }


    public void onTemplateClick(MouseEvent mouseEvent){
        int templateID = templateLV.getSelectionModel().getSelectedIndex();
        String path = "resources/"+ templateID + ".png";

        try
        {
            templatePicIV.setImage(new Image(path));
        }
        catch(IllegalArgumentException exception)
        {
            Alert imageNotFound = new Alert (Alert.AlertType.WARNING);
            imageNotFound.setTitle("Ostrzeżenie");
            imageNotFound.setHeaderText("");
            imageNotFound.setContentText("Nie znaleziono obrazu danego szablonu.");
            imageNotFound.showAndWait();
            templatePicIV.setImage(null);
        }
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
}
