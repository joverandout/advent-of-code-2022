package days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Day5 {
    public static String[] getSolutions(String fileAsText) {
        ArrayList<Stack<Character>> environment = organiseInput(fileAsText);
        String result = "";
        for(Stack<Character> stack : environment) {
            result += stack.pop().toString();
        }
        System.out.println(result);
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

    // 2 6 10

    private static ArrayList<Stack<Character>> performMove(int number, int source, int destination, ArrayList<Stack<Character>> currentEnv){
        for (int i = 0; i < number; i++) {
            char ctm = currentEnv.get(source).pop();
            currentEnv.get(destination).push(ctm);
        }
        return currentEnv;
    }


}
