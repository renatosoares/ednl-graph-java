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
    public void search()
    {
        Vertex s = this.V.get(0);

        for (Vertex v : this.V) {
            if (s == v) {
                continue;
            }

            v.setChecked(0);
            v.setChecked(-1);
        }

        this.d.add(s.getKey(), 0);
        this.Q.add(s);

        while (this.Q.isEmpty() != true) {
            Vertex v = this.Q.remove();

            for (Vertex vertex : this.V) {
                if (this.G.isAdjacent(v, vertex) && v != vertex) {
                    this.ADJ.add(v.getKey(), vertex);
                }
            }

            for (Vertex w : this.ADJ) {
                if (w.getChecked() == 0) {
                    this.d.set(w.getKey(), this.d.get(w.getKey() + 1));
                    w.setChecked(-1);
                    this.Q.add(w);
                }
            }

            v.setChecked(1);

            this.ADJ.clear();
        }
	}

}
