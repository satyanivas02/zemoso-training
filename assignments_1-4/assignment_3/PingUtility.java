package java_assignments.assignment_3;

/* *The system’s built-in ping utility is a simple way to check network latency
(the time taken for a signal to travel to the host and back)
   *When you ping a host, it sends small data packets to it and measures the time it takes to receive a response.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PingUtility {

    /**
     * Pings a host and computes the median of the time taken.
     *
     * @param host The host to ping.
     * @param count Number of ping attempts.
     * @return The median time taken for the ping requests in milliseconds, or -1 if the ping fails.
     */
    public static double pingAndComputeMedian(String host, int count) {
        List<Double> times = new ArrayList<>(); // Stores the ping times

        try {
            // 1. Setting up the command to ping
            // "ping -c <count> <host>" is for Linux/Mac, "ping -n <count> <host>" for Windows
            ProcessBuilder processBuilder = new ProcessBuilder("ping", "-n", String.valueOf(count), host);

            // 2. Start the process to execute the command
            Process process = processBuilder.start();

            // 3. Reading the output of the ping command
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;

                // Loop through each line of the output
                while ((line = reader.readLine()) != null) {
                    // 4. Check for "time=" in each line, which contains the ping time
                    if (line.contains("time=")) {
                        String[] parts = line.split("time=");
                        // Extract the part after "time=", which is the actual time value
                        String timePart = parts[1].split(" ")[0];
                        // Parse the time to a double and add it to the list
                        times.add(Double.parseDouble(timePart));
                    }
                }
            }

            // 5. Wait for the ping process to complete
            process.waitFor();

            // If no valid ping times were found, return -1 to indicate an error
            if (times.isEmpty()) {
                System.out.println("No valid ping times found.");
                return -1;
            }

            // 6. Calculate the median of the ping times
            Collections.sort(times); // Sort the times to get the median
            int size = times.size();
            if (size % 2 == 1) {
                // Odd number of times, median is the middle element
                return times.get(size / 2);
            } else {
                // Even number of times, median is the average of the two middle elements
                return (times.get(size / 2 - 1) + times.get(size / 2)) / 2.0;
            }

        } catch (IOException | InterruptedException e) {
            // Handle any exceptions and return -1 if an error occurs
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {
        // Host to ping and the number of ping attempts
        String host = "google.com";
        int pingCount = 5;

        // Call the function to ping the host and get the median ping time
        double medianTime = pingAndComputeMedian(host, pingCount);

        // Display the median time or an error message if the ping failed
        if (medianTime != -1) {
            System.out.printf("Median time to ping %s: %.2f ms %n", host, medianTime);
        } else {
            System.out.println("Ping failed or no response times were captured.");
        }
    }
}

