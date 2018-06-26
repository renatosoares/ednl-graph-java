package graph;

public interface IDijkstra
{
/**
    - Seja G(V,A) e uma função L(V,W) pertencente aos reais e um vértice fixo V0 de V (fonte).
    - Problema: determinar v0,v1,...,vk, tal que seja mínimo.
    - Somatória: k-1 Σ i = 0 L( vi, vi + 1 )
    - L ( v i , v j ) =
        {
            - Retorna infinito se não existir aresta ( vi , vj )
            - Retorna 0 se vi = vj
            - Retorna custo se exitir aresta ( vi , vj )
        }
*/

/**

    S={v0};
    D[v0]=0;

    para cada v pertencente a V-{v0}
        D[v]=L(v0,V);

    enquanto (s <> V){

        escolha o vértice w pertence V-S tal que D[w] seja mínimo e congele o antecessor
        coloque w em S, isto é, faça S=S U {w}

        para cada v pertencente V-S faca{
            D[v]=min(D[v],d[w]+L(w,v))
            se(d[w]+L(w,v)<D[v])
                D[v].antecessor=w;
        }
    }
*/
    public void shortestPath(Vertex source);
}
