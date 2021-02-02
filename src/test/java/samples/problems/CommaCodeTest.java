package samples.problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class CommaCodeTest {

    @Test
    void addComma() {
        List<String> test1 = Arrays.asList("dog", "cat", "dog");
        List<String> test2 = Arrays.asList("dog", "cat", "puppy", "sun");

        CommaCode commaCode = new CommaCode();
        System.out.println(commaCode.addComma(test1));
        System.out.println(commaCode.addComma(test2));
    }
}