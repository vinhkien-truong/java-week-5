/**
 * 1. Create a FileWriter to write into "resources/notes.txt".
 * 2. Write the following text lines into the file:
 *      - "Java I/O is powerful."
 *      - "Streams make reading and writing easier."
 * 3. Use try-with-resources for automatic stream closing.
 * 4. After writing, print "File written successfully!".
 */

package inputoutput1.exercises;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.management.RuntimeErrorException;

public class Exercise4
{
    public static void main(String[] args) {
        String path = "resouzrces" + File.separator + "notes.txt";

       /* if(writeFile(path)) { // true if error is found
            System.out.println("Error found");
        } else { // false if error is not found
            System.out.println("No Error");
        }*/

            try {
                writeFile(path);
            } catch (IOException e) {
                // TODO: handle exception
                System.out.println("Error found : " + e.getMessage());
            }
        
       
    }
    /**
     * This method create/write some text in the file
     * @param path
     * @return true if an exception is found, false if no exception was found
     */
    public static void writeFile(String path) throws IOException {
       // boolean exceptionFound = false;
        try (FileWriter writer = new FileWriter(path)) {
            writer.write("Java I/O is powerful.\n");
            writer.write("Streams make reading and writing easier.\n");
            writer.write("Streams make reading and writing easier.\n");
            System.out.println("File written successfully!");
        }
        catch (IOException e)
        {
            System.out.println("Error writing to file: " + e.getMessage());
            throw e;
            //exceptionFound = true;
        }
       // return exceptionFound;
    }

}
