package task5;

import org.assertj.core.api.Assertions;

public class MyTest {
    public static void main(String[] args) {
//        assertConditionA();
//        assertConditionB();
        sum(Integer.MAX_VALUE, Integer.MAX_VALUE);


    }
    public static void assertConditionA() {
        String[] weekends = {"Суббота", "Воскресенье"};
        assert weekends.length == 2: "Много выходных не бывает))";
        System.out.println("В неделе " + weekends.length + " дня выходных");
    }

    public static void assertConditionB() {
        int x = -1;
        assert x <= 0;
    }

    /**
     * Попробуем сделать наш код более надежным, предотвратив переполнение переменной.
     * Исправьте метод сложения двух чисел так, чтобы при переполнении переменной выбрасывалось
     * предупреждение.
     * @param a
     * @param b
     * @return
     */
    public static int sum(int a, int b) {
        assert (long) a+b < Integer.MAX_VALUE: "Переполнение переменной";
        return a+b;
    }


}
