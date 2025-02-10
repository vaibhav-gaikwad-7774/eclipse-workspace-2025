package Array;
import java.util.Random;

public class HackerVibe {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        // Set the duration for the effect (30 seconds)
        long endTime = System.currentTimeMillis() + 30 * 1000;

        // Characters to use in the "hacker" effect
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+";

        while (System.currentTimeMillis() < endTime) {
            StringBuilder line = new StringBuilder();

            // Generate a random line of characters
            for (int i = 0; i < 80; i++) {
                char randomChar = characters.charAt(random.nextInt(characters.length()));
                line.append(randomChar);
            }

            // Print the line to the console
            System.out.println(line);

            // Slow down the effect slightly for readability
            Thread.sleep(50);
        }

        System.out.println("\nHacker vibe session ended.");
    }
}
