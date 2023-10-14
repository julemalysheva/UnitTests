import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

/**
 * В этом тестовом классе мы используем ByteArrayOutputStream и PrintStream для перехвата вывода System.out
 * и затем проверяем, что метод compareAverage() правильно выводит соответствующие строки для различных сценариев.
 * setUpStreams и restoreStreams используются для восстановления стандартного вывода после теста.
 */

public class NumberListComparerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        outContent.reset();
    }

    @Test
    public void testCompareAverageWithEqualAverages() {
        NumberList list1 = new NumberList(Arrays.asList(1, 2, 3));
        NumberList list2 = new NumberList(Arrays.asList(3, 2, 1));

        NumberListComparer.compareAverage(list1, list2);
        assertEquals("Средние значения равны", outContent.toString().trim(),
                "Сообщение не соответствует ожидаемому");
    }

    @Test
    public void testCompareAverageWithFirstListGreater() {
        NumberList list1 = new NumberList(Arrays.asList(4, 5, 6));
        NumberList list2 = new NumberList(Arrays.asList(1, 2, 3));

        NumberListComparer.compareAverage(list1, list2);
        assertEquals("Первый список имеет большее среднее значение", outContent.toString().trim(),
                "Сообщение не соответствует ожидаемому");
    }

    @Test
    public void testCompareAverageWithSecondListGreater() {
        NumberList list1 = new NumberList(Arrays.asList(1, 2, 3));
        NumberList list2 = new NumberList(Arrays.asList(4, 5, 6));

        NumberListComparer.compareAverage(list1, list2);
        assertEquals("Второй список имеет большее среднее значение", outContent.toString().trim(),
                "Сообщение не соответствует ожидаемому");
    }
}
