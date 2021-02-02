package samples.problems.hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;

/** Based on HackerRank problem found here: https://www.hackerrank.com/challenges/balanced-brackets/problem**/
public class BalancedBracket {

    public String  isBalanced(String string) {
        if(string.isBlank())
            return "NO";

        Deque<Character> stack = new ArrayDeque<>();

        for (Character c: string.toCharArray()) {
            switch (c){
                case '{':
                case '(':
                case '[':
                    stack.addFirst(c);
                    break;
                case '}':
                    if (isMatch(stack, '{')) return "NO";
                    break;
                case ')':
                    if (isMatch(stack, '(')) return "NO";
                    break;
                case ']':
                    if (isMatch(stack, '[')) return "NO";
                    break;
                default:
                    return "NO";
            }
        }

        if (stack.isEmpty())
            return "YES";

        return "NO";
    }

    private boolean isMatch(Deque<Character> stack, Character character) {
        return stack.isEmpty() || !stack.removeFirst().equals(character);
    }
}
