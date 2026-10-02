package session1.class_problems;

public class NonRepeatingChar {
    public static void main(String[] args) {
        String input1 = "swiss";
        String input2 = "aabbcc";
        
        char result1 = findFirstNonRepeatingChar(input1);
        if (result1 != '\0') System.out.println("\"" + input1 + "\" | First Non-Repeating Character: '" + result1 + "'");
        else System.out.println("\"" + input1 + "\" | No Non-Repeating Character Found");
        
        char result2 = findFirstNonRepeatingChar(input2);
        if (result2 != '\0') System.out.println("\"" + input2 + "\" | First Non-Repeating Character: '" + result2 + "'");
        else System.out.println("\"" + input2 + "\" | No Non-Repeating Character Found");
    }

    public static char findFirstNonRepeatingChar(String text) {
        int[] counts = new int[256];
        for (char c : text.toCharArray()) counts[c]++;
        for (char c : text.toCharArray()) {
            if (counts[c] == 1) return c;
        }
        return '\0';
    }
}