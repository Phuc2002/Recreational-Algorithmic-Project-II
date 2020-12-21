package Algorithm;

import Graph.*;

import java.util.List;
import java.util.Stack;
import java.util.LinkedList;

public class ApproxAlg extends AbstractAlg {

    public ApproxAlg(int V){
        super(new GraphAdjMatrix(V));
        //this.g = new Graph.GraphAdjMatrix(V);
    }

    public List<Vertex> solve(){
        //run minimum spanning tree
        Graph mst = primsMST();

        // run DFS
        List<Vertex> hamiltonian = DFS(mst);
        return hamiltonian;
    }



    private Graph primsMST(){
        boolean[] inMST = new boolean[NUM_VERTICES];
        Predecessor[] tree = new Predecessor[NUM_VERTICES];
        float[] key = new float[NUM_VERTICES];

        for (int i = 1; i < NUM_VERTICES; i++){
            key[i] = Integer.MAX_VALUE;
            inMST[i] = false;
            tree[i] = new Predecessor();
        }

        key[1] = 0;
        tree[1].setParent(1);

        for (int i = 1; i < NUM_VERTICES; i++){
            int vertex = getMinKeyVertex(inMST, key);
            inMST[vertex] = true;

            for (int j = 1; j < NUM_VERTICES; j++){            //get all the neighbors j of vertex
                if (vertex != j && !inMST[j] && g.getEdge(vertex, j) < key[j]){
                    key[j] = g.getEdge(vertex, j);
                    tree[j].setParent(vertex);
                    tree[j].setWeight(key[j]);
                }
            }
        }

        /*for (int i = 1; i < NUM_VERTICES; i++){
            System.out.println("City " + i + tree[i]);
        }
        System.out.println("\n");*/

        Graph mst = getMST(tree);
        return mst;
    }

    private Graph getMST(Predecessor[] parents){
        int size = parents.length;
        int i;
        Graph graph = new GraphAdjList(size);
        for(i = 1; i < size; i++) {
            Vertex v = vertexSet.get(i - 1);
            Vertex u = vertexSet.get(parents[i].getParent() - 1);
            graph.addEdge(u, v, parents[i].getWeight());
        }

        return graph;
    }

    private int getMinKeyVertex(boolean[] inMST, float[] key){
        float minKey = Float.MAX_VALUE;
        int vertex = 0;

        for (int i = 1; i < NUM_VERTICES; i++){
            if (!inMST[i] && key[i] < minKey){
                minKey = key[i];
                vertex = i;
            }
        }

        return vertex;
    }


    private LinkedList<Vertex> DFS(Graph g){
        Stack<Vertex> stack = new Stack<>();
        boolean[] visited = new boolean[NUM_VERTICES];
        LinkedList<Vertex> tour = new LinkedList<>();

        for (int i = 1; i < NUM_VERTICES; i++){
            visited[i] = false;
        }

        Vertex v = vertexSet.get(0);         //get the first start node
        stack.push(v);

        while(!stack.empty()){
            v = stack.pop();

            if (!visited[v.getCity()]){
                visited[v.getCity()] = true;
                tour.addLast(v);
            }

            for (Edge e : g.getEdges(v.getCity())){
                if (!visited[e.getDestination().getCity()]){
                    stack.push(e.getDestination());
                }
            }
        }
        tour.addLast(vertexSet.get(0));

        /*for (Graph.Vertex u : tour){
            System.out.println(u);
        }
        System.out.println("\n");*/
        return tour;
    }
}
