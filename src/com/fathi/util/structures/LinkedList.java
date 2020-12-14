package com.fathi.util.structures;

import com.fathi.utilities.Node;

/**
 *
 * @author fathi
 */
public class LinkedList<t> {
    private Node head, tail;
    private int size;
    
    public LinkedList() {
        head = tail = null;
    }
    
    public LinkedList(LinkedList l) {
        LinkedList bid = new LinkedList();
        while(!bid.empty())
            this.push_front((t) bid.pop_back());
        bid = null;
    }
    
    
    public boolean empty() {
        return head == null;
    }
    
    public void clear() {
        while(head != null) {
            Node ptr = head;
            head = head.next;
            ptr = null;
        }
    }
    
    
    public void push_front(t data) {
        Node ptr = new Node(data);
        if(empty())
            head = tail = ptr;
        else {
            ptr.next = head;
            head = ptr;
        }
        size++;
    }
    
    public void push_back(t data) {
        Node ptr = new Node(data);
        if(empty())
            head = tail = ptr;
        else {
            tail.next = ptr;
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
                ptr = ptr.next;
            }
            prc.next = node;
            node.next = ptr;
            size++;
        }
    }
    
    
    public t pop_front() {
        try {
            t data = (t) head.data;
            if(head == tail)
                head = null;
            else {
                Node ptr = head;
                head = head.next;
                ptr = null;
            }
            size--;
            return data;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public t pop_back() {
        try {
            t data = (t) tail.data;
            if(head == tail)
                head = null;
            else {
                Node tmp = head;
                while(tmp.next != tail)
                    tmp = tmp.next;
                tmp.next = null;
                Node ptr = tail;
                ptr = null;
            }
            size--;
            return data;
        } catch(Exception e) {
            e.printStackTrace();
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
                    ptr = ptr.next;
                }
                t data = (t) ptr.data;
                prc.next = ptr.next;
                ptr = null;
                size--;
                return data;
            }
        } catch(Exception e) {
            e.printStackTrace();
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
            return (t) head.data;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public t back() {
        try {
            return (t) tail.data;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    public int size() {
        return this.size;
    }
    
    
    public void reverse() {
        LinkedList l = new LinkedList();
        while(!this.empty())
            l.push_front(this.pop_front());
        while(!l.empty())
            this.push_back((t) l.pop_front());
    }
    
    
    public void display() {
        if(!empty()) {
            Node tmp = head;
            while(tmp != null) {
                System.out.print(tmp.data);
                if (tmp.next != null)
                    System.out.print(" -> ");
                tmp = tmp.next;
            }
            tmp = null;
        }
    }
}
