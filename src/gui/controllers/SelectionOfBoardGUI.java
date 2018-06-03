package gui.controllers;


import gui.logic.BoardSize;
import gui.logic.Theme;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class SelectionOfBoardGUI {

    public CheckBox wrapBorderCheckB;
    public CheckBox normalBorderCheckB;
    public TextField heightTF;
    public TextField widthTF;


    @FXML
    void initialize()
    {
        heightTF.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                heightTF.setText(newValue.replaceAll("[^\\d]", ""));
            }
                int number;
                try
                {
                    number = Integer.parseInt(heightTF.getText());
                }
                catch (NumberFormatException e)
                {
                    if(!heightTF.getText().equals(""))
                    heightTF.setText(oldValue);
                    else heightTF.setText("");
                    number = 0;
                }
                if(number>1000 && heightTF.getText().length() > 3)heightTF.setText(oldValue);
                //if(number == 0 && !heightTF.getText().equals(""))heightTF.setText("");

        });

        widthTF.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                widthTF.setText(newValue.replaceAll("[^\\d]", ""));
            }
            int number;
            try
            {
                number = Integer.parseInt(widthTF.getText());
            }
            catch (NumberFormatException e)
            {
                if(!widthTF.getText().equals(""))
                    widthTF.setText(oldValue);
                else widthTF.setText("");
                number = 0;
            }
            if(number>1000 && widthTF.getText().length() > 3)widthTF.setText(oldValue);
            //if(number == 0 && !widthTF.getText().equals(""))widthTF.setText(oldValue);
        });

        normalBorderCheckB.setSelected(true);
        heightTF.setText("50");
        widthTF.setText("50");
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
        if(wrapBorderCheckB.isSelected())normalBorderCheckB.setSelected(false);
        else normalBorderCheckB.setSelected(true);
    }

    public void normalCheckBAction(ActionEvent actionEvent) {
        if(normalBorderCheckB.isSelected())wrapBorderCheckB.setSelected(false);
        else wrapBorderCheckB.setSelected(true);
    }

    public void onMakeAction(ActionEvent actionEvent) throws IOException {
        if(heightTF.getText().equals("") || widthTF.getText().equals("")){
            Alert fieldNotFilled = new Alert (Alert.AlertType.WARNING);
            fieldNotFilled.setTitle("Ostrzeżenie");
            fieldNotFilled.setHeaderText("");
            fieldNotFilled.setContentText("Nie podano wymiarów tworzonej planszy.");
            fieldNotFilled.showAndWait();
        }
        else {
            BoardSize.setHeight(Integer.parseInt(heightTF.getText()));
            BoardSize.setWidth(Integer.parseInt(widthTF.getText()));
            if(normalBorderCheckB.isSelected())BoardSize.setBorder(true);
            else BoardSize.setBorder(false);
            Parent DesignerSceneParent = FXMLLoader.load(getClass().getResource("/gui/fxml/BoardDesigner.fxml"));
            DesignerSceneParent.setStyle("-fx-background-color: " + Theme.getColorName());
            Stage stage = new Stage();
            stage.setScene(new Scene(DesignerSceneParent, 800, 650));
            stage.setResizable(false);
            stage.show();
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        }
    }

    public void onSelectAction(ActionEvent actionEvent) throws IOException {
        if(normalBorderCheckB.isSelected())BoardSize.setBorder(true);
        Parent TemplateSceneParent = FXMLLoader.load(getClass().getResource("/gui/fxml/TemplateSelection.fxml"));
        Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        TemplateSceneParent.setStyle("-fx-background-color: " + Theme.getColorName());
        window.setScene(new Scene(TemplateSceneParent));
    }
}
