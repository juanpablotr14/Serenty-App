/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package serenty.presentaciones.psicologo;

import serenty.clases.ConexionDB;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import serenty.clases.ConsultasDB;
import serenty.clases.UsuarioActivo;

/**
 *
 * @author User
 */
public class CitasPendientesPsicologo extends javax.swing.JInternalFrame {
    ConexionDB connection = new ConexionDB ();
    Connection cn = connection.conectar();
    
    
    /**
     * Creates new form ADMINISTRADORP
     */
    public CitasPendientesPsicologo() {
        initComponents();
        MostrarCitas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void MostrarCitas (){
        DefaultTableModel tCitas = new DefaultTableModel ();
        tCitas.addColumn("ID");
        tCitas.addColumn("NOMBRE");
        tCitas.addColumn("APELLIDO");
        tCitas.addColumn("FECHA");
        tCitas.addColumn("HORA");
        tCitas.addColumn("MODALIDAD");
        tCitas.addColumn("DIRECCIÓN");
        tCitas.addColumn("ESTADO");

        citasPendientes.setModel(tCitas);

        String [] datos =new String[8];
         
        try {
            
            UsuarioActivo idUsuario = UsuarioActivo.getInstance();
            
            PreparedStatement psConsultaPsicologo = (PreparedStatement) cn.prepareStatement(String.format(ConsultasDB.SELECT_IDPSICOLOGO_IDUSUARIO, String.valueOf(idUsuario.getIdUsuario())));
            ResultSet rsConsultaPsicologo = psConsultaPsicologo.executeQuery();
            rsConsultaPsicologo.next();
            
            String idPsicologo = rsConsultaPsicologo.getString("ID_PSICOLOGO");
            
            PreparedStatement psCitas = (PreparedStatement) cn.prepareStatement(String.format(ConsultasDB.SELECT_CITA_IDPSICOLOGO, idPsicologo));
            ResultSet rsCitas = psCitas.executeQuery();

            while(rsCitas.next()){
                
                datos[0] = rsCitas.getString("ID_CITA");
                datos[1] = rsCitas.getString("NOMBRE_PACIENTE");
                datos[2] = rsCitas.getString("APELLIDO_PACIENTE");
                datos[3] = rsCitas.getString("FECHA_CITA");
                datos[4] = rsCitas.getString("HORA_CITA");
                datos[5] = rsCitas.getString("MODALIDAD_CITA");
                datos[6] = rsCitas.getString("DIRECCION_CITA");
                datos[7] = rsCitas.getString("ESTADO_CITA");

                tCitas.addRow(datos);
                    
            }

            citasPendientes.setModel(tCitas);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }       
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        citasPendientes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        citasPendientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        citasPendientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                citasPendientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(citasPendientes);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jLabel20.setFont(new java.awt.Font("mariana", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(241, 229, 199));
        jLabel20.setText("Citas Agendadas");

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
    
    private void citasPendientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_citasPendientesMouseClicked

    }//GEN-LAST:event_citasPendientesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable citasPendientes;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
