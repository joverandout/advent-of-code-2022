package days;

import common.Day;
import common.util.KeyValue;
import common.util.Node;

import java.util.Scanner;


public class Day7 extends Day {

    @Override
    public Object[] getSolutions(String fileAsText) {
        char[] inputAsArray = fileAsText.toCharArray();

        KeyValue<String, Integer> root = new KeyValue<>("/", 0);
        Node<KeyValue<String, Integer>> rootNode = new Node<KeyValue<String, Integer>>(root);

        Node currentNode = rootNode;


        try{
            Scanner scanner = new Scanner(fileAsText);
            boolean currentCommandIsListAll = false, currentCommandIsCD = false;

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                String previousToken = "";

                while(lineScanner.hasNext()) {
                    String token = lineScanner.next();
                    if(token.equals("$")) {}
                    else if(token.equals("cd")){
                        currentCommandIsListAll = false;
                        currentCommandIsCD = true;
                    }
                    else if(token.equals("ls")){
                        currentCommandIsListAll = true;
                        currentCommandIsCD = false;
                    }
                    else if(currentCommandIsCD){
                        System.out.println(token);
                        if(token.equals("..")){
//                            System.out.println("Current node before - " + currentNode.getData().getKey());
                            currentNode = currentNode.getParent();
//                            System.out.println("Current node after - " + currentNode.getData().getKey());
                        }
                        else if(currentNode.getChild(token) != null){
//                            System.out.println("Current node before - " + currentNode.getData().getKey());
                            currentNode = currentNode.getChild(token);
//                            System.out.println("Current node after - " + currentNode.getData().getKey());
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

            addAllNodes(rootNode);
            CheckAllNodes(rootNode);

            return new Object[]{2, 3};

        } catch (Exception e){
            e.printStackTrace();
        }
        return new Object[]{22, 3};
    }

    private void addAllNodes(Node<KeyValue<String, Integer>> node){
        for (Node<KeyValue<String, Integer>> child : node.getChildren() ) {
            addAllNodes(child);
            child.AddChildren();
        }
    }

    private void CheckAllNodes(Node<KeyValue<String, Integer>> node){
        for (Node<KeyValue<String, Integer>> child : node.getChildren() ) {
            CheckAllNodes(child);
            if(child.getData().getValue() > 100000) System.out.println(child.getData().getKey());
        }
    }


}
