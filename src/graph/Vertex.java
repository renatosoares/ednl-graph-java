package graph;

public class Vertex implements IVertex
{

    private int key;
    private double value;
    private int checked;
    private int degree;

    /**
     * @param key
     * @param value
     */
    public Vertex(int key, double value)
    {
        this.key = key;
        this.value = value;
        this.checked = 0;
        this.degree = 0;
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


    public int getChecked()
    {
		return this.checked;
	}

    public void setChecked(int checked)
    {
		this.checked = checked;
    }

    public int getdegree()
    {
		return this.degree;
	}

    public void setdegree(int degree)
    {
		this.degree = degree;
    }

    public String toString()
    {
        return "|#| key => " + key + " |-> value => " + value + " |#|" + System.lineSeparator();
    }

}
