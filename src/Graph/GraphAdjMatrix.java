package Graph;

import Graph.Edge;

import java.util.LinkedList;
import java.util.List;

public class GraphAdjMatrix extends AbstractGraph {

    private float[][] adjMatrix;

    public GraphAdjMatrix(int v){
        super(v);
        this.adjMatrix = new float[V][V];
    }

    public void resetGraph(int v){
        super.resetGraph(v);
        adjMatrix = new float[V][V];
    }

    public void addEdge(Vertex src, Vertex dest, float weight){
        adjMatrix[src.getCity()][dest.getCity()] = weight;
        adjMatrix[dest.getCity()][src.getCity()] = weight;
    }

    public float getEdge(int i, int j) {
        return adjMatrix[i][j];
    }

    public List<Edge> getEdges(int vertex) {
        LinkedList<Edge> neighbors = new LinkedList<>();
        Vertex src = vertexSet.get(vertex - 1);
        for (int i = 1; i < V; i++){
            Vertex dest = vertexSet.get(i - 1);
            if (dest.getCity() != src.getCity()) {
                neighbors.addLast(new Edge(src, dest, getEdge(src.getCity(), dest.getCity())));
            }
        }
        return neighbors;
    }

    public float[][] getAdjMatrix() {
        return adjMatrix;
    }

    public String toString(){
        String str = "";
        for (int i = 0; i < vertexSet.size(); i++){
            for (int j = 0; j < vertexSet.size(); j++){
                if (i != j) {
                    str += vertexSet.get(i) + " to " + vertexSet.get(j) + " weight " + adjMatrix[i + 1][j + 1] + ";  ";
                }
            }
            str += "\n";
        }

        return str;
    }

}
