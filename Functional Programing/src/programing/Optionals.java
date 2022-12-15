package programing;

import java.util.List;
import java.util.Optional;

public class Optionals {
    public static void main(String[] args) {
        List<String> fruits = List.of("Apple", "Pear", "Peach", "Watermelon");
        Optional<String> optional = fruits.stream()
                .filter(fruit -> fruit.startsWith("P"))
                .findFirst();

        System.out.println(optional);
    }
}
