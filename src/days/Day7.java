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
            boolean currentCommandIsListAll = false;
            int lineno = 0;

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                String previousToken = "";

                lineno++;

                while(lineScanner.hasNext()) {
                    String token = lineScanner.next();
                    if(token.equals("$")) {}
                    else if(token.equals("cd")){
                        currentCommandIsListAll = false;
                    }
                    else if(token.equals("ls")){
                        currentCommandIsListAll = true;
                    }
                    else if(previousToken.equals("cd")){
                        if(token.equals("..")){
                            currentNode = currentNode.getParent();
                        }
                        else if(currentNode.getChild(token) != null){
                            currentNode = currentNode.getChild(token);
                        }
                    }
                    else if(currentCommandIsListAll){
                        String name = lineScanner.next();
                        KeyValue<String, Integer> childNode;
                        if(token.equals("dir")){
                            childNode = new KeyValue<>(name, 0);
                        }
                        else{
                            childNode = new KeyValue<>(name, Integer.parseInt(token));
                        }

                        currentNode.addChild(childNode);
                    }
                }
            }

            return new Object[]{2, 3};

        } catch (Exception e){
            e.printStackTrace();
        }
        return new Object[]{22, 3};
    }

}
