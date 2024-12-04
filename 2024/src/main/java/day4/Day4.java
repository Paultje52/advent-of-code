package day4;

import adventofcode_2024.Util;

import java.util.Arrays;

public class Day4 {

    public Day4() {
        System.out.println();

        findXmasInWordSearch();
        readMasInAnX();
    }

    /**
     * Find the word "XMAS" in a word search
     * The most ugly code so far, but it works...
     */
    private void findXmasInWordSearch() {
        String[][] linesAndColumns = readInput();
        if (linesAndColumns == null) return;

        // We have to count how many times the word "XMAS" appears. This can be in any direction
        int count = 0;

        for (int line = 0; line < linesAndColumns.length; line++) {
            for (int column = 0; column < linesAndColumns[line].length; column++) {
                // To start the search, we need to find the first letter of the word "XMAS"
                if (!linesAndColumns[line][column].equalsIgnoreCase("X")) continue;

                // Now, we can check in every direction
                // Vertical directions
                if (checkXmasUp(linesAndColumns, line, column)) count++;
                if (checkXmasDown(linesAndColumns, line, column)) count++;

                // Horizontal directions
                if (checkXmasLeft(linesAndColumns, line, column)) count++;
                if (checkXmasRight(linesAndColumns, line, column)) count++;

                // Diagonal directions
                if (checkXMasUpLeft(linesAndColumns, line, column)) count++;
                if (checkXMasUpRight(linesAndColumns, line, column)) count++;
                if (checkXMasDownLeft(linesAndColumns, line, column)) count++;
                if (checkXMasDownRight(linesAndColumns, line, column)) count++;
            }
        }

        System.out.println("Day 4: The word XMAS appears " + count + " times in the word search");
    }

    /**
     * Read the input from the file
     * @return The word search as a 2D matrix
     */
    private String[][] readInput() {
        String input;

        try {
            input = Util.readFile("src/main/java/day4/input.txt");
        } catch (Exception e) {
            System.out.println("Error reading file: " + e);
            return null;
        }

        // Split the input into lines and columns
        String[] lines = input.split("\n");
        return Arrays.stream(lines).map(line -> line.split("")).toArray(String[][]::new);
    }

    /**
     * Check if the word "XMAS" is in the up direction
     * @param linesAndColumns The word search
     * @param line The line where the first letter of the word "XMAS" is
     * @param column The column where the first letter of the word "XMAS" is
     * @return True if the word "XMAS" is in the up direction, false otherwise
     */
    private boolean checkXmasUp(String[][] linesAndColumns, int line, int column) {
        // To go up, we need to be at least in the fourth line
        if (line < 3) return false;

        // Check if the word "XMAS" is in the up direction
        return linesAndColumns[line - 1][column].equalsIgnoreCase("M") &&
                linesAndColumns[line - 2][column].equalsIgnoreCase("A") &&
                linesAndColumns[line - 3][column].equalsIgnoreCase("S");
    }

    /**
     * Check if the word "XMAS" is in the down direction
     * @param linesAndColumns The word search
     * @param line The line where the first letter of the word "XMAS" is
     * @param column The column where the first letter of the word "XMAS" is
     * @return True if the word "XMAS" is in the down direction, false otherwise
     */
    private boolean checkXmasDown(String[][] linesAndColumns, int line, int column) {
        // To go down, we need to be at least in the fourth line
        if (line > linesAndColumns.length - 4) return false;

        // Check if the word "XMAS" is in the down direction
        return linesAndColumns[line + 1][column].equalsIgnoreCase("M") &&
                linesAndColumns[line + 2][column].equalsIgnoreCase("A") &&
                linesAndColumns[line + 3][column].equalsIgnoreCase("S");
    }

