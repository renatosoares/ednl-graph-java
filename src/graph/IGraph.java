package graph;

import java.util.ArrayList;
import java.util.Vector;

public interface IGraph 
{
	/**
	 * private int quantityVertex;
	 * private ArrayList vertex;
	 * private Edge matrixAdj[][]
	 */

// %%%%%%%%%%%%%%%%%%%%% Acesso simplificado %%%%%%%%%%%%%%%%%%%%% //
    
    /**
	 * Retorna um array armazenando os vértices finais da aresta e.
	 */
    public abstract Vector finalVertex(Edge e);
    
    /**
     * Retorna o vértice oposto de v em e, ou seja, o vértice final da aresta e separado do vértice v. Um erro ocorre se e não é incidente a v
     */
    public abstract Vertex opposite(Vertex v, Edge e) throws Exception;

    /**
     * Retorna true se v e w são adjacentes
     */
    public abstract boolean isAdjacent(Vertex v, Vertex w);
    
    /**
     * Substitui o elemento armazenado no vértice V por X
     */
    public abstract void replaceVertex(Vertex v, int x);

    /**
     * Substitui o elemento armazenado na aresta e com x
     */
    public abstract void replaceEdge(Edge v, int x);


// %%%%%%%%%%%%%%%%%%%%% Atualização simplificado %%%%%%%%%%%%%%%%%%%%% //
    
    /**
	 * Insere e retorna um novo vértice armazenando o elemento Vertex
	 */
	public abstract Vertex insertVertex(Vertex vertex);
    
    /**
     * Insere e retorna uma nova aresta não-dirigida (vertexOne, vertexTwo) armazenando o elemento value
     */
    public abstract Edge insertEdge(Vertex vertexOne, Vertex vertexTwo, double value);
	/**
     * Insere e retorna uma nova aresta não-dirigida (vertexOne, vertexTwo)
     */
	public abstract Edge insertEdge(Vertex vertexOne, Vertex vertexTwo);

    /**
     * Remove o vértice vertex ( e todas as arestas incidentes) e retorna o elemento armazenado em vertex
     */
	public abstract int removeVertex(Vertex vertex);

    /**
     * Remove a aresta edge, retornando o elemento armazenado
     */
    public abstract int removeEdge(Edge edge);
    
// %%%%%%%%%%%%%%%%%%%%% Métodos Interadores simplificado %%%%%%%%%%%%%%%%%%%%% //    

    /**
     * Retorna uma coleção de todas as arestas incidentes sob o vértice v
     */
    public abstract Vector edgesIncidents(Vertex v);
    
    /**
     * Retorna uma coleção de todos os vértices no grafo.
     */
    public abstract Vector vertex();

    /**
     * Retorna uma coleçao de todas as arestas no grafo
     */
	public abstract Vector edge();
    
// %%%%%%%%%%%%%%%%%%%%% %%%%%%%%%%%%%%%%% %%%%%%%%%%%%%%%%%%%%% // 

    /**
     * 
     */
    public abstract int degree(Vertex vertex);

    /**
     * 
     */
    public abstract int order();
    
// %%%%%%%%%%%%%%%%%%%%% Dirigido simplificado %%%%%%%%%%%%%%%%%%%%% // 

    /**
     * Testa se a aresta é direcionada
     */
    public abstract boolean isDirected(Edge e);

    /**
     * Inserir uma nova aresta dirigida com origem em vertexOne e destino em vertexTwo e armazenando o elemento value.
     */
    public abstract void insertEdgeDirected(Vertex vertexOne, Vertex vertexTwo, int value);








	

		
}
