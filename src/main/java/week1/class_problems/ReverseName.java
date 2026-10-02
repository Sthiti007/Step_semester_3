package session1.class_problems;

public class ReverseName {
    public static void main(String[] args) {
        String name = "Sunil";
        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reverseCustomerName(name));
    }

    public static String reverseCustomerName(String customerName) {
        char[] arr = customerName.toCharArray();
        String reversed = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            reversed += arr[i];
        }
        return reversed;
    }
}