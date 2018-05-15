package gui;


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
        loader.setLocation(this.getClass().getResource("/gui/fxml/Entry.fxml"));
        Pane stack = loader.load();

        Scene scene = new Scene(stack);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);


        primaryStage.setTitle("Okno");
        primaryStage.show();
    }


}
