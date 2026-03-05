/**
 * 1. Create a File object that points to "resources/info.txt".
 * 2. Check if the file exists.
 * 3. If it exists:
 *      - Print its absolute path.
 *      - Print its size in bytes.
 *      - Check if it’s readable and writable.
 * 4. If it doesn’t exist, print a message saying "File not found!".
 */

package introduction.exercises;

import java.io.File;

public class Exercise1
{
    public static void main(String[] args)
    {
        String path = "resources" + File.separator + "info.txt";
        File file = new File(path);
        if (file.exists())
        {
            System.out.println("File exists: " + file.getAbsolutePath());
            System.out.println("File size: " + file.length() + " bytes");
            System.out.println("Readable: " + file.canRead());
            System.out.println("Writable: " + file.canWrite());
        }
        else
        {
            System.out.println("File not found!");
        }

    }
}

