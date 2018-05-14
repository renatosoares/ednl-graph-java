package graph;

interface IEurelianPath
{
    /*
    grau=0; soma=0; matadj[][]; N=numero de linhas da matriz; f=0;//linha atual;
    Enquanto(soma<=2)e(f<=N) {
        grau=0;

        para(g=0;g<N;g++) {
            grau+=matadj[f][g];
        }

        se grau mod 2 == 1 // ímpar
            soma++
        f++;
    }

    Se (soma>2) NÃO EXISTE CAMINHO
    Senao EXISTE CAMINHO
    */

    /**
     * Algoritmo para verificar a existência de um caminho euleriano
     */
    public boolean hasPath();

}
