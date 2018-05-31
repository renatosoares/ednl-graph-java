package graph;

import java.util.ArrayList;

/**
 * Dijkstra

 */
public class Dijkstra implements IDijkstra
{
    ArrayList<Vertex> S;
    ArrayList<Vertex> V;
    int[] D;
    ArrayList<Vertex> prev;
    Vertex W;


    public Dijkstra(ArrayList vertices)
    {
        this.V = vertices;
        this.D = new int[vertices.size()];
        this.prev = new ArrayList<Vertex>();


    }

	@Override
    public ArrayList shortestPath(Vertex source)
    {
        this.S.add(source);
        this.V.remove(source);
        int positionCurrentVertex;
        int cost;
        int minCost;

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

                minCost = Math.min(this.D[positionCurrentVertex], (this.D[positionCurrentVertex + 1] + hasEdge(this.prev.get(positionCurrentVertex + 1), v)));
                this.D[positionCurrentVertex] = minCost;

                if (this.D[positionCurrentVertex + 1] + hasEdge(this.prev.get(positionCurrentVertex + 1), v) > this.D[positionCurrentVertex]) {
                    prev.add(positionCurrentVertex, V.get(positionCurrentVertex + 1));
                }
            }
        }

		return null;
    }

    /**
     * retorna custo se existir aresta adjacente
     */
    protected int hasEdge(Vertex source, Vertex next) // TODO
    {
        return 0;
    }



}
