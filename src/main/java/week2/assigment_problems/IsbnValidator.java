package session2.assigment_problems;

public class IsbnValidator {
    public static void main(String[] args) {
        System.out.println(validateAndFormat("  pen2026004251 "));
        System.out.println(validateAndFormat("12N2026004251"));
    }

    public static String normalizeCode(String raw) {
        if (raw == null || raw.trim().length() < 3) return raw != null ? raw.trim() : "";
        String trimmed = raw.trim();
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        String normalized = normalizeCode(code);
        
        if (normalized.length() != 13) return "Invalid: wrong length";
        
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        
        String pubCode = normalized.substring(0, 3);
        String year = normalized.substring(3, 7);
        String catalog = normalized.substring(7);
        
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ").append(year).append(" | CATALOG: ").append(catalog);
        return sb.toString();
    }
}