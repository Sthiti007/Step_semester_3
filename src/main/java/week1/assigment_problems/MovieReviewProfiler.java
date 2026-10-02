package session1.assigment_problems;

public class MovieReviewProfiler {
    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }

    public static void classifyWordLengths(String review) {
        String[] words = review.split(" ");
        int shortWords = 0, mediumWords = 0, longWords = 0;

        for (String word : words) {
            int len = word.length();
            if (len >= 1 && len <= 4) shortWords++;
            else if (len >= 5 && len <= 8) mediumWords++;
            else if (len >= 9) longWords++;
        }
        
        System.out.printf("Short: %d | Medium: %d | Long: %d\n", shortWords, mediumWords, longWords);
    }
}