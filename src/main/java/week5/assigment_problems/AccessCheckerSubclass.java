package session6.assignment;

public class AccessCheckerSubclass {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
            if (fieldModifier.equals("protected") || fieldModifier.equals("public")) {
                return "ALLOWED";
            }
            return "DENIED";
        }
        if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {
            return fieldModifier.equals("public") ? "ALLOWED" : "DENIED";
        }
        return AccessCheckerAssignment.classifyAccess(fieldModifier, accessorContext);
    }

    public static String firstDeniedAttempt(String[][] attempts) {
        if (attempts == null) return "None Denied";
        for (int i = 0; i < attempts.length; i++) {
            String mod = attempts[i][0];
            String context = attempts[i][1];
            String result = classifyAccess(mod, context);
            if (result.equals("DENIED")) {
                return mod + " via " + context + " (attempt #" + (i + 1) + ")";
            }
        }
        return "None Denied";
    }
}