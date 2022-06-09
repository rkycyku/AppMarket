package Admin;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import AppMarket.AritkujtEMenys.PijeTeNgrohta;
import AppMarket.ProgramiShitjes;
import AppMarket.ProgramiShitjesMeComboBox;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.util.Arrays;
import java.util.logging.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rkycy
 */
public class RegisterForm extends javax.swing.JFrame {

    /**
     * Creates new form RegisterForm
     */
    public RegisterForm() {
        initComponents();
        
        Perdoruesi();
        AksesiIPerdoruesit();
        
        this.setTitle("Regjistrimi | AppMarket");
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void Perdoruesi(){
        DefaultTableModel model;
        model = (DefaultTableModel)l.getModel();
        
        model.setRowCount(0);
        
        try {
            Connection con = MyConnection.getConnection();//Creating object of Connection class
            Statement st;
            ResultSet rs; 
            st = con.createStatement();//crating statement object
            String query = "SELECT * FROM `loginandreg`";//Storing MySQL query in A string variable
            rs = st.executeQuery(query);//executing query and storing result in ResultSet
 
 
            while (rs.next()) {
            
             //Retrieving details from the database and storing it in the String variables
                String ID = rs.getString("ID");
                String emri = rs.getString("u_fname");
                String mbiemri = rs.getString("u_lname");
                String username = rs.getString("u_uname");
                String aksesi = rs.getString("u_access");
                
                model.addRow(new Object[]{ID, emri, mbiemri, username, aksesi});//Adding row in Table
                
            }
            
 
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
    public void PastroFaqen(){
        jTextField_FN.setText("");
        jTextField_LN.setText("");
        jTextField_UN.setText("");
        jPasswordField_PASS.setText("");
        jPasswordField_REPASS.setText("");
        IDLabel.setText("");
        jComboBox1.setSelectedIndex(0);
        
        Perdoruesi();
    }
    
    public boolean checkUsername(String username)
    {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `loginandreg` WHERE `u_uname` =?";
        
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, username);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                checkUser = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
         return checkUser;
    }
    
    
    public void PerditesimiPerdoruesit(){
        java.sql.Connection con = MyConnection.getConnection();
        java.sql.Statement st;
        
        if(jTextField_UN.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Username nuk mund te jete i zbrazet! Venosni një Username!");
        }
        
        else if(jPasswordField_PASS.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Password nuk mund te jete i zbrazet! Venosni një Password!");
        }
        else if(!jPasswordField_PASS.getText().equals(jPasswordField_REPASS.getText()))
        {
            JOptionPane.showMessageDialog(null, "Rishkruani Password-in!");
        }else{
            try{
                //<editor-fold desc="Vendosja e Inputeve ne Databaze">
                st = con.createStatement();

                String sqlQuery = "UPDATE `loginandreg` SET `u_fname` = '"+jTextField_FN.getText()+"', `u_lname` = '"+jTextField_LN.getText()+"', `u_uname` = '"+jTextField_UN.getText()+"', `u_pass` = '"+jPasswordField_PASS.getText()+"' , `u_bdate` = '', `u_address` = '', `u_access` = '"+jComboBox1.getSelectedItem().toString()+"' WHERE `ID` = "+IDLabel.getText();
                java.sql.PreparedStatement ps = con.prepareStatement(sqlQuery);

                ps.executeUpdate();
            }

            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
            
            PastroFaqen();
            ZhbllokimiPerditsim();
        }
    }
    
    private void AksesiIPerdoruesit(){
        try{
            Connection con = MyConnection.getConnection();//Creating object of Connection class
            Statement st;
            ResultSet rs; 
            st = con.createStatement();//crating statement object
            String query = "SELECT * FROM `katakses`";//Storing MySQL query in A string variable
            rs = st.executeQuery(query);//executing query and storing result in ResultSet
            while(rs.next())
            {
                String name = rs.getString("llojiAk");
                jComboBox1.addItem(name);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void BllokimiPerditsim(){
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
        jButton1.setEnabled(false);
    }
    
    public void ZhbllokimiPerditsim(){
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
        jButton1.setEnabled(true);
    }
    
    public String fname;
    public String lname;
    public String uname;
    public String pass;
    public String re_pass;
    public int kontrolli = 0;
    
    
        
    public String getFname(){
        return fname;
    }
    public String getLname(){
        return lname;
    }
    public String getUname(){
        return uname;
    }
    public String getPass(){
        return pass;
    }
    public String getRe_Pass(){
        return re_pass;
    }
    
    public void setFname(String emri){
        fname = emri;
    }
    public void setLname(String mbiemri){
        lname = mbiemri;
    }
    public void setUname(String username){
        uname = username;
    }
    public void setPass(String password){
        pass = password;
    }
    public void setRe_Pass(String repassword){
        re_pass = repassword;
    }
        
    public void Kontrollimi(){
        setFname(jTextField_FN.getText());
        setLname(jTextField_LN.getText());
        setUname(jTextField_UN.getText());
        setPass(jPasswordField_PASS.getText());
        setRe_Pass(jPasswordField_REPASS.getText());
                
        if(getUname().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Username nuk mund te jete i zbrazet! Venosni një Username!");
            kontrolli = 1;
        }
        
        else if(getPass().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Password nuk mund te jete i zbrazet! Venosni një Password!");
            kontrolli = 1;
        }
        else if(!getPass().equals(getRe_Pass()))
        {
            JOptionPane.showMessageDialog(null, "Rishkruani Password-in!");
            kontrolli = 1;
        }
        
        else if(checkUsername(getUname()))
        {
            JOptionPane.showMessageDialog(null, "Ky Username tashmë ekziston!");
            kontrolli = 1;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jPasswordField_REPASS = new javax.swing.JPasswordField();
        jPasswordField_PASS = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField_UN = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_LN = new javax.swing.JTextField();
        jTextField_FN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        IDLabel = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        l = new javax.swing.JTable();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("Perdoruesi*:");

        jButton1.setText("Regjistro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setText("Password*:");

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel6.setText("Rishkruani Pass*:");

        jButton2.setText("Mbylle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Programi i Shitjes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Regjistro Perdorues");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setText("Emri:");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setText("Mbiemri:");

        jButton4.setText("Anulo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel7.setText("ID:");

        IDLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        jButton5.setText("Perditeso Te Dhenat");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel8.setText("Aksesi:");

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jButton6.setText("Delete");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordField_REPASS)
                    .addComponent(jPasswordField_PASS)
                    .addComponent(jTextField_UN)
                    .addComponent(jTextField_FN)
                    .addComponent(jTextField_LN)
                    .addComponent(IDLabel)
                    .addComponent(jComboBox1, 0, 120, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(IDLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_FN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_LN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_UN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jPasswordField_PASS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jPasswordField_REPASS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        l.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Emri", "Mbiemri", "Perdoruesi", "Aksesi"
            }
        ));
        l.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(l);
        if (l.getColumnModel().getColumnCount() > 0) {
            l.getColumnModel().getColumn(0).setResizable(false);
            l.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Kontrollimi();
        if(kontrolli == 0){
            
            
            PreparedStatement ps;
            String query = "INSERT INTO `loginandreg`(`u_fname`, `u_lname`, `u_uname`, `u_pass`, `u_bdate`, `u_address`, `u_access`) VALUES (?,?,?,?,?,?,?)";

            try {
                ps = MyConnection.getConnection().prepareStatement(query);
                System.out.println(fname);
                ps.setString(1, getFname());
                ps.setString(2, getLname());
                ps.setString(3, getUname());
                ps.setString(4, getPass());
                ps.setString(5, "");
                ps.setString(6,"");
                ps.setString(7, jComboBox1.getSelectedItem().toString());
                
                
                if(ps.executeUpdate() > 0)
                {
                    JOptionPane.showMessageDialog(null, "U shtua përdoruesi i ri!");
                }

            } 
            catch (SQLException ex) {
                Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Perdoruesi();
            PastroFaqen();
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ProgramiShitjes prg = new ProgramiShitjes(1);
        prg.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        PastroFaqen();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void lMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lMouseClicked
        int i = l.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)l.getModel();
        
        IDLabel.setText(model.getValueAt(i,0).toString());
        jTextField_FN.setText(model.getValueAt(i,1).toString());
        jTextField_LN.setText(model.getValueAt(i,2).toString());
        jTextField_UN.setText(model.getValueAt(i,3).toString());
        jComboBox1.setSelectedItem(model.getValueAt(i,4).toString());
        
        BllokimiPerditsim();
    }//GEN-LAST:event_lMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        PerditesimiPerdoruesit();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int i = l.getSelectedRow();  

        if( i >= 0){
            try{
               Connection con = MyConnection.getConnection();
               Statement st;
               st = con.createStatement();

               String sql = "DELETE FROM `loginandreg` WHERE `id`="+IDLabel.getText()+"";
               st.execute(sql);

               Perdoruesi();
               PastroFaqen();
            }

            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }   
        }

        else{
            JOptionPane.showMessageDialog(null,"Nuk keni zgjedhur asnje perdorues.", "",2);
        }
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField_PASS;
    private javax.swing.JPasswordField jPasswordField_REPASS;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField_FN;
    private javax.swing.JTextField jTextField_LN;
    private javax.swing.JTextField jTextField_UN;
    private javax.swing.JTable l;
    // End of variables declaration//GEN-END:variables
}
