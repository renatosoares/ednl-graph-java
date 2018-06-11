package graph;

import java.util.ArrayList;

public class DepthFirstSearch implements IDepthFirstSearch
{

    private ArrayList<Vertex> V;
    private ArrayList<Integer> d;
    private ArrayList<Integer> s;
    private int t;

    private Graph G;

    public DepthFirstSearch(ArrayList<Vertex> vertices, Graph graph)
    {
        this.V = vertices;
        this.G = graph;
        this.d = new ArrayList<Integer>();
        this.s = new ArrayList<Integer>();
    }

    @Override
    public void search()
    {
        for (Vertex v : this.V ) {
            v.setChecked(0);
            this.d.add(v.getKey(), 0);
            this.s.add(v.getKey(), 0);
        }

        this.t = 0;

        for (Vertex v : this.V) {
            if (v.getChecked() == 0) {
                this.visit(v);
            }
        }
    }

    private void visit(Vertex v)
    {
        v.setChecked(-1);
        d.set(v.getKey(), ++this.t);

        for (Vertex vertex : this.V) {
                if (this.G.isAdjacent(v, vertex)) {
                    if (vertex.getChecked() == 0) {
                        this.visit(vertex);
                    }

                }
        }
        v.setChecked(1);
        this.s.set(v.getKey(), ++this.t);
    }

    public String toString()
    {
        String msg = "";

        for (int i = 0; i < this.V.size(); i++) {
            msg += "|#| d => " + this.d.get(i) + " |-> s => " + this.s.get(i) + " |-> vertex => " + this.V.get(i).getKey() + " |#|" + System.lineSeparator();
        }

        return msg;
    }
}
