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
            for(int i = 0;i < size; i++){
                if(data.get(i).getKey().equals(key)){
                    data.get(i).setValue(value);
                }
            }
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
        for(Entry e : data){
            if(e.getKey().equals(key)){
                data.remove(e);
                size--;
                return true;
            }
        }
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
            private int keyIndex;

            {
                keyIndex = 0;
            }

            @Override
            public boolean hasNext() {
                return size() != keyIndex;
            }

            @Override
            public K next() {
                if(hasNext()){
                    return data.get(keyIndex++).getKey();
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
            private int valueIndex;

            {
                valueIndex = 0;
            }
            @Override
            public boolean hasNext() {
                return size() != valueIndex;
            }

            @Override
            public V next() {
                if(hasNext()){
                    return data.get(valueIndex++).getValue();
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
            private int tupleIndex;
            {
                tupleIndex = 0;
            }

            @Override
            public boolean hasNext() {
                return size() != tupleIndex;
            }

            @Override
            public Tuple<K, V> next() {
                if (hasNext()) {
                    return data.get(tupleIndex++);
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

        private void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format(key + " -> " + value + "\n");
        }
    }
}
