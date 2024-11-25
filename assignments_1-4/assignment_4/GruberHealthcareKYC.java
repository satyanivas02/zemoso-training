package java_assignments.assignment_4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class GruberHealthcareKYC {
    // Date format for parsing and formatting dates
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    // Method to calculate and print the KYC date range
    public static void printKYCRange(String signupDateStr, String currentDateStr) throws ParseException {
        // Parse the input strings into Date objects
        Date signupDate = dateFormat.parse(signupDateStr);
        Date currentDate = dateFormat.parse(currentDateStr);

        // Check if current date is before the first possible anniversary
        if (currentDate.before(signupDate)) {
            System.out.println("No range");
            return;
        }

        // Extract the day and month from the signup date for annual anniversary calculation
        Calendar signupCalendar = Calendar.getInstance();
        signupCalendar.setTime(signupDate);
        int signupDay = signupCalendar.get(Calendar.DAY_OF_MONTH);
        int signupMonth = signupCalendar.get(Calendar.MONTH);

        // Set the anniversary date for the current year
        Calendar anniversaryCalendar = Calendar.getInstance();
        anniversaryCalendar.setTime(currentDate);
        anniversaryCalendar.set(Calendar.DAY_OF_MONTH, signupDay);
        anniversaryCalendar.set(Calendar.MONTH, signupMonth);

        // If the current date is before the anniversary, use the previous year's anniversary
        if (anniversaryCalendar.getTime().after(currentDate)) {
            anniversaryCalendar.add(Calendar.YEAR, -1);
        }

        // Calculate the KYC window (+/- 30 days around the anniversary)
        Calendar startWindow = (Calendar) anniversaryCalendar.clone();
        startWindow.add(Calendar.DAY_OF_MONTH, -30); // 30 days before anniversary

        Calendar endWindow = (Calendar) anniversaryCalendar.clone();
        endWindow.add(Calendar.DAY_OF_MONTH, 30); // 30 days after anniversary

        // Print the KYC range based on the current date
        if (currentDate.before(startWindow.getTime())) {
            // If the current date is before the start of the window, output "No range"
            System.out.println("No range");
        } else if (currentDate.after(endWindow.getTime())) {
            // If current date is after the window, print the full KYC window
            System.out.println(dateFormat.format(startWindow.getTime()) + " " + dateFormat.format(endWindow.getTime()));
        } else {
            // Current date is within the KYC window, print the range up to the current date
            System.out.println(dateFormat.format(startWindow.getTime()) + " " + dateFormat.format(currentDate));
        }
    }

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        // Read the number of inputs
        int n = Integer.parseInt(scanner.nextLine().trim());

        // Process each input line
        for (int i = 0; i < n; i++) {
            String[] dates = scanner.nextLine().split(" ");
            String signupDateStr = dates[0];
            String currentDateStr = dates[1];

            // Print the KYC range for each input
            printKYCRange(signupDateStr, currentDateStr);
        }

        scanner.close();
    }
}
