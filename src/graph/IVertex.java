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
	 * @return
	 */
	public abstract int setkey(int key);
	
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
	public abstract double setValue(double value);
	
}
