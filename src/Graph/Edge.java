package Graph;

public class Edge {
    private Vertex source;
    private Vertex destination;
    private float weight;

    public Edge(Vertex source, Vertex destination, float weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public Vertex getDestination() {
        return destination;
    }

    public Vertex getSource() {
        return source;
    }

    public String toString(){
        return String.format("Graph.Edge weight %.2f between " + source + " and " + destination, weight);
    }
}
