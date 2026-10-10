package session8.datastructures.practice;

public class WarehouseGridSummary {
    public static Object[] warehouseSummary(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new Object[]{0, new int[]{0, 0}};
        }

        int totalItems = 0;
        int maxCount = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int count = grid[r][c];
                totalItems += count;

                
                if (count > maxCount) {
                    maxCount = count;
                    maxRow = r;
                    maxCol = c;
                }
            }
        }

        return new Object[]{totalItems, new int[]{maxRow, maxCol}};
    }
}