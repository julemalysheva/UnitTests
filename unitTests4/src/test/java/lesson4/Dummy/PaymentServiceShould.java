package lesson4.Dummy;
/*
Из-за того, что класс PaymentService требует класс Logger в качестве обязательного
параметра в конструкторе, было принято решение использовать заглушку
LoggerDummy, чтобы избежать сохранения журналов логов в файл или отправки их
куда-либо еще, что может нарушить изоляцию теста. Также мы не хотим проверять
всю информацию, содержащуюся в журналах и не связанную с бизнес-логикой,
поэтому мы создаем фиктивный объект логгера и передаем его в сервис. Это
позволяет нам быть уверенными в работе наших тестов, поскольку, если тест
провалится, мы можем точно знать, что проблема не в тестовом двойнике.
Тест, проверяющий часть бизнес-логики класса PaymentServiceShould:
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceShould {
   // @Test
//    void create_payment_request() {
//// Создается dummy-обьект без реализации
//        LoggerDummy loggerDummy = new LoggerDummy();
////. . .
//// loggerDummy передается в качестве аргумента
//        PaymentService paymentService = new
//                PaymentService(loggerDummy);
//        assertEquals(true, paymentService.createPaymentRequest());
//    }
}
/*
Другие примеры таких dummy-объектов — new Object(), null, «Ignored String»
 */
