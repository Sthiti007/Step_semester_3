package session6.practice;

public class AccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier.equals("private")) {
            return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
        } else if (fieldModifier.equals("default")) {
            return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) ? "ALLOWED" : "DENIED";
        } else if (fieldModifier.equals("protected")) {
            return !accessorContext.equals("DIFFERENT_PACKAGE") ? "ALLOWED" : "DENIED";
        } else if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }
        return "DENIED";
    }

    public static String summarizeBatch(String[][] attempts) {
        int allowed = 0, denied = 0;
        for (String[] attempt : attempts) {
            String result = classifyAccess(attempt[0], attempt[1]);
            if (result.equals("ALLOWED")) {
                allowed++;
            } else {
                denied++;
            }
        }
        return "Allowed: " + allowed + "\nDenied: " + denied;
    }
}