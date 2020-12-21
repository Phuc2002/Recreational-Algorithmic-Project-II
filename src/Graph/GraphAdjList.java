package Graph;

import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;

public class GraphAdjList extends AbstractGraph {

    private final HashMap<Integer, LinkedList<Edge>> adjList;

    public GraphAdjList(int v){
        super(v);
        this.adjList = new HashMap<>();
    }

    public void addEdge(Vertex src, Vertex dest, float weight){
        Edge e1 = new Edge(src, dest, weight);
        Edge e2 = new Edge(dest, src, weight);
        if (!adjList.containsKey(src.getCity())){
            adjList.put(src.getCity(), new LinkedList<Edge>());
        }
        if (!adjList.containsKey(dest.getCity())){
            adjList.put(dest.getCity(), new LinkedList<Edge>());
        }
        adjList.get(src.getCity()).addLast(e1);
        adjList.get(dest.getCity()).addLast(e2);
        //System.out.println(e);
    }

    public void resetGraph(int v) {
        super.resetGraph(v);
        adjList.clear();
    }

    public float getEdge(int i, int j) {
        for (Edge e: adjList.get(i)){
            if (j == e.getDestination().getCity()){
                return e.getWeight();
            }
        }
        return -1;
    }

    public List<Edge> getEdges(int i){
        return adjList.get(i);
    }

    public HashMap<Integer, LinkedList<Edge>> getAdjList() {
        return adjList;
    }

    public String toString() {
        String str = "";

        for (int i : adjList.keySet()){
            str += i + " --> ";
            for (Edge e : adjList.get(i)) {
                str += e + ";  ";
            }
            str += '\n';
        }

        return str;
    }
}
