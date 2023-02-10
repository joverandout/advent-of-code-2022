package days;

import java.util.*;

public class Day1 extends Day{

    public Day1() {}

    @Override
    public Object[] getSolutions(String fileAsText){
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

        Object[] solutions = new Object[2];
        solutions[0] = part1(calories);
        solutions[1] = part2(calories);
        return solutions;
    }

    public static int part1(List<Integer> addedCalories){
        return Collections.max(addedCalories);
    }
    public static int part2(List<Integer> addedCalories){
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            int max = Collections.max(addedCalories);
            addedCalories.remove(addedCalories.indexOf(max));
            sum += max;
        }
        return sum;
    }
}
