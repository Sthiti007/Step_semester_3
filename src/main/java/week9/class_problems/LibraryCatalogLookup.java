package session8.datastructures.practice;

import java.util.List;

public class LibraryCatalogLookup {
    public static String findBook(List<String[]> catalog, String targetIsbn) {
        if (catalog == null || catalog.isEmpty()) {
            return "Not Found";
        }

        int low = 0;
        int high = catalog.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            String[] record = catalog.get(mid);
            String currentIsbn = record[0];

            int cmp = currentIsbn.compareTo(targetIsbn);
            if (cmp == 0) {
                return record[1];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return "Not Found";
    }
}