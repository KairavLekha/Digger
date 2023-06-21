/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DIT;

import DB.DBConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
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
public class Patients extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Patients() {
        initComponents();
             ImageIcon pic = new ImageIcon("pulseNew.png");
            this.setIconImage(pic.getImage());
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

        titleLabel = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        scrollLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        patientList = new javax.swing.JList<>();
        filterInput = new javax.swing.JTextField();
        criteriaButton = new javax.swing.JButton();
        instructionLabel1 = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        newPatientButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        viewButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(526, 350));

        titleLabel.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        titleLabel.setText("Doctor Information Terminal");

        editButton.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        scrollLabel.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        scrollLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scrollLabel.setText("List Of Patients");

        patientList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(patientList);

        filterInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filterInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterInputKeyReleased(evt);
            }
        });

        criteriaButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        criteriaButton.setText("Change Search Criteria");
        criteriaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criteriaButtonActionPerformed(evt);
            }
        });

        instructionLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        instructionLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        instructionLabel1.setText("Search Criteria: Firstname");

        logoutButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Pictures\\logoutIcon.png")); // NOI18N
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        newPatientButton.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        newPatientButton.setText("Add Patient");
        newPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPatientButtonActionPerformed(evt);
            }
        });

        viewButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        viewButton.setText("Consult");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(logoutButton)
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(editButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(viewButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newPatientButton))
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(scrollLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(criteriaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(instructionLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filterInput, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(146, 146, 146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(86, 86, 86))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(logoutButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(titleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(criteriaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(instructionLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filterInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(viewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(newPatientButton)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        String selected = patientList.getSelectedValue();
        new UpdateInformation().setVisible(true);
        dispose();
    }//GEN-LAST:event_editButtonActionPerformed

    

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
        new Home().setVisible(true);
        dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void newPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPatientButtonActionPerformed
        // TODO add your handling code here
        new AddPatient().setVisible(true);
        dispose();

    }//GEN-LAST:event_newPatientButtonActionPerformed

    private void filterInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterInputKeyReleased
        // TODO add your handling code here:
                String query2 = "select firstname, surname, PatientNumber FROM Patient WHERE "+Criteria+" LIKE '%"+filterInput.getText()+"%'ORDER BY firstname;";
        try {
            ResultSet rs = DBConnector.read(query2);
            
            String[] names = new String[2144444444];
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
    }//GEN-LAST:event_filterInputKeyReleased

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Patients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patients().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton criteriaButton;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField filterInput;
    private javax.swing.JLabel instructionLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton newPatientButton;
    private javax.swing.JList<String> patientList;
    private javax.swing.JLabel scrollLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
}
