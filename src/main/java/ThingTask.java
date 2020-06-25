import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ThingTask {

    private final Map<String, Integer> thing = new HashMap<>();

    public ThingTask(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("List of strings must not be empty");
        }

        strings.forEach(s -> thing.merge(s, 1, Integer::sum));
    }

    public List<Map.Entry<String, Integer>> getListOfEntriesWithCountOfEachStringInDescendingOrder() {
        return thing.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .collect(Collectors.toList());
    }

    public double getAverageStringLength() {
        return thing.entrySet().stream().mapToDouble(e -> e.getKey().length() * e.getValue()).sum()
            / thing.values().stream().mapToDouble(i -> i).sum();
    }

}
