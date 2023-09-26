package lesson1;
import static org.assertj.core.api.Assertions.*;

public class DivisionByZeroTest {
    public static void main(String[] args) {
        double dividend = 10.0;
        double divisor = 0.0;

        // Проверка с использованием условий if
//        if (divisor != 0) {
//            double result = dividend / divisor;
//            System.out.println("Result: " + result);
//        } else {
//            System.out.println("Error: Division by zero!");
//        }

//        // Проверка с использованием ассертов
//        assert divisor != 0 : "Error: Division by zero!";
//        double result = dividend / divisor;
//        System.out.println("Result: " + result);

        // Проверка с использованием AssertJ
        assertThat(divisor).isNotEqualTo(0.0);
        double result = dividend / divisor;
        System.out.println("Result: " + result);

    }
}

/**
 * Сравнение:
 * - Самым информативным будет сообщение об ошибке, созданное с использованием AssertJ.
 * Сообщение будет содержать информацию о том, что ожидается отделение от нуля (пример:
 * "Expected divisor to be not equal to 0.0"), что помогает лучше понять причину ошибки.
 * - Следующим по информативности будет сообщение об ошибке с ассертами,
 * в котором указывается причина ошибки (пример: "Error: Division by zero!").
 * - Самое простое сообщение об ошибке будет при использовании условий if,
 * где будет просто выводиться фраза "Error: Division by zero!".
 *
 * В целом, использование AssertJ позволяет создавать более информативные сообщения об
 * ошибках с помощью цепочки методов для проверки значений, что упрощает понимание причины ошибки.
 */