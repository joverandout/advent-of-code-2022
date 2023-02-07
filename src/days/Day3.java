package days;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day3 {

    public static int[] getSolutions(String fileAsText) {
        int total1 = 0, total2 = 0;
        int count = 1;
        String string1 = "", string2 ="", string3 = "";
        try{
            Scanner scanner = new Scanner(fileAsText);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                total1 += getPriorityOfALine(line);
                if(count % 3 == 1) string1 = line;
                else if(count % 3 == 2) string2 = line;
                else if(count % 3 == 0){
                    string3 = line;
                    total2 += getPriorityOfTheBadges(string1, string2, string3);
                }
                count++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        int[] solutions = new int[2];
        solutions[0] = total1;
        solutions[1] = total2;
        return solutions;
    }

    public static int getPriorityOfALine(String line) throws Exception {
        String s1a = line.substring(0, (line.length()/2));
        String s1b = line.substring((line.length()/2));
        char common = commonChars(s1a, s1b);
        if(Character.isLowerCase(common)){
            int asciiVal = common;
            asciiVal -= 96;
            return asciiVal;
        }
        else if(Character.isUpperCase(common)){
            int asciiVal = common;
            asciiVal -= 38;
            return asciiVal;
        }
        throw new Exception("Character returned was netiher lower nor upper case");
    }

    public static int getPriorityOfTheBadges(String line1, String line2, String line3) throws Exception {
        char common = commonCharsPart2(line1, line2, line3);
        if(Character.isLowerCase(common)){
            int asciiVal = common;
            asciiVal -= 96;
            return asciiVal;
        }
        else if(Character.isUpperCase(common)){
            int asciiVal = common;
            asciiVal -= 38;
            return asciiVal;
        }
        throw new Exception("Character returned was netiher lower nor upper case");
    }

    public static char commonChars(String s1, String s2) throws Exception {
        for(Character c : s1.toCharArray()) {
            if(s2.indexOf(c) >= 0) {
                return c;
            }
        }
        throw new Exception("No common chars");
    }

    public static char commonCharsPart2(String s1, String s2, String s3) throws Exception {
        for(Character c : s1.toCharArray()) {
            if(s2.indexOf(c) >= 0 && s3.indexOf(c) >= 0) {
                return c;
            }
        }
        throw new Exception("No common chars");
    }

}
