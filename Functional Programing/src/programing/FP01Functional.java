package programing;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {
        printNumbersInListFunctional(List.of(12, 9, 6, 7));
        printEvenNumbersInListFunctional(List.of(12, 9, 6, 7));
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {

        numbers.stream()
                //.filter(FP01Functional::isEven)
                .filter(number -> number % 2 == 0)

                .forEach(System.out::println);
    }

    private static void printNumbersInListFunctional(List<Integer> numbers) {
        //What to do
        numbers.stream()
                .forEach(System.out::println);
    }

/*    private static boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;
        }
        return false;
    }*/
}
