package samples.problems;

import java.util.ArrayList;
import java.util.List;

public class CommaCode {

    public String addComma(List<String> input) {
        List<String> copy = new ArrayList<>(input);
        String lastValue = copy.remove(copy.size() - 1);
        String result = String.join(", ", copy);

        return result + ", and " + lastValue;
    }

}
