package five.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class MaxNumberModuleTest {
    @Test
    public void testFindMaxNumber() {
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        List<Integer> numbers = Arrays.asList(1, 5, 3, 10, 7);

        int maxNumber = maxNumberModule.findMaxNumber(numbers);

        assertEquals(10, maxNumber);
    }
}