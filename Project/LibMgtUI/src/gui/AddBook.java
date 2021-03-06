/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LibrarianRegistrationn.java
 *
 * Created on Nov 7, 2017, 12:31:00 PM
 */
package gui;

//import daoo.DaoConnection;
import dao.BookDao;
import dao.DB;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
//import liverecognition.LiveRecognitionApp;
//import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author yatinVM
 */
public class AddBook extends javax.swing.JFrame {

    /**
     * Creates new form LibrarianRegistrationn
     */
    Frame frm;
//    DaoConnection dc = new DaoConnection();
    Connection conn;
    String new_trans_id = "";
    int unused_trans_id = -1;
    int id = 0;
    public static int btnView = 0;
    
    public AddBook(Frame frm) {
        initComponents();
        this.frm = frm;
//        frm.setSize(625, 520);

        conn = DB.getConnection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfAuthorName = new javax.swing.JTextField();
        tfPublisher = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfBookname = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tfCellNo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfQuantity = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btnRegister = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setName("jPanel5"); // NOI18N
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel4.setMaximumSize(new java.awt.Dimension(464, 648));
        jPanel4.setName("jPanel4"); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(464, 648));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Book Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SimSun", 1, 14))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Book Name :");
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Author Name :");
        jLabel6.setName("jLabel6"); // NOI18N

        tfAuthorName.setCaretColor(new java.awt.Color(0, 102, 102));
        tfAuthorName.setMinimumSize(new java.awt.Dimension(40, 24));
        tfAuthorName.setName("tfAuthorName"); // NOI18N
        tfAuthorName.setPreferredSize(new java.awt.Dimension(280, 32));

        tfPublisher.setCaretColor(new java.awt.Color(0, 102, 102));
        tfPublisher.setMinimumSize(new java.awt.Dimension(40, 24));
        tfPublisher.setName("tfPublisher"); // NOI18N
        tfPublisher.setPreferredSize(new java.awt.Dimension(280, 32));
        tfPublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPublisherActionPerformed(evt);
            }
        });

        jLabel2.setText("Publisher :");
        jLabel2.setName("jLabel2"); // NOI18N

        tfBookname.setCaretColor(new java.awt.Color(0, 102, 102));
        tfBookname.setMinimumSize(new java.awt.Dimension(40, 24));
        tfBookname.setName("tfBookname"); // NOI18N
        tfBookname.setPreferredSize(new java.awt.Dimension(280, 32));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Quantity :");
        jLabel16.setName("jLabel16"); // NOI18N

        tfCellNo.setCaretColor(new java.awt.Color(0, 102, 102));
        tfCellNo.setMinimumSize(new java.awt.Dimension(40, 24));
        tfCellNo.setName("tfCellNo"); // NOI18N
        tfCellNo.setPreferredSize(new java.awt.Dimension(280, 32));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cell No.");
        jLabel5.setName("jLabel5"); // NOI18N

        tfQuantity.setCaretColor(new java.awt.Color(0, 102, 102));
        tfQuantity.setMinimumSize(new java.awt.Dimension(40, 24));
        tfQuantity.setName("tfQuantity"); // NOI18N
        tfQuantity.setPreferredSize(new java.awt.Dimension(280, 32));
        tfQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQuantityActionPerformed(evt);
            }
        });

        jLabel1.setText("ex. JAVA@1");
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel16)
                    .addComponent(jLabel5))
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfCellNo, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                    .addComponent(tfBookname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                    .addComponent(tfAuthorName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfPublisher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCellNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBookname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAuthorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setName("jPanel10"); // NOI18N

        btnRegister.setFont(new java.awt.Font("Sylfaen 18", 1, 12)); // NOI18N
        btnRegister.setText("Add Book");
        btnRegister.setName("btnRegister"); // NOI18N
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Sylfaen 18", 1, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.setMaximumSize(new java.awt.Dimension(100, 25));
        btnBack.setMinimumSize(new java.awt.Dimension(110, 25));
        btnBack.setName("btnBack"); // NOI18N
        btnBack.setPreferredSize(new java.awt.Dimension(110, 25));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("Book Information");

        jPanel5.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel7.setBackground(new java.awt.Color(26, 42, 57));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setName("jPanel7"); // NOI18N
        jPanel7.setPreferredSize(new java.awt.Dimension(861, 202));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(new java.awt.Font("Times New Roman 14", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/AddBookTi.png"))); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N
        jPanel7.add(jLabel7, java.awt.BorderLayout.PAGE_START);

        jPanel2.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
    // TODO add your handling code here:

//    DaoConnection dao = new DaoConnection();
    if (("".equals(tfBookname.getText())) || ("".equals(tfAuthorName.getText())) || ("".equals(tfCellNo.getText())) || ("".equals(tfQuantity.getText())) || ("".equals(tfPublisher.getText()))) {
        JOptionPane.showMessageDialog(null, "Please Enter All The Fields !!!");
    } else {
        
        Pattern pattern1 = Pattern.compile("^[a-zA-Z]+([\\s][a-zA-Z]+)*$");
        Matcher matcherFName = pattern1.matcher(tfBookname.getText().trim());
        
        Pattern pattern2 = Pattern.compile("^[a-zA-Z]+([\\s][a-zA-Z]+)*$");
        Matcher matcherAuthor = pattern2.matcher(tfAuthorName.getText().trim());
        
        Pattern pattern3 = Pattern.compile("^[a-zA-Z]+([\\s][a-zA-Z]+)*$");
        Matcher matcherPublisher = pattern3.matcher(tfPublisher.getText().trim());
        
        Pattern pattern4 = Pattern.compile("^[0-9]*$");
        Matcher matcherQuantity = pattern4.matcher(tfQuantity.getText().trim());
        
        if (!matcherPublisher.matches()) {
            JOptionPane.showMessageDialog(null, "Enter Valid Publisher Name !!!");
        } else if (!matcherFName.matches()) {
            JOptionPane.showMessageDialog(null, "Enter Valid Book Name  !!!");
        } else if (!matcherAuthor.matches()) {
            JOptionPane.showMessageDialog(null, "Enter Valid Author Name !!!");
        } else if (!matcherQuantity.matches()) {
            JOptionPane.showMessageDialog(null, "Enter Quantity in Numbers Only !!!");
        } else {
            
            String callno = tfCellNo.getText();
            String name = tfBookname.getText();
            String author = tfAuthorName.getText();
            String publisher = tfPublisher.getText();
            String squantity = tfQuantity.getText();
            int quantity = Integer.parseInt(squantity);
            int i = BookDao.save(callno, name, author, publisher, quantity);
            if (i > 0) {
                JOptionPane.showMessageDialog(this, "Books added successfully!");
                tfAuthorName.setText("");
                tfBookname.setText("");
                tfCellNo.setText("");
                tfPublisher.setText("");
                tfQuantity.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Sorry, unable to save!");
            }
        }
    }
}//GEN-LAST:event_btnRegisterActionPerformed

private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
    // TODO add your handling code here:
    LibrarianSuccesss adminfrm = new LibrarianSuccesss();
    adminfrm.setSize(750, 800);
    adminfrm.setVisible(true);
    adminfrm.setLocationRelativeTo(null);
    this.dispose();
}//GEN-LAST:event_btnBackActionPerformed

    private void tfQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfQuantityActionPerformed

    private void tfPublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPublisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPublisherActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(LibrarianRegistrationn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(LibrarianRegistrationn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(LibrarianRegistrationn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LibrarianRegistrationn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                new LibrarianRegistrationn().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    public javax.swing.JTextField tfAuthorName;
    public javax.swing.JTextField tfBookname;
    public javax.swing.JTextField tfCellNo;
    public javax.swing.JTextField tfPublisher;
    public javax.swing.JTextField tfQuantity;
    // End of variables declaration//GEN-END:variables
}
