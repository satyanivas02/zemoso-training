package java_assignments.assignment_9;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SentenceValidator {
    public static void main(String[] args) {
        // Define a regular expression pattern to match a sentence
        String regex = "^[A-Z].*\\.$";

        // Test sentences
        String[] testSentences = {
                "This is a valid sentence.",
                "this sentence starts with a lowercase letter.",
                "This sentence ends without a period",
                "This one Ends with a period."
        };

        // Loop through each test sentence and check if it matches the pattern
        for (String sentence : testSentences) {
            if (isValidSentence(sentence)) {
                System.out.println("\"" + sentence + "\" is a valid sentence.");
            } else {
                System.out.println("\"" + sentence + "\" is NOT a valid sentence.");
            }
        }
    }

    // Method to validate a sentence against the regex pattern
    public static boolean isValidSentence(String sentence) {
        // Compile the regular expression pattern
        Pattern pattern = Pattern.compile("^[A-Z].*\\.$");

        // Create a matcher for the input sentence
        Matcher matcher = pattern.matcher(sentence);

        // Return whether the sentence matches the pattern
        return matcher.matches();
    }
}
