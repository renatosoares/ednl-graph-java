package graph;

public class Edge implements IEdge
{
    private Vertex vertexOrigin;
    private Vertex vertexDestination;
    private double value;
    private boolean directed;

    /**
     *
     */
    public Edge(Vertex vertexOrigin, Vertex vertexDestination)
    {
        super();
        this.vertexOrigin = vertexOrigin;
        this.vertexDestination = vertexDestination;
        this.directed = false;
    }

    /**
     *
     */
    public Edge(Vertex vertexOrigin, Vertex vertexDestination, double value)
    {
        super();
        this.vertexOrigin = vertexOrigin;
        this.vertexDestination = vertexDestination;
        this.value = value;
        this.directed = false;
    }

    /**
     *
     */
    public Edge(Vertex vertexOrigin, Vertex vertexDestination, double value, boolean directed)
    {
        super();
        this.vertexOrigin = vertexOrigin;
        this.vertexDestination = vertexDestination;
        this.value = value;
        this.directed = directed;
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
        return "| cost => " + this.value + " | ";
    }

    public void addLinkedList()
    {
        // cada edge tem um array list com os valores, de cada aresta
    }
}
