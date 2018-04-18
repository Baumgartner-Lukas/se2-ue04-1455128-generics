package collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {
    private ArrayList<String> arrayList;

    @Before
    public void setUp() throws Exception {
        arrayList = new ArrayList<>();
        arrayList.add("foo");
        arrayList.add("bar");
        arrayList.add("oof");
        arrayList.add("rab");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addingOverDefaultAmountDoublesArraySize() {

        for(int i = 0; i<16;i++){
            arrayList.add("a");
        }
        arrayList.add("b");
        assertEquals(40, arrayList.length());
    }

    @Test
    public void containsReturnsTrueIfTheObjectIsInArrayList() {
        assertTrue(arrayList.contains("oof"));
    }

    @Test
    public void getsMethodReturnsRightElementAtIndex() {
        assertEquals("oof", arrayList.get(2));
    }

    @Test
    public void removingElementFormatsArrayListCorrectly() {
        arrayList.remove("bar");
        assertEquals("oof", arrayList.get(1));
    }
}