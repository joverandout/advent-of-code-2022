package days;

import java.util.*;


public class Day1 {
    public static int part1(String fileAsText){
        List<Integer> calories = new ArrayList<Integer>();

        try{
            Scanner scanner = new Scanner(fileAsText);
            int currentCalories = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(!(line.equals(""))){
                    currentCalories += Integer.parseInt(line);
                }
                else{
                    calories.add(currentCalories);
                    currentCalories = 0;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return Collections.max(calories);
    }
}
