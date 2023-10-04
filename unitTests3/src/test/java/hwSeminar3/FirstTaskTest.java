package hwSeminar3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
Напишите тесты, покрывающие на 100% метод evenOddNumber,
который проверяет, является ли переданное число четным или нечетным.
 */

class FirstTaskTest {

    private FirstTask example;

    @BeforeEach
    void setUp() {
        example = new FirstTask();
    }

    @Test
    void testEvenOddNumberWithEvenNumber() {
        assertTrue(example.evenOddNumber(4), "Метод должен вернуть true для четного числа");
    }

    @Test
    void testEvenOddNumberWithOddNumber() {
        assertFalse(example.evenOddNumber(7), "Метод должен вернуть false для нечетного числа");
    }
}