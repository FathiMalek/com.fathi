package com.fathi.utilities;

/**
 *
 * @author fathi
 * @version 0.1.2
 * @param <t> [optional] a specific type for the DS
 */
public class Node<t> {
    private t data;
    private Node next = null;

    public Node (){}

    public Node (t data){
        this.data = data;
        this.next = null;
    }

    public Node (t data, Node next){
        this.data = data;
        this.next = next;
    }

    public t getData() {
        return data;
    }

    public void setData(t data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}