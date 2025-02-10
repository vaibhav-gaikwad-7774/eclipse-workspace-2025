package JavaTeam;


import java.util.*;

// Driver Class
class StringConverter {
    public static void main(String[] args)
    {
        // Constructor 1
        System.out.println("Using StringTokenizer - ");

        // StringTokenizer
        StringTokenizer st1 = new StringTokenizer(
            "Hello Geeks How are you", " ");

        // hasMoreTokens
        while (st1.hasMoreTokens())
            // Getting next tokens
            System.out.println(st1.nextToken());

        // Constructor 2
        System.out.println("Using hasMoreTokens - ");

        // method
        StringTokenizer st2 = new StringTokenizer(
            "JAVA : Code : String", " :");

        // If tokens are present
        while (st2.hasMoreTokens())

            // Print all tokens
            System.out.println(st2.nextToken());

        // Constructor 3
        System.out.println("Using nextToken - ");
 
        // method
        StringTokenizer st3 = new StringTokenizer(
            "JAVA : Code : String", " :", true);

        while (st3.hasMoreTokens())
            System.out.println(st3.nextToken());
    }
}