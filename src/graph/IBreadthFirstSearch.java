package graph;

public interface IBreadthFirstSearch
{
    /*
    Para cada vértice v pertencente a V –{S} faça
        v.marcar=0;//não visitado
        v.marcar=-1;// marcado

    d(s)=0;
    Q={}
    Q.enqueue(S);

    Enquanto(Q<>vazio){
        v=Q.dequeue();
        Para cada vértice w adjacente a ADJ[v] faça
            se(w.marcar==0){
                d(w)=d(v)+1;
                w.marcar=-1;
                Q.enqueue(w);
            }

        v.marcar=1; // marcado
    }
    */
    public void search();
}
