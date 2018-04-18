package collections;

/**
 * A two-tuple of a key of type K and a value of type V 
 * @param <K> the type of the key value of this tuple
 * @param <V> the type of the value value of this tuple
 */
public interface Tuple<K, V> {
	
	/**
	 * Gets the key value of this tuple 
	 * @return the key value
	 */
    K getKey();
    
    /**
     * Gets the value value of this tuple 
     * @return the value value
     */
    V getValue();
}
