package days;

import common.Day;
import common.util.KeyValue;
import common.util.Node;

import java.util.Scanner;


public class Day7 extends Day {

    private int part1 = 0;
    private int part2 = 70000000;
    private int total = 0;

    @Override
    public Object[] getSolutions(String fileAsText) {
        KeyValue<String, Integer> root = new KeyValue<>("/", 0);
        Node<KeyValue<String, Integer>> rootNode = new Node<KeyValue<String, Integer>>(root);

        Node currentNode = rootNode;

        try{
            Scanner scanner = new Scanner(fileAsText);
            boolean currentCommandIsListAll = false, currentCommandIsCD = false;

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line);

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
                        if(token.equals("..")){
                            currentNode = currentNode.getParent();
                        }
                        else if(currentNode.getChild("dir-"+token) != null){
                            currentNode = currentNode.getChild("dir-"+token);
                        }
                    }
                    else if(currentCommandIsListAll){
                        String name = lineScanner.next();
                        KeyValue<String, Integer> childNode;
                        if(token.equals("dir")){
                            childNode = new KeyValue<>("dir-"+name, 0);
                        }
                        else{
                            childNode = new KeyValue<>(name, Integer.parseInt(token));
                        }
                        currentNode.addChild(childNode);
                    }
                }
            }

            addAllNodes(rootNode);

            for (Node<KeyValue<String, Integer>> child : rootNode.getChildren()) {
                total += child.getData().getValue();
            }

            visitAllNodes(rootNode);

            return new Object[]{part1, part2};

        } catch (Exception e){
            e.printStackTrace();
        }
        return new Object[]{22, 3};
    }

    private void addAllNodes(Node<KeyValue<String, Integer>> node){
        for (Node<KeyValue<String, Integer>> child : node.getChildren() ) {
            addAllNodes(child);
            child.AddChildren();
            if(checkIfIsDir(child) && child.getData().getValue() < 100000){
                part1 += child.getData().getValue();
            }
        }
    }

    private void visitAllNodes(Node<KeyValue<String, Integer>> node){
        for (Node<KeyValue<String, Integer>> child : node.getChildren() ) {
            visitAllNodes(child);
            if(checkIfIsDir(child) && ((70000000 - total) + child.getData().getValue()) > 30000000){
                if(child.getData().getValue() < part2){
                    part2 = child.getData().getValue();
                }
            }
        }
    }

    private boolean checkIfIsDir(Node<KeyValue<String, Integer>> node){
        char[] name = node.getData().getKey().toCharArray();
        if(name[0] == 'd' && name[1] == 'i' && name[2] == 'r' && name[3] == '-'){
            return true;
        }
        return false;
    }
}
