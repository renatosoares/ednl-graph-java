package graph;

import java.util.ArrayList;
import java.util.Iterator;

public class Edge implements IEdge
{
    private Vertex vertexOrigin;
    private Vertex vertexDestination;
    private double value;
    private boolean directed;
    private ArrayList<Edge> edgeCollection;

    /**
     *
     */
    public Edge(Vertex vertexOrigin, Vertex vertexDestination, double value)
    {
        this.vertexOrigin = vertexOrigin;
        this.vertexDestination = vertexDestination;
        this.value = value;
    }

	@Override
    public Vertex getVertexOrigin()
    {
		return vertexOrigin;
	}

	@Override
    public void setVertexOrigin(Vertex vertexOrigin)
    {
		this.vertexOrigin = vertexOrigin;
	}

	@Override
    public Vertex getVertexDestination()
    {
		return vertexDestination;
	}

	@Override
    public void setVertexDestination(Vertex vertexDestination)
    {
		this.vertexDestination = vertexDestination;
	}

	@Override
    public double getValue()
    {
		return value;
	}

	@Override
    public void setValue(double value)
    {
		this.value = value;
	}

	@Override
    public boolean isDirected()
    {
		return directed;
	}

	@Override
    public void setDirected(boolean directed)
    {
		this.directed = directed;
    }

    public String toString()
    {
        // String outValue = new String();
        // Iterator<Edge> edgeIterator = edgeCollection.iterator();
        //
        // while (edgeIterator.hasNext()) {
        //     outValue += " " + edgeIterator.next().getValue();
        // }

		return "| cost => " + this.value + " | ";
    }
}
