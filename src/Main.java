import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Day1 day1 = new Day1();
        System.out.println(day1.part1(readFile(1)));
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

