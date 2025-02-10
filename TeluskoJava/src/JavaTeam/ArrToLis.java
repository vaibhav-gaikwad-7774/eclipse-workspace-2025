package JavaTeam;

import java.util.*;

public class ArrToLis{
    public static void main(String[] args) {
        // Example array
        String[] arr = {"geeks", "for", "geeks"};
        
        // Converting array to immutable list
        List<String> list = List.of(arr);
        
        System.out.println("List: " + list);
    }
}
