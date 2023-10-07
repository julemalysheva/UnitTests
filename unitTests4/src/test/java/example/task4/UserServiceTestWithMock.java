package example.task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class UserServiceTestWithMock {

    // Создаем мок для EmailService
    @Mock
    private EmailService emailService;

    public UserServiceTestWithMock() {
        // Инициализируем моки перед каждым тестом
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser() {
        // Создаем объект UserService с моком EmailService
        UserService userService = new UserService(emailService);

        // Вызываем метод registerUser
        userService.registerUser("user@example.com");

        // Проверяем, что метод sendEmail был вызван один раз с определенными аргументами
        verify(emailService, times(1)).sendEmail("user@example.com", "Добро пожаловать!", "Добро пожаловать в наше приложение!");
    }
}