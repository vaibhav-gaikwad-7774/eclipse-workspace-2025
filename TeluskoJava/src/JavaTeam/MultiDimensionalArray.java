package JavaTeam;

public class MultiDimensionalArray {
    public static void main(String []args) {
        int[] arr1, arr2;
        arr1 = new int[4];  
        arr2 = new int[4];  
        
        arr1[0] = 15;
        arr1[1] = 25;
        arr1[2] = 35;
        arr1[3] = 56;	
        
        arr2[0] = 11;
        arr2[1] = 22;
        arr2[2] = 33;
        arr2[3] = 53;
        

        // Printing the elements of array1
        System.out.println("Elements of Array1: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("Index " + i + ": " + arr1[i]);
        }

        // Printing the elements of array2
        System.out.println("Elements of Array2: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("Index " + i + ": " + arr2[i]);
        }
    }
}
