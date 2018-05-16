package gui.controllers;

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
import javafx.stage.Stage;

import java.io.IOException;

public class EntryController {

    @FXML
    public ComboBox<String> templateCB;
    public TextArea TitleTA;
    public Button nextButton;
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

    public void quitButtonAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void onThemeChosen(ActionEvent actionEvent){

    }

    public void nexButtonAction(ActionEvent actionEvent) throws IOException {
        Parent SecondParent = FXMLLoader.load(getClass().getResource("/gui/fxml/Second.fxml"));

        Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(new Scene(SecondParent));

    }

}

