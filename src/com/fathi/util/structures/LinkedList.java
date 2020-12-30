package com.fathi.util.structures;

import com.fathi.utilities.Node;

import java.util.Objects;

/**
 *
 * @author fathi
 * @version 0.1.2
 */
public class LinkedList<t> {
    private Node head = null, tail = null;
    private int size = 0;
    
    public LinkedList() {
        this.head = this.tail = null;
    }
    
    public LinkedList(LinkedList l) {
        Node ptr = l.head;
        while(ptr != null) {
            this.push_front((t) ptr.getData());
            ptr = ptr.getNext();
        }
        ptr = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Queue)) return false;
        Node ptr = this.head, ep = ((LinkedList) o).head;
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
        return this.head == null;
    }

    /**
     * Clear the data structure to be without any data but its still exist in the memory
     */
    public void clear() {
        while(!this.empty())
            this.pop_front();
    }

    public void push_front(t data) {
        Node ptr = new Node(data);
        if(empty())
            this.head = this.tail = ptr;
        else {
            ptr.setNext(this.head);
            this.head = ptr;
        }
        this.size++;
    }
    
    public void push_back(t data) {
        Node ptr = new Node(data);
        if(empty())
            this.head = this.tail = ptr;
        else {
            this.tail.setNext(ptr);
            this.tail = ptr;
        }
        this.size++;
    }
    
    public void insert(int pos, t data) {
        if(pos == 0 || this.empty()) {
            this.push_front(data);
        } else if(pos == -1) {
            this.push_back(data);
        } else {
            Node node = new Node(data);
            Node ptr = this.head, prc = this.head;
            for(int i = 0; i < pos; i++) {
                prc = ptr;
                ptr = ptr.getNext();
            }
            prc.setNext(node);
            node.setNext(ptr);
            this.size++;
        }
    }
    
    public t pop_front() {
        try {
            t data = (t) this.head.getData();
            if(this.head == this.tail)
                this.head = null;
            else {
                Node ptr = this.head;
                this.head = this.head.getNext();
                ptr = null;
            }
            this.size--;
            return data;
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public t pop_back() {
        try {
            t data = (t) this.tail.getData();
            if(this.head == this.tail)
                this.head = null;
            else {
                Node tmp = this.head;
                while(tmp.getNext() != this.tail)
                    tmp = tmp.getNext();
                tmp.setNext(null);
                Node ptr = this.tail;
                ptr = null;
            }
            this.size--;
            return data;
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public t remove(int pos) {
        try {
            if(pos == 0) {
                return pop_front();
            } else if(pos == -1) {
                return pop_back();
            } else {
                Node ptr = this.head, prc = this.head;
                for(int i = 0; i < pos; i++) {
                    prc = ptr;
                    ptr = ptr.getNext();
                }
                t data = (t) ptr.getData();
                prc.setNext(ptr.getNext());
                ptr = null;
                this.size--;
                return data;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

//    public void delete(t data) {
//
//    }
//
//    public void delete(t data, int num) {
//
//    }

    /**
     * return the data of the first element of the data structure (here return the data of the head of the linked list)
     * @return the data of the first element in the data structure
     */
    public t getFront() {
        try {
            return (t) this.head.getData();
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * return the data of the last element of the data structure (here return the data of the tail of the linked list)
     * @return the data of the last element in the data structure
     */
    public t getBack() {
        try {
            return (t) this.tail.getData();
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Reverse the data structure, so the first element will be the last and the last will be the first and so on
     */
    public void reverse() {
        LinkedList l = new LinkedList();
        while(!this.empty())
            l.push_front(this.pop_front());
        while(!l.empty())
            this.push_back((t) l.pop_front());
    }
}
