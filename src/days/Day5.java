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
            for(Stack<Character> stack : environment){
                System.out.println(stack.toString());
            }
            System.out.println("-------");
            environment = reverseStacks(environment);
            for(Stack<Character> stack : environment){
                System.out.println(stack.toString());
            }
            while (scanner.hasNext()){
                scanner.next();                      // read next and throw away
                int numToMove = scanner.nextInt();   // read nextInt -> number to move
                //System.out.println(numToMove);
                scanner.next();                      // read next and throw away
                int moveFrom = scanner.nextInt()-1;    // read nextInt -> move from
                //System.out.println(moveFrom);
                scanner.next();
                int moveTo = scanner.nextInt()-1;      // read nextInt -> move to
                //System.out.println(moveTo)

                environment = performMove(numToMove, moveFrom, moveTo, environment);
                System.out.println("++++++++++++++++++++++++++++++++++");
                System.out.println("move " + numToMove + " from " + moveFrom + " to " + moveTo);
                System.out.println();
                for(Stack<Character> stack : environment){
                    System.out.println(stack.toString());
                }
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
            System.out.println(a);
            newStack.push(a);
        }
        System.out.println(newStack);
        arr = newStack;
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
            System.out.println(ctm);
            currentEnv.get(destination).push(ctm);
        }
        return currentEnv;
    }


}
