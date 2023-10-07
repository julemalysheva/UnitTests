package example.task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

//устаревшая реализация
//public class EmailSenderTest {
//    @Mock
//    private EmailService mockEmailService;
//
//    @BeforeEach
//    void setUp() {
//        // Инициализируем моки
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void testSendWelcomeEmail() {
//        // Создаем экземпляр EmailSender с моком EmailService
//        EmailSender emailSender = new EmailSender(mockEmailService);
//
//        // Вызываем метод, который мы хотим протестировать
//        emailSender.sendWelcomeEmail("user@example.com");
//
//        // Проверяем, что метод sendEmail был вызван с ожидаемыми аргументами
//        verify(mockEmailService).sendEmail("user@example.com", "Добро пожаловать!", "Добро пожаловать в наше приложение!");
//       // verify(mockEmailService).sendEmail(eq("user@example.com"), any(), any());
//    }
//}


//современная реализация
/*
Данный код представляет пример теста для класса EmailSender.

- Аннотация @ExtendWith(MockitoExtension.class) указывает на использование Mockito в тестовом классе.

- @Mock аннотация создает заглушку (mock) объекта EmailService. В этом случае,
mockEmailService является заглушкой для реального объекта EmailService.

- @InjectMocks аннотация внедряет (inject) созданные заглушки в объект emailSender,
который является объектом, который мы хотим протестировать.

- @Test аннотация указывает, что следующий метод является тестовым методом.

- Внутри тестового метода testSendWelcomeEmail мы вызываем метод emailSender.sendWelcomeEmail("user@example.com"),
который мы хотим протестировать.

- Затем мы используем verify для проверки, что метод sendEmail в mockEmailService был вызван с о
жидаемыми аргументами ("user@example.com", "Добро пожаловать!", "Добро пожаловать в наше приложение!").

Тест в данном примере проверяет, что при вызове метода sendWelcomeEmail у объекта emailSender
с аргументом "user@example.com", метод sendEmail у mockEmailService также вызывается с ожидаемыми аргументами.

Таким образом, весь код образует простой тест, использующий Mockito для создания заглушки
mockEmailService и проверки вызова метода sendEmail с ожидаемыми аргументами.

 */
@ExtendWith(MockitoExtension.class)
public class EmailSenderTest {

    @Mock
    private EmailService mockEmailService;

    @InjectMocks
    private EmailSender emailSender;

    @Test
    void testSendWelcomeEmail() {
        // Вызываем метод, который мы хотим протестировать
        emailSender.sendWelcomeEmail("user@example.com");

        // Проверяем, что метод sendEmail был вызван с ожидаемыми аргументами
        verify(mockEmailService).sendEmail("user@example.com", "Добро пожаловать!", "Добро пожаловать в наше приложение!");
    }
}
