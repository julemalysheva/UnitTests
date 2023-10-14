import java.util.List;

/**
 * Класс отвечает за управление списком чисел и вычисление среднего значения.
 */
public class NumberList {
    /**
     * Атрибут класса - список чисел.
     */
    private List<Integer> numbers;

    /**
     * констуктор класса.
     * @param numbers список чисел
     */
    public NumberList(List<Integer> numbers) {
        this.numbers = numbers;
    }

    /**
     * Метод получения среднего значения чисел в списке.
     * @return среднее значение списка
     */
    public double getAverage() {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List is null or empty");
        }

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        return (double) sum / numbers.size();
    }
}
