package LoginAndRegister;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rkycy
 */
public class MyConnection {
    public static java.sql.Connection getConnection(){

   java.sql.Connection con = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/java_login_registerr", "root", "");
    } catch (ClassNotFoundException | SQLException ex) {
    System.out.println(ex.getMessage());
    }

    return con;
    }


    
}
