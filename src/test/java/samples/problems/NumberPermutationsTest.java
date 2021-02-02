package samples.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberPermutationsTest {

    @Test
    public void validPermutationsTest() {
        NumberPermutations numberPermutations = new NumberPermutations();

        List<Integer> list = List.of(1, 2, 1, 3);

        assertFalse(numberPermutations.validPermutations(list, 8));
        assertTrue(numberPermutations.validPermutations(list, 7));
        assertTrue(numberPermutations.validPermutations(list, 25));
    }
}
