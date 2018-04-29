package graph;

/**
 * 
 * @author renato soares
 * 
 * 
 *
 */
public interface IEdge 
{
	/**
	 * private Vertex vertexOrigin
	 * private Vertex vertexDestination
	 * private double value
	 * private boolean directed
	 * public Edge(Vertex vertexOrigin, Vertex vertexDestination) 
	 * public Edge(Vertex vertexOrigin, Vertex vertexDestination,double value)
     * public Edge(Vertex vertexOrigin, Vertex vertexDestination,double value, boolean directed)      
	 */

    /**
     * 
     */
    public abstract Vertex getVertexOrigin();

    /**
     * 
     */
    public abstract void setVertexOrigin(Vertex vertexOrigin);
    
    /**
     * 
     */
    public abstract Vertex getVertexDestination();

    /**
     * 
     */
    public abstract void setVertexDestination(Vertex vertexDestination);

    /**
     * 
     */
    public abstract double getValue();

    /**
     *
     */
    public abstract void setValue(double value);

    /**
     * Testa se a aresta é direcionada
     * 
     */
    public abstract boolean isDirected();

    /**
     * 
     */
    public abstract void setDirected(boolean directed);
}
