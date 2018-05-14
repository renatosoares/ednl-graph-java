package graph;

import java.util.ArrayList;

public class Main
{
    public static final void main(String[] cmd_lineParams)
    {
        Graph g = new Graph();

        Vertex v0 = new Vertex(0, 9.00);
        Vertex v1 = new Vertex(1, 10.00);
        Vertex v2 = new Vertex(2, 13.00);
        Vertex v3 = new Vertex(3, 12.00);
        Vertex v4 = new Vertex(4, 14.00);

        g.insertVertex(v0);
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

        g.insertEdge(vertex.get(0), vertex.get(3), 10);

        g.insertEdge(vertex.get(2), vertex.get(0), 30);

        g.insertEdge(vertex.get(2), vertex.get(3), 15);

        g.insertEdge(vertex.get(4), vertex.get(3), 35);
        g.insertEdge(vertex.get(4), vertex.get(1), 27);

        g.insertEdge(vertex.get(1), vertex.get(2), 33);
        g.insertEdge(vertex.get(1), vertex.get(2), 41);



        g.showMatrix();

        System.out.println();


        System.out.print("%%%%%%%% remoção aresta %%%%%%%%");
        System.out.println();

        g.removeEdge(vertex.get(1), vertex.get(2), 0);

        g.showMatrix();

        System.out.println();

        System.out.print("%%%%%%%% remoção vértice %%%%%%%%");
        System.out.println();

        g.removeVertex(vertex.get(0));

        g.showMatrix();

        System.out.println();

        System.out.print("%%%%%%%% Verifica se existe caminho Eureliano %%%%%%%%");
        System.out.println();
        System.out.print(g.eulerianPath());

    }
}
