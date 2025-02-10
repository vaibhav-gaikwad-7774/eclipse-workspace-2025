package JavaTeam;
import java.util.StringJoiner;

public class StringJoinerMethodsExample{
    public static void main(String[] args) {
        
        // add() method
        StringJoiner gfg1 = new StringJoiner(", ");
        gfg1.add("geeks").add("for").add("geeks");
        System.out.println("StringJoiner with elements: " + gfg1.toString());
        
        // 2. Using setEmptyValue() method 
        StringJoiner gfg2 = new StringJoiner(", ");
        gfg2.setEmptyValue("No elements to join");
        System.out.println("Empty StringJoiner: " + gfg2.toString());  
        
        // 3. Using toString() method
        StringJoiner gfg3 = new StringJoiner(" | ", "[", "]");
        gfg3.add("geeks").add("for").add("geeks");
        System.out.println("StringJoiner with prefix and suffix: " + gfg3.toString());
        
        // 4. Checking the length of the joined string
        StringJoiner gfg4 = new StringJoiner(", ");
        gfg4.add("geeks").add("for").add("geeks");
        System.out.println("Length of joined string: " + gfg4.length());
        
    }
}
