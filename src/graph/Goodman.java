package graph;

import java.util.ArrayList;
import java.util.Iterator;

public class Goodman extends Graph implements IGoodman
{
    private ArrayList<Vertex> allVertex;
    private int connectivity;
    private int quantityVertex;

    public Goodman(ArrayList<Vertex> vertex)
    {
        this.allVertex = vertex;
        this.connectivity = 0;
        this.quantityVertex = vertex.size();
    }

	@Override
	public boolean hasConnection(ArrayList<Vertex> vetex) {
        int q = 0;
        while (this.allVertex != null) {
            Vertex v = this.allVertex.get(0);

        }
		return false;
	}
}
