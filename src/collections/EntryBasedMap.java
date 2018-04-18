package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class EntryBasedMap<K, V> implements Map<K, V> {
    private ArrayList<Entry<K, V>> data;
    private int size = 0;

    public EntryBasedMap() {
        this.data = new ArrayList<>();
    }

    /**
     * Add a value for the given key to the map.
     * If there already exists a value assigned to the given key it should be replaced.
     *
     * @param key   The key
     * @param value The value
     */
    @Override
    public void put(K key, V value) {
        if (contains(key)) {

        } else {
            data.add(new Entry<>(key, value));
            size++;
        }
    }

    /**
     * Gives the value assigned to a given key
     *
     * @param key The key
     * @return The value assigned to the key, or null if no matching entry is found
     */
    @Override
    public V get(K key) {
        for(int i = 0; i < size; i++){
            if(data.get(i).getKey().equals(key)){
                return data.get(i).getValue();
            }
        }
        return null;
    }

    /**
     * Check whether an entry exists for the given key.
     *
     * @param key The key
     * @return True if this map contains an entry for the given key, otherwise false
     */
    @Override
    public boolean contains(K key) {
        for (int i = 0; i < size; i++) {
            if (data.get(i).getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the entry for the given key if existing
     *
     * @param key The key
     * @return True if an entry has been removed, otherwise false
     */
    @Override
    public boolean remove(K key) {
        return false;
    }

    /**
     * Returns the number of entries in this map
     *
     * @return The number of entries
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * An iterator that iterates over all keys in this map
     *
     * @return An iterator that iterates over all keys in this map
     */
    @Override
    public Iterator<K> keyIterator() {
        return new Iterator<K>() {
            private Object current;
            private int i;

            {
                current = data.get(i).getKey();
            }

            @Override
            public boolean hasNext() {
                return size != 0;
            }

            @Override
            public K next() {
                if(hasNext()){
                    current = data.get(i++).getKey();
                    return (K)current;
                }else{
                    throw new NoSuchElementException("No more elements");
                }
            }
        };
    }

    /**
     * An iterator that iterates over all values in this map
     *
     * @return An iterator that iterates over all values in this map
     */
    @Override
    public Iterator<V> valueIterator() {
        return new Iterator<V>() {
            private Object current;
            private int i;

            {
                current = data.get(i).getValue();
            }
            @Override
            public boolean hasNext() {
                return size != 0;
            }

            @Override
            public V next() {
                if(hasNext()){
                    current = data.get(i++).getValue();
                    return (V) current;
                }else{
                    throw new NoSuchElementException("No more elements");
                }
            }
        };
    }

    /**
     * An iterator that iterates over all key-value pairs in this map
     *
     * @return An iterator that iterates over all key-value pairs in this map
     */
    @Override
    public Iterator<Tuple<K, V>> iterator() {
        return new Iterator<Tuple<K, V>>() {
            private Tuple current;
            private int i = 0;

            {
                current = data.get(i);
            }

            @Override
            public boolean hasNext() {
                return size != 0;
            }

            @Override
            public Tuple<K, V> next() {
                if (hasNext()) {
                    current = data.get(i++);
                    return current;
                } else {
                    throw new NoSuchElementException("No more elements");
                }
            }
        };
    }

    private class Entry<K, V> implements Tuple<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Gets the key value of this tuple
         *
         * @return the key value
         */
        @Override
        public K getKey() {
            return this.key;
        }

        /**
         * Gets the value value of this tuple
         *
         * @return the value value
         */
        @Override
        public V getValue() {
            return this.value;
        }
    }
}
