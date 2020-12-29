package com.fathi.util.structures;

import com.fathi.utilities.Node;

/**
 *
 * @author fathi
 * */
public class Queue<t> {
    private Node front, back;
    private int size = 0;

    public Queue() {
        back = front = null;
    }

    public Queue(Queue q) {

    }

    public int getSize() { return size; }

    public boolean empty() { return front == null; }

    public void clear() {
        while(!empty())
            this.dequeue();
    }

    public void enqueue(t data) {
        Node node = new Node(data);
        if (empty())
            front = node;
        else
            back.setNext(node);
        back = node;
        size++;
    }

    public t dequeue() {
        try {
            t data = (t) front.getData();
            if (size == 1)
                front = null;
            else {
                Node ptr = front;
                front = front.getNext();
                ptr = null;
            }
            size--;
            return data;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public t getFront() {
        try {
            return (t) front.getData();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public t getBack() {
        try {
            return (t) back.getData();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
