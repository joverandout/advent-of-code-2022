package common.util;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    private List<Node<KeyValue<String, Integer>>> children = new ArrayList<Node<KeyValue<String, Integer>>>();
    private Node<KeyValue<String, Integer>> parent = null;
    private KeyValue<String, Integer> data = null;

    public Node(KeyValue<String, Integer> data) {
        this.data = data;
    }

    public Node(KeyValue<String, Integer> data, Node<KeyValue<String, Integer>> parent) {
        this.data = data;
        this.parent = parent;
    }

    public List<Node<KeyValue<String, Integer>>> getChildren() {
        return children;
    }

    public void setParent(Node<KeyValue<String, Integer>> parent) {
        this.parent = parent;
    }

    public void addChild(KeyValue<String, Integer> data) {
        Node<KeyValue<String, Integer>> child = new Node<KeyValue<String, Integer>>(data);
        child.setParent((Node<KeyValue<String, Integer>>) this);
        this.children.add(child);
    }

    public void addChild(Node<KeyValue<String, Integer>> child) {
        child.setParent((Node<KeyValue<String, Integer>>) this);
        this.children.add(child);
    }

    public KeyValue<String, Integer> getData() {
        return this.data;
    }

    public void setData(KeyValue<String, Integer> data) {
        this.data = data;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }

    public void removeParent() {
        this.parent = null;
    }
    
    public Node<KeyValue<String, Integer>> getChild(String key){
        for (Node<KeyValue<String, Integer>> child : children) {
            if(child.getData().getKey().equals(key)){
                return child;
            }
        }
        return null;
    }

    public Node<KeyValue<String, Integer>> getParent(){
        return this.parent;
    }
}
