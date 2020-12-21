package Algorithm;

import Graph.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


public class NearestNeighborAlg extends AbstractAlg {

    public NearestNeighborAlg(int V){
        super(new GraphAdjMatrix(V));
        //this.g = new Graph.GraphAdjMatrix(V);
    }


    public List<Vertex> solve(){
        LinkedList<Vertex> tour = new LinkedList<>();
        HashSet<Vertex> visited = new HashSet<>();

        Vertex current = vertexSet.get(0);
        tour.addLast(current);
        visited.add(current);
        for (int i = 1; i < NUM_VERTICES - 1; i++){
            Vertex next = getClosestVertex(g.getEdges(current.getCity()), visited);
            tour.addLast(next);
            visited.add(next);

            current = next;
        }

        tour.addLast(vertexSet.get(0));
        return tour;
    }




    private Vertex getClosestVertex(List<Edge> edges, HashSet<Vertex> visited){
        float minWeight = Float.MAX_VALUE;
        Vertex closest = new Vertex();
        for (Edge e : edges){
            if (minWeight > e.getWeight() && !visited.contains(e.getDestination())){
                closest = e.getDestination();
                minWeight = e.getWeight();
            }
        }
        return closest;
    }
}
