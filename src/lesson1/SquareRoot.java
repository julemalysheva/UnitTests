package lesson1;

public class SquareRoot {
//    public static double squareRoot(double num) {
//        if (num < 0) {
//            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
//        }
//
//        return Math.sqrt(num);
//    }

//    public static void main(String[] args) {
//        System.out.print(squareRoot(9.0));
//    }

    public static double squareRoot(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }

        double guess = num / 2;
        double prevGuess;

        do {
            prevGuess = guess;
            guess = (prevGuess + (num / prevGuess)) / 2;
        } while (Math.abs(guess - prevGuess) >= 0.0001);

        return guess;
    }
}
