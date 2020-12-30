package com.fathi.util.structures;

import com.fathi.utilities.Node;

import java.util.Objects;

/**
 *
 * @author fathi
 * @version 0.1.2
 * */
public class Queue<t> {
    private Node front, back;
    private int size = 0;

    public Queue() {
        this.back = this.front = null;
    }

    public Queue(Queue q) {
        Node ptr = q.front;
        while(ptr != null) {
            this.enqueue((t) ptr.getData());
            ptr = ptr.getNext();
        }
        ptr = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Queue)) return false;
        Node ptr = this.front, ep = ((Queue) o).front;
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
        return Objects.hash(getFront(), getBack(), getSize());
    }

    /**
     * get the size of the data structure
     * @return Integer value represent the current size of the data structure
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Know whether the data structure is empty or not
     * @return Boolean value that specifies whether the data structure is empty or not
     */
    public boolean empty() {
        return this.front == null;
    }

    /**
     * Clear the data structure to be without any data but its still exist in the memory
     */
    public void clear() {
        while(!empty())
            this.dequeue();
    }

    public void enqueue(t data) {
        Node node = new Node(data);
        if (empty())
            this.front = node;
        else
            this.back.setNext(node);
        this.back = node;
        this.size++;
    }

    public t dequeue() {
        try {
            t data = (t) this.front.getData();
            if (this.size == 1)
                this.front = null;
            else {
                Node ptr = this.front;
                this.front = this.front.getNext();
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
     * return the data of the first element of the data structure (here return the data of the front of the queue)
     * @return the data of the first element in the data structure
     */
    public t getFront() {
        try {
            return (t) this.front.getData();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * return the data of the last element of the data structure (here return the data of the back of the queue)
     * @return the data of the last element in the data structure
     */
    public t getBack() {
        try {
            return (t) this.back.getData();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Reverse the data structure, so the first element will be the last and the last will be the first and so on
     */
    public void reverse() {
        Stack s = new Stack();
        while(!this.empty())
            s.push(this.dequeue());
        while(!s.empty())
            this.enqueue((t) s.pop());
    }
}
