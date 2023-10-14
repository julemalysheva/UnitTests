import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * В этом тестовом классе мы проверяем различные варианты работы метода getAverage() класса NumberList,
 * включая случаи с одним элементом, отрицательными числами, пустым и null списком.
 */

public class NumberListTest {
    private NumberList numberList;

    @Test
    public void testGetAverageWithSingleElement() {
        numberList = new NumberList(Arrays.asList(5));
        assertEquals(5, numberList.getAverage(), 0.0001,
                "Метод не корректен");
    }

    @Test
    public void testGetAverageWithMultipleElements() {
        numberList = new NumberList(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(3.0, numberList.getAverage(), 0.0001,
                "Метод не корректен");
    }

    @Test
    public void testGetAverageWithNegativeNumbers() {
        numberList = new NumberList(Arrays.asList(-1, -2, -3, -4, -5));
        assertEquals(-3.0, numberList.getAverage(), 0.0001,
                "Метод не корректен");
    }

    @Test
    public void testGetAverageWithEmptyList() {
        numberList = new NumberList(Collections.emptyList());
        assertThrows(IllegalArgumentException.class, () -> numberList.getAverage(),
                "Ожидается исключение IllegalArgumentException");
    }

    @Test
    public void testGetAverageWithNullList() {
        numberList = new NumberList(null);
        assertThrows(IllegalArgumentException.class, () -> numberList.getAverage(),
                "Ожидается исключение IllegalArgumentException");
    }
}
