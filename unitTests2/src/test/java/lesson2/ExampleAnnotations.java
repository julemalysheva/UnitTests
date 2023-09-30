package lesson2;
//Пример использования аннотаций

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ExampleAnnotations {
    @BeforeAll
    static void setUpAll() {
        System.out.println("Выполняется перед началом всех тестов");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Выполняется перед каждым тестовым методом");
    }

    @Test
    @DisplayName("Пример тестового метода")
    void testMethod() {
        System.out.println("Тестовый метод");
    }

    @Disabled
    @Test
    void disabledTest() {
        System.out.println("Этот тест будет пропущен");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void parameterizedTest(int value) {
        System.out.println("Параметрованный тест со значением: " + value);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Выполняется после каждого тестового метода");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Выполняется после окончания всех тестов");
    }
}
