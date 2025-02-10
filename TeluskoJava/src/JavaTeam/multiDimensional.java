package JavaTeam;

public class multiDimensional {
    public static void main(String args[])
    {
        // Syntax 1
        // declaring and initializing 2D array
        int[][] arr1
            = { { 2, 7, 9 }, { 3, 6, 1 }, { 7, 4, 2 } };

        // printing 2D array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(arr1[i][j] + " ");

            System.out.println();
        }
        System.out.println();

        // Syntax 2
        // declaring and initializing 2D array
        int arr2[][] = { { 10, 20, 30 }, { 40, 50, 60 } };

        // printing 2D array
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(arr2[i][j] + " ");

            System.out.println();
        }
    }
}