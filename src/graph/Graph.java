package graph;

import java.util.*;

public class Graph implements IGraph
{
    private int quantityVertex;
    private ArrayList<Vertex> vertex;
    private Edge[][] matrixAdjacent;

    /**
     *
     */
    public Graph()
    {
        this.quantityVertex = 0;
        this.vertex = new ArrayList<Vertex>();
    }

  /**
     *  Insere e retorna um novo vértice armazenando o elemento vertex
     * @param Vertex vertex
     * @return Vertex
     */
    @Override
    public Vertex insertVertex(Vertex vertex)
    {
        this.quantityVertex = this.quantityVertex + 1;
        this.vertex.add(vertex);
        this.matrixAdjacent = new Edge[this.quantityVertex][this.quantityVertex];

        return vertex;
    }

	@Override
    public ArrayList<Vertex> finalVertex(Edge e)
    {
        ArrayList<Vertex> v = new ArrayList<Vertex>();

        v.add(e.getVertexOrigin());
        v.add(e.getVertexDestination());

		return v;
	}

	@Override
	public Vertex opposite(Vertex v, Edge e) throws Exception {
		return null;
	}

	@Override
    public boolean isAdjacent(Vertex v, Vertex w)
    {
        int indexOne = findIndex(v.getKey());
        int indexTwo = findIndex(w.getKey());

        return (this.matrixAdjacent[indexOne][indexTwo]) != null;
	}

	@Override
    public void replaceVertex(Vertex v, int x)
    {

	}

	@Override
    public void replaceEdge(Edge v, int x)
    {

	}

	@Override
    public Edge insertEdge(Vertex vertexOne, Vertex vertexTwo, double value)
    {
        Edge e;

        int indexOne = this.findIndex(vertexOne.getKey());
        int indexTwo = this.findIndex(vertexTwo.getKey());

        if ((this.matrixAdjacent[indexOne][indexTwo]) == null) {
            e = new Edge();
            e.storeLinkedList(vertexOne, vertexTwo, value, new Edge());
        } else {
            e = this.matrixAdjacent[indexOne][indexTwo];
            e.updateLinkedList(vertexOne, vertexTwo, value, new Edge());
        }

        this.matrixAdjacent[indexTwo][indexOne] = e;
        this.matrixAdjacent[indexOne][indexTwo] = matrixAdjacent[indexTwo][indexOne];

		return e;
	}

	@Override
    public void removeVertex(Vertex vertex)
    {
        this.quantityVertex--;

        int index = this.findIndex(vertex.getKey());

        this.vertex.remove(index); // remove o vértice do ArrayList

        Edge tempMatrixAdjacent[][] = new Edge[this.quantityVertex][this.quantityVertex];

        int ff = 0;
        int gg;
        for (int f = 0; f < this.quantityVertex + 1; f++) {

            gg = 0;
            for (int g = 0; g < this.quantityVertex + 1; g++) {
                if (f != index && g != index) {
                    tempMatrixAdjacent[ff][gg] = this.matrixAdjacent[f][g];

                    if (g != index) {
                        gg++;
                    }
                }
            }

            if (f != index) {
                ff++;
            }
        }

        this.matrixAdjacent = tempMatrixAdjacent;
	}

	@Override
    public void removeEdge(Edge edge)
    {
        int indexOne = findIndex(edge.getVertexOrigin().getKey());
        int indexTwo = findIndex(edge.getVertexOrigin().getKey());
        this.matrixAdjacent[indexOne][indexTwo] = this.matrixAdjacent[indexTwo][indexOne] = null;
    }

	@Override
    public ArrayList<Edge> edgesIncidents(Vertex v)
    {
		return null;
	}

	@Override
    public ArrayList<Vertex> vertex()
    {
		return this.vertex;
	}

	@Override
    public ArrayList<Edge> edge()
    {
        ArrayList<Edge> al = new ArrayList<Edge>();

        for (int f = 0; f < this.quantityVertex; f++) {
            for (int s = 0; s < this.quantityVertex; s++) {
                al.add(this.matrixAdjacent[f][s]);
            }
        }

		return al;
	}

	@Override
    public int degree(Vertex vertex)
    {
		return 0;
	}

	@Override
    public int order()
    {
		return this.quantityVertex;
	}

	@Override
    public boolean isDirected(Edge e)
    {
		return false;
	}

	@Override
    public void insertEdgeDirected(Vertex vertexOne, Vertex vertexTwo, int value)
    {

    }

    @Override
    public Edge getEdge(Vertex v, Vertex w)
    {
        int indexOne = findIndex(v.getKey());
        int indexTwo = findIndex(w.getKey());

        return (this.matrixAdjacent[indexOne][indexTwo]);
    }

    /**
     *
     */
    public void showVertex()
    {
        for (int f = 0; f < this.vertex.size(); f++) {
            System.out.print(this.vertex.get(f));
        }
    }

    /**
     *
     */
    public void showMatrix()
    {
        for (int f = 0; f < this.quantityVertex; f++) {

            for (int g = 0; g < this.quantityVertex; g++) {
                System.out.print(this.matrixAdjacent[f][g] + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     */
    private int findIndex(int key)
    {
        Iterator<Vertex> i = this.vertex.iterator();

        int index = 0;

        while (i.hasNext()) {
            Vertex v = (Vertex) (i.next());
            if (v.getKey() == key) {
                return index;
            }
            index++;
        }

        return 0;
    }
}
