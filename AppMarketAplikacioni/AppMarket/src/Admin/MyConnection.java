package Admin;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rkycy
 */
public class MyConnection {
    public static java.sql.Connection getConnection(){

   java.sql.Connection con = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/appmarket", "root", "root");
    } catch (ClassNotFoundException | SQLException ex) {
        JOptionPane.showMessageDialog(null, "Problem ne komunikimin me Databazen. Ju lutem sigurohuni qe e keni aktive dhe te konfiguruar!", "Problem Komunikimi", 2);
        Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
    }

    return con;
    }


    
}
