package gui.controllers;

import gui.logic.BoardSize;
import gui.logic.ChangeColor;
import gui.logic.Simulation;
import gui.logic.Theme;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SimulationGui {

    public ScrollPane playgroundSP;
    public TilePane playgroundTP;
    public Button quitButton;
    public Button backButton;
    public Button pauseButton;
    public Label generationLabel;
    public Button startButton;
    private boolean isPaused = true;
    private boolean isStop = true;
    private Service<Void> backgroundThread;

    @FXML
    void initialize(){
        pauseButton.setDisable(true);
        playgroundTP.setPrefSize(20 * BoardSize.getWidth(), 20 * BoardSize.getHeight());
        for (int i = 0; i < BoardSize.getHeight(); i++) {
            for (int j = 0; j < BoardSize.getWidth(); j++) {
                Color c = Color.BLACK;
                Rectangle r = new Rectangle(18, 18, c);
                r.setX(j * 18);
                r.setY(i * 18);
                r.setStroke(Color.GREY);
                r.setStrokeWidth(2);
                playgroundTP.getChildren().add(r);
            }
        }
        firstGen();
    }

    private void firstGen ()
    {
        ChangeColor paneColor = new ChangeColor(playgroundTP);
        generationLabel.setText("0");
        for (int j = 1; j <= BoardSize.getHeight(); j++) {
            for (int k = 1; k <= BoardSize.getWidth(); k++) {
                if (Simulation.firstGen[j][k] == 1) paneColor.makeYellow(j-1, k-1);
                if (Simulation.firstGen[j][k] == 2) paneColor.makeRed(j-1, k-1);
                if (Simulation.firstGen[j][k] == 3) paneColor.makeBlue(j-1, k-1);
            }
        }
    }

    private synchronized void start (ArrayList<int[][]> lista){
        backgroundThread = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        int actualGen = 0;
                        ChangeColor paneColor = new ChangeColor(playgroundTP);
                        for (int[][] Array : lista) {
                            while(isPaused)Thread.sleep(1);
                            actualGen++;
                            if (isStop) break;
                            else {
                                for (int j = 1; j <= BoardSize.getHeight(); j++) {
                                    for (int k = 1; k <= BoardSize.getWidth(); k++) {
                                        if (Array[j][k] == 1) paneColor.makeYellow(j - 1, k - 1);
                                        if (Array[j][k] == 2) paneColor.makeRed(j - 1, k - 1);
                                        if (Array[j][k] == 3) paneColor.makeBlue(j - 1, k - 1);
                                    }
                                }
                                Thread.sleep(500);
                            }
                        }
                        return null;
                    }
                };
            }
        };
        backgroundThread.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {

            }
        });
        backgroundThread.restart();
    }

    public void onQuitAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void onBackAction(ActionEvent actionEvent) throws IOException {
        Parent DesignerSceneParent = FXMLLoader.load(getClass().getResource("/gui/fxml/BoardDesigner.fxml"));
        DesignerSceneParent.setStyle("-fx-background-color: " + Theme.getColorName());
        Stage stage = new Stage();
        stage.setScene(new Scene(DesignerSceneParent, 800, 600));
        stage.setResizable(false);
        stage.show();
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void onStartAction(ActionEvent actionEvent){
        pauseButton.setDisable(false);
        startButton.setDisable(true);
        start(Simulation.getLista());
        isPaused = false;
        isStop = false;
    }

    public void onStopButton(ActionEvent actionEvent) {
        isStop = true;
        startButton.setDisable(false);
        if(pauseButton.getText().equals("Wznow"))
        {
            pauseButton.setText("Pauza");
            isPaused = false;
        }
        pauseButton.setDisable(true);
        firstGen();
    }

    public synchronized void onPauseAction(ActionEvent actionEvent){
        if(pauseButton.getText().equals("Pauza")) {
            isPaused = true;
            pauseButton.setText("Wznow");
        }
        else
        {
            isPaused = false;
            pauseButton.setText("Pauza");
        }
    }
}