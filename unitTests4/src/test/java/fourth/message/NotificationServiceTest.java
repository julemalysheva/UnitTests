package fourth.message;

/*
Задание №5
Вам нужно написать тест с использованием моков для сервиса отправки сообщений.
Условие: У вас есть класс MessageService с методом public void sendMessage(String message, String
recipient), который отправляет сообщение получателю.
Вам необходимо проверить правильность работы класса NotificationService, который использует
MessageService для отправки уведомлений.

 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceTest {

    @Mock
    private MessageService messageService;

    @Test
    public void testSendNotification() {
        NotificationService notificationService = new NotificationService(messageService);

        String message = "Hello";
        String recipient = "user@example.com";

        notificationService.sendNotification(message, recipient);

        verify(messageService).sendMessage(message, recipient);
    }
}

