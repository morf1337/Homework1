import org.example.MyArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Comparator;

public class MyArrayListTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 10, 100, 1000, 10000})
    public void addingElementsSizeTest(int number) {
        MyArrayList<Object> list = new MyArrayList<>();
        for (int i = 0; i < number; i++) {
            list.add(new Object());
        }
        Assertions.assertEquals(list.size(), number);
    }

    @Test
    public void stringAddAndGetElementsTest() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        Assertions.assertSame("first", list.get(0));
        Assertions.assertSame("second", list.get(1));
        Assertions.assertSame("third", list.get(2));
    }

    @Test
    public void integerAddAndGetElementsTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        Assertions.assertEquals(0, (int) list.get(0));
        Assertions.assertEquals(1, (int) list.get(1));
        Assertions.assertEquals(2, (int) list.get(2));
    }

    @Test
    public void booleanAddAndGetElementsTest() {
        MyArrayList<Boolean> list = new MyArrayList<>();
        list.add(true);
        list.add(false);
        Assertions.assertTrue((boolean) list.get(0));
        Assertions.assertFalse((boolean) list.get(1));
    }

    @Test
    public void doubleAddAndGetElementsTest() {
        MyArrayList<Double> list = new MyArrayList<>();
        list.add(1.1111);
        list.add(2.2222);
        list.add(3.3333);
        Assertions.assertEquals(1.1111, list.get(0));
        Assertions.assertEquals(2.2222, list.get(1));
        Assertions.assertEquals(3.3333, list.get(2));
    }

    @Test
    public void clearListTest() {
        MyArrayList<Object> list = new MyArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Object());
        }
        list.clear();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void sortListTest() {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(5);
        list.add(3);
        list.add(8);
        list.add(1);
        list.add(4);

        list.sort(Comparator.naturalOrder());

        Assertions.assertEquals(Integer.valueOf(1), list.get(0));
        Assertions.assertEquals(Integer.valueOf(3), list.get(1));
        Assertions.assertEquals(Integer.valueOf(4), list.get(2));
        Assertions.assertEquals(Integer.valueOf(5), list.get(3));
        Assertions.assertEquals(Integer.valueOf(8), list.get(4));
    }

    @Test
    public void addByIndexTest() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("a");
        list.add("b");
        list.add("d");

        list.add(2, "c");

        Assertions.assertEquals("a", list.get(0));
        Assertions.assertEquals("b", list.get(1));
        Assertions.assertEquals("c", list.get(2));
        Assertions.assertEquals("d", list.get(3));
    }

    @Test
    public void removeByIndexTest() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.remove(2);

        Assertions.assertEquals(Integer.valueOf(1), list.get(0));
        Assertions.assertEquals(Integer.valueOf(2), list.get(1));
        Assertions.assertEquals(Integer.valueOf(4), list.get(2));
        Assertions.assertEquals(3, list.size());
    }


    @Test
    public void outOfBoundsAccessTest() {
        MyArrayList<Object> list = new MyArrayList<>();
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> list.get(20));
    }
}
