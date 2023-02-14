package days;

import common.Day;
import common.util.KeyValue;
import common.util.Node;

import java.util.ArrayList;
import java.util.Scanner;


public class Day7 extends Day {

    @Override
    public Object[] getSolutions(String fileAsText) {
        char[] inputAsArray = fileAsText.toCharArray();

        KeyValue<String, Integer> root = new KeyValue<>("/", 0);
        Node<KeyValue> rootNode = new Node<KeyValue>(root);

        Node currentNode = rootNode;


        try{
            Scanner scanner = new Scanner(fileAsText);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                boolean currentCommandIsListAll = false;
                String previousToken = "";
                int lineno = 0;
                while(lineScanner.hasNext()) {
                    String token = lineScanner.next();
//                    System.out.println(token);
                    if(token.equals("$")) {}
                    else if(token.equals("cd")){
                        currentCommandIsListAll = false;
                    }
                    else if(token.equals("ls")){
                        System.out.print("HEOHRJN");
                        currentCommandIsListAll = true;
                    }
                    else if(previousToken.equals("cd")){
                        if(token.equals("..")){
//                            currentNode = currentNode.getParent();
                        }
                        else if(currentNode.getChild(token) != null){
//                            currentNode = currentNode.getChild(token);
                        }
                    }
                    else if(currentCommandIsListAll){
                        KeyValue<String, Integer> ChildTest = new KeyValue<>(lineScanner.next(), Integer.parseInt(token));
                        System.out.println("key: " + token);
                        System.out.println("val: " + lineScanner.next());

                    }

                    previousToken = token;

                }
            }

            return new Object[]{2, 3};

        } catch (Exception e){
            e.printStackTrace();
        }
        return new Object[]{22, 3};
    }

}
