package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class ArrayList<T> implements List<T>, Iterable<T> {
    private Object[] data;
    private static final int DEFAULT_SIZE = 20;
    private int size = 0;

    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    public ArrayList(int size) {
        data = new Object[size];
    }

    /**
     * Adds an element to the end of the list
     *
     * @param elem The element to add
     */
    @Override
    public void add(T elem) {
        if (size < data.length) {
            data[size++] = elem;
        } else {
            Object[] tempArray = new Object[data.length * 2];
            System.arraycopy(data, 0,
                    tempArray, 0, data.length);
            data = tempArray;
            data[size++] = elem;
        }
    }

    /**
     * Returns the object at index i, or null if the index is out of bounds.
     *
     * @param i The index which's object should be returned
     * @return The object at index i or null if the index is invalid
     */
    @Override
    public T get(int i) {
        if (i < 0 || i > size) {
            throw new RuntimeException("Invalid index");
        }
        return (T) data[i];
    }

    /**
     * Removes the first occurrence of an element from this list if the element is contained at least one time
     *
     * @param elem The element to remove
     * @return True if an element has been removed, otherwise false
     */
    @Override
    public boolean remove(T elem) {
        if (this.contains(elem)) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(elem)) {
                    data[i] = null;
                    size--;
                    format();
                    return true;
                }
            }
        }
        return false;
    }

    private void format() {
        for (int i = 0; i <= size; i++) {
            if (data[i] == null) {
                data[i] = data[i + 1];
                data[i + 1] = null;
            }
        }
    }

    /**
     * Checks if a given object is present in this list.
     * Objects are compared using the equals() method.
     *
     * @param obj The object which should be checked for presence in this list
     * @return True if this list contains the given object at least once, otherwise false
     */
    @Override
    public boolean contains(Object obj) {
        for (int i = 0; i <= size; i++) {
            if (data[i].equals(obj)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of entries in this list
     *
     * @return The number of entries
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * IGNORE! Used for testing
     *
     * @return length of data
     */
    public int length() {
        return data.length;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Object current;
            private int i = 0;

            {
                current = data[i];
            }

            /**
             * Returns {@code true} if the iteration has more elements.
             * (In other words, returns {@code true} if {@link #next} would
             * return an element rather than throwing an exception.)
             *
             * @return {@code true} if the iteration has more elements
             */
            @Override
            public boolean hasNext() {
                return current != null;
            }


            /**
             * Returns the next element in the iteration.
             *
             * @return the next element in the iteration
             * @throws NoSuchElementException if the iteration has no more elements
             */
            @Override
            public T next() {
                if (current != null) {
                    current = data[++i];
                    return (T) current;
                } else {
                    throw new NoSuchElementException("No more elements in this list");
                }
            }
        };
    }
}
