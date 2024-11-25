package java_assignments.assignment_11;


import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CharacterCount {
    public static void main(String[] args) {
        // Step 1: Specify the absolute paths for input and output files
        String inputFileName = "E:\\Apple\\Zemoso_Learning\\newJava\\Food-Delivery\\src\\main\\java\\java_assignments\\assignment_11\\input.txt";  // Absolute path to input file
        String outputFileName = "E:\\Apple\\Zemoso_Learning\\newJava\\Food-Delivery\\src\\main\\java\\java_assignments\\assignment_11\\CharacterCounts.txt";  // Output file in the project root

        // Step 2: Create a map to store character counts
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Step 3: Read the file and count the characters
        try {
            // Step 3a: Get the path for the input file
            Path inputPath = Paths.get(inputFileName);

            // Check if the input file exists
            if (!Files.exists(inputPath)) {
                System.out.println("The file " + inputFileName + " does not exist.");
                return;
            }

            // Step 3b: Read the entire content of the input file into a string
            String content = new String(Files.readAllBytes(inputPath));

            // Step 3c: Iterate through each character in the string and count
            for (char ch : content.toCharArray()) {
                // Skip whitespace characters (spaces, tabs, newlines)
                if (Character.isWhitespace(ch)) continue;

                // Update the character count in the map
                charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
            }
        } catch (IOException e) {
            // If an error occurs while reading the file, print the error message
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Step 4: Write the character counts to an output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            // Step 4a: Write each character and its count to the output file
            for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();  // Add a new line after each character's count
            }
            // Notify that the file has been written successfully
            System.out.println("Character counts have been written to " + outputFileName);
        } catch (IOException e) {
            // If an error occurs while writing to the output file, print the error message
            System.out.println("Error writing to the output file: " + e.getMessage());
        }
    }
}
