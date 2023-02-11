package days;

import common.Day;

public class Day6 extends Day {

    @Override
    public Object[] getSolutions(String fileAsText) {
        char[] currentFourChars = new char[4];
        char[] inputAsArray = fileAsText.toCharArray();

        int partOne = getPosition(currentFourChars, inputAsArray);

        Object[] solutions = new Object[2];
        solutions[0] = partOne;
        solutions[1] = partOne;
        return solutions;
    }

    private boolean allFourCharsDiffer(char[] curr){
        return ((curr[0] != curr[1] && curr[0] != curr[2] && curr[0] != curr[3])
                && (curr[1] != curr[2] && curr[1] != curr[3]) && (curr[2] != curr[3]));
    }

    private int getPosition(char[] currentFourChars, char[] inputAsArray){
        int pastRemove = 0;
        for (int i = 0; i < inputAsArray.length; i++) {
            if (i < 4){
                currentFourChars[i] = inputAsArray[i];
                if(i == 4 && allFourCharsDiffer(currentFourChars)){
                    return i+1;
                }
            }
            else {
                currentFourChars[pastRemove] = inputAsArray[i];
                if(pastRemove < 3) pastRemove++;
                else pastRemove = 0;
                if(allFourCharsDiffer(currentFourChars)){
                    return i+1;
                }
            }
        }
        return inputAsArray.length;
    }

}
