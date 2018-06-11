package graph;

import java.util.*;

public class Graph implements IGraph
{
    private int quantityVertex;
    private ArrayList<Vertex> vertex;
    private ArrayList[][] matrixAdjacent;

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
        this.matrixAdjacent = new ArrayList[this.quantityVertex][this.quantityVertex];

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
    public Vertex opposite(Vertex v, Edge e) throws Exception
    {
		return null; // TODO
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
        // TODO
	}

	@Override
    public void replaceEdge(Edge v, int x)
    {
        // TODO
	}

	@Override
    public Edge insertEdge(Vertex vertexOne, Vertex vertexTwo, double value)
    {
        Edge e = new Edge(vertexOne, vertexTwo, value, false);

        int indexOne = this.findIndex(vertexOne.getKey());
        int indexTwo = this.findIndex(vertexTwo.getKey());

        if (this.matrixAdjacent[indexOne][indexTwo] == null){
            this.matrixAdjacent[indexTwo][indexOne] = this.matrixAdjacent[indexOne][indexTwo] = new ArrayList();

            this.matrixAdjacent[indexOne][indexTwo].add(e);
        } else {
            this.matrixAdjacent[indexOne][indexTwo].add(e);
        }

        return e;
	}

	@Override
    public void removeVertex(Vertex vertex)
    {
        this.quantityVertex--;

        int index = this.findIndex(vertex.getKey());

        this.vertex.remove(index); // remove o vértice do ArrayList

        ArrayList tempMatrixAdjacent[][] = new ArrayList[this.quantityVertex][this.quantityVertex];

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
    public void removeEdge(Vertex v, Vertex w, int key)
    {
        int indexOne = findIndex(v.getKey());
        int indexTwo = findIndex(w.getKey());

        if (this.matrixAdjacent[indexOne][indexTwo].isEmpty() && this.matrixAdjacent[indexTwo][indexOne].isEmpty()) {
            this.matrixAdjacent[indexOne][indexTwo] = this.matrixAdjacent[indexTwo][indexOne] = null;
        } else {
            this.matrixAdjacent[indexOne][indexTwo].remove(key);
        }
    }

	@Override
    public ArrayList<Edge> edgesIncidents(Vertex v)
    {
		return null; // TODO
	}

	@Override
    public ArrayList<Vertex> vertex()
    {
		return this.vertex;
	}

	@Override
    public ArrayList edge()
    {
        ArrayList al = new ArrayList();

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
        int d = 0;
        for (Vertex v : this.vertex) {
            if (this.isAdjacent(vertex, v)) {
                d++;
            }
        }
		return d;
	}

	@Override
    public int order()
    {
		return this.quantityVertex;
	}

	@Override
    public boolean isDirected(Edge e)
    {
		return e.isDirected(); // TODO
	}

	@Override
    public void insertEdgeDirected(Vertex vertexOne, Vertex vertexTwo, double value)
    {
        Edge e = new Edge(vertexOne, vertexTwo, value, true);

        int indexOne = this.findIndex(vertexOne.getKey());
        int indexTwo = this.findIndex(vertexTwo.getKey());

        if (this.matrixAdjacent[indexOne][indexTwo] == null){
            this.matrixAdjacent[indexTwo][indexOne] = this.matrixAdjacent[indexOne][indexTwo] = new ArrayList();

            this.matrixAdjacent[indexOne][indexTwo].add(e);
        } else {
            this.matrixAdjacent[indexOne][indexTwo].add(e);
        }
    }

    @Override
    public ArrayList getEdge(Vertex v, Vertex w)
    {
        int indexOne = findIndex(v.getKey());
        int indexTwo = findIndex(w.getKey());

        return this.matrixAdjacent[indexOne][indexTwo];
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
                if (this.matrixAdjacent[f][g] != null) {
                    System.out.print(this.matrixAdjacent[f][g] + " ");
                } else {
                    System.out.print( " ... ");
                }
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

    public String eulerianPath()
    {
        EulerianPath path = new EulerianPath(this.matrixAdjacent, this.quantityVertex);

        if (path.hasPath()) {
            return "Existe caminho Euleriano.";
        } else {
            return "Não existe caminho Euleriano.";
        }

    }
}
