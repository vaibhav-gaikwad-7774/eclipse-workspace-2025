package JavaTeam;

// Java program to demonstrate differences between 
// String, StringBuilder, and StringBuffer

class StrngDifference123 {

    // Concatenates to String (immutable)
    public static void concat1(String s1) {
        s1 = s1 + "forgeeks"; // Creates a new String object
    }

    // Concatenates to StringBuilder (mutable)
    public static void concat2(StringBuilder s2) {
        s2.append("forgeeks"); // Modifies the original object
    }

    // Concatenates to StringBuffer (mutable and thread-safe)
    public static void concat3(StringBuffer s3) {
        s3.append("forgeeks"); // Modifies the original object
    }

    public static void main(String[] args) {
        // String (immutable)
        String s1 = "Geeks";
        concat1(s1); // No change in s1
        System.out.println("String: " + s1);

        // StringBuilder (mutable)
        StringBuilder s2 = new StringBuilder("Geeks");
        concat2(s2); // Changes s2
        System.out.println("StringBuilder: " + s2);

        // StringBuffer (mutable and thread-safe)
        StringBuffer s3 = new StringBuffer("Geeks");
        concat3(s3); // Changes s3
        System.out.println("StringBuffer: " + s3);
    }
}
