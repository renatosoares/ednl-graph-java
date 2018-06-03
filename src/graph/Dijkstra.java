package graph;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Dijkstra

 */
public class Dijkstra implements IDijkstra
{
    ArrayList<Vertex> S;
    ArrayList<Vertex> V;
    double[] D;
    ArrayList<Vertex> prev;
    Vertex W;
    Graph G;


    public Dijkstra(ArrayList vertices, Graph G)
    {
        this.V = vertices;
        this.D = new double[vertices.size()];
        this.prev = new ArrayList<Vertex>();

        this.G = G;


    }

	@Override
    public ArrayList shortestPath(Vertex source)
    {
        this.S.add(source);
        this.V.remove(source);
        int positionCurrentVertex;
        double cost;
        double minCost;

        double firstValue;
        double lastValue;

        for (Vertex v : this.V) {
            positionCurrentVertex = this.V.indexOf(v);
            cost = this.hasEdge(source, v);

            this.prev.add(positionCurrentVertex, v);
            this.D[positionCurrentVertex] = cost;

        }

        positionCurrentVertex = 0;
        while (this.S.size() != (this.V.size() -1)) {

            for (Vertex v : this.V) {

                positionCurrentVertex = this.V.indexOf(v);

                firstValue = this.D[positionCurrentVertex];
                lastValue = this.D[positionCurrentVertex + 1] + hasEdge(this.prev.get(positionCurrentVertex + 1), v);

                minCost = Math.min(firstValue, lastValue);
                this.D[positionCurrentVertex] = minCost;

                if (this.D[positionCurrentVertex + 1] + hasEdge(this.prev.get(positionCurrentVertex + 1), v) > this.D[positionCurrentVertex]) {
                    prev.add(positionCurrentVertex, V.get(positionCurrentVertex + 1));
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
        if (! this.G.isAdjacent(source, next)) {
            return Double.POSITIVE_INFINITY;
        } else {
            edgesList = this.G.getEdge(source, next);
            return this.getMinValue(edgesList);
        }
    }

    /**
     * Pega o valor mínimo da aresta paralela
     */
    private double getMinValue(ArrayList<Edge> list)
    {
        Edge e = list.get(0);
        double minValue = e.getValue();

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getValue() < minValue) {
                minValue = list.get(i).getValue();
            }
        }

        return minValue;
    }

    @Override
    public String toString()
    {
        String msg = "custo -> ";
        for (Vertex minCost : this.prev) {
            msg = msg + " " + Double.toString(minCost.getValue()) + " | ";
        }
        return "";
    }

}
