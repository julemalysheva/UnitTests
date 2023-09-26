package task1Sem1;

public class Calculator {
    public double calculateDiscount(double purchaseAmount, double discountPercentage) {
        if (purchaseAmount < 0 || discountPercentage < 0) {
            throw new ArithmeticException("Недопустимые аргументы: " +
                    "сумма покупки и процент скидки должны быть неотрицательными");
        }

        double discountAmount = purchaseAmount * (discountPercentage / 100);
        return purchaseAmount - discountAmount;
    }
}
