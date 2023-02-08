package days;

import java.util.Scanner;

public class Day4 {

    public static int[] getSolutions(String fileAsText) {
        int count = 0;
        try{
            Scanner scanner = new Scanner(fileAsText);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(part1Rule(line)) count++;
            }
            return new int[]{count};
        } catch (Exception e){
            e.printStackTrace();
        }
        return new int[]{0};
    }

    private static boolean part1Rule(String line){
        String[] ranges = line.split(",");
        int[] array1 = getRangeSplit(ranges[0]);
        int[] array2 = getRangeSplit(ranges[1]);

        if(array1[0] <= array2[0] && array1[1] >= array2[1]){
            return true;
        }
        if(array2[0] <= array1[0] && array2[1] >= array1[1]){
            return true;
        }
        return false;
    }

    private static int[] getRangeSplit (String range){
        String[] parts = range.split("-");
        return new int[] {Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
    }
}
