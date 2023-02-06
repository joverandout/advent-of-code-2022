package days;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {
    public static int[] getSolutions(String fileAsText) {
        int total = 0;
        try{
            Scanner scanner = new Scanner(fileAsText);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                total += getIndividualScore(line);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        int[] solutions = new int[2];
        solutions[0] = total;
        solutions[1] = total;
        return solutions;
    }

    public static int getIndividualScore(String line) throws Exception {
        String[] round = line.split(" ");
        return getGameScore(round) + getYourScore(round);
    }

    public static int getYourScore(String[] round) throws Exception {
        if(round[1].equals("X")) return 1;
        if(round[1].equals("Y")) return 2;
        if(round[1].equals("Z")) return 3;
        throw new Exception("Received something other than X Y or Z");
    }
    public static int getGameScore(String[] round) throws Exception {
        if(round[0].equals("A")){
            if(round[1].equals("X")) return 3;
            if(round[1].equals("Y")) return 6;
            if(round[1].equals("Z")) return 0;
        }
        else if(round[0].equals("B")){
            if(round[1].equals("X")) return 0;
            else if(round[1].equals("Y")) return 3;
            else if(round[1].equals("Z")) return 6;
        }
        else if(round[0].equals("C")){
            if(round[1].equals("X")) return 6;
            else if(round[1].equals("Y")) return 0;
            else if(round[1].equals("Z")) return 3;
        }
        throw new Exception("Received something other than A B or C. Received: " + round[0]);
    }
}
