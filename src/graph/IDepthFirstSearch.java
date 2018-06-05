package graph;

public interface IDepthFirstSearch
{
/**
  Para cada vértice v pertencente a V faça
    v.marcar=0;//não visitado

  d(v)=0; t=0;

  Para cada vértice v pertencente a V faça
    se(v.marcar==0)
      DFS-VISITA(v);

  DFS-VISITA(v){
    v.marcar=-1;// visitado
    d(v)=++t;

    // vertices w adjacentes ADJ[v]
    Para cada vértice w pertencente a ADJ[v] faça

      se (w.marcar==0)
        DFS-VISITA(w);

    v.marcar=1; // marcado
    s(v)=++t;
  }
*/
  public void discovered();
}
