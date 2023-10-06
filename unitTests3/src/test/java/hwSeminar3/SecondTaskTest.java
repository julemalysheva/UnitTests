package hwSeminar3;

/*
. Разработайте и протестируйте метод numberInInterval, который проверяет, попадает ли
переданное число в интервал (25;100)
public boolean numberInInterval(int n) { … }
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SecondTaskTest {

    private SecondTask example;

    @BeforeEach
    void setUp() {
        example = new SecondTask();
    }

    @ParameterizedTest
    @CsvSource({"50, 25, 100", "26, 25, 100"})
    void testNumberInIntervalTrue(int number, int min, int max) {
        assertTrue(example.numberInInterval(number, min, max),
                String.format("Метод должен вернуть true для числа %d в интервале (%d, %d)", number, min, max));
    }

    @ParameterizedTest
    @CsvSource({"25, 25, 100", "100, 25, 100", "15, 25, 100"})
    void testNumberInIntervalFalse(int number, int min, int max) {
        assertFalse(example.numberInInterval(number, min, max),
                String.format("Метод должен вернуть false для числа %d в интервале (%d, %d)", number, min, max));
    }
}