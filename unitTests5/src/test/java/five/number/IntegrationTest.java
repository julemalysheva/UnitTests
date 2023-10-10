package five.number;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegrationTest {
    @Test
    public void testIntegration() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        List<Integer> numbers = randomNumberModule.generateRandomNumbers(10, 1, 100);

        int maxNumber = maxNumberModule.findMaxNumber(numbers);

        assertTrue(numbers.contains(maxNumber));
    }
}

/*
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {

    @Test
    void testIntegration() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        MaxNumberFinder finder = new MaxNumberFinder();

        // Генерация случайного списка чисел
        List<Integer> randomNumbers = generator.generateRandomNumbers(10);

        // Поиск максимального числа
        int maxNumber = finder.findMaxNumber(randomNumbers);

        // Проверка на правильность
        assertEquals(maxNumber, Collections.max(randomNumbers));
    }
}
 */
