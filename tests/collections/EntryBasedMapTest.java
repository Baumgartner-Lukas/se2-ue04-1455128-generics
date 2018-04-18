package collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntryBasedMapTest {
    private EntryBasedMap<Integer, String> ebm;

    @Before
    public void setUp() throws Exception {
        ebm = new EntryBasedMap<>();
        ebm.put(1, "Banana");
        ebm.put(2, "Apple");
        ebm.put(3, "Sausage");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void containsReturnsTrueIfEntryIsInMap() {
        assertTrue(ebm.contains(2));
    }

    @Test
    public void getReturnsRightValueForMappedKey() {
        assertEquals("Apple", ebm.get(2));
    }

    @Test
    public void updatingAnEntryOverwritesTheValueCorrectly() {
        ebm.put(2, "Kiwi");
        assertEquals("Kiwi", ebm.get(2));
    }

    @Test
    public void removingItemFromMapReSizesMapCorrectly() {
        ebm.remove(2);
        assertEquals(2, ebm.size());
    }
}