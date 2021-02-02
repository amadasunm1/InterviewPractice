package samples.problems;

import org.junit.jupiter.api.Test;

class CollatzTest {

    @Test
    void collatz() {
        Collatz collatzObject = new Collatz();
        collatzObject.collatz(5);
        collatzObject.collatz(2);
    }

    @Test
    void runCollatzUntilOne() {
        Collatz collatzObject = new Collatz();
        collatzObject.runCollatzUntilOne(5);
        collatzObject.runCollatzUntilOne(3);
        collatzObject.runCollatzUntilOne(2);
    }
}