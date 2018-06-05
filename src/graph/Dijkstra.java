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
        int positionCurrentVertex;
        double cost;
        double minCost;

        double firstValue;
        double lastValue;

        int vertexMinCost;

        for (Vertex v : this.V) {
            positionCurrentVertex = this.V.indexOf(v);

            cost = this.hasEdge(source, v);

            this.prev.add(positionCurrentVertex, this.V.get(0));
            this.D[positionCurrentVertex] = cost;

        }

        Vertex v;
        positionCurrentVertex = 0;

        while (this.S.size() != this.V.size()) {
            vertexMinCost = this.getMinCost(this.D, this.S.size());
            v = this.V.get(vertexMinCost);
            this.prev.set(vertexMinCost, this.S.get(this.S.size() - 1));
            this.S.add(v);

            for (Vertex w : this.V) {
                if (this.S.contains(w)) {
                    continue;
                } else {
                    positionCurrentVertex = this.V.indexOf(w);

                    firstValue = this.D[positionCurrentVertex];

                    lastValue =  this.D[vertexMinCost] + hasEdge(w, v);

                    minCost = Math.min(firstValue, lastValue);
                    this.D[positionCurrentVertex] = minCost;

                    if (lastValue < firstValue) {
                        prev.set(positionCurrentVertex, v);
                    }

                }

            }
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
    private int getMinCost(double[] list, int init)
    {
        double minValue;
        minValue = list[init];

        int position = init;
        init++;
        for (int i = init; i < list.length; i++) {

            if (minValue == 0) {
                minValue = list[i];
                position = i;
                continue;
            }

            if (list[i] < minValue && list[i] != 0) {
                minValue = list[i];
                position = i;
            }
        }

        return position;
    }

    @Override
    public String toString()
    {
        String msg = "";
        for (int i = 0; i < this.D.length; i++) {
            if (this.D[i] == 0) {
                continue;
            }
            msg = msg + " ## custo -> " + Double.toString(this.D[i]) + " | Vértice anterior -> " + this.prev.get(i).getKey() + "## " + System.lineSeparator();
        }
        return msg;
    }

}
