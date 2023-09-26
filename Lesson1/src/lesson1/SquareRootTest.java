package lesson1;

import static org.assertj.core.api.Assertions.*;

public class SquareRootTest {
    public static void main(String[] args) {
        testSquareRootWithConditions();
        testSquareRootWithAssert();
        testSquareRootWithAssertJ();
    }

    public static void testSquareRootWithConditions() {
        double positiveNum = 4.0;
        double zeroNum = 0.0;
        double negativeNum = -4.0;

        // Проверка с использованием обычных условий if
        if (positiveNum >= 0) {
            double result = SquareRoot.squareRoot(positiveNum);
            if (result == 2.0) {
                System.out.println("Test Passed: squareRoot(" + positiveNum + ") returned " + result);
            } else {
                System.out.println("Test Failed: Expected 2.0, but got " + result);
            }
        }

        if (zeroNum >= 0) {
            double result = SquareRoot.squareRoot(zeroNum);
            if (result == 0.0) {
                System.out.println("Test Passed: squareRoot(" + zeroNum + ") returned " + result);
            } else {
                System.out.println("Test Failed: Expected 0.0, but got " + result);
            }
        }

        if (negativeNum >= 0) {
            double result = SquareRoot.squareRoot(negativeNum);
            if (result == 2.0) {
                System.out.println("Test Passed: squareRoot(" + negativeNum + ") returned " + result);
            } else {
                System.out.println("Test Failed: Expected 2.0, but got " + result);
            }
        }
    }

    public static void testSquareRootWithAssert() {
        double positiveNum = 4.0;
        double zeroNum = 0.0;
        double negativeNum = -4.0;

        // Проверка с использованием Assert
        double positiveResult = SquareRoot.squareRoot(positiveNum);
        assert positiveResult == 2.0 : "Test Failed: Expected 2.0, but got " + positiveResult;

        double zeroResult = SquareRoot.squareRoot(zeroNum);
        assert zeroResult == 0.0 : "Test Failed: Expected 0.0, but got " + zeroResult;

        double negativeResult = SquareRoot.squareRoot(negativeNum);
        assert negativeResult == 2.0 : "Test Failed: Expected 2.0, but got " + negativeResult;

        System.out.println("All tests passed with Assert");
    }

    public static void testSquareRootWithAssertJ() {
        double positiveNum = 4.0;
        double zeroNum = 0.0;
        double negativeNum = -4.0;

        // Проверка с использованием AssertJ
        assertThat(SquareRoot.squareRoot(positiveNum)).isEqualTo(2.0);
        assertThat(SquareRoot.squareRoot(zeroNum)).isEqualTo(0.0);
        assertThat(SquareRoot.squareRoot(negativeNum)).isEqualTo(2.0);

        System.out.println("All tests passed with AssertJ");
    }
}
