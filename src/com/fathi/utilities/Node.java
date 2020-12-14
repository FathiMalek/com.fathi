/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fathi.utilities;

/**
 *
 * @author fathi
 */
public class Node<t> {
    public t data;
    public Node next = null;

    public Node(){}
    public Node(t data){
        this.data = data;
        this.next = null;
    }
    public Node(t data, Node next){
        this.data = data;
        this.next = next;
    }
}