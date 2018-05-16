package gui.controllers;


import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;


public class SelectionOfBoardGUI {

    public CheckBox wrapBorderButton;
    public CheckBox normalBorderButton;

    void initialize()
    {

    }

    public void wrapButtonAction(ActionEvent actionEvent) {
        if(wrapBorderButton.isSelected())normalBorderButton.setDisable(true);
        else normalBorderButton.setDisable(false);
    }

    public void normalButtonAction(ActionEvent actionEvent) {
        if(normalBorderButton.isSelected())wrapBorderButton.setDisable(true);
        else wrapBorderButton.setDisable(false);
    }
}
