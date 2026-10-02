package session1.assigment_problems;

public class TrafficSignalStreak {
    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }

    public static void findLongestStreak(String signalLog) {
        int maxStreak = 0;
        char maxChar = ' ';
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentStreak++;
            } else {
                currentStreak = 1;
            }
            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
                maxChar = signalLog.charAt(i);
            }
        }
        System.out.println("Longest Streak: '" + maxChar + "' repeated " + maxStreak + " times");
    }
}