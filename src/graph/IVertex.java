package graph;

public interface IVertex 
{
	/**
	 * 
	 * @return
	 */
	public abstract int getKey();
	
	/**
	 * 
	 * @param key
	 * @return void
	 */
	public abstract void setkey(int key);
	
	/**
	 * 
	 * @return
	 */
	public abstract double getValue();
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public abstract void setValue(double value);
	
}
