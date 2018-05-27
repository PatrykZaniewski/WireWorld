package gui.controllers;

import gui.logic.BoardSize;
import gui.logic.ChangeColor;
import gui.logic.Simulation;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class SimulationGui {

    public ScrollPane playgroundSP;
    public TilePane playgroundTP;
    private int [][] Array;
    private Service<Void> backgroundThread;

    @FXML
    void initialize() throws InterruptedException {
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
         start(Simulation.getLista());
    }

    private void start (ArrayList<int[][]> lista) throws InterruptedException {
        backgroundThread = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        ChangeColor paneColor = new ChangeColor(playgroundTP);
                        for (int [] [] Array : lista) {
                            for (int j = 1; j <= BoardSize.getHeight(); j++) {
                                for (int k = 1; k <= BoardSize.getWidth(); k++) {
                                    if (Array[j][k] == 1) paneColor.makeYellow(j-1, k-1);
                                    if (Array[j][k] == 2) paneColor.makeRed(j-1, k-1);
                                    if (Array[j][k] == 3) paneColor.makeBlue(j-1, k-1);
                                }
                            }
                            Thread.sleep(1000);
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
}