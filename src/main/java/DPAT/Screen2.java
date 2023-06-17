/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DPAT;

import DB.DBConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kairav
 */
//ColumnNames
//PatientNumber
//Firstname
//Surname
//DateOfBirth
//Medical_Conditions
//PhoneNumber
//Address
//Visits
public class Screen2 extends javax.swing.JFrame {

    /**
     * Creates new form Screen1
     */
    public Screen2() {
        initComponents();
        setSize(526, 355);
        setLocationRelativeTo(null);
        try {
            DBConnector.init();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Could not find DB driver");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Could not connect to db");
        }

        String query2 = "select firstname, surname, PatientNumber FROM Patient ORDER BY firstname;";
        try {
            ResultSet rs = DBConnector.read(query2);

            String[] names = new String[9999];
            int i = 0;
            while (rs.next()) {
                String name = rs.getString("firstname");
                String surname = rs.getString("surname");
                int patientNum = rs.getInt("PatientNumber");
                names[i] = "Patient ID:" + patientNum + " " + name + " " + surname;
                i++;
                patientList.setListData(names);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in SQL query");
        }
    }
    String Criteria = "firstname";

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Logo = new javax.swing.JButton();
        PasswordField = new javax.swing.JPasswordField();
        searchLabel = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        titleLabel = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        scrollLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        patientList = new javax.swing.JList<>();
        filterInput = new javax.swing.JTextField();
        criteriaButton = new javax.swing.JButton();
        instructionLabel1 = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        filterButton1 = new javax.swing.JButton();
        newPatientButton = new javax.swing.JButton();

        Logo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Pictures\\2023-05-13.png")); // NOI18N

        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });

        searchLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        searchLabel.setText("Type In The Patient's Fullname");

        jToggleButton1.setText("jToggleButton1");

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frame2"); // NOI18N
        setUndecorated(true);
        setSize(new java.awt.Dimension(526, 350));

        titleLabel.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        titleLabel.setText("Digital Patient Acess Terminal");

        searchButton.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        scrollLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        scrollLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scrollLabel.setText("List Of Patients");

        patientList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(patientList);

        filterInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filterInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterInputActionPerformed(evt);
            }
        });

        criteriaButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        criteriaButton.setText("Change Search Criteria");
        criteriaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criteriaButtonActionPerformed(evt);
            }
        });

        instructionLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        instructionLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        instructionLabel1.setText("Search Criteria: Firstname");

        logoutButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Pictures\\logoutIcon.png")); // NOI18N
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        filterButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filterButton1.setText("Apply Filter");
        filterButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButton1ActionPerformed(evt);
            }
        });

        newPatientButton.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        newPatientButton.setText("Add Patient");
        newPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPatientButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(titleLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(criteriaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(instructionLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(logoutButton)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(searchButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newPatientButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(filterButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filterInput, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(titleLabel)
                .addGap(2, 2, 2)
                .addComponent(criteriaButton)
                .addGap(2, 2, 2)
                .addComponent(instructionLabel1)
                .addGap(6, 6, 6)
                .addComponent(filterInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollLabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newPatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(logoutButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        String selected = patientList.getSelectedValue();
        new Screen3().setVisible(true);
        dispose();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void filterInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterInputActionPerformed

    private void criteriaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criteriaButtonActionPerformed
        // TODO add your handling code here:

        if (Criteria=="firstname") {
            instructionLabel1.setText("Search Criteria: Surname");
            Criteria = "surname";
        } else if (Criteria=="surname") {
            instructionLabel1.setText("Search Criteria: Address");
            Criteria = "address";
        } else if (Criteria=="address") {
            instructionLabel1.setText("Search Criteria: Phone Number");
            Criteria = "phoneNumber";
        } else if (Criteria=="phoneNumber") {
            instructionLabel1.setText("Search Criteria: Date Of Birth");
            Criteria = "dateOfBirth";
        } else if (Criteria=="dateOfBirth") {
            instructionLabel1.setText("Search Criteria: Firstname");
            Criteria = "firstname";
        }

    }//GEN-LAST:event_criteriaButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        new Screen1().setVisible(true);
        dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void newPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPatientButtonActionPerformed
        // TODO add your handling code here
        new Screen4().setVisible(true);
        dispose();

    }//GEN-LAST:event_newPatientButtonActionPerformed

    private void filterButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButton1ActionPerformed
        // TODO add your handling code here:
               String query2 = "select firstname, surname, PatientNumber FROM Patient WHERE "+Criteria+" LIKE '%"+filterInput.getText()+"%'ORDER BY firstname;";
        try {
            ResultSet rs = DBConnector.read(query2);
            
            String[] names = new String[9999];
            int i = 0;
            while(rs.next()){
                String name = rs.getString("firstname");
                String surname = rs.getString("surname");
                int patientNum = rs.getInt("PatientNumber");
                names[i] ="Patient ID:"+patientNum+" "+name+ " "+surname;
                i++;
                patientList.setListData(names);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error in SQL query");
        }
    }//GEN-LAST:event_filterButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            DBConnector.init();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Could not find DB driver");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Could not connect to db");
        }

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
            java.util.logging.Logger.getLogger(Screen2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Screen2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Screen2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Screen2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Screen2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logo;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton criteriaButton;
    private javax.swing.JButton filterButton1;
    private javax.swing.JTextField filterInput;
    private javax.swing.JLabel instructionLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton newPatientButton;
    private javax.swing.JList<String> patientList;
    private javax.swing.JLabel scrollLabel;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
