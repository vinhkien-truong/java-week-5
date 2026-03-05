/**
 * 1. Use FileInputStream and FileOutputStream to copy a file.
 * 2. Read from "source.txt" and write its content into "backup.txt".
 * 3. Use try-with-resources to automatically close both streams.
 * 4. After copying, print "File copied successfully!".
 * 5. Handle IOException properly.
 */

package introduction.exercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise5
{
    public static void main(String[] args)
    {
        String sourcePath = "resources" + File.separator + "source.txt";
        String destPath = "resources" + File.separator + "backup.txt";

        try (FileInputStream inputStream = new FileInputStream(sourcePath);
             FileOutputStream outputStream = new FileOutputStream(destPath)) {

            int byteData;
            while ((byteData = inputStream.read()) != -1)
            {
                outputStream.write(byteData);
            }
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }

    }
}
