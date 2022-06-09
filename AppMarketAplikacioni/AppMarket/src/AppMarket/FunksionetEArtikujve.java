package AppMarket;

import AppMarket.AritkujtEMenys.PijeAlkolike;
import AppMarket.AritkujtEMenys.PijeTeNgrohta;
import AppMarket.AritkujtEMenys.Embelsira;
import AppMarket.AritkujtEMenys.Pije;
import AppMarket.AritkujtEMenys.Snacks;
import Admin.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*  
 *
 *  Importimi i Librarive
 *
 */



/*  
 *
 *  Tema: 
 *  @author Rilind Kyçyku - rkycyku
 *
 */
public class FunksionetEArtikujve {
    public static String produkti;
    
    public static int id = 1;
    
    public static void setId(int a){
        id = a;
    }
    
    public static void Produkti(){
        DefaultTableModel model;
        if(ProgramiShitjes.getRasti() == 1){
            model = (DefaultTableModel)ProgramiShitjes.l.getModel();
        }else{
            model = (DefaultTableModel)ProgramiShitjesMeComboBox.l.getModel();
        }
        
        
        int flag=0;
        
        try {
            Connection con = MyConnection.getConnection();//Creating object of Connection class
            Statement st;
            ResultSet rs; 
            st = con.createStatement();//crating statement object
            String query = "SELECT * FROM `produktet` where `emrprod` = '" + produkti + "'";//Storing MySQL query in A string variable
            rs = st.executeQuery(query);//executing query and storing result in ResultSet
            
 
            while (rs.next()) {
            
             //Retrieving details from the database and storing it in the String variables
                String emri = rs.getString("emrprod");
                String sasia = rs.getString("sasia");
                String kat = rs.getString("katprod");
                String qmimi = rs.getString("qmimi");
                if (produkti.equalsIgnoreCase(emri)) {
                    flag = 1;
                    model.addRow(new Object[]{id,emri, kat, sasia, qmimi});//Adding row in Table
                    id++;
                    KrijimiArtikujve();
                    
                }
                if (flag == 0) {
                JOptionPane.showMessageDialog(null, "Ju lutemi Shtoni kete Produkt ne list!");//When invalid username is entered
                }
            }
            
 
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
    public static void KrijimiArtikujve(){
        if(ProgramiShitjes.getRasti() == 1){
            ProgramiShitjes.getSum();
            ProgramiShitjes.KusuriFix();
            ProgramiShitjes.Kusuri();
        }else{
            ProgramiShitjesMeComboBox.getSum();
            ProgramiShitjesMeComboBox.KusuriFix();
            ProgramiShitjesMeComboBox.Kusuri();
        }
    }
    
    public static void PijeTeNgrohta(){
        try
        {
            Connection con = MyConnection.getConnection();//Creating object of Connection class
            Statement st;
            ResultSet rs; 
            st = con.createStatement();//crating statement object
            String query = "SELECT * FROM `produktet` where `katprod` = 'PijeteNgrohta'";//Storing MySQL query in A string variable
            rs = st.executeQuery(query);//executing query and storing result in ResultSet
            while(rs.next())
            {
                String name = rs.getString("emrprod");
                if(ProgramiShitjes.getRasti() == 1){
                    PijeTeNgrohta.jComboBox2.addItem(name);
                }else{
                    ProgramiShitjesMeComboBox.jComboBox2.addItem(name);
                }
            }
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public static void Pije(){
        try
        {
            Connection con = MyConnection.getConnection();//Creating object of Connection class
            Statement st;
            ResultSet rs; 
            st = con.createStatement();//crating statement object
            String query = "SELECT * FROM `produktet` where `katprod` = 'Pije'";//Storing MySQL query in A string variable
            rs = st.executeQuery(query);//executing query and storing result in ResultSet
            while(rs.next())
            {
                String name = rs.getString("emrprod");
                if(ProgramiShitjes.getRasti() == 1){
                    Pije.jComboBox2.addItem(name);
                }else{
                    ProgramiShitjesMeComboBox.jComboBox5.addItem(name);
                }
            }
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public static void Embelsira(){
        try
        {
            Connection con = MyConnection.getConnection();//Creating object of Connection class
            Statement st;
            ResultSet rs; 
            st = con.createStatement();//crating statement object
            String query = "SELECT * FROM `produktet` where `katprod` = 'Embelsira'";//Storing MySQL query in A string variable
            rs = st.executeQuery(query);//executing query and storing result in ResultSet
            while(rs.next())
            {
                String name = rs.getString("emrprod");
                if(ProgramiShitjes.getRasti() == 1){
                    Embelsira.jComboBox2.addItem(name);
                }else{
                    ProgramiShitjesMeComboBox.jComboBox4.addItem(name);
                }
            }
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public static void PijeAlkolike(){
        try
        {
            Connection con = MyConnection.getConnection();//Creating object of Connection class
            Statement st;
            ResultSet rs; 
            st = con.createStatement();//crating statement object
            String query = "SELECT * FROM `produktet` where `katprod` = 'PijeAlkolike'";//Storing MySQL query in A string variable
            rs = st.executeQuery(query);//executing query and storing result in ResultSet
            while(rs.next())
            {
                String name = rs.getString("emrprod");
                if(ProgramiShitjes.getRasti() == 1){
                    PijeAlkolike.jComboBox6.addItem(name);
                }else{
                    ProgramiShitjesMeComboBox.jComboBox6.addItem(name);
                }
            }
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    
    public static void Snacks(){
        try
        {
            Connection con = MyConnection.getConnection();//Creating object of Connection class
            Statement st;
            ResultSet rs; 
            st = con.createStatement();//crating statement object
            String query = "SELECT * FROM `produktet` where `katprod` = 'Snacks'";//Storing MySQL query in A string variable
            rs = st.executeQuery(query);//executing query and storing result in ResultSet
            while(rs.next())
            {
                String name = rs.getString("emrprod");
                if(ProgramiShitjes.getRasti() == 1){
                    Snacks.jComboBox2.addItem(name);
                }else{
                    ProgramiShitjesMeComboBox.jComboBox7.addItem(name);
                }
            }
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
