package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public interface Graph {

    public void loadGraph(BufferedReader file) throws IOException;
    public void resetGraph(int V);
    public void addEdge(Vertex src, Vertex dest, float weight);
    public float getEdge(int src, int dest);
    public List<Edge> getEdges(int vertex);
    public String toString();
    public int getNumVertices();
    public void setNumVertices(int V);
    public List<Vertex> getVertexSet();
    public float[] getMinMax();

}
