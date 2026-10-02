package session1.class_problems;

public class PalindromeChecker {
    public static void main(String[] args) {
        String text1 = "madam";
        String text2 = "hello";
        
        System.out.println("Input: \"" + text1 + "\" | Iterative: " + (isPalindromeIterative(text1) ? "Palindrome" : "Not Palindrome") +
                " | Recursive: " + (isPalindromeRecursive(text1) ? "Palindrome" : "Not Palindrome") +
                " | Array Reversal: " + (isPalindromeArrayReversal(text1) ? "Palindrome" : "Not Palindrome"));
                
        System.out.println("Input: \"" + text2 + "\" | Iterative: " + (isPalindromeIterative(text2) ? "Palindrome" : "Not Palindrome") +
                " | Recursive: " + (isPalindromeRecursive(text2) ? "Palindrome" : "Not Palindrome") +
                " | Array Reversal: " + (isPalindromeArrayReversal(text2) ? "Palindrome" : "Not Palindrome"));
    }

    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left++) != text.charAt(right--)) return false;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();
        String reversed = "";
        for (int i = arr.length - 1; i >= 0; i--) reversed += arr[i];
        return text.equals(reversed);
    }
}