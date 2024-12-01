package day1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    /**
     * <a href="https://adventofcode.com/2024/day/1">Day 1</a>
     */
    public Day1() {
        distance();
        similarity();
    }

    /**
     * Part one of the challenge: calculate the distance between the two location IDs
     */
    private void distance() {
        int[][] input;

        try {
            input = readInputForDistance();
        } catch (Exception e) {
            System.out.println("Could not read the input file");
            return;
        }

        // Define the distance
        int distance = 0;

        // Go through all the entries in the first row
        for (int i = 0; i < input[0].length; i++) {
            // We have to get the lowest number from both rows.
            // Then we have to calculate the distance between the two numbers
            // We already sorted both rows from low to high, so we can just take the first number
            int numOne = input[0][i];
            int numTwo = input[1][i];

            // Add the distance between the two numbers to the total distance
            distance += Math.abs(numOne - numTwo);
        }

        // Print the result
        System.out.println("Day 1: The distance is: " + distance);
    }

    /**
     * Read the input from the file to calculate the result
     * This automatically sorts the two rows from low to high
     * @return The result of the calculation
     * @throws Exception If the input could not be read
     */
    private int[][] readInputForDistance() throws Exception {
        // First, read the input.txt file
        String input = readFile("src/main/java/day1/input.txt");

        // Define the rows
        List<Integer> rowOne = new ArrayList<>();
        List<Integer> rowTwo = new ArrayList<>();

        // Go through each line to read the two rows
        for (String line : input.split("\n")) {
            String[] parts = line.split(" {3}"); // Each row is separated by 3 spaces

            int numOne = Integer.parseInt(parts[0]);
            addToListInOrder(rowOne, numOne);

            int numTwo = Integer.parseInt(parts[1]);
            addToListInOrder(rowTwo, numTwo);
        }

        // Return the rows as a 2D array
        return new int[][] {
                rowOne.stream().mapToInt(i -> i).toArray(),
                rowTwo.stream().mapToInt(i -> i).toArray()
        };
    }

    /**
     * Add the number to the list in order
     * @param list The list to add the number to
     * @param num The number to add
     */
    private void addToListInOrder(List<Integer> list, int num) {
        for (int i = 0; i < list.size(); i++) {
            // For each number in the list, check if the number is bigger
            // If so, add the number at that index
            if (list.get(i) > num) {
                list.add(i, num);
                return;
            }
        }
        // If the number is bigger than all the numbers in the list, add it at the end
        list.add(num);
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
     * Part two of the challenge: calculate the similarity between the two location IDs
     */
    private void similarity() {
        int[][] input;

        try {
            input = readInputForSimilarity();
        } catch (Exception e) {
            System.out.println("Could not read the input file");
            return;
        }

        // Define the similarity
        int similarity = 0;

        // Go through all the entries in the first row
        for (int i = 0; i < input[0].length; i++) {
            int numberOne = input[0][i];
            int appearances = 0;

            // Go through all the entries in the second row and check if the number is the same
            for (int j = 0; j < input[1].length; j++) {
                int numberTwo = input[1][j];
                if (numberOne == numberTwo) appearances++;
            }

            // Add to the similarity score
            similarity += numberOne * appearances;
        }

        // Print the result
        System.out.println("Day 1: The similarity score is: " + similarity);
    }

    /**
     * Read the input from the file to calculate the result
     * @return The result of the calculation
     * @throws Exception If the input could not be read
     */
    private int[][] readInputForSimilarity() throws Exception {
        // First, read the input.txt file
        String input = readFile("src/main/java/day1/input.txt");

        // Define the rows
        List<Integer> rowOne = new ArrayList<>();
        List<Integer> rowTwo = new ArrayList<>();

        // Go through each line to read the two rows
        for (String line : input.split("\n")) {
            String[] parts = line.split(" {3}"); // Each row is separated by 3 spaces

            int numOne = Integer.parseInt(parts[0]);
            rowOne.add(numOne);

            int numTwo = Integer.parseInt(parts[1]);
            rowTwo.add(numTwo);
        }

        // Return the rows as a 2D array
        return new int[][] {
                rowOne.stream().mapToInt(i -> i).toArray(),
                rowTwo.stream().mapToInt(i -> i).toArray()
        };
    }

}
