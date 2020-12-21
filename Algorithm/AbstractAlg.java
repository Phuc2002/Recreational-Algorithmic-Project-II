package Algorithm;

import Graph.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public abstract class AbstractAlg implements Solver {
    protected Graph g;
    protected int NUM_VERTICES;
    protected List<Vertex> vertexSet;

    public AbstractAlg(Graph g){
        this.g = g;
        this.vertexSet = g.getVertexSet();
        this.NUM_VERTICES = g.getNumVertices();
    }

    public void loadGraph(BufferedReader file) throws IOException{
        this.g.loadGraph(file);
    }

    public void reset(int V){
        this.g.resetGraph(V);
        this.NUM_VERTICES = g.getNumVertices();
        this.vertexSet = g.getVertexSet();
    }

    public abstract List<Vertex> solve();

    public Graph getG() {return g;}
}
