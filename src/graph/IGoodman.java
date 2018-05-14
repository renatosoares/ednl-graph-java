package graph;

interface IGoodman
{
    /*
    P0 [inicialização]
        H=Vg; // todos os vértices
        c=0;
    P1[gere a próxima componente conexa]
        Enquanto (H!=vazio){
            selecione um vértice v0 pertencente a H
            Enquanto (v0 for adjacente a algum vértice v pertencente a H){
                H=grafo resultante da fusão de v com v0;
            }
            remova v0, isto é, faça H=H-v0;
            c=c+1;
        }
    P2[Testa o tipo de conexidade]
        Se(c>1)
            G é não conexo
        senao
            G é conexo
    */
}
