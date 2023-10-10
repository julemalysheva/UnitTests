package five.order;

public class OrderService {
    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public boolean processOrder(Order order) {
        // Логика обработки заказа, например, расчет скидок и отправка на выполнение
        // В данном примере мы просто вызываем метод processPayment из PaymentService
        return paymentService.processPayment(order);
    }
}

//public class OrderService {
//    private final PaymentService paymentService;
//
//    public OrderService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
//
//    public boolean placeOrder(String orderId, double amount) {
//        // Заказ принимается, только если платеж успешно обработан
//        return paymentService.processPayment(orderId, amount);
//    }
//}
