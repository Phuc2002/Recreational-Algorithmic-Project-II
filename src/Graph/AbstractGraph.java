package Graph;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGraph implements Graph {
    protected int V;                                    //store total number of vertices of the graph
    protected final ArrayList<Vertex> vertexSet;        //store the set of vertices of the graph
    protected float[] minMax;                           //store min & max values of coordinates to later rescale the data

    public AbstractGraph(int V){
        this.V = V + 1;                                 //the city start with 1 instead of 0 base index!
        this.vertexSet = new ArrayList<>();
        this.minMax = new float[4];
    }

    public void loadGraph(BufferedReader file) throws java.io.IOException{
        float minX = Float.MAX_VALUE, minY = Float.MAX_VALUE, maxX = -1, maxY = -1;
        while(file.ready()){
            Vertex v = Vertex.loadVertex(file);
            vertexSet.add(v);

            if (v.getX() < minX) minX = v.getX();
            if (v.getY() < minY) minY = v.getY();
            if (v.getX() > maxX) maxX = v.getX();
            if (v.getY() > maxY) maxY = v.getY();
        }

        minMax[0] = minX;
        minMax[1] = minY;
        minMax[2] = maxX;
        minMax[3] = maxY;

        for (int i = 0; i < vertexSet.size() - 1; i++){
            for (int j =  i + 1; j < vertexSet.size(); j++){
                Vertex source = vertexSet.get(i);
                Vertex destination = vertexSet.get(j);
                float weight = source.distanceTo(destination);
                addEdge(source, destination, weight);
            }
        }
    }

    public void resetGraph(int V){
        setNumVertices(V);
        vertexSet.clear();
        minMax = new float[4];
    }
    public abstract void addEdge(Vertex src, Vertex dest, float w);
    public abstract float getEdge(int src, int dest);
    public abstract List<Edge> getEdges(int vertex);
    public abstract String toString();

    public int getNumVertices(){
        return V;
    }

    public void setNumVertices(int V) {
        this.V = V + 1;
    }

    public List<Vertex> getVertexSet(){
        return vertexSet;
    }

    public float[] getMinMax() {
        return minMax;
    }
}
