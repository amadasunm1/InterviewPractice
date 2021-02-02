package samples.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Problem: A farmer wants to take a fox, a chicken, and a bag of grain across a river. He has only one boat with which he
can carry one item across the river at once. The only issue is that if the fox and chicken are left unsupervised,
the fox will eat the chicken. The same goes for the chicken and the grain.

Goal: Print out a series of steps that the farmer could take to transport all three items across the river.

One way the farmer might solve this is to:

Take chicken over
Return
Take fox over
Return with chicken
Take grain over
Return
Take chicken over
*/

public class FarmerProblem {

    private static class State {
        public static final String CHICKEN = "chicken";
        public static final String FOX = "fox";
        public static final String GRAIN = "grain";
        private List<String> left;
        private List<String> right;
        private boolean farmerOnLeft;
        private final List<String> chickenFox = List.of(CHICKEN, FOX);
        private final List<String> chickenGrain = List.of(CHICKEN, GRAIN);
        private State prevState;

        public State() {
            this.farmerOnLeft = true;
            this.left = List.of(CHICKEN, FOX, GRAIN);
            this.right = new ArrayList<>();
        }

        public State(List<String> left, List<String> right, boolean farmerOnLeft) {
            this.left = left;
            this.right = right;
            this.farmerOnLeft = farmerOnLeft;
        }

        public boolean isGoal() {
            return right.size() == 3;
        }

        public boolean isValid() {
            // return true if none of the items eats another item, false otherwise
            if(farmerOnLeft) {
                if(this.right.size() == 3)
                    return false;
                if(this.right.containsAll(chickenFox) && !this.right.contains(GRAIN))
                    return false;

                return !this.right.containsAll(chickenGrain) || this.right.contains(FOX);
            } else {
                if(this.left.size() == 3)
                    return false;
                if(this.left.containsAll(chickenFox) && !this.left.contains(GRAIN))
                    return false;

                return !this.left.containsAll(chickenGrain) || this.left.contains(FOX);
            }

        }

        public List<State> nextStates() {
            List<State> states = new ArrayList<>();
            State state = new State(new ArrayList<>(this.left), new ArrayList<>(this.right), !this.farmerOnLeft);
            states.add(state);

            if (this.farmerOnLeft) {
                // Move to right
                for(String object : this.left) {
                    List<String> newRight = new ArrayList<>(this.right);
                    List<String> newLeft = new ArrayList<>(this.left);

                    newRight.add(object);
                    newLeft.remove(object);
                    State newState = new State(newLeft, newRight, false);

                    states.add(newState);
                }
            } else {
                // Move to left
                for(String object : this.right) {
                    List<String> newRight = new ArrayList<>(this.right);
                    List<String> newLeft = new ArrayList<>(this.left);

                    newRight.remove(object);
                    newLeft.add(object);
                    State newState = new State(newLeft, newRight, true);

                    states.add(newState);
                }
            }

            return states;
        }

    }

    public static void main(String[] args) {
        State state = new State();

        Queue<State> q = new LinkedList<>();
        q.add(state);

        while(!q.isEmpty()) {
            State s = q.poll();
            if(s.isGoal()) {
                System.out.println("Found goal.");
                while (s != null) {
                    System.out.println(s.left);
                    System.out.println(s.right);
                    System.out.println(s.farmerOnLeft + "\n");
                    s = s.prevState;
                }
                return;
            }
            List<State> states = s.nextStates();
            for(State st : states) {
                if(st.isValid()){
                    st.prevState = s;
                    q.add(st);
                }

            }
        }
    }
}
