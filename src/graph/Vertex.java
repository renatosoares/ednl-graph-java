package graph;

public class Vertex implements IVertex 
{

    private int key;
    private double value;

    /**
     * @param key
     * @param value
     */
    public Vertex(int key, double value) 
    {
        super();
        this.key = key;
        this.value = value;        
    }

	@Override
    public int getKey() 
    {
		return key;
	}

	@Override
    public void setkey(int key) 
    {
        this.key = key;
	}

	@Override
    public double getValue() 
    {
		return value;
	}

	@Override
    public void setValue(double value) 
    {
		this.value = value;
    }
    
    public String toString()
    {
        return "key => " + key + " |-> value => " + value + " |#| ";
    }

}
