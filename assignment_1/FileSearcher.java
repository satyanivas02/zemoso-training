package java_assignments.assignment_1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSearcher {

    /**
     * Recursively searches for files that match a given regular expression in the specified directory.
     *
     * @param directory The starting directory for the search.
     * @param regex The regular expression pattern to match file names.
     * @return A list of absolute paths of files that match the regex.
     */
    public static List<String> searchFiles(File directory, String regex) {
        List<String> matchingFiles = new ArrayList<>();
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Recursively search in subdirectories
                    matchingFiles.addAll(searchFiles(file, regex));
                } else {
                    // Check if the file name matches the regex
                    if (file.getName().matches(regex)) {
                        matchingFiles.add(file.getAbsolutePath());
                    }
                }
            }
        }
        return matchingFiles;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String homeDirectory = System.getProperty("user.home");

        System.out.println("Welcome to the File Searcher!");
        System.out.println("Enter a regular expression to search for files in your home directory.");
        System.out.println("Type 'exit' to quit the program.");

        while (true) {
            System.out.print("\nEnter regex: ");
            String regex = scanner.nextLine().trim();

            // Exit if the user types "exit"
            if (regex.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program.");
                break;
            }

            // Perform file search
            File homeDir = new File(homeDirectory);
            List<String> result = searchFiles(homeDir, regex);

            // Print results
            if (result.isEmpty()) {
                System.out.println("No files found matching the pattern.");
            } else {
                System.out.println("Matching files:");
                for (String filePath : result) {
                    System.out.println(filePath);
                }
            }
        }

        scanner.close();
    }
}

