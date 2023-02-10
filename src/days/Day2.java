package days;

import java.util.Scanner;

public class Day2 extends Day{

    public Day2() {}

    @Override
    public Object[] getSolutions(String fileAsText) {
        int total1 = 0, total2 = 0;
        try{
            Scanner scanner = new Scanner(fileAsText);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                total1 += getPart1Score(line);
                total2 += getPart2Score(line);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        Object[] solutions = new Object[2];
        solutions[0] = total1;
        solutions[1] = total2;
        return solutions;
    }

    public static int getPart1Score(String line) throws Exception {
        String[] round = line.split(" ");
        return getGameScore(round) + getYourScore(round);
    }

    public static int getPart2Score(String line) throws Exception {
        String[] round = line.split(" ");
        return getNewScore(round);
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

    public static int getNewScore(String[] round) throws Exception {
        if(round[1].equals("X")){
            if(round[0].equals("A")) return getPart1Score("A Z");
            if(round[0].equals("B")) return getPart1Score("B X");
            if(round[0].equals("C")) return getPart1Score("C Y");
        }
        else if(round[1].equals("Y")){
            if(round[0].equals("A")) return getPart1Score("A X");
            if(round[0].equals("B")) return getPart1Score("B Y");
            if(round[0].equals("C")) return getPart1Score("C Z");
        }
        else if(round[1].equals("Z")){
            if(round[0].equals("A")) return getPart1Score("A Y");
            if(round[0].equals("B")) return getPart1Score("B Z");
            if(round[0].equals("C")) return getPart1Score("C X");
        }
        throw new Exception("Received something other than A B or C. Received: " + round[0]);
    }
}
