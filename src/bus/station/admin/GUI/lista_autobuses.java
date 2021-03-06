/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.station.admin.GUI;

import bus.station.admin.GUI.FORMS.ConexionPostgres;
import bus.station.admin.GUI.FORMS.Agregar_autobus;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Rivel
 */
public class lista_autobuses extends javax.swing.JFrame {

    /**
     * Creates new form lista_autobuses
     */
    String SQL;
    String au[];
    public lista_autobuses(String sql) {
        SQL=sql;
        initComponents();
        this.setLocationRelativeTo(null);
        ConexionPostgres c = new ConexionPostgres();
        c.Conectar();
        String[] nombres=c.consultaA(sql);
        au=nombres;
        DefaultListModel modelo = new DefaultListModel();
        for(int i = 0; i<nombres.length; i++){
            
                modelo.addElement(nombres[i]);
        }
        this.jList1.setModel(modelo);
    }

    private lista_autobuses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ver_datos_Autobus = new javax.swing.JButton();
        agregar_Autobus_Button = new javax.swing.JButton();
        jList1 = new javax.swing.JList<>();
        volver_Datos_Terminal = new javax.swing.JButton();
        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ver_datos_Autobus.setText("MOSTRAR DATOS COMPLETOS DEL AUTOBUS");
        ver_datos_Autobus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ver_datos_AutobusActionPerformed(evt);
            }
        });

        agregar_Autobus_Button.setText("AGREGAR NUEVO AUTOBUS");
        agregar_Autobus_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_Autobus_ButtonActionPerformed(evt);
            }
        });

        jList1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "AUTOBUS #1", "AUTOBUS #2", "AUTOBUS #3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setMaximumSize(new java.awt.Dimension(48, 48));

        volver_Datos_Terminal.setText("Atras");
        volver_Datos_Terminal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volver_Datos_TerminalActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AUTOBUSES");

        jButton4.setText("ELIMINAR AUTOBUS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(volver_Datos_Terminal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ver_datos_Autobus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(agregar_Autobus_Button))
                            .addComponent(jList1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(volver_Datos_Terminal)
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(jList1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar_Autobus_Button)
                    .addComponent(ver_datos_Autobus)
                    .addComponent(jButton4))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volver_Datos_TerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volver_Datos_TerminalActionPerformed
         lista_terminales LT = new lista_terminales();
        LT.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_volver_Datos_TerminalActionPerformed

    private void ver_datos_AutobusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ver_datos_AutobusActionPerformed
        
       if(this.jList1.getSelectedIndex()>=0){
        datos_autobus DA = new datos_autobus("select * from autobus where placas='"+this.jList1.getSelectedValue()+"'");
        DA.setVisible(true);
        this.setVisible(false);
       }else{
           JOptionPane.showMessageDialog(null, "Selecciona un autobus");
       }
    }//GEN-LAST:event_ver_datos_AutobusActionPerformed

    private void agregar_Autobus_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_Autobus_ButtonActionPerformed
        Agregar_autobus AAutobus = new Agregar_autobus();
        AAutobus.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_agregar_Autobus_ButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(this.jList1.getSelectedIndex()>=0){
        ConexionPostgres c = new ConexionPostgres();
        c.Conectar();
        c.eliminarAutobus(this.jList1.getSelectedValue());
        }else{
            JOptionPane.showMessageDialog(null, "Selecciona un autobus");}
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(lista_autobuses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lista_autobuses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lista_autobuses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lista_autobuses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lista_autobuses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar_Autobus_Button;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JButton ver_datos_Autobus;
    private javax.swing.JButton volver_Datos_Terminal;
    // End of variables declaration//GEN-END:variables
}
