package programing;

import java.util.List;

public class FP01Structured {

    public static void main(String[] args) {
        printNumbersInListStructured(List.of(12, 9, 6, 7));
        printEvenNumbersInListFunctional(List.of(12, 9, 6, 7));
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        for (int number : numbers) {
            if (number % 2 == 0) {
                System.out.println(number);
            }
        }
    }

    private static void printNumbersInListStructured(List<Integer> numbers) {
        //How to do
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
