import days.Day1;
import days.*;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        int dayNumber = 2;

//        Day1 day1 = new Day1();
//        System.out.println(day1.getSolutions(readFile(1))[0]);
//        System.out.println(day1.getSolutions(readFile(1))[1]);

        Day2 day2 = new Day2();
        System.out.println(day2.getSolutions(readFile(dayNumber))[0]);
    }

    public static String readFile(int dayNumber){
        try {
            return Files.readString(Path.of("/Users/joemoore/IdeaProjects/AdventOfCode2022/src/inputs/Day"+ dayNumber+ ".txt"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}

