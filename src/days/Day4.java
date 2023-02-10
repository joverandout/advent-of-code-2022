package days;

import java.util.Scanner;

public class Day4 extends Day{
    public Day4() {}

    @Override
    public Object[] getSolutions(String fileAsText) {
        int[] count = {0,0};
        try{
            Scanner scanner = new Scanner(fileAsText);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(part1Rule(line)) count[0]++;
                if(part2Rule(line)) count[1]++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return new Object[]{count[0], count[1]};
    }

    private static boolean part1Rule(String line){
        int[][] arrays = lineToIntArray(line);
        int[] array1 = arrays[0];
        int[] array2 = arrays[1];

        if(array1[0] <= array2[0] && array1[1] >= array2[1]){
            return true;
        }
        if(array2[0] <= array1[0] && array2[1] >= array1[1]){
            return true;
        }
        return false;
    }

    private static int[][] lineToIntArray(String line){
        String[] ranges = line.split(",");
        return new int[][]{getRangeSplit(ranges[0]), getRangeSplit(ranges[1])};
    }

    private static boolean part2Rule(String line){
        int[][] arrays = lineToIntArray(line);
        int[] array1 = arrays[0];
        int[] array2 = arrays[1];

        if(array1[1] >= array2[0] && array1[0] <= array2[0]){
            return true;
        }
        if(array2[1] >= array1[0] && array2[0] <= array1[0]){
            return true;
        }
        return false;
    }

    private static int[] getRangeSplit (String range){
        String[] parts = range.split("-");
        return new int[] {Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
    }
}
