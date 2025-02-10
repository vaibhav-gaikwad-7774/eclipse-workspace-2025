import static org.testng.AssertJUnit.assertEquals;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.testng.annotations.Test;

public class ResourceTest {

    @Test
    public void testReadResourceFileWithInputStream() {
        // Open the resource file as an InputStream
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.txt");
             Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {

            // Read the content from the InputStream
            String content = scanner.useDelimiter("\\A").next();

            // Assert the content of the file
            assertEquals("Expected content", content.trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
