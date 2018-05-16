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
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class MainFormGUI {


    @FXML
    public ComboBox<String> templateCB;
    public TextArea TitleTA;
    public Button nextButton;
    @FXML
    private Button quitButton;
    private Theme theme = new Theme(0);


    @FXML
    void initialize(){
        templateCB.getItems().addAll("Różowy", "Czarny", "Biały", "Niebieski", "Szary");
        templateCB.getSelectionModel().select(0);
    }

    public void quitButtonAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void onThemeChosen(ActionEvent actionEvent){
        int templateID = templateCB.getSelectionModel().getSelectedIndex();
        Theme.setColorID(templateID);
        theme.returnTheme();
        Parent thisScene = ((Node) actionEvent.getSource()).getParent();
        thisScene.setStyle("-fx-background-color: " + Theme.colorName);
    }

    public void nexButtonAction(ActionEvent actionEvent) throws IOException {
        Parent SecondParent = FXMLLoader.load(getClass().getResource("/gui/fxml/SelectionOfBoard.fxml"));

        Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        SecondParent.setStyle("-fx-background-color: " + Theme.colorName);
        window.setScene(new Scene(SecondParent));

    }

}

