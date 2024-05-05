package com.example.minimalrotation;

import java.util.*;

public class Dijkstra {
    public List<List> get_nodes(ArrayList<Position> positions, Position source, Position dest) {

        HashMap<Position, Double> distances = new HashMap<>();
        HashMap<Position, Position> parent = new HashMap<>();
        HashSet<Position> undiscovered = new HashSet<>();
        ArrayList<List> lists = new ArrayList<>();

        // Nodeların atamasını yaptım. Yani nodeları oluşturdum.
        Position M1 = positions.get(0);
        Position M2 = positions.get(1);
        Position M3 = positions.get(2);
        Position T1 = positions.get(3);
        Position T2 = positions.get(4);
        Position T3 = positions.get(5);
        Position T4 = positions.get(6);
        Position Hangar1 = positions.get(7);
        Position Hangar2 = positions.get(8);
        Position Security_Hut1 = positions.get(9);
        Position Security_Hut2 = positions.get(10);
        Position Security_Hut3 = positions.get(11);
        Position Security_Hut4 = positions.get(12);
        Position Stop1 = positions.get(13);
        Position Stop2 = positions.get(14);
        Position Military = positions.get(15);
        Position Student_Life_Center = positions.get(16);
        Position BinBin = positions.get(17);
        Position Pool = positions.get(18);
        Position Dining_Hall = positions.get(19);

        // Nodeları birbirine bağladım. Bu bağlı nodeların listesidir.
        M3.Add(M2, M3.calculateDistance(M2));
        M3.Add(Security_Hut2, M3.calculateDistance(Security_Hut2));
        Security_Hut2.Add(M3, Security_Hut2.calculateDistance(M3));
        M2.Add(M3, M2.calculateDistance(M3));
        M2.Add(M1, M2.calculateDistance(M1));
        M1.Add(M2, M1.calculateDistance(M2));
        M2.Add(Military, M2.calculateDistance(Military));
        Military.Add(M2, Military.calculateDistance(M2));
        M1.Add(Security_Hut1, M1.calculateDistance(Security_Hut1));
        Security_Hut1.Add(Stop1, Security_Hut1.calculateDistance(Stop1));
        Security_Hut1.Add(M1, Security_Hut1.calculateDistance(M1));
        M1.Add(Student_Life_Center, M1.calculateDistance(Student_Life_Center));
        Student_Life_Center.Add(M1, Student_Life_Center.calculateDistance(M1));
        Stop1.Add(Security_Hut1, Stop1.calculateDistance(Security_Hut1));
        Stop1.Add(Student_Life_Center, Stop1.calculateDistance(Student_Life_Center));
        Student_Life_Center.Add(Stop1, Student_Life_Center.calculateDistance(Stop1));
        Stop1.Add(BinBin, Stop1.calculateDistance(BinBin));
        BinBin.Add(Stop1, BinBin.calculateDistance(Stop1));
        Student_Life_Center.Add(Military, Student_Life_Center.calculateDistance(Military));
        Military.Add(Student_Life_Center, Military.calculateDistance(Student_Life_Center));
        Student_Life_Center.Add(T4, Student_Life_Center.calculateDistance(T4));
        T4.Add(Student_Life_Center, T4.calculateDistance(Student_Life_Center));
        Military.Add(T3, Military.calculateDistance(T3));
        T3.Add(Military, T3.calculateDistance(Military));
        Security_Hut2.Add(Military, Security_Hut2.calculateDistance(Military));
        Military.Add(Security_Hut2, Military.calculateDistance(Security_Hut2));
        Security_Hut2.Add(Hangar2, Security_Hut2.calculateDistance(Hangar2));
        Hangar2.Add(Security_Hut2, Hangar2.calculateDistance(Security_Hut2));
        Hangar2.Add(T3, Hangar2.calculateDistance(T3));
        T3.Add(Hangar2, T3.calculateDistance(Hangar2));
        Hangar2.Add(Security_Hut4, Hangar2.calculateDistance(Security_Hut4));
        Security_Hut4.Add(Hangar2, Security_Hut4.calculateDistance(Hangar2));
        T3.Add(Pool, T3.calculateDistance(Pool));
        Pool.Add(T3, Pool.calculateDistance(T3));
        T3.Add(T4, T3.calculateDistance(T4));
        T4.Add(T3, T4.calculateDistance(T3));
        T4.Add(BinBin, T4.calculateDistance(BinBin));
        BinBin.Add(T4, BinBin.calculateDistance(T4));
        T4.Add(T2, T4.calculateDistance(T2));
        T2.Add(T4, T2.calculateDistance(T4));
        BinBin.Add(Stop2, BinBin.calculateDistance(Stop2));
        Stop2.Add(BinBin, Stop2.calculateDistance(BinBin));
        Stop2.Add(Security_Hut3, Stop2.calculateDistance(Security_Hut3));
        Security_Hut3.Add(Stop2, Security_Hut3.calculateDistance(Stop2));
        Stop2.Add(T2, Stop2.calculateDistance(T2));
        T2.Add(Stop2, T2.calculateDistance(Stop2));
        T2.Add(Hangar1, T2.calculateDistance(Hangar1));
        Hangar1.Add(T2, Hangar1.calculateDistance(T2));
        T2.Add(Pool, T2.calculateDistance(Pool));
        Pool.Add(T2, Pool.calculateDistance(T2));
        Pool.Add(Dining_Hall, Pool.calculateDistance(Dining_Hall));
        Dining_Hall.Add(Pool, Dining_Hall.calculateDistance(Pool));
        Security_Hut4.Add(Pool, Security_Hut4.calculateDistance(Pool));
        Pool.Add(Security_Hut4, Pool.calculateDistance(Security_Hut4));
        Security_Hut4.Add(T1, Security_Hut4.calculateDistance(T1));
        T1.Add(Security_Hut4, T1.calculateDistance(Security_Hut4));
        T1.Add(Dining_Hall, T1.calculateDistance(Dining_Hall));
        Dining_Hall.Add(T1, Dining_Hall.calculateDistance(T1));
        Hangar1.Add(Dining_Hall, Hangar1.calculateDistance(Dining_Hall));
        Dining_Hall.Add(Hangar1, Dining_Hall.calculateDistance(Hangar1));
        Security_Hut3.Add(Hangar1, Security_Hut3.calculateDistance(Hangar1));
        Hangar1.Add(Security_Hut3, Hangar1.calculateDistance(Security_Hut3));


        for(Position p : positions){
            if(p == source){
                distances.put(p, 0.0);
            }
            else {
                distances.put(p, Double.MAX_VALUE);
            }
        }

        undiscovered.addAll(positions);

        while(!undiscovered.isEmpty()){
            Position current = getMinValueKey(distances, undiscovered);
            undiscovered.remove(current);

            if(current == dest)
            {
                break;
            }

            for (Position adjacentNode : current.getNodeMap().keySet()) {
                Double distance = current.getNodeMap().get(adjacentNode); // Değer (Double)

                double subDistance = distances.get(current) + distance;
                if(subDistance < distances.get(adjacentNode))
                {
                    distances.put(adjacentNode, subDistance);
                    parent.put(adjacentNode, current);
                }
            }
        }

        // Traversing the path
        List<Position> pathNodes = new ArrayList<>();
        Position currentNode = dest;

        while (currentNode != null)
        {
            pathNodes.add(currentNode);
            currentNode = parent.getOrDefault(currentNode, null);
        }


        for(Position p : pathNodes)
        {
            System.out.print(p.getName() + " -> ");
        }


        StackS s = new StackS();
        for (Position value : pathNodes) {
            s.push(value);
        }
        List<Position> pathNodesLast = new ArrayList<>();

        Position p;

        while ((p = s.pop()) != null){
            pathNodesLast.add(p);
        }

        //return pathNodesLast;

        List<Position> depthPath;
        depthPath = findPath(source, dest);
        //return depthPath;
        lists.add(pathNodesLast);
        lists.add(depthPath);
        return lists;
    }


