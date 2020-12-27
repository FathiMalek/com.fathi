package com.fathi.util.structures;

import com.fathi.utilities.Node;

/**
 *
 * @author fathi
 */
public class LinkedList<t> {
    private Node head = null, tail = null;
    private int size = 0;
    
    public LinkedList() {
        head = tail = null;
    }
    
    public LinkedList(LinkedList l) {
        while(!l.empty())
            this.push_front((t) l.pop_back());
    }

    public int getSize() {
        return this.size;
    }

    public boolean empty() {
        return head == null;
    }

    public void clear() {
        while(head != null) {
            Node ptr = head;
            head = head.getNext();
            ptr = null;
        }
        size = 0;
    }

    public void push_front(t data) {
        Node ptr = new Node(data);
        if(empty())
            head = tail = ptr;
        else {
            ptr.setNext(head);
            head = ptr;
        }
        size++;
    }
    
    public void push_back(t data) {
        Node ptr = new Node(data);
        if(empty())
            head = tail = ptr;
        else {
            tail.setNext(ptr);
            tail = ptr;
        }
        size++;
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
            size++;
        }
    }
    
    public t pop_front() {
        try {
            t data = (t) head.getData();
            if(head == tail)
                head = null;
            else {
                Node ptr = head;
                head = head.getNext();
                ptr = null;
            }
            size--;
            return data;
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public t pop_back() {
        try {
            t data = (t) tail.getData();
            if(head == tail)
                head = null;
            else {
                Node tmp = head;
                while(tmp.getNext() != tail)
                    tmp = tmp.getNext();
                tmp.setNext(null);
                Node ptr = tail;
                ptr = null;
            }
            size--;
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
                Node ptr = head, prc = head;
                for(int i = 0; i < pos; i++) {
                    prc = ptr;
                    ptr = ptr.getNext();
                }
                t data = (t) ptr.getData();
                prc.setNext(ptr.getNext());
                ptr = null;
                size--;
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
    
    public t front() {
        try {
            return (t) head.getData();
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public t back() {
        try {
            return (t) tail.getData();
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public void reverse() {
        LinkedList l = new LinkedList();
        while(!this.empty())
            l.push_front(this.pop_front());
        while(!l.empty())
            this.push_back((t) l.pop_front());
    }
}
