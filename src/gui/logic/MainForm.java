package gui.logic;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainForm extends Application {



    public static void main (String [] args)
    {
        launch(args);
    }

    public void start (Stage primaryStage) throws Exception
    {
        FXMLLoader loader  = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/gui/fxml/MainForm.fxml"));
        Pane stack = loader.load();

        Theme theme = new Theme(0);
        Theme.setColorID(0);
        theme.returnTheme();
        stack.setStyle("-fx-background-color: " + Theme.colorName);

        Scene scene = new Scene(stack);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
