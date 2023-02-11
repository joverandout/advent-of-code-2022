import common.Day;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        for (int day = 1; day <= 6; day++) {
            System.out.println("==Day " + day + "==");
            Day instance = (Day) Class.forName("days.Day" + day).getDeclaredConstructor().newInstance();
            instance.PrintParts(readFile(day));
        }
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

