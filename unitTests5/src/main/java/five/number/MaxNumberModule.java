package five.number;

import java.util.List;

public class MaxNumberModule {
    public int findMaxNumber(List<Integer> numbers) {
        int maxNumber = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > maxNumber) {
                maxNumber = number;
            }
        }

        return maxNumber;
    }
}