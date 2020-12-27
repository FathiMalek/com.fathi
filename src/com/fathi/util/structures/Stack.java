package com.fathi.util.structures;

import com.fathi.utilities.Node;

/**
 *
 * @author fathi
 */
public class Stack<t> {
    private Node top = null;
    private int size = 0;

    public Stack () {
        top = null;
    }

    public Stack (Stack s) {
        Stack bid = new Stack();
        while (!s.empty())
            bid.push((t) s.pop());
        while (!bid.empty())
            this.push((t) bid.pop());
        bid = null;
    }

    public int getSize () { return this.size; }
    
    public boolean empty () {
        return top == null;
    }

    public void clear () {
        while(top != null) {
            Node ptr = top;
            top = top.getNext();
            ptr = null;
        }
        size = 0;
    }
    
    public void push (t data) {
        Node node = new Node(data);
        if (empty())
            top = node;
        else {
            node.setNext(top);
            top = node;
        }
        size++;
    }

    public t pop () {
        try {
            t data = (t) top.getData();
            if (size == 1)
                top = null;
            else {
                Node ptr = top;
                top = top.getNext();
                ptr = null;
            }
            size--;
            return data;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
