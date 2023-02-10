package days;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
 * I CAN CODE BETTER THAN THIS - THIS IS REALLY POOR
 * Actually feel shameful that this is my solution
 * Had to reverse the stacks because I cocked up
 * Let's hope day 6 is better
 */

public class Day5 extends Day{
    public Day5() {
        super(5);
    }

    @Override
    public Object[] getSolutions(String fileAsText) {
        ArrayList<Stack<Character>> environment = organiseInput(fileAsText);
        String result = "";
        for(Stack<Character> stack : environment) {
            result += stack.pop().toString();
        }
        return new String[]{result};
    }

    public static ArrayList<Stack<Character>> organiseInput(String fileAsText) {
        ArrayList<Stack<Character>> environment = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            environment.add(new Stack<>());
        }

        boolean makeEnvironment = true;
        try{
            Scanner scanner = new Scanner(fileAsText);
            while (scanner.hasNextLine() && makeEnvironment) {
                String line = scanner.nextLine();
                if(line.equals("") || line.toCharArray()[1] == '1') break;
                else if(makeEnvironment){
                    environment = tokeniseOneLine(line.toCharArray(), environment);
                }
            }

            // I had to fucking reverse the stacks because I had done it wrong - really poor from me.
            // A botch of a botch
            environment = reverseStacks(environment);

            while (scanner.hasNext()){
                scanner.next();
                int numToMove = scanner.nextInt();
                scanner.next();
                int moveFrom = scanner.nextInt()-1;
                scanner.next();
                int moveTo = scanner.nextInt()-1;

                environment = performMove(numToMove, moveFrom, moveTo, environment);
            }
            return environment;

        } catch (Exception e){
            e.printStackTrace();
        }
        return environment;
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

    private static ArrayList<Stack<Character>> performMove(int number, int source, int destination, ArrayList<Stack<Character>> currentEnv){
        // Absolute garbage way of doing it
        for (int i = 0; i < number; i++) {
            char ctm = currentEnv.get(source).pop();
            currentEnv.get(destination).push(ctm);
        }
        return currentEnv;
    }


}
