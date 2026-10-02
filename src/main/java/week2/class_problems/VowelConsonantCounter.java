package session2.class_problems;

public class VowelConsonantCounter {
    public static void main(String[] args) {
        countVowelsAndConsonants("Java Programming");
    }

    public static void countVowelsAndConsonants(String text) {
        int vowels = 0, consonants = 0;
        String lowerText = text.toLowerCase();
        
        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);
            if (ch == ' ') continue;
            
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else if (ch >= 'a' && ch <= 'z') {
                consonants++;
            }
        }
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }
}