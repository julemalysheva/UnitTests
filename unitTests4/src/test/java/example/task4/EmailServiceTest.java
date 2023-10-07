package example.task4;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class EmailServiceTest {

    @Test
    void testSendWelcomeEmail() {
        // Создаем шпиона для сервиса отправки email
        EmailService emailService = spy(new EmailService());

        // Вызываем метод регистрации пользователя
        UserService userService = new UserService(emailService);
        userService.registerUser("user@example.com");

        // Проверяем, что метод sendEmail был вызван с определенными аргументами
        verify(emailService).sendEmail("user@example.com", "Добро пожаловать!", "Добро пожаловать в наше приложение!");
        /*
        Для проверки только одного аргумента в вызове метода с использованием Mockito,
        вы можете использовать метод eq() вместо any().
        Метод eq() позволяет указать конкретное значение, которое вы ожидаете увидеть в аргументе.
         */
//        verify(emailService).sendEmail(eq("user@example.com"), any(), any());


    }
}