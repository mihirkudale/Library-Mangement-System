/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LibraryMainFramee.java
 *
 * Created on Nov 7, 2017, 12:41:19 PM
 */
package gui;

/**
 *
 * @author yatinVM
 */
public class LibraryMainFramee extends javax.swing.JFrame {

    /** Creates new form LibraryMainFramee */
    public LibraryMainFramee() {
        initComponents();
        
//        this.setSize(760, 620);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbLiberianLogin = new javax.swing.JLabel();
        lbAdminLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lb.jpg"))); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        lbLiberianLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ad.jpg"))); // NOI18N
        lbLiberianLogin.setName("lbLiberianLogin"); // NOI18N
        lbLiberianLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLiberianLoginMouseClicked(evt);
            }
        });

        lbAdminLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lbr.jpg"))); // NOI18N
        lbAdminLogin.setName("lbAdminLogin"); // NOI18N
        lbAdminLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAdminLoginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbAdminLogin)
                        .addGap(126, 126, 126)
                        .addComponent(lbLiberianLogin)
                        .addGap(62, 62, 62))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbAdminLogin)
                    .addComponent(lbLiberianLogin))
                .addGap(24, 24, 24))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void lbLiberianLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLiberianLoginMouseClicked
// TODO add your handling code here:
    LibrarianLogin.viewLibrarianLogin();
    this.dispose();
}//GEN-LAST:event_lbLiberianLoginMouseClicked

private void lbAdminLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAdminLoginMouseClicked
// TODO add your handling code here:
    AdminLogin.viewAdminLogin();
    this.dispose();
}//GEN-LAST:event_lbAdminLoginMouseClicked

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LibraryMainFramee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibraryMainFramee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibraryMainFramee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibraryMainFramee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                LibraryMainFramee libmain=new LibraryMainFramee();
                libmain.setVisible(true);
                libmain.setLocationRelativeTo(null);
                libmain.setSize(680, 520);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAdminLogin;
    private javax.swing.JLabel lbLiberianLogin;
    // End of variables declaration//GEN-END:variables
}
