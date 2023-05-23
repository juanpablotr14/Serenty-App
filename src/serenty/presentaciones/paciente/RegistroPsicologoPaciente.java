/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package serenty.presentaciones.paciente;

import serenty.presentaciones.psicologo.*;
import serenty.clases.ConexionDB;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import serenty.clases.ConsultasDB;

/**
 *
 * @author User
 */
public class RegistroPsicologoPaciente extends javax.swing.JInternalFrame {
    ConexionDB connection = new ConexionDB ();
    Connection cn = connection.conectar();
       
    /**
     * Creates new form ADMINISTRADORP
     */
    public RegistroPsicologoPaciente() {
        initComponents();
        MostrarDatosPsicologos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void MostrarDatosPsicologos (){
        DefaultTableModel tPsico = new DefaultTableModel ();
        tPsico.addColumn("NÚMERO ID");
        tPsico.addColumn("TIPO DE ID");
        tPsico.addColumn("NOMBRE");
        tPsico.addColumn("APELLIDO");
        tPsico.addColumn("TELEFONO");
        tPsico.addColumn("GENERO");
        tPsico.addColumn("ENTIDAD");
        tPsico.addColumn("ESPECIALIDAD");
        tablaPsico.setModel(tPsico);

        String [] datos =new String[10];
         
        try {
            
            PreparedStatement preparedStatement = (PreparedStatement) cn.prepareStatement(ConsultasDB.SELECT_SOME_PSICOLOGO_DOS);
            ResultSet resultado = preparedStatement.executeQuery();

            while(resultado.next()){
                
                datos[0] = resultado.getString("ID_PSICOLOGO");
                datos[1] = resultado.getString("TIPOID_PSICOLOGO");
                datos[2] = resultado.getString("NOMBRE_PSICOLOGO");
                datos[3] = resultado.getString("APELLIDO_PSICOLOGO");
                datos[4] = resultado.getString("TELEFONO_PSICOLOGO");
                datos[5] = resultado.getString("GENERO_PSICOLOGO");
                datos[6] = resultado.getString("TIPOENT_PSICOLOGO");
                datos[7] = resultado.getString("ESPECIALIDAD_PSICOLOGO");

                tPsico.addRow(datos);
                
            }

            tablaPsico.setModel(tPsico);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }       
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPsico = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        tablaPsico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaPsico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPsicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPsico);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jLabel20.setFont(new java.awt.Font("mariana", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(241, 229, 199));
        jLabel20.setText("REGISTRO DE PACIENTES");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel20)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void tablaPsicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPsicoMouseClicked

    }//GEN-LAST:event_tablaPsicoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPsico;
    // End of variables declaration//GEN-END:variables
}
