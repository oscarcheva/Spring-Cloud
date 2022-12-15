package programing;

import java.util.List;

public class FP01Exercises {
    public static void main(String[] args) {
        //printNumbersInListFunctional(List.of(12, 9, 6, 7));
        printEvenNumbersInListFunctional(List.of(12, 9, 6, 7));
        printSquareOfNumbersInListFunctional(List.of(12, 9, 6, 7));
        printCubeOfOddNumbersInListFunctional(List.of(12, 9, 6, 7));

        printAllCoursesInFunctional(List.of("Spring", "H2", "Kubernetes", "Spring boot"));
        printSomeCoursesInFunctional(List.of("Spring", "H2", "Kubernetes", "Spring boot"));
        printAtLeast4LetterCoursesInFunctional(List.of("Spring", "H2", "Kubernetes", "Spring boot"));
        printLenghtCoursesInFunctional(List.of("Spring", "H2", "Kubernetes", "Spring boot"));
    }

    private static void printLenghtCoursesInFunctional(List<String> courses) {
        System.out.println("----- Length ------------");
        courses.stream()
                .map(v -> v.length())
                .forEach(System.out::println);
    }

    private static void printCubeOfOddNumbersInListFunctional(List<Integer> numbers) {
        System.out.println("----- Cubes -----------");
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(v -> Math.pow(v, 3))
                .forEach(System.out::println);
    }

    private static void printSquareOfNumbersInListFunctional(List<Integer> numbers) {

        System.out.println("--------- Squares --------");

        numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(v -> Math.pow(v, 2))
                .forEach(System.out::println);
    }

    private static void printAtLeast4LetterCoursesInFunctional(List<String> courses) {
        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

    private static void printSomeCoursesInFunctional(List<String> courses) {
        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void printAllCoursesInFunctional(List<String> courses) {
        courses.stream()
                .forEach(System.out::println);
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {

        numbers.stream()
                //.filter(FP01Functional::isEven)
                .filter(number -> number % 2 != 0)

                .forEach(System.out::println);
    }

/*    private static void printNumbersInListFunctional(List<Integer> numbers) {
        //What to do
        numbers.stream()
                .forEach(System.out::println);
    }*/

/*    private static boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;
        }
        return false;
    }*/
}
