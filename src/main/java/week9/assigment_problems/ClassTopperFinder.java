package session8.datastructures;

public class ClassTopperFinder {
    public static int[] findTopper(int[][] marks) {
        if (marks == null || marks.length == 0) {
            return new int[]{-1, 0};
        }

        int bestRow = 0;
        int maxTotal = -1;

        for (int i = 0; i < marks.length; i++) {
            int currentTotal = 0;
            for (int mark : marks[i]) {
                currentTotal += mark;
            }

            
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                bestRow = i;
            }
        }
        return new int[]{bestRow, maxTotal};
    }
}