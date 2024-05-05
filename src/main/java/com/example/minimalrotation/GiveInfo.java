package com.example.minimalrotation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class GiveInfo extends Dijkstra{

    ArrayList<Position> positions = new ArrayList<>();
    java.util.List<List> routeFinder = new ArrayList<>();
    java.util.List<Position> Best = new ArrayList<>();
    java.util.List<Position> Option = new ArrayList<>();
    Position M3 = new Position(0, 0, "M3");
    Position M2 = new Position(0, 25, "M2");
    Position M1 = new Position(0, 50, "M1");
    Position Security_Hut1 = new Position(0, 65, "Security_Hut1");
    Position Security_Hut2 = new Position(30, 0, "Security_Hut2");
    Position Military = new Position(30, 20, "Military");
    Position Student_Life_Center = new Position(30, 45, "Student_Life_Center");
    Position Stop1 = new Position(30, 65, "Stop1");
    Position Hangar2 = new Position(55, 0, "Hangar2");
    Position T3 = new Position(55, 35, "T3");
    Position T4 = new Position(55, 55, "T4");
    Position BinBin = new Position(55, 65, "BinBin");
    Position Security_Hut4 = new Position(75, 0, "Security_Hut4");
    Position Pool = new Position(75, 35, "Pool");
    Position T2 = new Position(75, 55, "T2");
    Position Stop2 = new Position(75, 65, "Stop2");
    Position T1 = new Position(90, 0, "T1");
    Position Dining_Hall = new Position(90, 30, "Dining_Hall");
    Position Hangar1 = new Position(90, 50, "Hangar1");
    Position Security_Hut3 = new Position(90, 65, "Security_Hut3");
    Position source;
    Position dest;

    public String[] startStop = new String[2];
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField route1;
    @FXML
    private TextField route2;
    @FXML
    private TextField route3;
    @FXML
    private TextField bestTime;
    @FXML
    private TextField worstTime;
    @FXML
    private TextField extraTime;
    @FXML
    private TextField bestNum;
    @FXML
    private TextField worstNum;
    @FXML
    private TextField extraNum;



    @FXML
    protected void Back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("map-view.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void getRootInfo(String[] ss) {
        startStop = ss;
        positions.add(M1);
        positions.add(M2);
        positions.add(M3);
        positions.add(T1);
        positions.add(T2);
        positions.add(T3);
        positions.add(T4);
        positions.add(Hangar1);
        positions.add(Hangar2);
        positions.add(Security_Hut1);
        positions.add(Security_Hut2);
        positions.add(Security_Hut3);
        positions.add(Security_Hut4);
        positions.add(Stop1);
        positions.add(Stop2);
        positions.add(Military);
        positions.add(Student_Life_Center);
        positions.add(BinBin);
        positions.add(Pool);
        positions.add(Dining_Hall);

        for(Position p : positions){
            if(Objects.equals(p.name, ss[0]))
            {
                source = p;
            }
            else if(Objects.equals(p.name, ss[1]))
            {
                dest = p;
            }
        }
        // Source ve dest noktalari basari ile olustururldu!!

        String route = "";
        int counter = 0;
        double distance1 = 0;
        routeFinder = get_nodes(positions, source, dest);
        Best = routeFinder.get(0);
        Option = routeFinder.get(1);

        QueueQ q = new QueueQ();
        for (Position value : Best) {
            q.enqueue(value);
        }
        Position p;
        while ((p = q.dequeue()) != null){
            counter++;
            if(p.next == null){
                route = route.concat(p.getName());
            }
            else route = route.concat(p.getName() + " -> ");
        }
        int copy_counter = counter-1;
        for(int i = 0; i < copy_counter; i++){
            distance1 += Best.get(i).calculateDistance(Best.get(i+1));
        }
        route1.setText(route);
        bestNum.setText(String.valueOf(counter));
        bestTime.setText(String.valueOf(distance1));

        //Option
        int counter1 = 0;
        String route1 = "";
        double distance2 = 0;
        QueueQ q1 = new QueueQ();
        for (Position value : Option) {
            q1.enqueue(value);
        }
        Position p1;
        while ((p1 = q1.dequeue()) != null){
            counter1++;
            if(p1.next == null){
                route1 = route1.concat(p1.getName());
            }
            else route1 = route1.concat(p1.getName() + " -> ");
        }
        int copy_counter1 = counter1-1;
        for(int i = 0; i < copy_counter1; i++){
            distance2 += Option.get(i).calculateDistance(Option.get(i+1));
        }
        route2.setText(route1);
        worstNum.setText(String.valueOf(counter1));
        worstTime.setText(String.valueOf(distance2));



        double distance3 = source.calculateDistance(dest);
        route3.setText(source.getName() + " -> " + dest.getName());
        extraNum.setText(String.valueOf(2));
        extraTime.setText(String.valueOf(distance3));

    }
}
