package graph;

import java.util.ArrayList;

/**
 * Dijkstra
 */
public class Dijkstra implements IDijkstra
{
    private ArrayList<Vertex> S;
    private ArrayList<Vertex> V;
    private double[] D;
    private ArrayList<Vertex> antecessor;
    private Graph G;


    public Dijkstra(ArrayList<Vertex> vertices, Graph graph)
    {
        this.V = vertices;
        this.S = new ArrayList<Vertex>();
        this.D = new double[vertices.size()];
        this.antecessor = new ArrayList<Vertex>(vertices.size());

        this.G = graph;
    }

	@Override
    public void shortestPath(Vertex source)
    {
        double firstValue;
        double lastValue;
        Vertex w;

        this.S.add(source);

        for (Vertex v : this.V) {
            this.D[v.getKey()] = this.G.hasEdge(source, v);
            this.antecessor.add(v.getKey(), this.V.get(0));
        }

        while (this.S.size() != this.V.size()) {

            w = this.getMinCost(this.D, this.S);
            this.S.add(w);

            for (Vertex v : this.V) {
                if (this.S.contains(v)) {
                    continue;

                } else {
                    firstValue = this.D[v.getKey()];
                    lastValue =  this.D[w.getKey()] + this.G.hasEdge(w, v);
                    this.D[v.getKey()] = Math.min(firstValue, lastValue);

                    if (lastValue < firstValue) {
                        this.antecessor.set(v.getKey(), w);
                    }
                }
            }
        }
    }

    /**
    * Pega o valor mínimo do array, e retorna o vértice ligado a esse valor
    */
    private Vertex getMinCost(double[] list, ArrayList<Vertex> cloud)
    {
        double minValue = list[0];
        int position = 0;

        for (int i = 0; i < list.length; i++) {

            if (cloud.contains(this.V.get(i))) {
                continue;
            } else {
                if (minValue == 0) {
                    minValue = list[i];
                    position = i;
                    continue;

                } else if (list[i] < minValue && list[i] != 0) {
                    minValue = list[i];
                    position = i;
                }
            }
        }

        return this.V.get(position);
    }

    @Override
    public String toString()
    {
        String msg = "";

        for (Vertex v : this.S) {
            if (this.S.indexOf(v) == 0) {
                msg += v.getKey();
            } else {
                msg += " => " + v.getKey();
            }
        }

        msg += System.lineSeparator();
        msg += System.lineSeparator();

        for (int i = 0; i < this.D.length; i++) {
            if (this.D[i] == 0) {
                continue;
            }
            msg += " ## Para vértice " + i + " = custo -> " + Double.toString(this.D[i]) + " | Vértice antecessor -> " + this.antecessor.get(i).getKey() + " ## " + System.lineSeparator();
        }
        return msg;
    }

}
