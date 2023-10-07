package fourth.card;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PaymentFormTest {

    /**
     * 4.2. Используя библиотеку Mockito, напишите модульные тесты для проверки функциональности формы оплаты на сайте.
     * * Вместо реальной кредитной карты используйте мок-объект.
     * Создайте класс `CreditCard` с методами `getCardNumber()`, `getCardHolder()`, `getExpiryDate()`, `getCvv()`, `charge(double amount)`.
     * Создайте класс `PaymentForm` с методом `pay(double amount)`.
     * В тестовом классе, создайте мок-объект для класса `CreditCard`.
     * Определите поведение мок-объекта с помощью метода `when()`.
     * Создайте объект класса `PaymentForm`, передайте ему мок-объект в качестве аргумента.
     * Вызовите метод `pay()` и убедитесь, что мок-объект вызывает метод `charge()`
     */

    @Test
    public void paymentFormShouldChargeCreditCard() {
        // Arrange - Создается мок-объект creditCardMock с помощью метода mock(CreditCard.class).
        CreditCard creditCardMock = mock(CreditCard.class);

        //- Создается экземпляр класса PaymentForm и передается мок-объект creditCardMock в
        // качестве аргумента конструктора.
        PaymentForm paymentForm = new PaymentForm(creditCardMock);

        double amount = 100.0;

        // Act - - Вызывается метод pay() на объекте paymentForm с передачей заданной суммы amount.
        paymentForm.pay(amount);

        // Assert - проверяется, что метод charge() у мок-объекта creditCardMock был вызван с заданной суммой
        // amount с помощью метода verify(creditCardMock).charge(amount).
        verify(creditCardMock).charge(amount);
    }

    /*
    Таким образом, в этом модульном тесте проверяется, что метод pay() класса PaymentForm вызывает метод charge()
    у объекта CreditCard. Это гарантирует, что форма оплаты корректно использует кредитную карту для
    выполнения оплаты.
     */
}