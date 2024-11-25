package java_assignments.assignment_2;

import java.util.HashSet;
import java.util.Set;

public class AlphabetChecker {

    /**
     * Checks if the input string contains all the letters of the alphabet (a-z), case-insensitive.
     *
     * @param input The input string to check.
     * @return true if the input contains all letters of the alphabet, false otherwise.
     */
    public static boolean containsAllLetters(String input) {
        if (input == null || input.length() < 26) {
            return false;
        }

        Set<Character> letters = new HashSet<>();

        for (char c : input.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                letters.add(c);
            }
            if (letters.size() == 26) {  // Early exit if all letters are found
                return true;
            }
        }

        return letters.size() == 26;
    }

    public static void main(String[] args) {
        System.out.println(containsAllLetters("The quick brown fox jumps over the lazy dog")); // true
        System.out.println(containsAllLetters("Hello World")); // false
    }
}

/*
    *Time Complexity: O(n)
    * Space Complexity: O(1)
 */