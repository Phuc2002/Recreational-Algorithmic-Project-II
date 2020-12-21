package App;

import javafx.collections.FXCollections;
import javafx.scene.layout.Pane;
import javafx.scene.control.*;


public class Viewer extends Pane {
    private static Pane canvas;
    private Pane topPane;
    private MenuBar menuBar;
    private Menu solverMenu;
    private MenuItem solverItem1, solverItem2;
    private ComboBox fileList;
    private Button executeButton;

    public MenuItem getSolverItem1() {
        return solverItem1;
    }

    public MenuItem getSolverItem2() {
        return solverItem2;
    }

    public ComboBox getFileList() {
        return fileList;
    }

    public Button getExecuteButton() {
        return executeButton;
    }

    public static Pane getCanvas() {
        return canvas;
    }

    public void resetCanvas(){
        canvas = new Pane();
        canvas.relocate(10, 30);
        canvas.setStyle("-fx-background-color: beige;");
        canvas.setPrefSize(1480,760);

        getChildren().addAll(canvas);
    }

    public Viewer(){
        topPane = new Pane();
        canvas = new Pane();
        canvas.relocate(10, 30);
        canvas.setStyle("-fx-background-color: beige;");
        canvas.setPrefSize(1480,760);

        solverMenu = new Menu("Solvers");
        solverItem1 = new MenuItem("2-Approximation Algorithm");
        solverItem2 = new MenuItem("Nearest Neighbor Algorithm");
        menuBar = new MenuBar();
        solverMenu.getItems().addAll(solverItem1, solverItem2);
        menuBar.getMenus().addAll(solverMenu);

        String[] files = {"test.txt",  "westernsahara.txt", "djibouti.txt", "qatar.txt", "uruguay.txt", "canada.txt", "luxembourg.txt", "italy.txt", "monalisa.txt"}; //"vietnam.txt"
        fileList = new ComboBox(FXCollections.observableArrayList(files));
        fileList.relocate(100, 0);

        executeButton = new Button("Run");
        executeButton.relocate(1450, 0);

        topPane.getChildren().addAll(menuBar, fileList, executeButton);
        getChildren().addAll(topPane, canvas);

    }
}
