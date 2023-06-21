/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DIT;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Kairav
 */
public class AddPatient extends javax.swing.JFrame {


    /*
     * Creates new form Screen1
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
    public AddPatient() {
        initComponents();
            ImageIcon pic = new ImageIcon("pulseNew.png");
            this.setIconImage(pic.getImage());
        
        setSize(526, 355);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        firstnameField = new javax.swing.JTextField();
        DOBfield = new javax.swing.JTextField();
        numberField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        numberLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        visitLabel = new javax.swing.JLabel();
        visitField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        surnameField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        medicalField = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        AddressField = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        titleLabel.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        titleLabel.setText("Doctor Information Terminal");

        backButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kairav\\OneDrive\\Pictures\\logoutIcon.png")); // NOI18N
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        firstnameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        DOBfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DOBfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DOBfieldActionPerformed(evt);
            }
        });

        numberField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameLabel.setText("Name:");

        dateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateLabel.setText("Date Of Birth:");

        addressLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addressLabel.setText("Address:");

        numberLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        numberLabel.setText("Phone Number:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Medical Conditions:");

        visitLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        visitLabel.setText("Consults:");

        visitField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        visitField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visitFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Patient Information");
        jLabel2.setOpaque(true);

        editButton.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        editButton.setText("Add Patient");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Surname:");

        surnameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        medicalField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(medicalField);

        jScrollPane4.setViewportView(AddressField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(dateLabel)
                                        .addGap(3, 3, 3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(addressLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DOBfield)
                                    .addComponent(firstnameField)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(numberLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(numberField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(visitLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(visitField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton)
                        .addGap(156, 156, 156)
                        .addComponent(editButton)))
                .addGap(0, 45, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel)
                    .addComponent(jLabel3)
                    .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DOBfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateLabel)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4)
                            .addComponent(addressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(visitLabel)
                            .addComponent(visitField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
         new Home().setVisible(true);
         dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void visitFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visitFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_visitFieldActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editButtonActionPerformed

    private void DOBfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DOBfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DOBfieldActionPerformed

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
                new UpdateInformation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane AddressField;
    private javax.swing.JTextField DOBfield;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField firstnameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane medicalField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField numberField;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField visitField;
    private javax.swing.JLabel visitLabel;
    // End of variables declaration//GEN-END:variables
}
