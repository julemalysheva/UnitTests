package seminar3.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorView {
    public void printMenu() {
        System.out.print("Выберите операцию:\n1. Сложение\n2. Вычитание\n3. Умножение\n4. Деление\n5. Выход\n");
    }

    public void printResult(int result) {

        System.out.println("Результат: " + result);
    }

    /*
    В случае, когда вводимые данные не являются типом int,
    метод будет выбрасывать исключение InputMismatchException.
     */
    public int getInput() throws InputMismatchException {

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void printErrorMessage(String message) {

        System.out.println(message);
    }
}
