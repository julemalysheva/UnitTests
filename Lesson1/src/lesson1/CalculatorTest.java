package lesson1;
import static org.assertj.core.api.Assertions.*;
public class CalculatorTest {
    public static void main(String[] args) {
//        if (8 != Calculator.calculation(2, 6, '+')) {
//            throw new AssertionError("Ошибка в методе");
//        }
//        if (0 != Calculator.calculation(2, 2, '-')) {
//            throw new AssertionError("Ошибка в методе");
//        }
//        if (14 != Calculator.calculation(2, 7, '*')) {
//            throw new AssertionError("Ошибка в методе");
//        }
//        if (1 != Calculator.calculation(2, 2, '/')) {
//            throw new AssertionError("Ошибка в методе");
//        }
        // Проверка базового функционала с целыми числами, с
        // использованием утверждений:
//        assert 8 == Calculator.calculation(2, 6, '+');
//        assert 0 == Calculator.calculation(2, 2, '-');
//        assert 14 == Calculator.calculation(2, 7, '*');
//        assert 2 == Calculator.calculation(100, 50, '/');

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);

        // Случаи с неправильными аргументами
        // аргумент operator типа char, должен вызывать исключение, если он получает не базовые символы (+-*/)
//        try {
//            Calculator.calculation(8, 4, '_');
//        } catch (IllegalStateException e) {
//            if (!e.getMessage().equals("Unexpected value operator: _"))
//            {
//                throw new AssertionError("Ошибка в методе");
//            }
//        }
        assertThatThrownBy( () -> Calculator.calculation(8, 4, '_')
        ).isInstanceOf(IllegalStateException.class);

    }

}
