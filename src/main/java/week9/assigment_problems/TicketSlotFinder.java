package session8.datastructures;

import java.util.List;

public class TicketSlotFinder {
    public static int findSlot(List<Integer> prices, int newPrice) {
        if (prices == null || prices.isEmpty()) {
            return 0;
        }

        int low = 0;
        int high = prices.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int current = prices.get(mid);

            if (current == newPrice) {
                return mid;
            } else if (current < newPrice) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // When not found, 'low' points exactly to the insertion index
        return low;
    }
}