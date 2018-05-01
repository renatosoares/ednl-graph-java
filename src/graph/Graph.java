package graph;

import java.util.Vector;

public class Graph implements IGraph
{
	@Override
	public Vector finalVertex(Edge e) {
		return null;
	}

	@Override
	public Vertex opposite(Vertex v, Edge e) throws Exception {
		return null;
	}

	@Override
	public boolean isAdjacent(Vertex v, Vertex w) {
		return false;
	}

	@Override
	public void replaceVertex(Vertex v, int x) {
		
	}

	@Override
	public void replaceEdge(Edge v, int x) {
		
	}

	@Override
	public Vertex insertVertex(Vertex vertex) {
		return null;
	}

	@Override
	public Edge insertEdge(Vertex vertexOne, Vertex vertexTwo, double value) {
		return null;
	}

	@Override
	public Edge insertEdge(Vertex vertexOne, Vertex vertexTwo) {
		return null;
	}

	@Override
	public int removeVertex(Vertex vertex) {
		return 0;
	}

	@Override
	public int removeEdge(Edge edge) {
		return 0;
	}

	@Override
	public Vector edgesIncidents(Vertex v) {
		return null;
	}

	@Override
	public Vector vertex() {
		return null;
	}

	@Override
	public Vector edge() {
		return null;
	}

	@Override
	public int degree(Vertex vertex) {
		return 0;
	}

	@Override
	public int order() {
		return 0;
	}

	@Override
	public boolean isDirected(Edge e) {
		return false;
	}

	@Override
	public void insertEdgeDirected(Vertex vertexOne, Vertex vertexTwo, int value) {
		
	}
}
