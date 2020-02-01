package samples.problems;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

import java.util.*;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class FeatureRequests
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> popularNFeatures(int numFeatures, int topFeatures, List<String> possibleFeatures,
                                         int numFeatureRequests, List<String> featureRequests) {
        // WRITE YOUR CODE HERE
        Map<String, Integer> mostDesiredMap = new TreeMap<>();
        for (String posibleFeature : possibleFeatures) {
            // Make more efficient if time permits
            int count = 0;
            for (String featureRequest : featureRequests) {
                if(getCount(posibleFeature, featureRequest) != 0) {
                    count++;
                }
            }
            mostDesiredMap.put(posibleFeature, count);
        }

        ArrayList<String> result = new ArrayList<>();

        Map<String, Integer> collect = mostDesiredMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(topFeatures).collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        collect.forEach((n, j) -> result.add(n));

        return result;
    }
    // METHOD SIGNATURE ENDS

    private Integer getCount(String possibleFeature, String featureRequest) {
        return StringUtils.countMatches(featureRequest, possibleFeature);
    }
}

