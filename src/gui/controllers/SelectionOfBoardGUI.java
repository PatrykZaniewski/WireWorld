package gui.controllers;


import gui.logic.Theme;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class SelectionOfBoardGUI {

    public CheckBox wrapBorderCheckB;
    public CheckBox normalBordeCheckB;
    public TextField heightTF;
    public TextField widthTF;


    @FXML
    void initialize()
    {
        heightTF.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                heightTF.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        widthTF.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                widthTF.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    public void backButtonAction(ActionEvent actionEvent) throws IOException {
        Parent nextSceneParent = FXMLLoader.load(getClass().getResource("/gui/fxml/MainForm.fxml"));
        Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        nextSceneParent.setStyle("-fx-background-color: " + Theme.getColorName());
        window.setScene(new Scene(nextSceneParent));

    }

    public void qutButtonAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void wrapCheckBAction(ActionEvent actionEvent) {
        if(wrapBorderCheckB.isSelected())normalBordeCheckB.setDisable(true);
        else normalBordeCheckB.setDisable(false);
    }

    public void normalCheckBAction(ActionEvent actionEvent) {
        if(normalBordeCheckB.isSelected())wrapBorderCheckB.setDisable(true);
        else wrapBorderCheckB.setDisable(false);
    }

    public void onMakeAction(ActionEvent actionEvent) throws IOException {
        Parent nextSceneParent = FXMLLoader.load(getClass().getResource("/gui/fxml/TemplateSelection.fxml"));
        Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        nextSceneParent.setStyle("-fx-background-color: " + Theme.getColorName());
        window.setScene(new Scene(nextSceneParent));
    }

    public void onSelectAction(ActionEvent actionEvent) {

    }
}
