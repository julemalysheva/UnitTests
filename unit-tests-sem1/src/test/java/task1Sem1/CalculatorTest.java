package task1Sem1;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    /*
    мы проверяем правильность вычисления суммы со скидкой при передаче допустимых аргументов
     */
    @Test
    public void testCalculateDiscountWithValidArgs() {
        Calculator calculator = new Calculator();
        double purchaseAmount = 100.0;
        double discountPercentage = 20.0;
        double expected = 80.0;

        double result = calculator.calculateDiscount(purchaseAmount, discountPercentage);

        assertThat(result).as("Получен неожидаемый резултат").isEqualTo(expected);
    }

    /*
    мы проверяем, что метод calculateDiscount() выбрасывает исключение ArithmeticException,
    если сумма покупки purchaseAmount меньше 0.0
     */
    @Test
    public void testCalculateDiscountWithNegativePurchaseAmount() {
        Calculator calculator = new Calculator();
        double purchaseAmount = -100.0;
        double discountPercentage = 20.0;

        assertThatThrownBy(() ->
                calculator.calculateDiscount(purchaseAmount, discountPercentage))
                .as("Исключение ArithmeticException должно быть выброшено при отрицательной сумме покупки")
                .isInstanceOf(ArithmeticException.class);
    }

    /*
     тест testCalculateDiscountWithZeroPurchaseAmount() отражает логику,
     при которой ожидается возврат 0.0, если сумма покупки равна 0.0
     */
    @Test
    public void testCalculateDiscountWithZeroPurchaseAmount() {
        Calculator calculator = new Calculator();
        double purchaseAmount = 0.0;
        double discountPercentage = 20.0;
        double expected = 0.0;

        double result = calculator.calculateDiscount(purchaseAmount, discountPercentage);

        assertThat(result)
                .as("Результат должен быть равен 0.0")
                .isEqualTo(expected);
    }

    /*
    мы проверяем, что метод выбрасывает исключение ArithmeticException при передаче отрицательного процента скидки
     */
    @Test
    public void testCalculateDiscountWithNegativeDiscountPercentage() {
        Calculator calculator = new Calculator();
        double purchaseAmount = 100.0;
        double discountPercentage = -20.0;

        assertThatThrownBy(() ->
                        calculator.calculateDiscount(purchaseAmount, discountPercentage))
                .as("Исключение ArithmeticException должно быть выброшено при отрицательном проценте скидки")
                .isInstanceOf(ArithmeticException.class);
    }
}
