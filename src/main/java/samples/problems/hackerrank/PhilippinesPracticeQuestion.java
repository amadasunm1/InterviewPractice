package samples.problems.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhilippinesPracticeQuestion {

    public List<Integer> dishesPerDay(List<Integer> shrubs, Map<Integer, Integer> rangePerDay){
        List<Integer> result = new ArrayList<>();

        rangePerDay.forEach((key, value) -> {
            // validate starting range
            if (key <= 0) {
                key = 1;
            }

            // validate end range
            if (value > shrubs.size()){
                System.out.println("Range of Shrubs is greater than number of shrubs. Will only count to end...");
                value = shrubs.size() - 1;
            }

            // Add to return list
            result.add(shrubs.subList(key -1, value)
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum()
            );
            incrementShrubs(shrubs);
        });

        return result;
    }

    private void incrementShrubs(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            value++;
            list.set(i, value);
        }
    }
}
