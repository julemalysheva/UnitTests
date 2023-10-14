/**
 * Класс отвечает за сравнение средних значений списков.
 */
public class NumberListComparer {
    /**
     * Определяем допустимую дельту для сравнения double.
     */
    private static final double DELTA = 1e-10;

    /**
     * метод сравнения двух списков по их среднему значению.
     * @param list1 список 1
     * @param list2 список 2
     */
    public static void compareAverage(NumberList list1, NumberList list2) {
        double average1 = list1.getAverage();
        double average2 = list2.getAverage();

        // Сравнение средних значений с плавающей точкой с использованием дельты
        if (Math.abs(average1 - average2) < DELTA) {
            System.out.println("Средние значения равны");
        } else if (average1 > average2) {
            System.out.println("Первый список имеет большее среднее значение");
        } else {
            System.out.println("Второй список имеет большее среднее значение");
        }
    }

}
