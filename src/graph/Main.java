package graph;

import java.util.ArrayList;

public class Main
{
    public static final void main(String[] cmd_lineParams)
    {
        Graph g = new Graph();

        Vertex v1 = new Vertex(1, 10.00);
        Vertex v2 = new Vertex(2, 13.00);
        Vertex v3 = new Vertex(3, 12.00);
        Vertex v4 = new Vertex(4, 14.00);

        g.insertVertex(v1);
        g.insertVertex(v2);
        g.insertVertex(v3);
        g.insertVertex(v4);

        System.out.print("%%%%%%%% insere vértice %%%%%%%%");
        System.out.println();

        g.showVertex();

        System.out.println();

        ArrayList<Vertex> vertex = g.vertex();

        System.out.println();
        System.out.print("%%%%%%%% Matriz Adjacente %%%%%%%%");

        System.out.println();

        g.insertEdge(vertex.get(0), vertex.get(1), 40);

        g.insertEdge(vertex.get(0), vertex.get(2), 10);

        g.insertEdge(vertex.get(3), vertex.get(1), 30);

        g.insertEdge(vertex.get(3), vertex.get(2), 15);

        g.insertEdge(vertex.get(3), vertex.get(2), 35);
        g.insertEdge(vertex.get(3), vertex.get(2), 27);

        g.showMatrix();

        System.out.println();


        System.out.print("%%%%%%%% remoção aresta %%%%%%%%");
        System.out.println();

        g.removeEdge(vertex.get(3), vertex.get(2), 0);
        g.removeEdge(vertex.get(3), vertex.get(2), 0);
        g.removeEdge(vertex.get(3), vertex.get(2), 0);
        g.removeEdge(vertex.get(3), vertex.get(2), 0);

        g.showMatrix();

        System.out.println();

        System.out.print("%%%%%%%% remoção vértice %%%%%%%%");
        System.out.println();

        g.removeVertex(vertex.get(0));

        g.showMatrix();

    }
}
