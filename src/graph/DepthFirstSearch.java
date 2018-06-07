package graph;

public class DepthFirstSearch implements IDepthFirstSearch
{

  private ArrayList<Vertex> vertices;
  private ArrayList<int> d;
  private ArrayList<int> s;
  private ADJ[];
  private int t;

  public DepthFirstSearch()
  {

  }

  public void discovered()
  {

  }

  private void search()
  {
    for (Vertex v : this.vertices ) {
      v.checked = 0;
    }

    this.d.add(v.key(), 0);
    this.t = 0;
  }
}
