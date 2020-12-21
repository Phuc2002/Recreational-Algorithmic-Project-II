package Algorithm;

import Graph.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public interface Solver {

    public void loadGraph(BufferedReader file) throws IOException;
    public void reset(int V);
    public List<Vertex> solve();
    public Graph getG();
}
