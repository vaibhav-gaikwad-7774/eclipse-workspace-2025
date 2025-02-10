package JavaTeam;

public class ArrayIteration {
    public static void main(String[] args) {
        // Define an integer array
        int[] numbers = {10, 20, 30, 40, 50};

        // Iterating using for loop
        System.out.println("Iterating using for loop:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element at index " + i + ": " + numbers[i]);
        }

        // Iterating using foreach loop
        System.out.println("\nIterating using foreach loop:");
        for (int number : numbers) {
            System.out.println("Element: " + number);
        }
    }
}
