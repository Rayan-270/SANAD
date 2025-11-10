package SanadUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.*;
import java.util.*;


public class App {
    static Connection con ;
    Statement stat;
    public App(){
        String url = "jdbc:mysql://localhost:3306/sanad";
        String user = "root";
        String pass = "app@mysql";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("done");

            con = DriverManager.getConnection(url, user, pass);
            System.out.println("connected");

            stat = con.createStatement();
        } catch (ClassNotFoundException e) { 
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }


    public ArrayList<String> getdata(String helptype){
        ArrayList<String> all_data = new ArrayList<>();
        String query ="select * from doner where helptype = '"+helptype+"'"; 
        try {
            ResultSet data = stat.executeQuery(query);
            while(data.next()){
                all_data.add("name:" + data.getString(2) + "\nphone number: " + data.getString(4) + "\nfacebook account: " + data.getString(5) +"\nEmail: " + data.getString(6) + "\nzone: " + data.getString(7));  
            }
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return all_data;
    } 
    public void add_doner(){

    }

    // public static void main(String[] args) {
    //     App a = new App();
    //     ArrayList<String> all_data = a.getdata("medicine");
    //     for (String data : all_data) {
    //         System.out.println(data);
    //         System.out.println("------------------------");
    //     }
    // }
}
