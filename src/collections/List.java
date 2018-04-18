package collections;

/**
 * Interface for List of elements
  *
 * @param <T> the type of the elements 
 */
public interface List<T> {
    /**
     * Adds an element to the end of the list
     * @param elem The element to add
     */
    public void add(T elem);

    /**
     * Returns the object at index i, or null if the index is out of bounds.
     * @param i The index which's object should be returned
     * @return The object at index i or null if the index is invalid
     */
    public T get(int i);

    /**
     * Removes the first occurrence of an element from this list if the element is contained at least one time
     * @param elem The element to remove
     * @return True if an element has been removed, otherwise false
     */
    public boolean remove(T elem);

    /**
     * Checks if a given object is present in this list.
     * Objects are compared using the equals() method.
     * @param obj The object which should be checked for presence in this list
     * @return True if this list contains the given object at least once, otherwise false
     */
    public boolean contains(Object obj);

    /**
     * Returns the number of entries in this list
     * @return The number of entries
     */
    public int size();
}
