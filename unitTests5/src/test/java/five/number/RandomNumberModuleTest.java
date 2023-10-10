package five.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class RandomNumberModuleTest {
    @Test
    public void testGenerateRandomNumbers() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();

        List<Integer> numbers = randomNumberModule.generateRandomNumbers(10, 1, 100);

        assertEquals(10, numbers.size());
        for (int number : numbers) {
            assertTrue(number >= 1 && number <= 100);
        }
    }
}