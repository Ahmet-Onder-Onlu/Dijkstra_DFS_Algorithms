package com.example.minimalrotation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;

public class Map {

    String[] locs = {"M3","M2","M1","T1","T2","T3","T4", "Security_Hut1",
            "Security_Hut2","Security_Hut3","Security_Hut4","Military","Student_Life_Center",
            "Stop1","Stop2","Hangar1","Hangar2","BinBin","Pool","Dining_Hall"};
    String[] ss = new String[2];

    @FXML
    private RadioButton M3,M2,M1,T1,T2,T3,T4,Sec1,Sec2,Sec3,Sec4,Mil,Stu,Sto1,Sto2,Han1,Han2,Bin,Pool,Din;

    private Stage stage;
    private Scene scene;
    private Parent root;
    public TextField location1,location2;



    private boolean getLocs()  {
        String loc1 = location1.getText();
        String loc2 = location2.getText();
        Boolean flag1 = false, flag2 = false;
        if(loc1.equals(loc2)){
            System.out.println("Name must not be same!");
            alert();
            return false;
        }
        for(String s : locs) {
            if(loc1.equals(s)){
                System.out.println("Current loc is OK");
                flag1 = true;
            }
            if(loc2.equals(s)){
                System.out.println("Destination loc is OK");
                flag2 = true;
            }
        }
        if(flag1 && flag2){
            ss[0] = loc1;
            ss[1] = loc2;
            return true;
        }
        else{
            alert();
            return false;
        }
    }

    public void alert() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Be sure that you chose correct!");

        // Uyarı mesajını göster
        alert.showAndWait();
    }

    private boolean control() {
        boolean flag = getLocs();
        return flag;
    }

    private String getLocation()  {
        if(M3.isSelected()){
            return M3.getText();
        }
        if(M2.isSelected()){
            return M2.getText();
        }
        if(M1.isSelected()){
            return M1.getText();
        }
        if(T4.isSelected()){
            return T4.getText();
        }
        if(T3.isSelected()){
            return T3.getText();
        }
        if(T2.isSelected()){
            return T2.getText();
        }
        if(T1.isSelected()){
            return T1.getText();
        }
        if(Sec1.isSelected()){
            return Sec1.getText();
        }
        if(Sec2.isSelected()){
            return Sec2.getText();
        }
        if(Sec3.isSelected()){
            return Sec3.getText();
        }
        if(Sec4.isSelected()){
            return Sec4.getText();
        }
        if(Mil.isSelected()){
            return Mil.getText();
        }
        if(Stu.isSelected()){
            return Stu.getText();
        }
        if(Sto1.isSelected()){
            return Sto1.getText();
        }
        if(Sto2.isSelected()){
            return Sto2.getText();
        }
        if(Bin.isSelected()){
            return Bin.getText();
        }
        if(Pool.isSelected()){
            return Pool.getText();
        }
        if(Din.isSelected()){
            return Din.getText();
        }
        if(Han1.isSelected()){
            return Han1.getText();
        }
        if(Han2.isSelected()){
            return Han2.getText();
        }
        return "";
    }

    @FXML
    protected void choose1()  {
        ss[0] = getLocation();
        location1.setText(ss[0]);
    }

    @FXML
    protected void choose2()  {
        ss[1] = getLocation();
        location2.setText(ss[1]);
    }

    @FXML
    protected void exit()   {
        System.exit(0);
    }

    @FXML
    protected void next(ActionEvent event) throws IOException {
        if(control()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("giveinfo-view.fxml"));
            root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);

            GiveInfo giveInfo = loader.getController();

            // Öğrenci bilgisini alıcı controller'a aktar
            giveInfo.getRootInfo(ss);

            stage.show();
        }
    }
}