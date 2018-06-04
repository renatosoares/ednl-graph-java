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

        for (Vertex v : this.V) {
            positionCurrentVertex = this.V.indexOf(v);

            cost = this.hasEdge(source, v);

            this.prev.add(positionCurrentVertex, v);
            this.D[positionCurrentVertex] = cost;

        }

        int vertexMinCost = this.getMinCost(this.D);

        this.S.add(vertexMinCost, prev.get(vertexMinCost));
        positionCurrentVertex = 0;

        while (this.S.size() != this.V.size()) {

            for (Vertex w : this.V) {
                if (this.S.contains(w)) {
                    continue;
                } else {
                    positionCurrentVertex = this.V.indexOf(w);

                    firstValue = this.D[positionCurrentVertex];

                    lastValue = this.D[positionCurrentVertex -1] + hasEdge(w, this.V.get(positionCurrentVertex -1));

                    minCost = Math.min(firstValue, lastValue);
                    this.D[positionCurrentVertex] = minCost;

                    if (lastValue < this.D[positionCurrentVertex]) {
                        prev.set(positionCurrentVertex, w);
                    }

                }

            }
            // TODO vai ter que adicionar o nova aresta com base no menor valor do array que não foi adicionado.
            // TODO  verificar quando o valor retornado é zero.
            this.S.add(prev.get(this.S.size()));
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
            return Double.POSITIVE_INFINITY;
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
        double minValue = list[0];

        int position = 0;
        for (int i = 1; i < list.length; i++) {
            if (list[i] < minValue) {
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
