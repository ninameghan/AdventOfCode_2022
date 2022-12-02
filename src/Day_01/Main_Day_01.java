package Day_01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main_Day_01 {
    public static void main(String[] args) throws IOException {

        String file = Files.readString(Path.of("src/Day_01/Calories.txt"));

        List<Integer> elves = GetElvesFromFile(file);

        // Part 1
        System.out.println("AOC Day 01 Part 1: " + elves.get(0));

        // Part 2
        System.out.println("AOC Day 01 Part 2: " + GetTop3Total(elves));
    }

    public static List<Integer> GetElvesFromFile(String file) {
        return Arrays.stream(file.split("\\r\\n\\r\\n"))
                .map(s -> Arrays.stream(s.split("\\r\\n"))
                        .mapToInt(Integer::parseInt)
                        .sum())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static int GetTop3Total(List<Integer> elves) {
        return elves.get(0) + elves.get(1) + elves.get(2);
    }
}