package session8.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class CanteenPopularOrder {
    public static String[] mostPopular(List<String> orders) {
        if (orders == null || orders.isEmpty()) {
            return new String[]{"", "0"};
        }

        Map<String, Integer> counts = new HashMap<>();
        for (String item : orders) {
            counts.put(item, counts.getOrDefault(item, 0) + 1);
        }

        String bestItem = "";
        int maxCount = -1;

        
        for (String item : orders) {
            int count = counts.get(item);
            if (count > maxCount) {
                maxCount = count;
                bestItem = item;
            }
        }

        return new String[]{bestItem, String.valueOf(maxCount)};
    }
}