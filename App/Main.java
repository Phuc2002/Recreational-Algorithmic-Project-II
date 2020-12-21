package App;

import Algorithm.*;
import Graph.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.*;
import java.io.*;

public class Main extends Application {
    private int V;
    private Solver model;
    private String filename;
    private Pane aPane;
    private Viewer view;

    public void start(Stage primaryStage) {
        aPane = new Pane();
        view = new Viewer();
        aPane.getChildren().add(view);

        view.getSolverItem1().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                try {
                    model = new ApproxAlg(V);
                } catch (OutOfMemoryError e) {
                    System.out.println("Error: Program ran out of memory.");
                }
                //System.out.println(V);
                System.out.println("Algorithm.Solver 1 Approx Alg selected");
            }
        });

        view.getSolverItem2().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                try {
                    model = new NearestNeighborAlg(V);
                } catch (OutOfMemoryError e){
                    System.out.println("Error: Program ran out of memory.");
                }
                //System.out.println(V);
                System.out.println("Algorithm.Solver 2 Nearest Neighbor Alg selected");
            }
        });

        view.getFileList().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                filename = (String) view.getFileList().getSelectionModel().getSelectedItem();
                System.out.println("File retrieved");
                //System.out.println(model.getG());
            }
        });

        view.getExecuteButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                update();
                if (model == null) return;

                List<Vertex> hamiltonian = model.solve();
                for (Vertex v : hamiltonian){
                    v.normalize(model.getG().getMinMax(), 1460, 740);
                }

                for (int i = 0; i < hamiltonian.size() - 1; i++){
                    hamiltonian.get(i).drawAndConnectLine(hamiltonian.get(i + 1));
                }
                System.out.println("Executed");
            }
        });

        primaryStage.setTitle("For Santa Claus");
        primaryStage.setScene(new Scene(aPane, 1500, 800));
        primaryStage.show();
    }

    public void update() {
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            V = Integer.parseInt(file.readLine());
            model.reset(V);
            model.loadGraph(file);
            file.close();
            view.resetCanvas();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Cannot open file for reading.");
        } catch (IOException e){
            System.out.println("Error: Cannot read from file.");
        } catch (OutOfMemoryError e){
            System.out.println("Error: Program ran out of memory.");
        } catch (NullPointerException e){
            System.out.println("Error: Model is not selected. I told you to interact with the GUI correctly.");
        }
    }

    public static void main(String[] args) {launch(args);}
}
