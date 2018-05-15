package gui.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class EntryController {

    @FXML
    public ComboBox<String> templateCB;
    public TextArea TitleTA;
    @FXML
    private Button quitButton;

    public EntryController()
    {
        System.out.println("a");
    }

    @FXML
    void initialize(){
        templateCB.getItems().addAll("Czarny","Biały","Różowy","Niebieski","Szary");
        templateCB.getSelectionModel().select(0);
    }

    public void onButtonAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void onThemeChosen(ActionEvent actionEvent){

    }
}
