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
                boolean cd = false, listAll = false;
                while(lineScanner.hasNext()) {
                    String token = lineScanner.next();
                }
            }

            return new Object[]{2, 3};

        } catch (Exception e){
            e.printStackTrace();
        }
        return new Object[]{22, 3};
    }

}
