package com.fathi.util.structures;

import com.fathi.utilities.Node;
import java.util.Objects;

/**
 *
 * @author fathi
 * @version 0.1.2
 * @param <t> [optional] a specific type for the DS
 */
public class Stack<t> {
    private Node top = null;
    private int size = 0;

    public Stack () {
        this.top = null;
    }

    public Stack (Stack s) {
        Node ptr = s.top;
        while(ptr != null) {
            this.push((t) ptr.getData());
            ptr = ptr.getNext();
        }
        ptr = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stack)) return false;
        Node ptr = this.top, ep = ((Stack) o).top;
        while(ptr != null && ep != null) {
            if(ptr.getData() != ep.getData())
                return false;
            ptr = ptr.getNext();
            ep = ep.getNext();
        }
        if(ptr != null || ep != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTop(), getSize());
    }

    /**
     * get the size of the data structure
     * @return Integer value represent the current size of the data structure
     */
    public int getSize () {
        return this.size;
    }

    /**
     * Know whether the data structure is empty or not
     * @return Boolean value that specifies whether the data structure is empty or not
     */
    public boolean empty () {
        return this.top == null;
    }

    /**
     * Clear the data structure to be without any data but its still exist in the memory
     */
    public void clear () {
        while(!this.empty()) {
            this.pop();
        }
    }
    
    /**
     * add an element for the stack from the top
     * @param data the data to be added in the stack
     */
    public void push (t data) {
        Node node = new Node(data);
        if (empty())
            this.top = node;
        else {
            node.setNext(this.top);
            this.top = node;
        }
        this.size++;
    }
    
    /**
     * remove the first element from the stack and return its value
     * @return the value of the first element in the stack
     */
    public t pop () {
        try {
            t data = (t) this.top.getData();
            if (this.size == 1)
                this.top = null;
            else {
                Node ptr = this.top;
                this.top = this.top.getNext();
                ptr = null;
            }
            this.size--;
            return data;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * return the data of the first element of the data structure (here return the data of the top of the stack)
     * @return the data of the first element in the data structure
     */
    public t getTop() {
        try {
            return (t) this.top;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Reverse the data structure, so the first element will be the last and the last will be the first and so on
     */
    public void reverse() {
        Stack s1 = new Stack(), s2 = new Stack();
        while(!this.empty())
            s1.push(this.pop());
        while(!s1.empty())
            s2.push(this.pop());
        while(!s2.empty())
            this.push((t) s2.pop());
        s1 = s2 = null;
    }
    
}
