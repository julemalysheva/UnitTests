package five.order;

public class PaymentService {
    public boolean processPayment(Order order) {
        // Здесь должна быть логика обработки платежа, например, проверка карты и списание средств
        // В данном примере мы просто вернем true для успешного платежа
        return true;
    }
}

//public class PaymentService {
//    public boolean processPayment(String orderId, double amount) {
//        // Здесь обычно был бы код для обработки платежей, но для примера просто возвращаем true
//        return true;
//    }
//}
