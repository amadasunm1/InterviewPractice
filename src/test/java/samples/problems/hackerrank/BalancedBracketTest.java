package samples.problems.hackerrank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BalancedBracketTest {

    @Test
    void isBalanced() {
        BalancedBracket balancedBracket = new BalancedBracket();
        assertEquals("NO", balancedBracket.isBalanced(""));
        assertEquals("YES", balancedBracket.isBalanced("{[()]}"));
        assertEquals("NO", balancedBracket.isBalanced("{[(])}"));
        assertEquals("YES", balancedBracket.isBalanced("{{[[(())]]}}"));
    }
}
