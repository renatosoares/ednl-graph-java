package graph;

import java.util.ArrayList;
import java.util.Collections;

public class VertexColoring implements IVertexColoring
{
    private Graph G;
    private ArrayList<Vertex> vertices;
    private ArrayList<Vertex> V;
    private ArrayList<Vertex>[] T;

    public VertexColoring(Graph graph)
    {
        this.G = graph;
        this.vertices = this.G.vertex();
        this.V = new ArrayList<Vertex>(this.vertices.size());
        this.T[this.vertices.size()] = new ArrayList<Vertex>(this.vertices.size());
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

        Collections.sort(this.V);

        i = 0;

        while (! this.V.isEmpty()) {
            this.T[i].add(this.V.remove(0));

            int k = 0;
            while (! this.G.isAdjacent(this.V.get(k), this.T[i].get(k))) {
                this.T[i].add(this.V.remove(k));

                if (++k < this.V.size()) {
                    k = 0;
                    break;
                }
            }
            i++;
        }
    }

    public String toString()
    {
        String msg = "";

        for (int i = 0; i < this.T.length; i++) {
            for (int j = 0; j < this.T[i].size(); i++) {

                msg += "|#| cor -> " + i + " |#| " + "|#| vértice -> " + this.T[i].get(j).getKey() + " |#| " + System.lineSeparator();
            }
        }

        return msg;
    }
}
