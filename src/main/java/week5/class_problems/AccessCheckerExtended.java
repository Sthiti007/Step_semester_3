package session6.practice;

public class AccessCheckerExtended {
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
        return AccessChecker.classifyAccess(fieldModifier, accessorContext);
    }
}