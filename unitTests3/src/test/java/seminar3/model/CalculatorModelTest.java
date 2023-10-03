package seminar3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorModelTest {

    private static CalculatorModel calculator;
    
    @BeforeAll
    public  static void createCalculator () {
        calculator = new CalculatorModel();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getFirstNumber() {
        int expectedNum = 3;
        calculator.setFirstNumber(expectedNum);
        int actualNum = calculator.getFirstNumber();
        assertEquals(expectedNum, actualNum, "Метод getFirstNumber некорректен");
    }

    @Test
    void setFirstNumber() {
        int expectedNum = 3;
        calculator.setFirstNumber(expectedNum);
        int actualNum = calculator.getFirstNumber();
        assertEquals(expectedNum, actualNum, "Метод setFirstNumber некорректен");
    }

    @Test
    void getSecondNumber() {
        int expectedNum = 3;
        calculator.setSecondNumber(expectedNum);
        int actualNum = calculator.getSecondNumber();
        assertEquals(expectedNum, actualNum, "Метод getSecondNumber некорректен");
    }

    @Test
    void setSecondNumber() {
        int expectedNum = 3;
        calculator.setSecondNumber(expectedNum);
        int actualNum = calculator.getSecondNumber();
        assertEquals(expectedNum, actualNum, "Метод setSecondNumber некорректен");
    }

    @Test
    void add() {
        int expectedNum = 14;
        calculator.setFirstNumber(6);
        calculator.setSecondNumber(8);
        int actualNum = calculator.add();
        assertEquals(expectedNum, actualNum, "Метод add некорректен");
    }

    @Test
    void subtract() {
        int expectedNum = 6;
        calculator.setFirstNumber(14);
        calculator.setSecondNumber(8);
        int actualNum = calculator.subtract();
        assertEquals(expectedNum, actualNum, "Метод subtract некорректен");
    }

    @Test
    void multiply() {
        int expectedNum = 32;
        calculator.setFirstNumber(4);
        calculator.setSecondNumber(8);
        int actualNum = calculator.multiply();
        assertEquals(expectedNum, actualNum, "Метод multiply некорректен");

    }

    @Test
    void divide() {
        int expectedNum = 4;
        calculator.setFirstNumber(12);
        calculator.setSecondNumber(3);
        int actualNumber = calculator.divide();
        assertEquals(expectedNum, actualNumber, "Метод divide некорректен");
    }

    @Test
    void divideByZero(){
        //String message = "Деление на ноль запрещено!";
        calculator.setFirstNumber(12);
        calculator.setSecondNumber(0);
//        Exception actualException = assertThrows(ArithmeticException.class, () -> calculator.divide());
//        assertEquals(message, actualException.getMessage(),
//                "Метод divide со вторым аргументом равным 0 некорректен");
        assertThrows(ArithmeticException.class, () -> calculator.divide(), "Метод divide со вторым аргументом равным 0 некорректен");
    }
}