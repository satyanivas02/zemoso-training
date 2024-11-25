package java_assignments.assignment_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class VampireNumbers {
    // Method to check if two numbers x and y are "fangs" of v
    public static boolean isVampireNumber(int v, int x, int y) {
        if (x % 10 == 0 && y % 10 == 0) return false; // Rule: fangs cannot both end in zero

        String vDigits = Integer.toString(v);
        String fangDigits = Integer.toString(x) + Integer.toString(y);

        char[] vArr = vDigits.toCharArray();
        char[] fArr = fangDigits.toCharArray();

        Arrays.sort(vArr);
        Arrays.sort(fArr);

        return Arrays.equals(vArr, fArr); // Check if sorted digits match
    }

    public static void main(String[] args) {
        List<Integer> vampireNumbers = new ArrayList<>();
        int count = 0;
        int v = 1000; // Start from smallest 4-digit number

        while (count < 100) { // We want the first 100 vampire numbers
            int n = Integer.toString(v).length();

            if (n % 2 == 0) { // Only even-digit numbers are eligible
                int half = n / 2;
                int lower = (int) Math.pow(10, half - 1);
                int upper = (int) Math.pow(10, half);

                for (int x = lower; x < upper; x++) {
                    if (v % x == 0) {
                        int y = v / x;
                        if (y >= lower && y < upper && isVampireNumber(v, x, y)) {
                            vampireNumbers.add(v);
                            count++;
                            System.out.println("Vampire Number " + count + ": " + v);
                            break;
                        }
                    }
                }
            }
            v++;
        }
    }
}


/*
    *Let's check if 1260 qualifies as a vampire number:
    * Step 1: Find possible factors We look for pairs of factors x and y of 1260,
       each with half the digits of 1260 (1260 has 4 digits, so x and y should each have 2 digits).
    *Step 2: Possible pairs
      The two-digit factor pairs of 1260 are:
        𝑥 = 21 and y=60
        * x=30 and y=42
    *Step 3: Check digit rearrangement
      For each pair, we check if the digits of 1260 can be rearranged to form the digits of x and y.
      *Pair (21, 60): 21 × 60 = 1260
       The digits of 1260 are [1, 2, 6, 0]
       The combined digits of 21 and 60 are also [2, 1, 6, 0]
       They match, so 1260 is a vampire number.
 */