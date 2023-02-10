package days;

import common.Day;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Day5 extends Day {
    public Day5() {}

    @Override
    public Object[] getSolutions(String fileAsText) {
        ArrayList<Stack<Character>>[] environment = organiseInput(fileAsText);
        String partOne = "", partTwo = "";
        for(Stack<Character> stack : environment[0]) {
            partOne += stack.pop().toString();
        }
        for(Stack<Character> stack : environment[1]) {
            partTwo += stack.pop().toString();
        }
        return new String[]{partOne, partTwo};
    }

    public static ArrayList<Stack<Character>>[] organiseInput(String fileAsText) {
        ArrayList<Stack<Character>> environmentPart1 = new ArrayList<>();
        ArrayList<Stack<Character>> environmentPart2 = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            environmentPart1.add(new Stack<>());
            environmentPart2.add(new Stack<>());
        }

        boolean makeEnvironment = true;
        try{
            Scanner scanner = new Scanner(fileAsText);
            while (scanner.hasNextLine() && makeEnvironment) {
                String line = scanner.nextLine();
                if(line.equals("") || line.toCharArray()[1] == '1') break;
                else if(makeEnvironment){
                    environmentPart1 = tokeniseOneLine(line.toCharArray(), environmentPart1);
                    environmentPart2 = tokeniseOneLine(line.toCharArray(), environmentPart2);
                }
            }

            environmentPart1 = reverseStacks(environmentPart1);
            environmentPart2 = reverseStacks(environmentPart2);

            while (scanner.hasNext()){
                scanner.next();
                int numToMove = scanner.nextInt();
                scanner.next();
                int moveFrom = scanner.nextInt()-1;
                scanner.next();
                int moveTo = scanner.nextInt()-1;

                environmentPart1 = performMovePart1(numToMove, moveFrom, moveTo, environmentPart1);
                environmentPart2 = performMovePart2(numToMove, moveFrom, moveTo, environmentPart2);
            }
            return new ArrayList[]{environmentPart1, environmentPart2};

        } catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList[]{environmentPart1, environmentPart2};
    }

    private static ArrayList<Stack<Character>> reverseStacks(ArrayList<Stack<Character>> currentEnv) {
        ArrayList<Stack<Character>> reversedEnvironment = new ArrayList<>();
        for (Stack<Character> stack : currentEnv) {
            reversedEnvironment.add(reverse(stack));
        }
        return reversedEnvironment;
    }

    public static Stack<Character> reverse(Stack<Character> arr){
        Stack<Character> newStack = new Stack<>();
        while(!arr.empty()){
            char a = arr.pop();
            newStack.push(a);
        }
        return newStack;
    }

    private static ArrayList<Stack<Character>> tokeniseOneLine(char[] line, ArrayList<Stack<Character>> currentEnv) {
        for (int i = 0; i < ((line.length+1)/4); i++) {
            if (line[(i * 4) + 1] != ' ') {
                currentEnv.get(i).push(line[(i * 4) + 1]);
            }
        }
        return currentEnv;
    }

    private static ArrayList<Stack<Character>> performMovePart1(int number, int source, int destination,
                                                                            ArrayList<Stack<Character>> currentEnv){
        for (int i = 0; i < number; i++) {
            char ctm = currentEnv.get(source).pop();
            currentEnv.get(destination).push(ctm);
        }
        return currentEnv;
    }

    private static ArrayList<Stack<Character>> performMovePart2(int number, int source, int destination,
                                                                            ArrayList<Stack<Character>> currentEnv){
        Stack<Character> tempStack = new Stack<>();
        for (int i = 0; i < number; i++) {
            char ctm = currentEnv.get(source).pop();
            tempStack.push(ctm);
        }
        for (int i = 0; i < number; i++) {
            char ctm = tempStack.pop();
            currentEnv.get(destination).push(ctm);
        }
        return currentEnv;
    }

}
