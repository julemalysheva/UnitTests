package lesson1;

public class Calculator {
//    public static void main(String[] args) {
//        System.out.printf("Результат операции: %s \n",
//                calculation(2,2,'+')); //Результат операции: 4
//        System.out.printf("Результат операции: %s \n",
//                calculation(2,1,'-')); // Результат операции: 1
//        System.out.printf("Результат операции: %s \n",
//                calculation(2,3,'*')); // Результат операции: 6
//        System.out.printf("Результат операции: %s \n",
//                calculation(8,2,'/')); // Результат операции: 4
//    }
    public static int calculation(int firstOperand, int
            secondOperand, char operator) {
//        int result = 0;
//        switch (operator) {
//            case '+':
//                result = firstOperand + secondOperand;
//                break;
//            case '-':
//                result = firstOperand - secondOperand;
//                break;
//            case '*':
//                result = firstOperand * secondOperand;
//                break;
//            case '/':
//                result = firstOperand / secondOperand;
//                break;
//        }
//        return result;
//    }

        int result;
        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;

    }
}
