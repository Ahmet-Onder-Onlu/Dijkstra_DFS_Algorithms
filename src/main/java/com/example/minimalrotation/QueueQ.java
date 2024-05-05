package com.example.minimalrotation;

public class QueueQ {
    Position front;
    Position rear;

    public QueueQ() {
        this.front = null;
        this.rear = null;
    }

    void enqueue(Position newNode){
        if(front == null){
            front = rear = newNode;
        }
        else{
            rear.next = newNode;
            rear = newNode;
        }
    }

    Position dequeue(){
        if(front == null){
            return null;
        }
        else{
            Position p = front;
            front = front.next;
            if(front == null) {
                rear = null;
            }
            return p;
        }
        }
}

