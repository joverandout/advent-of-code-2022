package days;

import common.Day;

import java.util.HashSet;

public class Day6 extends Day {

    @Override
    public Object[] getSolutions(String fileAsText) {
        char[] inputAsArray = fileAsText.toCharArray();

        int partOne = getPosition(inputAsArray, 4);
        int partTwo = getPosition(inputAsArray, 14);

        Object[] solutions = new Object[2];
        solutions[0] = partOne;
        solutions[1] = partTwo;
        return solutions;
    }

    private boolean allFourCharsDiffer(char[] curr){
        var valueList = new HashSet<Character>();
        for (var v : curr)
        {
           if (valueList.contains(v)) return false;
           else valueList.add(v);
        }
        return true;
    }

    private int getPosition(char[] inputAsArray, int lengthVal){
        char[] currentFourChars = new char[lengthVal];
        int pastRemove = 0;
        for (int i = 0; i < inputAsArray.length; i++) {
            if (i < lengthVal){
                currentFourChars[i] = inputAsArray[i];
                if(i == lengthVal && allFourCharsDiffer(currentFourChars)){
                    return i+1;
                }
            }
            else {
                currentFourChars[pastRemove] = inputAsArray[i];
                if(pastRemove < lengthVal-1) pastRemove++;
                else pastRemove = 0;
                if(allFourCharsDiffer(currentFourChars)){
                    return i+1;
                }
            }
        }
        return inputAsArray.length;
    }
}
