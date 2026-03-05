/**
 * 1. Use the File class to create a new file called "resources/students.txt".
 * 2. If the file already exists, print a message "File already exists."
 * 3. If it is newly created, print "File created successfully!"
 * 4. After creation, print the file’s absolute path.
 */

package introduction.exercises;

import java.io.File;
import java.io.IOException;

public class Exercise2
{
    public static void main(String[] args)
    {
        String path = "resources" + File.separator + "students.txt";
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists."); 
            }
            System.out.println("File absolute path: " + file.getAbsolutePath());
        }
        catch (IOException e)
        {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }
}
