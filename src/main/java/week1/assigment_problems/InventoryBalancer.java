package session1.assigment_problems;

public class InventoryBalancer {
    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        analyzeInventory(sectionA, sectionB);
    }

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0;
        int maxQty = -1, maxIndex = -1;
        String maxSection = "";

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxQty) {
                maxQty = sectionA[i];
                maxIndex = i;
                maxSection = "Section A";
            }
        }
        
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxQty) {
                maxQty = sectionB[i];
                maxIndex = i;
                maxSection = "Section B";
            }
        }
        
        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)\n",
                          totalA, totalB, status, maxQty, maxSection, (maxIndex + 1));
    }
}