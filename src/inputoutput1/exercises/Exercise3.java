/**
 * 1. Create a File object pointing to the ("resources") directory.
 * 2. List all files and folders in it.
 * 3. Print each item’s name:
 *      - Add "[DIR]" before folder names.
 *      - Add "[FILE]" before file names.
 * 4. Print the total number of files and directories found.
 */

package inputoutput1.exercises;

import java.io.File;

public class Exercise3
{
    public static void main(String[] args)
    {
        File directory = new File("resources");
        File[] items = directory.listFiles();
        int fileCount = 0;
        int dirCount = 0;

        if (items != null) {
            for (File item : items) {
                if (item.isDirectory()) {
                    System.out.println("[DIR] " + item.getName());
                    dirCount++;
                } else {
                    System.out.println("[FILE] " + item.getName());
                    fileCount++;
                }
            }
        }

        System.out.println("Total files: " + fileCount);
        System.out.println("Total directories: " + dirCount);
    }
}
