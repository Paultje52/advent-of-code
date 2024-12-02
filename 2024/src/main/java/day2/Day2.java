package day2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day2 {

    /**
     * <a href="https://adventofcode.com/2024/day/2">Day 2</a>
     */
    public Day2() {
        System.out.println();

        checkSaveReports();
        checkSafeReportsWithProblemDampener();
    }

    /**
     * Part one of the challenge: Check how many reports are safe
     */
    private void checkSaveReports() {
        int[][] reports;

        try {
            reports = readInputForCheckSaveReports();
        } catch (Exception e) {
            System.out.println("Could not read the input file");
            return;
        }

        // Check how many reports are safe
        int safeReports = 0;
        for (int[] report : reports) {
            // Check if the report is safe
            if (isSafe(report)) {
                safeReports++;
            }
        }

        // Print the result
        System.out.println("Day 2: The number of safe reports is: " + safeReports);
    }

    /**
     * Read the input from the file
     * @return The reports
     * @throws Exception If the input could not be read
     */
    private int[][] readInputForCheckSaveReports() throws Exception {
        // Read & split the file
        String input = readFile("src/main/java/day2/input.txt");
        String[] lines = input.split("\n");

        List<int[]> reports = new ArrayList<>();

        // Go through each line to read the row
        for (String line : lines) {
            String[] report = line.split(" "); // Each level is separated by a space

            // Convert to int array
            int[] reportInt = new int[report.length];
            for (int i = 0; i < report.length; i++) {
                reportInt[i] = Integer.parseInt(report[i]);
            }

            // Add the report to the list
            reports.add(reportInt);
        }

        return reports.toArray(new int[0][0]);
    }

    /**
     * Read the file from the given path
     * @param filePath The path to the file
     * @return The content of the file
     * @throws Exception If the file could not be read
     */
    public static String readFile(String filePath) throws Exception {
        return Files.readString(Path.of(filePath));
    }

    /**
     * Check if the report is safe
     * A report is safe when the distance between two levels is at most 3 and the levels are either all increasing or all decreasing
     * @param report The report to check
     * @return True if the report is safe, false otherwise
     */
    private boolean isSafe(int[] report) {
        List<Integer> differences = new ArrayList<>();

        for (int i = 1; i < report.length; i++) {
            int difference = report[i] - report[i - 1];
            differences.add(difference);
        }

        boolean increasing = differences.stream().allMatch(difference -> difference > 0 && difference <= 3);
        boolean decreasing = differences.stream().allMatch(difference -> difference < 0 && difference >= -3);

        return increasing || decreasing;
    }

    /**
     * Part two of the challenge: Check how many reports are safe with the Problem Dampener
     */
    private void checkSafeReportsWithProblemDampener() {
        int[][] reports;

        try {
            reports = readInputForCheckSaveReports();
        } catch (Exception e) {
            System.out.println("Could not read the input file");
            return;
        }

        // Check how many reports are safe
        int safeReports = 0;
        for (int[] report : reports) {
            // Check if the report is safe
            if (isSafeWithProblemDampener(report)) {
                safeReports++;
            }
        }

        // Print the result
        System.out.println("Day 2: The number of safe reports with Problem Dampener is: " + safeReports);
    }

    /**
     * Check if the report is safe (with the Problem Dampener)
     * A report is safe when the distance between two levels is at most 3 and the levels are either all increasing or all decreasing
     * The problem dampener allows one level to be bad
     * @param report The report to check
     * @return True if the report is safe, false otherwise
     */
    private boolean isSafeWithProblemDampener(int[] report) {
        if (isSafe(report)) return true;

        // Go through each level and remove it one by one to check if the report is safe
        for (int i = 0; i < report.length; i++) {
            int[] reportWithoutLevel = createArrayWithoutElement(report, i);
            if (isSafe(reportWithoutLevel)) return true;
        }

        return false;
    }

    /**
     * Create an array without the element at the given index
     * @param array The array to remove the element from
     * @param index The index of the element to remove
     * @return The array without the element
     */
    private int[] createArrayWithoutElement(int[] array, int index) {
        int[] newArray = new int[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        return newArray;
    }

}
