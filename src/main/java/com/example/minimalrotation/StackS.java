package com.example.minimalrotation;

public class StackS {
    Position head;

    public StackS() {
        this.head = null;
    }

    public Position pop(){
        if(head == null)
        {
            return null;
        }
        Position temp = head;
        head = head.next;
        return temp;
    }
    public void push(Position n1){
        if(head == null){
            head = n1;
        }
        else{
            n1.next = head;
            head = n1;
        }
    }

}

