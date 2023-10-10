package five.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceIntegrationTest {

    private OrderService orderService;

    @Mock
    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        orderService = new OrderService(paymentService);
    }

    @Test
    void testProcessOrderWithSuccessfulPayment() {
        Order order = new Order(100); // Создаем заказ с общей суммой 100

        // Задаем ожидаемое поведение для метода processPayment: вернуть true (успешный платеж)
        when(paymentService.processPayment(order)).thenReturn(true);

        // Вызываем метод processOrder из OrderService
        boolean result = orderService.processOrder(order);

        // Проверяем, что метод processPayment был вызван с заказом
        verify(paymentService).processPayment(order);

        // Проверяем, что результат равен true (успешный заказ)
        assertTrue(result);
    }

    @Test
    void testProcessOrderWithFailedPayment() {
        Order order = new Order(200); // Создаем заказ с общей суммой 200

        // Задаем ожидаемое поведение для метода processPayment: вернуть false (неуспешный платеж)
        when(paymentService.processPayment(order)).thenReturn(false);

        // Вызываем метод processOrder из OrderService
        boolean result = orderService.processOrder(order);

        // Проверяем, что метод processPayment был вызван с заказом
        verify(paymentService).processPayment(order);

        // Проверяем, что результат равен false (неуспешный заказ)
        assertFalse(result);
    }
}