    /**
     * Check if the word "XMAS" is in the left direction
     * @param linesAndColumns The word search
     * @param line The line where the first letter of the word "XMAS" is
     * @param column The column where the first letter of the word "XMAS" is
     * @return True if the word "XMAS" is in the left direction, false otherwise
     */
    private boolean checkXmasLeft(String[][] linesAndColumns, int line, int column) {
        // To go left, we need to be at least in the fourth column
        if (column < 3) return false;

        // Check if the word "XMAS" is in the left direction
        return linesAndColumns[line][column - 1].equalsIgnoreCase("M") &&
                linesAndColumns[line][column - 2].equalsIgnoreCase("A") &&
                linesAndColumns[line][column - 3].equalsIgnoreCase("S");
    }

    /**
     * Check if the word "XMAS" is in the right direction
     * @param linesAndColumns The word search
     * @param line The line where the first letter of the word "XMAS" is
     * @param column The column where the first letter of the word "XMAS" is
     * @return True if the word "XMAS" is in the right direction, false otherwise
     */
    private boolean checkXmasRight(String[][] linesAndColumns, int line, int column) {
        // To go right, we need to be at least in the fourth column
        if (column > linesAndColumns[line].length - 4) return false;

        // Check if the word "XMAS" is
        return linesAndColumns[line][column + 1].equalsIgnoreCase("M") &&
                linesAndColumns[line][column + 2].equalsIgnoreCase("A") &&
                linesAndColumns[line][column + 3].equalsIgnoreCase("S");
    }

    /**
     * Check if the word "XMAS" is in the up left direction
     * @param linesAndColumns The word search
     * @param line The line where the first letter of the word "XMAS" is
     * @param column The column where the first letter of the word "XMAS" is
     * @return True if the word "XMAS" is in the up left direction, false otherwise
     */
    private boolean checkXMasUpLeft(String[][] linesAndColumns, int line, int column) {
        // To go up left, we need to be at least in the fourth line and fourth column
        if (line < 3 || column < 3) return false;

        // Check if the word "XMAS" is in the up left direction
        return linesAndColumns[line - 1][column - 1].equalsIgnoreCase("M") &&
                linesAndColumns[line - 2][column - 2].equalsIgnoreCase("A") &&
                linesAndColumns[line - 3][column - 3].equalsIgnoreCase("S");
    }

    /**
     * Check if the word "XMAS" is in the up right direction
     * @param linesAndColumns The word search
     * @param line The line where the first letter of the word "XMAS" is
     * @param column The column where the first letter of the word "XMAS" is
     * @return True if the word "XMAS" is in the up right direction, false otherwise
     */
    private boolean checkXMasUpRight(String[][] linesAndColumns, int line, int column) {
        // To go up right, we need to be at least in the fourth line and fourth column
        if (line < 3 || column > linesAndColumns[line].length - 4) return false;

        // Check if the word "XMAS" is in the up right direction
        return linesAndColumns[line - 1][column + 1].equalsIgnoreCase("M") &&
                linesAndColumns[line - 2][column + 2].equalsIgnoreCase("A") &&
                linesAndColumns[line - 3][column + 3].equalsIgnoreCase("S");
    }

    /**
     * Check if the word "XMAS" is in the down left direction
     * @param linesAndColumns The word search
     * @param line The line where the first letter of the word "XMAS" is
     * @param column The column where the first letter of the word "XMAS" is
     * @return True if the word "XMAS" is in the down left direction, false otherwise
     */
    private boolean checkXMasDownLeft(String[][] linesAndColumns, int line, int column) {
        // To go down left, we need to be at least in the fourth line and fourth column
        if (line > linesAndColumns.length - 4 || column < 3) return false;

        // Check if the word "XMAS" is in the down left direction
        return linesAndColumns[line + 1][column - 1].equalsIgnoreCase("M") &&
                linesAndColumns[line + 2][column - 2].equalsIgnoreCase("A") &&
                linesAndColumns[line + 3][column - 3].equalsIgnoreCase("S");
    }

