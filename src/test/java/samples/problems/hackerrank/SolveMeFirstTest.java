package samples.problems.hackerrank;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolveMeFirstTest {

    @ParameterizedTest
    @MethodSource("input_oneArgument")
    void input_one(int a, int b, int expected){
        SolveMeFirst smv = new SolveMeFirst();

        int solution = smv.solution(a, b);

        assertEquals(expected, solution);
    }

    private static Stream<Arguments> input_oneArgument(){
       return Stream.of(Arguments.of(2, 3, 5),
               Arguments.of(10, 12, 22),
               Arguments.of(-10, 10, 0));
    }
}