package graph;

import java.util.ArrayList;

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
    public abstract ArrayList<Vertex> finalVertex(Edge e);

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

    /**
     * Retorna uma aresta a partir dos vetores adicionados
     */
    public abstract ArrayList getEdge(Vertex v, Vertex w);


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
     * Remove o vértice vertex ( e todas as arestas incidentes) e retorna o elemento armazenado em vertex
     */
	public abstract void removeVertex(Vertex vertex);

    /**
     * Remove a aresta edge, retornando o elemento armazenado
     */
    public abstract void removeEdge(Vertex v, Vertex w, int key);

// %%%%%%%%%%%%%%%%%%%%% Métodos Interadores simplificado %%%%%%%%%%%%%%%%%%%%% //

    /**
     * Retorna uma coleção de todas as arestas incidentes sob o vértice v
     */
    public abstract ArrayList<Edge> edgesIncidents(Vertex v);

    /**
     * Retorna uma coleção de todos os vértices no grafo.
     */
    public abstract ArrayList<Vertex> vertex();

    /**
     * Retorna uma coleçao de todas as arestas no grafo
     */
	public abstract ArrayList<Edge> edge();

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
    public abstract void insertEdgeDirected(Vertex vertexOne, Vertex vertexTwo, double value);











}
