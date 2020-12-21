package Graph;

import App.Viewer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.io.*;

public class Vertex {
    private float x;
    private float y;
    private int city;
    private boolean isNormalized;

    public Vertex(){
        this(0, 0, 0);
    }

    public Vertex(float x, float y, int city){
        this.x = x;
        this.y = y;
        this.city = city;
        this.isNormalized = false;
    }

    public float distanceTo(Vertex neighbor){
        return (float) Math.sqrt( Math.pow( this.x - neighbor.x, 2) +
                          Math.pow( this.y - neighbor.y, 2) );
    }

    public static Vertex loadVertex(BufferedReader file) throws java.io.IOException {
        Vertex v = new Vertex();
        String[] line = file.readLine().split(" ");
        v.city = Integer.parseInt(line[0]);
        v.x = Float.parseFloat(line[1]);
        v.y = Float.parseFloat(line[2]);

        return v;
    }

    public void normalize(float[] minMax, int newScaleX, int newScaleY){
        if (!isNormalized) {
            float minX = minMax[0];
            float minY = minMax[1];
            float maxX = minMax[2];
            float maxY = minMax[3];

            this.x = ((this.x - minX) / (maxX - minX)) * newScaleX;
            this.y = ((this.y - minY) / (maxY - minY)) * newScaleY;
            this.isNormalized = true;
        }
    }

    public int getCity() {
        return city;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String toString() {
        return String.format("City %d (%.2f, %.2f)", city, x, y);
    }

    public void drawAndConnectLine(Vertex u){
        Circle circle = new Circle(1.5  , Color.BLACK);
        circle.relocate((int) this.x, 749 - (int) this.y);

        Line line = new Line();
        line.setStartX((int) this.x + 1);
        line.setStartY(750 - (int) this.y);
        line.setEndX((int) u.x + 1);
        line.setEndY(750 - (int) u.y);

        Viewer.getCanvas().getChildren().addAll(circle, line);
    }
}
