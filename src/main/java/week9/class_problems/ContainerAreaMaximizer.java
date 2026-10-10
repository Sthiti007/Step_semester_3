package session8.datastructures.practice;

public class ContainerAreaMaximizer {
    public static int maxContainerArea(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }

        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(heights[left], heights[right]);
            int w = right - left;
            int currentArea = h * w;
            
            if (currentArea > maxArea) {
                maxArea = currentArea;
            }

            
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}