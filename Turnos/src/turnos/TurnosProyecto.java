/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnos;

/**
 *
 * @author Administrador
 */
public class TurnosProyecto extends javax.swing.JFrame {

    /**
     * Creates new form TurnosPoryecto
     */
    public TurnosProyecto() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGenerarTurno = new javax.swing.JButton();
        btnModificarTurno = new javax.swing.JButton();
        btnEliminarTurno = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGenerarTurno.setBackground(new java.awt.Color(0, 153, 153));
        btnGenerarTurno.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnGenerarTurno.setForeground(new java.awt.Color(0, 153, 153));
        btnGenerarTurno.setText("GENERAR TURNO");
        btnGenerarTurno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGenerarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarTurnoActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerarTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 131, -1));

        btnModificarTurno.setBackground(new java.awt.Color(0, 153, 153));
        btnModificarTurno.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnModificarTurno.setForeground(new java.awt.Color(0, 153, 153));
        btnModificarTurno.setText("MODIFICAR TURNO");
        btnModificarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarTurnoActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificarTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 144, -1));

        btnEliminarTurno.setBackground(new java.awt.Color(0, 153, 153));
        btnEliminarTurno.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnEliminarTurno.setForeground(new java.awt.Color(0, 153, 153));
        btnEliminarTurno.setText("ELIMINAR TURNO");
        btnEliminarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTurnoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminarTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 150, -1));

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("SISTEMA DE TURNOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 300, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarTurnoActionPerformed
        // TODO add your handling code here:
        new GenerarTurno().setVisible(true);
    }//GEN-LAST:event_btnGenerarTurnoActionPerformed

    private void btnModificarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarTurnoActionPerformed
        // TODO add your handling code here:
        new ModificarTurno().setVisible(true);
    }//GEN-LAST:event_btnModificarTurnoActionPerformed

    private void btnEliminarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTurnoActionPerformed
        // TODO add your handling code here:
        new EliminarTurno().setVisible(true);
    }//GEN-LAST:event_btnEliminarTurnoActionPerformed

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
            java.util.logging.Logger.getLogger(TurnosProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TurnosProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TurnosProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TurnosProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TurnosProyecto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarTurno;
    private javax.swing.JButton btnGenerarTurno;
    private javax.swing.JButton btnModificarTurno;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}