    static Position getMinValueKey(HashMap<Position, Double> distances, HashSet<Position> undiscovered) {
        Position minPosition = null;
        double minValue = Double.MAX_VALUE;
        for (Position position : distances.keySet()) {
            if(undiscovered.contains(position)) {
                double value = distances.get(position);
                if (value < minValue) {
                    minValue = value;
                    minPosition = position;
                }
            }
        }
        return minPosition;
    }

    public List<Position> findPath(Position start, Position end) {
        HashSet<Position> visited = new HashSet<>();
        Stack<Position> stack = new Stack<>();
        HashMap<Position, Position> parent = new HashMap<>();

        stack.push(start);
        visited.add(start);

        while (!stack.isEmpty()) {
            Position current = stack.pop();
            if (current == end) {
                // Yolu bulduk, şimdi geriye dönebiliriz
                return reconstructPath(parent, current);
            }

            for (Position neighbor : current.getNodeMap().keySet()) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                }
            }
        }

        // A'dan C'ye bir yol bulunamadı
        return null;
    }

    private List<Position> reconstructPath(HashMap<Position, Position> parent, Position end) {
        List<Position> path = new ArrayList<>();
        Position current = end;
        while (current != null) {
            path.add(current);
            current = parent.get(current);
        }
        Collections.reverse(path);
        return path;
    }

}
