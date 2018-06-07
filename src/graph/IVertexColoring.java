package graph;

public interface IVertexColoring
{
/*
    Entrada: grafo matriz de adjacência)
    Saída: Tk, k=1,2,..., onde Tk contém os vértices coloridos com a cor k

    P1:
        sejam v1,v2,...,vk os vértices do grafo G(V,A);
        Coloque os vértices numa lista de tal modo que Gr(vi) >= gr(vj)
        para todo e qualquer vi, vj pertencente a V (ordem crescente de graus)

    P2:
        i=1;

    P3:
        enquanto(v<>vazio) {
            coloque o primeiro elemento na lista em Ti(vi)
            retire Vj da lista

            enquanto(existir na lista algum vértice vk não adjac.a qualquer vértice de Ti) {
                coloque Vk em Ti;
                retire Vk da lista ;
            }

            i++
        }
    P4:
        o número cromático é dado por i-1 e os vértice de mesma cor estão em Ti
*/
}
