package JavaTeam;

public class Arr1d {
    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30, 40, 50}; // Initialization using int[] a
        int arr2[] = {25, 35, 45, 55, 65};    // Initialization using int a[]

        System.out.println("Elements of 'arr1' array:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("Element at index " + i + ": " + arr1[i]);
        }

        System.out.println();

        System.out.println("Elements of 'arr2' array:");
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("Element at index " + i + ": " + arr2[i]);
        }
    }
}
