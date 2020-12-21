/*
import Graph.*;

import java.io.*;
import java.util.*;

public class TestProgram {
    public static void main(String[] args) {
        try {
            BufferedReader file = new BufferedReader(new FileReader("test.txt"));
            int v = Integer.parseInt(file.readLine());
            Graph g = new Graph.GraphAdjMatrix(v);
            g.loadGraph(file);
            List<Graph.Edge> edges = g.getEdges(3);

            for (Graph.Edge e: edges){
                System.out.println(e);
            }

            //System.out.println(g);                            //this little maneuver
            //System.out.println("\n\n");                       //is gonna cost us
            //System.out.println(mst);                          //51 years
            //System.out.println(mst.getEdge(29, 7));           //for small datasets you're allowed to uncomment these lines.


            file.close();


        } catch (FileNotFoundException e) {
            System.out.println("Error: Cannot open file.");
        } catch (IOException e) {
            System.out.println("Error: Cannot read from file");
        }
    }

}*/
