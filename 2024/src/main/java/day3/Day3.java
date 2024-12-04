package day3;

import adventofcode_2024.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {

    public Day3() {
        System.out.println();

        multiplyWithCorruption();
        multiplyWithConditionals();
    }

    /**
     * Part one of the challenge: multiply and ignore the corruption
     */
    private void multiplyWithCorruption() {
        String input;

        try {
            input = Util.readFile("src/main/java/day3/input.txt");
        } catch (Exception e) {
            System.out.println("Error reading file: " + e);
            return;
        }

        // Get all the multiplications from the input
        String[] multiplications = getValidInstructions(input, "mul\\([0-9]{1,3},[0-9]{1,3}\\)");

        // Calculate the result
        int result = 0;
        for (String multiplication : multiplications) {
            result += executeMultiplyInstruction(multiplication);
        }

        System.out.println("The result of the multiplications is: " + result);
    }

    /**
     * Get the valid instructions from the input using a regex
     * @param input The input string
     * @param regex The regex to match the instructions
     * @return The valid instructions
     */
    private String[] getValidInstructions(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> matches = new ArrayList<>();

        while (matcher.find()) {
            matches.add(matcher.group());
        }

        return matches.toArray(new String[0]);
    }

    /**
     * Execute the multiplication instruction
     * @param instruction The instruction (For example "mul(2,3)")
     * @return The result of the multiplication
     */
    private int executeMultiplyInstruction(String instruction) {
        String[] parts = instruction.split(",");
        int x = Integer.parseInt(parts[0].split("\\(")[1]);
        int y = Integer.parseInt(parts[1].split("\\)")[0]);

        return x * y;
    }

    /**
     * Part two of the challenge: multiply with conditionals
     */
    private void multiplyWithConditionals() {
        String input;

        try {
            input = Util.readFile("src/main/java/day3/input.txt");
        } catch (Exception e) {
            System.out.println("Error reading file: " + e);
            return;
        }

        // Get all the instructions from the input
        String[] instructions = getValidInstructions(input, "mul\\([0-9]{1,3},[0-9]{1,3}\\)|don't\\(\\)|do\\(\\)");

        // Calculate the result
        int result = 0;
        boolean doMultiply = true;

        for (String instruction : instructions) {
            if (instruction.equals("don't()")) {
                doMultiply = false;
            } else if (instruction.equals("do()")) {
                doMultiply = true;
            } else if (doMultiply) {
                result += executeMultiplyInstruction(instruction);
            }
        }

        System.out.println("The result of the multiplications with conditionals is: " + result);
    }
}
