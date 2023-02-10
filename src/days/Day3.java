package days;

import java.util.Scanner;

public class Day3 extends Day{
    public Day3() {}

    @Override
    public Object[] getSolutions(String fileAsText) {
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

        Object[] solutions = new Object[2];
        solutions[0] = total1;
        solutions[1] = total2;
        return solutions;
    }

    private static int getPriorityOfALine(String line) throws Exception {
        String s1a = line.substring(0, (line.length()/2));
        String s1b = line.substring((line.length()/2));
        return convertCharToPriority(commonChars(s1a, s1b));
    }

    private static int getPriorityOfTheBadges(String line1, String line2, String line3) throws Exception {
        return convertCharToPriority(commonCharsPart2(line1, line2, line3));
    }

    private static char commonChars(String s1, String s2) throws Exception {
        for(Character c : s1.toCharArray()) {
            if(s2.indexOf(c) >= 0) {
                return c;
            }
        }
        throw new Exception("No common chars");
    }

    private static char commonCharsPart2(String s1, String s2, String s3) throws Exception {
        for(Character c : s1.toCharArray()) {
            if(s2.indexOf(c) >= 0 && s3.indexOf(c) >= 0) {
                return c;
            }
        }
        throw new Exception("No common chars");
    }

    private static int convertCharToPriority(char common) throws Exception {
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

}
