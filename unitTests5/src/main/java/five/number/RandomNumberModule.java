package five.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberModule {
    public List<Integer> generateRandomNumbers(int count, int min, int max) {
        List<Integer> numbers = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int number = random.nextInt(max - min + 1) + min;
            numbers.add(number);
        }

        return numbers;
    }
}
