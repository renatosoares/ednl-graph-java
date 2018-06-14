package graph;

import java.util.ArrayList;

public class Main
{
    public static final void main(String[] cmd_lineParams)
    {
        Graph g = new Graph();

        Graph graphColor = new Graph();

        Vertex v0 = new Vertex(0, 10.00);
        Vertex v1 = new Vertex(1, 11.00);
        Vertex v2 = new Vertex(2, 12.00);
        Vertex v3 = new Vertex(3, 13.00);
        Vertex v4 = new Vertex(4, 14.00);
        Vertex v5 = new Vertex(5, 15.00);
        Vertex v6 = new Vertex(6, 16.00);

        g.insertVertex(v0);
        g.insertVertex(v1);
        g.insertVertex(v2);
        g.insertVertex(v3);
        g.insertVertex(v4);
        g.insertVertex(v5);
        g.insertVertex(v6);

        graphColor.insertVertex(v0);
        graphColor.insertVertex(v1);
        graphColor.insertVertex(v2);
        graphColor.insertVertex(v3);

        System.out.print("%%%%%%%% insere vértice %%%%%%%%");
        System.out.println();

        g.showVertex();

        System.out.println();

        ArrayList<Vertex> vertex = g.vertex();

        System.out.println();
        System.out.print("%%%%%%%% Matriz Adjacente %%%%%%%%");

        System.out.println();

        g.insertEdgeDirected(vertex.get(0), vertex.get(1), 10);
        g.insertEdgeDirected(vertex.get(0), vertex.get(3), 15);


        g.insertEdgeDirected(vertex.get(1), vertex.get(3), 25);
        g.insertEdgeDirected(vertex.get(1), vertex.get(4), 60);

        g.insertEdgeDirected(vertex.get(2), vertex.get(0), 35);
        g.insertEdgeDirected(vertex.get(2), vertex.get(5), 30);

        g.insertEdgeDirected(vertex.get(3), vertex.get(2), 20);
        g.insertEdgeDirected(vertex.get(3), vertex.get(4), 100);
        g.insertEdgeDirected(vertex.get(3), vertex.get(5), 33);
        g.insertEdgeDirected(vertex.get(3), vertex.get(6), 41);

        g.insertEdgeDirected(vertex.get(4), vertex.get(6), 40);

        g.insertEdgeDirected(vertex.get(6), vertex.get(5), 45);



        g.showMatrix();

        // System.out.println();


        // System.out.print("%%%%%%%% remoção aresta %%%%%%%%");
        // System.out.println();

        // // g.removeEdge(vertex.get(1), vertex.get(2), 0);

        // g.showMatrix();

        // System.out.println();

        // System.out.print("%%%%%%%% remoção vértice %%%%%%%%");
        // System.out.println();

        // // g.removeVertex(vertex.get(0));

        // g.showMatrix();

        System.out.println();

        // System.out.print("%%%%%%%% Verifica se existe caminho Eureliano %%%%%%%%");
        // System.out.println();
        // System.out.print(g.eulerianPath());

        // System.out.println();
        // System.out.print("%%%%%%%% dijkstra %%%%%%%%");
        // System.out.println();

        // Dijkstra dkt = new Dijkstra(g.vertex(), g);
        // dkt.shortestPath(v0);
        // System.out.print(dkt);
        // System.out.println();


        // System.out.println();
        // System.out.print("%%%%%%%% DFS %%%%%%%%");
        // System.out.println();

        // DepthFirstSearch dfs = new DepthFirstSearch(g.vertex(), g);
        // dfs.search();
        // System.out.print(dfs);
        // System.out.println();

        // System.out.println();
        // System.out.print("%%%%%%%% BFS %%%%%%%%");
        // System.out.println();

        // BreadthFirstSearch bfs = new BreadthFirstSearch(g.vertex(), g);
        // bfs.search(0);
        // System.out.print(bfs);
        // System.out.println();

        System.out.println();
        System.out.print("%%%%%%%% Coloração de Grafos %%%%%%%%");
        System.out.println();

        VertexColoring vcolor = new VertexColoring(graphColor);
        vcolor.coloring();
        System.out.print(vcolor);
        System.out.println();

    }
}
