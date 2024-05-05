package com.example.minimalrotation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Position {
    public int x;
    public int y;
    public String name;
    Integer uzaklik = Integer.MAX_VALUE;
    HashMap<Position, Double> nodeMap;
    Position next;


    public Position( int x, int y, String name) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.nodeMap = new HashMap<>(); // Doğru: Sınıfın alanını başlatıyor
        next = null;
    }

    public Position Add(Position node, double distance)
    {
        nodeMap.put(node, distance);
        return this;
    }

    public HashMap<Position, Double> getNodeMap() {
        return this.nodeMap;
    }

    double calculateDistance(Position neigh)
    {
        return Math.sqrt(Math.pow((this.x - neigh.x),2) + Math.pow((this.y - neigh.y),2));
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

