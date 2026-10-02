package session6.assignment;

import java.util.LinkedHashMap;
import java.util.Map;

public class AccessCheckerAssignment {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        switch (fieldModifier) {
            case "private":
                return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            case "default":
                return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) ? "ALLOWED" : "DENIED";
            case "protected":
                return !accessorContext.equals("DIFFERENT_PACKAGE") ? "ALLOWED" : "DENIED";
            case "public":
                return "ALLOWED";
            default:
                return "DENIED";
        }
    }

    public static String summarizeByModifier(String[][] attempts) {
        String[] modifiers = {"private", "default", "protected", "public"};
        Map<String, int[]> stats = new LinkedHashMap<>();
        for (String mod : modifiers) {
            stats.put(mod, new int[]{0, 0}); // {allowed, denied}
        }

        if (attempts != null) {
            for (String[] attempt : attempts) {
                String mod = attempt[0];
                String context = attempt[1];
                String res = classifyAccess(mod, context);
                if (stats.containsKey(mod)) {
                    if (res.equals("ALLOWED")) {
                        stats.get(mod)[0]++;
                    } else {
                        stats.get(mod)[1]++;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String mod : modifiers) {
            int[] counts = stats.get(mod);
            sb.append(mod).append(": ").append(counts[0]).append(" allowed / ").append(counts[1]).append(" denied ");
        }
        return sb.toString().trim();
    }
}