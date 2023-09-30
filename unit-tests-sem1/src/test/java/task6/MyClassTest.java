package task6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyClassTest {
    @Test
    void sumListsShouldBeCorrect(){
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> result = new ArrayList<>(Arrays.asList(5, 4, 6));
        List<Integer> resultTest = MyClass.sumLists(list1, list2);

        assertEquals(result, resultTest, "Сумма списков не равна");

    }

    /**
     * Проверяем выброс исключения IllegalArgumentException, когда списки list1 и list2 имеют разную длину.
     */
    @Test
    void testSumListsWithDifferentSizes() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5);

        assertThrows(IllegalArgumentException.class, () ->
                MyClass.sumLists(list1, list2));
    }

    /**
     * - Тестирование с пустыми списками (list1 и list2). В нашем коде такое исключение не описано.
     * Проверка, что при передаче пустых списков выбрасывается исключение IllegalArgumentException.
     */
    @Test
    void testSumListsEmptyLists() {
        List<Integer> emptyList1 = new ArrayList<>();
        List<Integer> emptyList2 = new ArrayList<>();

        assertThrows(IllegalArgumentException.class, () ->
                MyClass.sumLists(emptyList1, emptyList2));
    }

    /**
     * проверяет, что метод findMax() корректно возвращает максимальное значение из списка чисел
     */
    @Test
    void testFindMaxReturn(){
        List<Integer> num = Arrays.asList(11, 22, 3, 50, 15);
        int expectedMax = 5;
        int actualMax = MyClass.findMax(num);
        assertEquals(expectedMax, actualMax, "Максимум найден некорректно");
    }

    /**
     * В этом тестовом методе testFindMaxWithEmptyList(), мы создаем пустой список emptyList.
     * Затем мы используем Assertions.assertThrows() для проверки, что вызов MyClass.findMax(emptyList)
     * выбрасывает исключение IllegalArgumentException. Если исключение выбрасывается, тест считается успешным.
     * Если исключение не выбрасывается или выбрасывается другое исключение,
     * тест не пройдет и будет сгенерировано исключение AssertionError.
     */
    @Test
    void testFindMaxWithEmptyList(){
        List<Integer> emptyList = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () ->
                MyClass.findMax(emptyList));
    }

    /**
     * проверяет, что метод filterStrings() корректно возвращает отфильтрованный список по заданной длине слова
     */
    @Test
    void testFilterStrings(){
        List<String> stringList = Arrays.asList("те", "тест", "тестовый", "тестировать", "тестирование");
        int lengthWord = 4;
        List<String> expectedList = Arrays.asList("тест", "тестовый", "тестировать", "тестирование");
//        List<String> expectedList = Arrays.asList("тестовый", "тестировать", "тестирование");
        assertEquals(expectedList, MyClass.filterStrings(stringList, lengthWord)
                , "Список фильтруется некорректно");
    }

    /**
     * Проверяем выброс исключения IllegalArgumentException, когда minLength принимает отрицательное значение.
     */
    @Test
    void testFilterStringsMinLength() {
        List<String> stringList = Arrays.asList("те", "тест", "тестовый", "тестировать", "тестирование");
        int lengthWord = -4;
        assertThrows(IllegalArgumentException.class, () -> MyClass.filterStrings(stringList, lengthWord));
    }

    /**
     *  тест проверяет, что метод filterStrings() правильно обрабатывает пустой список строк и
     *  возвращает пустой результат, в соответствии с ожидаемым поведением.
     */
    @Test
    void testFilterStringsWithEmptyList() {
        List<String> emptyList = new ArrayList<>();
        int minLength = 5;

        List<String> result = MyClass.filterStrings(emptyList, minLength);

        // Проверка, что возвращается пустой список
        assertTrue(result.isEmpty());
    }
}
