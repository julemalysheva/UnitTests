package lesson2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculationTestPow {
    Calculator calculator = new Calculator();

    @Test
    public void testPowPositiveNumbers() {
        assertEquals(8.0, calculator.pow(2.0, 3.0), 0.001);
    }
    @Test
    public void testPowZeroExponent() {
        assertEquals(1.0, calculator.pow(2.0, 0.0), 0.001);
    }
    @Test
    public void testPowOneExponent() {
        assertEquals(2.0, calculator.pow(2.0, 1.0), 0.001);
    }
    @Test
    public void testPowNegativeBase() {
        assertEquals(-8.0, calculator.pow(-2.0, 3.0), 0.001);
    }
    @Test
    public void testPowNegativeExponent() {
        assertEquals(0.5, calculator.pow(2.0, -1.0), 0.001);
    }
}
