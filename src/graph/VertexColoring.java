package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class VertexColoring implements IVertexColoring
{
    private Graph G;
    private ArrayList<Vertex> vertices;
    private PriorityQueue<Vertex> V;
    private PriorityQueue<Vertex> T;

    public VertexColoring(Graph graph)
    {
        this.G = graph;
        this.V = new PriorityQueue<Vertex>();
        this.vertices = this.G.vertex();
    }

    public void coloring()
    {
        int degree;
        int i;
        for (Vertex v : this.vertices) {
            degree = this.G.degree(v);
            v.setdegree(degree);
            this.V.add(v);

        }

        i = 1;

        while (this.V.isEmpty() != true) {
            this.T.add(this.V.poll());

            Vertex vT = this.T.peek();

            while (! this.G.isAdjacent(this.V.peek(), vT)) {
                this.T.add(this.V.poll());
            }
            i++;
        }
    }


}
