package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch implements IBreadthFirstSearch
{
    private ArrayList<Vertex> V;
    private ArrayList<Integer> d;
    private Queue<Vertex> Q;

    private Graph G;
    private ArrayList<Vertex> ADJ;

    public BreadthFirstSearch(ArrayList<Vertex> vertices, Graph graph)
    {
        this.V = vertices;
        this.Q = new LinkedList<Vertex>();

        this.G = graph;
        this.ADJ = new ArrayList<Vertex>();
    }

	@Override
    public void search(int vertexKey)
    {
        Vertex s = this.V.get(vertexKey);

        for (Vertex v : this.V) {



            if (s == v) {
                continue;
            }

            v.setChecked(0);

        }
        s.setChecked(-1);
        this.d.add(vertexKey, 0);
        this.Q.add(s);

        while (this.Q.isEmpty() != true) {
            Vertex v = this.Q.remove();

            for (Vertex w : this.V) {
                if (this.G.isAdjacent(v, w)) {
                    Edge e = (Edge) this.G.getEdge(v, w).get(0);

                    if (w.getChecked() == 0) {
                        if (e.isDirected() && e.getVertexOrigin() == v && e.getVertexDestination() == w) {

                            this.d.add(w.getKey(), this.d.get(v.getKey()) + 1);
                            w.setChecked(-1);
                            this.Q.add(w);

                        } else {

                            this.d.add(w.getKey(), this.d.get(v.getKey()) + 1);
                            w.setChecked(-1);
                            this.Q.add(w);

                        }
                    }
                }
            }

            v.setChecked(1); // marcado
        }
    }

    public String toString() // FIXME parei aqui
    {
        String msg = "";

        for (int i = 0; i < this.Q.size(); i++) {
            // msg += "|#| d => " + this.d.get(i) + " |-> s => " + this.s.get(i) + " |-> vertex => " + this.V.get(i).getKey() + " |#|" + System.lineSeparator();
        }

        return msg;
    }

}
