package samples.problems.hackerrank;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PhilippinesPracticeQuestionTest {

    @ParameterizedTest
    @MethodSource("dishesPerDay")
    void dishesPerDayValid(List<Integer> flowersInShrub, Map<Integer, Integer> range, List<Integer> expected){
        PhilippinesPracticeQuestion ppq = new PhilippinesPracticeQuestion();
        List<Integer> result = ppq.dishesPerDay(flowersInShrub, range);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> dishesPerDay(){
        List<Integer> flowers1 = new ArrayList<>(List.of(1, 1, 2, 1, 9, 9));
        Map<Integer, Integer> range1 = new LinkedHashMap<>();
        range1.put(3,5);
        range1.put(1,6);
        range1.put(2,2);
        List<Integer> expected1 = new ArrayList<>(List.of(12, 29, 3));

        List<Integer> flowers2 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Map<Integer, Integer> range2 = new LinkedHashMap<>();
        range2.put(1,10);
        List<Integer> expected2 = List.of(55);

        return Stream.of(
                Arguments.of(flowers1,
                        range1,
                        expected1),
                Arguments.of(flowers2, range2, expected2)
        );
    }

}