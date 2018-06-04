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
    private ArrayList<Vertex> prev;
    private Vertex W;
    private Graph G;


    public Dijkstra(ArrayList vertices, Graph G)
    {
        this.V = vertices;
        this.S = new ArrayList<Vertex>();
        this.D = new double[vertices.size()];
        this.prev = new ArrayList<Vertex>();

        this.G = G;
    }

	@Override
    public ArrayList shortestPath(Vertex source)
    {
        this.S.add(source);
        // this.V.remove(source);
        int positionCurrentVertex;
        double cost;
        double minCost;

        double firstValue;
        double lastValue;

        int vertexMinCost;

        for (Vertex v : this.V) {
            positionCurrentVertex = this.V.indexOf(v);

            cost = this.hasEdge(source, v);

            // this.prev.add(positionCurrentVertex, v);
            this.D[positionCurrentVertex] = cost;

        }

        Vertex v;
        positionCurrentVertex = 0;

        while (this.S.size() != this.V.size()) {
            vertexMinCost = this.getMinCost(this.D);
            v = this.V.get(vertexMinCost);
            this.prev.add(vertexMinCost, v);
            this.S.add(vertexMinCost, v);

            for (Vertex w : this.V) {
                if (this.S.contains(w)) {
                    continue;
                } else {
                    positionCurrentVertex = this.V.indexOf(w);

                    firstValue = this.D[vertexMinCost];

                    lastValue = this.D[positionCurrentVertex] + hasEdge(w, v);

                    minCost = Math.min(firstValue, lastValue);
                    this.D[positionCurrentVertex] = minCost;

                    if (lastValue < firstValue) {
                        prev.set(positionCurrentVertex, w);
                    }

                }

            }
            // TODO vai ter que adicionar o nova aresta com base no menor valor do array que não foi adicionado.
            // TODO  verificar quando o valor retornado é zero.
            // this.S.add(prev.get(this.S.size()));
        }

		return prev;
    }

    /**
     * retorna custo se existir aresta adjacente
     */
    protected double hasEdge(Vertex source, Vertex next) // TODO
    {
        ArrayList edgesList;
        if (source == next) {
            return 0;
        } else if (! this.G.isAdjacent(source, next)) {
            return Double.POSITIVE_INFINITY;
        } else {
            edgesList = this.G.getEdge(source, next);
            return this.getMinParallelCost(edgesList);
        }
    }

    /**
     * Pega o valor mínimo da aresta paralela
     */
    private double getMinParallelCost(ArrayList<Edge> list)
    {
        Edge e = list.get(0);
        double minValue = e.getValue();

        if (list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).getValue() < minValue) {
                    minValue = list.get(i).getValue();
                }
            }
        }

        return minValue;
    }

     /**
     * Pega o valor mínimo do array
     */
    private int getMinCost(double[] list)
    {
        int init = 0;
        double minValue;
        if (list[init] != 0) {
            minValue = list[init];
        } else {
            init++;
            minValue = list[init];
        }


        int position = init;
        for (int i = init + 1; i < list.length; i++) {
            if (list[i] < minValue && list[i] != 0.0) {
                minValue = list[i];
                position = i;
            }
        }

        return position;
    }

    @Override
    public String toString()
    {
        String msg = "custo -> ";
        for (double minCost : this.D) {
            msg = msg + " " + Double.toString(minCost) + " | ";
        }
        return msg;
    }

}