    /**
     * Check if the word "XMAS" is in the down right direction
     * @param linesAndColumns The word search
     * @param line The line where the first letter of the word "XMAS" is
     * @param column The column where the first letter of the word "XMAS" is
     * @return True if the word "XMAS" is in the down right direction, false otherwise
     */
    private boolean checkXMasDownRight(String[][] linesAndColumns, int line, int column) {
        // To go down right, we need to be at least in the fourth line and fourth column
        if (line > linesAndColumns.length - 4 || column > linesAndColumns[line].length - 4) return false;

        // Check if the word "XMAS" is in the down right direction
        return linesAndColumns[line + 1][column + 1].equalsIgnoreCase("M") &&
                linesAndColumns[line + 2][column + 2].equalsIgnoreCase("A") &&
                linesAndColumns[line + 3][column + 3].equalsIgnoreCase("S");
    }

    /**
     * Read "MAS" in an x
     */
    private void readMasInAnX() {
        String[][] linesAndColumns = readInput();
        if (linesAndColumns == null) return;

        // We have to count how many times the word "MAS" appears in an X. This can be in any direction
        int count = 0;

        for (int line = 0; line < linesAndColumns.length; line++) {
            for (int column = 0; column < linesAndColumns[line].length; column++) {
                // To start the search, we need to find the second letter "A". If we found it, we can look up left, up right, down left and down right
                if (!linesAndColumns[line][column].equalsIgnoreCase("A")) continue;

                if (
                        // First, up left to down right
                        checkMasUpLeftDownRight(linesAndColumns, line, column) &&
                        // Second, up right to down left
                        checkMasUpRightDownLeft(linesAndColumns, line, column)
                ) {
                    count++;
                }
            }
        }

        System.out.println("Day 4: The word MAS appears " + count + " times in an X");
    }

    /**
     * Check if the word "MAS" is in the up right and down left direction
     * @param linesAndColumns The word search
     * @param line The line where the second letter of the word "MAS" is
     * @param column The column where the second letter of the word "MAS" is
     * @return True if the word "MAS" is in the up right and down left direction, false otherwise
     */
    private boolean checkMasUpLeftDownRight(String[][] linesAndColumns, int line, int column) {
        // To go up left, we need to be at least in the second line and second column
        if (line < 1 || column < 1) return false;

        // To go down right, we need to be at least in the second last line and second last column
        if (line > linesAndColumns.length - 2 || column > linesAndColumns[line].length - 2) return false;

        // First option: M in top left and S in bottom right
        if (linesAndColumns[line - 1][column - 1].equalsIgnoreCase("M") &&
                linesAndColumns[line + 1][column + 1].equalsIgnoreCase("S")
        ) return true;

        // Second option: S in top left and M in bottom right
        return linesAndColumns[line - 1][column - 1].equalsIgnoreCase("S") &&
                linesAndColumns[line + 1][column + 1].equalsIgnoreCase("M");
    }

    /**
     * Check if the word "MAS" is in the up right and down left direction
     * @param linesAndColumns The word search
     * @param line The line where the second letter of the word "MAS" is
     * @param column The column where the second letter of the word "MAS" is
     * @return True if the word "MAS" is in the up right and down left direction, false otherwise
     */
    private boolean checkMasUpRightDownLeft(String[][] linesAndColumns, int line, int column) {
        // To go up right, we need to be at least in the second line and second last column
        if (line < 1 || column > linesAndColumns[line].length - 2) return false;

        // To go down left, we need to be at least in the second last line and second column
        if (line > linesAndColumns.length - 2 || column < 1) return false;

        // First option: M in top right and S in bottom left
        if (linesAndColumns[line - 1][column + 1].equalsIgnoreCase("M") &&
                linesAndColumns[line + 1][column - 1].equalsIgnoreCase("S")
        ) return true;

        // Second option: S in top right and M in bottom left
        return linesAndColumns[line - 1][column + 1].equalsIgnoreCase("S") &&
                linesAndColumns[line + 1][column - 1].equalsIgnoreCase("M");
    }

}
