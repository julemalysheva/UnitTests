package lesson2;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import lesson2.Calculator;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTest {
    @Test
    void additionExpressionEvaluation() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2,6,'+')).isEqualTo(8);
    }
    @Test
    void subtractionExpressionEvaluation () {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2,2,'-')).isEqualTo(0);
    }
    @Test
    void multiplicationExpressionEvaluation () {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2,7,'*')).isEqualTo(14);
    }
    @Test
    void divisionExpressionEvaluation () {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(100,90,'/')).isEqualTo(2);
    }

    @Test
    void DivizionByZeryTest(){
        //// Проверка деления на ноль
        //try {
        // Calculator.calculation(1, 0, '/');
        // assert false; // Если мы здесь, значит, ожидаемого исключения не было
        //} catch (ArithmeticException e) {
        // assert true; // Мы ожидаем исключение ArithmeticException при делении на ноль
        //}
        Calculator calculator = new Calculator();
        assertThatThrownBy(() ->
                calculator.calculation(8,0,'/'))
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    void expectedIllegalStateExceptionOnInvalidOperatorSymbol ()
    {
        /*
        // Проверка неправильного оператора
        try {
         Calculator.calculation(1, 1, 'a');
         assert false; // Если мы здесь, значит, ожидаемого исключения не было
        } catch (IllegalStateException e) {
         assert true; // Мы ожидаем исключение IllegalStateException при использовании неправильного оператора
        }
         */
        Calculator calculator = new Calculator();
        assertThatThrownBy(() ->
                calculator.calculation(8,4,'_'))
                .isInstanceOf(IllegalStateException.class);
    }

    /*
    Метод getOperand работает со сканером, и должен корректно принимать цифры.
Для теста мы должны имитировать ввод пользователем значений. Это делается с
помощью System.setIn(...):
     */
    @Test
    void getOperandCompletesCorrectlyWithNumbers() {
        String testedValue = "9"; // Значение для тестов
        ByteArrayInputStream in = new
                ByteArrayInputStream(testedValue.getBytes());
        InputStream inputStream = System.in; // Сохраняем ссылку на ввод с клавиатуры
        System.setIn(in); // Подменяем ввод
        Calculator.getOperand(); // Вызываем метод
        System.out.println(testedValue); // Для наглядности вывода
        System.setIn(inputStream); // Подменяем обратно
    }

    @Test
    void getOperandCompletesCorrectlyWithNotNumbers() {
        String testedValue = "k";
        ByteArrayInputStream in = new
                ByteArrayInputStream(testedValue.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream inputStream = System.in;
        System.setIn(in);
        System.setOut(new PrintStream(out));
        assertThatThrownBy(() -> Calculator.getOperand())
                .isInstanceOf(IllegalStateException.class).describedAs("" +
                                "Ошибка в вводимых данных");
                        System.setIn(inputStream);
        System.setOut(null);
    }

    /*
    код с презентации Семинара 2 по заданиям лекции 2
     */
    @Test
    void testIntegerValue(){
        // Проверка максимального и минимального значения, которое может хранить тип int
        assert Integer.MAX_VALUE == Calculator.calculation(Integer.MAX_VALUE - 1, 1, '+');
        assert Integer.MIN_VALUE == Calculator.calculation(Integer.MIN_VALUE + 1, -1, '+');
    }

    // Проверка переполнения - странный код с презентации к уроку
//    @Test
//    void CheckingIntegerOverflow(){
//        try {
//            Calculator.calculation(Integer.MAX_VALUE, 1, '+');
//            assert false; // Если мы здесь, значит, ожидаемого исключения не было
//        } catch (ArithmeticException e) {
//            assert true; // Мы ожидаем исключение ArithmeticException при переполнении
//        }
//        try {
//            Calculator.calculation(Integer.MIN_VALUE, -1, '+');
//            assert false; // Если мы здесь, значит, ожидаемого исключения не было
//        } catch (ArithmeticException e) {
//            assert true; // Мы ожидаем исключение ArithmeticException при переполнении
//        }
        //my code
//        Calculator calculator = new Calculator();
//        assertThatThrownBy(() ->
//                calculator.calculation(Integer.MAX_VALUE, 1, '+'))
//                .isInstanceOf(ArithmeticException.class);
//    }

}
