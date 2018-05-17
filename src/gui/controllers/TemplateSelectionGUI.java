package gui.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

public class TemplateSelectionGUI {

    public ListView<String> templateLV;
    public ImageView templatePicIV;
    public Image image;

    @FXML
    void initialize()
    {
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
            Parent stack = ((Node)mouseEvent.getSource()).getParent();
            Alert imageNotFound = new Alert (Alert.AlertType.WARNING);
            imageNotFound.setTitle("Ostrzeżenie");
            imageNotFound.setHeaderText("");
            imageNotFound.setContentText("Nie znaleziono obrazu danego szablonu.");
            imageNotFound.showAndWait();
            templatePicIV.setImage(null);
        }
    }
}
