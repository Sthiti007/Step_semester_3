package session8.datastructures;

import java.util.ArrayList;
import java.util.List;

public class TokenMerger {
    public static List<Integer> mergeTokens(List<Integer> counterA, List<Integer> counterB) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        if (counterA == null) counterA = new ArrayList<>();
        if (counterB == null) counterB = new ArrayList<>();

        while (i < counterA.size() && j < counterB.size()) {
            if (counterA.get(i) <= counterB.get(j)) {
                merged.add(counterA.get(i++));
            } else {
                merged.add(counterB.get(j++));
            }
        }

        while (i < counterA.size()) {
            merged.add(counterA.get(i++));
        }

        while (j < counterB.size()) {
            merged.add(counterB.get(j++));
        }

        return merged;
    }
}