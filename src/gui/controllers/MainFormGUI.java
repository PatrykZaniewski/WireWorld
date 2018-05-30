package gui.controllers;

import gui.logic.Theme;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.io.IOException;

public class MainFormGUI {

    public ComboBox<String> themeCB;
    public Button nextButton;


    @FXML
    void initialize(){

        themeCB.getItems().addAll("Szary", "Czarny", "Biały", "Fioletowy", "Różowy");
        themeCB.getSelectionModel().select(Theme.getColorID());
    }

    public void quitButtonAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    public void onThemeChosen(ActionEvent actionEvent){
        int themeID = themeCB.getSelectionModel().getSelectedIndex();
        Theme.setColorID(themeID);
        Parent thisScene = ((Node) actionEvent.getSource()).getParent();
        thisScene.setStyle("-fx-background-color: " + Theme.getColorName());
    }

    public void nexButtonAction(ActionEvent actionEvent) throws IOException {
        Parent nextSceneParent = FXMLLoader.load(getClass().getResource("/gui/fxml/SelectionOfBoard.fxml"));
        Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        nextSceneParent.setStyle("-fx-background-color: " + Theme.getColorName());
        window.setScene(new Scene(nextSceneParent));

    }

}

