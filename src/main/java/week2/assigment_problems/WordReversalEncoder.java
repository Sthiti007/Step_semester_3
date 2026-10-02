package session2.assigment_problems;

import java.util.*;

public class WordFrequencyReport {
    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }

    public static void printFilteredWordFrequency(String feedback) {
        String cleanedText = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleanedText.split("\\s+");
        
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));
        Map<String, Integer> wordCount = new HashMap<>();
        
        for (String word : words) {
            if (!word.isEmpty() && !stopWords.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}