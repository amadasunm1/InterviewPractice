package samples.problems.facebook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IncreasingSequenceTest {
    private IncreasingSequence increasingSequence;

    @BeforeEach
    public void init() {
        increasingSequence = new IncreasingSequence();
    }

    @Test
    void  testSequence() {
        int[] input = {1, 2, 1, 5};
        int expected = 3;

        int[] input1 = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int expected1 = 6;

        assertEquals(expected, increasingSequence.longestIncreasingSubsequence(input));
        assertEquals(expected1, increasingSequence.longestIncreasingSubsequence(input1));
    }

}
