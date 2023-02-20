package days;

import common.Day;

import java.util.ArrayList;
import java.util.Scanner;

public class Day8 extends Day {

    @Override
    public Object[] getSolutions(String fileAsText) {

        char[][] forest = new char[99][];

        Scanner scanner = new Scanner(fileAsText);
        int i = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            char[] lineArr = line.toCharArray();
            forest[i] = lineArr;
            i++;
        }

        Object[] solutions = new Object[2];
        solutions[0] = partOne(forest);
        solutions[1] = partTwo(forest);
        return solutions;
    }

    private int partOne(char[][] forest) {
        int count = 0;
        for (int i = 0; i < forest.length; i++) {
            for (int j = 0; j < forest[i].length; j++) {
                if(i == 0 || j == 0 || i == forest.length-1 || j==forest[i].length-1){
                    count++;
                }
                else if(checkHorizontal(forest, i, j) || checkVertical(forest, i, j)){
                    count++;
                }
                else{
                }
            }
        }
        return count;
    }


    private int partTwo(char[][] forest) {
        int max = 0;
        for (int i = 0; i < forest.length; i++) {
            for (int j = 0; j < forest[i].length; j++) {
                if(getScenicScoreVertical(forest, i, j) * getScenicScoreHorizontal(forest, i, j) > max){
                    max = getScenicScoreVertical(forest, i, j) * getScenicScoreHorizontal(forest, i, j);
                }
            }
        }
        return max;
    }

    private boolean checkHorizontal(char[][] forest, int i, int j) {
        boolean leftOfIt = true, rightOfIt = true;
        for (int k = j+1; k < forest[i].length; k++) {
            if(forest[i][j] <= forest[i][k]){
                rightOfIt = false;
                break;
            }
        }
        for (int k = 0; k < j; k++) {
            if(forest[i][j] <= forest[i][k]){
                leftOfIt = false;
                break;
            }
        }
        return leftOfIt || rightOfIt;
    }

    private boolean checkVertical(char[][] forest, int i, int j) {
        boolean upOftIt = true, downOfIt = true;
        for (int k = i+1; k < forest.length; k++) {
            if(forest[i][j] <= forest[k][j]){
                downOfIt = false;
                break;
            }
        }
        for (int k = 0; k < i; k++) {
            if(forest[i][j] <= forest[k][j]){
                upOftIt = false;
                break;
            }
        }
        return upOftIt || downOfIt;
    }


    private int getScenicScoreVertical(char[][] forest, int i, int j) {
        int upOftIt = 0, downOfIt = 0;
        for (int k = i+1; k < forest.length; k++) {
            downOfIt++;
            if(forest[i][j] <= forest[k][j]){
                break;
            }
        }
        for (int k = 0; k < i; k++) {
            upOftIt++;
            if(forest[i][j] <= forest[k][j]){
                break;
            }
        }
        return downOfIt*upOftIt;
    }

    private int getScenicScoreHorizontal(char[][] forest, int i, int j) {
        int rightOfIt = 0, leftOfIt = 0;
        for (int k = j+1; k < forest[i].length; k++) {
            rightOfIt++;
            if(forest[i][j] <= forest[i][k]){
                break;
            }
        }
        for (int k = 0; k < j; k++) {
            leftOfIt++;
            if(forest[i][j] <= forest[i][k]){
                break;
            }
        }
        return leftOfIt*rightOfIt;
    }

}
