
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class FRiwayat extends javax.swing.JFrame {
    Statement st;
    ResultSet rs;
    koneksi koneksi;
    //variabel Report
    JasperReport JasRep;
    JasperPrint JasPri;
    Map param =new HashMap();
    JasperDesign JasDes;
    /**
     * Creates new form FRiwayat
     */
    public FRiwayat() {
        koneksi = new koneksi();
        initComponents();
        load_data();
        dokter();
        pasien();
    }

    public void dokter(){
        try{
            st=koneksi.con.createStatement();
            String query = "SELECT * FROM tbl_dokter";
            rs = st.executeQuery(query);
            while (rs.next()){
                dokter.addItem(rs.getString("id_dokter"));
            }
            rs.close();
        }
        catch(SQLException e){
        }
    }
    public void pasien(){
        try{
            st=koneksi.con.createStatement();
            String query = "SELECT * FROM tbl_pasien";
            rs = st.executeQuery(query);
            while (rs.next()){
                pasien.addItem(rs.getString("id_pasien"));
            }
            rs.close();
        }
        catch(SQLException e){
        }
    }
    private void load_data()
    {
        Object header[]={"NO","ID PASIEN","ID DOKTER","JENIS PENYAKIT"};
        DefaultTableModel data = new DefaultTableModel(null,header);
        tabelriwayat.setModel(data);
         String sql="SELECT riwayat_penyakit.no, tbl_pasien.id_pasien,"
                + " tbl_dokter.id_dokter,"
                + "riwayat_penyakit.jenis_penyakit FROM riwayat_penyakit "
                + "INNER JOIN tbl_pasien ON "
                + "riwayat_penyakit.id_pasien=tbl_pasien.id_pasien "
                + "INNER JOIN tbl_dokter ON riwayat_penyakit.id_dokter=tbl_dokter.id_dokter;";
        try{
            st=koneksi.con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next())
            {
                String k1=rs.getString(1);
                String k2=rs.getString(2);
                String k3=rs.getString(3);
                String k4=rs.getString(4);
                
                String k[]={k1,k2,k3,k4};
                data.addRow(k);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void input_data()
    {
        try{
            st=koneksi.con.createStatement();
            String pasien1="";
            String query="SELECT id_pasien FROM tbl_pasien WHERE id_pasien='"+
                    pasien.getSelectedItem()+"'";
            rs=st.executeQuery(query);
            if(rs.next()){
                pasien1=rs.getString("id_pasien");
            }
            String dokter1="";
            String query1="SELECT id_dokter FROM tbl_dokter WHERE id_dokter='"+
                    dokter.getSelectedItem()+"'";
            rs=st.executeQuery(query1);
            if(rs.next()){
                dokter1=rs.getString("id_dokter");
            }
            String sql="INSERT INTO riwayat_penyakit values('"+no.getText()
                    +"','"+pasien1
                    +"','"+dokter1
                    +"','"+jenis.getText()
                    +"')";
            st.execute(sql);
            JOptionPane.showMessageDialog(null, "Data Barang Berhasil Dimasukkan");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void Edit(){
        try{
            st=koneksi.con.createStatement();
            String pasien1="";
            String query="SELECT id_pasien FROM tbl_pasien WHERE id_pasien='"+
                    pasien.getSelectedItem()+"'";
            rs=st.executeQuery(query);
            if(rs.next()){
                pasien1=rs.getString("id_pasien");
            }
            String dokter1="";
            String query1="SELECT id_dokter FROM tbl_dokter WHERE id_dokter='"+
                    dokter.getSelectedItem()+"'";
            rs=st.executeQuery(query1);
            if(rs.next()){
                dokter1=rs.getString("id_dokter");
            }
            String sql_edit="UPDATE riwayat_penyakit SET no='"+no.getText()
                    +"',id_pasien='"+pasien1
                    +"',id_dokter='"+dokter1
                    +"',jenis_penyakit='"+jenis.getText()
                    +"'WHERE no='"+no.getText()+"'";
            st.executeUpdate(sql_edit);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Update");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void Hapus(){
        try{
            st = koneksi.con.createStatement();
            String sql_delete = "DELETE FROM riwayat_penyakit "
                    + "WHERE no='"+no.getText()+"'";
            st.execute(sql_delete);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        no = new javax.swing.JTextField();
        jenis = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        report = new javax.swing.JButton();
        pasien = new javax.swing.JComboBox();
        dokter = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelriwayat = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Data Riwayat Penyakit");

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("No");

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ID Pasien");

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ID Dokter");

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Jenis Penyakit");

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Save-icon.png"))); // NOI18N
        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit-validated-icon.png"))); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button-icon-png-favpng-uaphFJ8yTGuRHRCD7WkRVv0mL.jpg"))); // NOI18N
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        report.setText("Report Data Riwayat Penyakit");
        report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(simpan)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(edit)
                .add(18, 18, 18)
                .add(hapus)
                .add(83, 83, 83))
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(66, 66, 66)
                        .add(jLabel8))
                    .add(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel9)
                            .add(jLabel10)
                            .add(jLabel11))
                        .add(55, 55, 55)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(no)
                            .add(jenis)
                            .add(pasien, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(dokter, 0, 143, Short.MAX_VALUE)))
                    .add(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel12))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(52, 52, 52)
                        .add(report)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel8)
                        .add(35, 35, 35)
                        .add(jLabel9))
                    .add(no, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(24, 24, 24)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel10)
                            .add(pasien, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(jLabel11)
                        .add(18, 18, 18)
                        .add(jLabel12))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(dokter, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(jenis, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(29, 29, 29)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(simpan)
                    .add(edit)
                    .add(hapus))
                .add(18, 18, 18)
                .add(report)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        tabelriwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelriwayat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelriwayatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelriwayat);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 305, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 452, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 340, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        jMenu1.setText("Kembali");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu1MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MousePressed
        // TODO add your handling code here:
        new FUtama().show();
        this.dispose();
    }//GEN-LAST:event_jMenu1MousePressed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        input_data();
        new FRiwayat().setVisible(true);
    }//GEN-LAST:event_simpanActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        Edit();
        new FRiwayat().setVisible(true);
    }//GEN-LAST:event_editActionPerformed

    private void tabelriwayatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelriwayatMouseClicked
        // TODO add your handling code here:
        int bar = tabelriwayat.getSelectedRow();
        // TODO add your handling code here:
        String a = tabelriwayat.getValueAt(bar, 0).toString();
        String b = tabelriwayat.getValueAt(bar, 1).toString();
        String c = tabelriwayat.getValueAt(bar, 2).toString();
        String d = tabelriwayat.getValueAt(bar, 3).toString();
        
        no.setText(a);
        pasien.setSelectedItem(b);
        dokter.setSelectedItem(c);
        jenis.setText(d);
        //set disable button
        no.setEditable(false);
        simpan.setEnabled(false);
        edit.setEnabled(true);
        hapus.setEnabled(true); 
    }//GEN-LAST:event_tabelriwayatMouseClicked

    private void reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportActionPerformed
        // TODO add your handling code here:
        try {
            //File file = new File("reportRiwayat.jrxml");
            InputStream file = getClass().getResourceAsStream("reportRiwayat.jrxml");
            JasDes = JRXmlLoader.load(file);
            param.clear();
            JasRep = JasperCompileManager.compileReport(JasDes);
            JasPri = JasperFillManager.fillReport(JasRep, param, koneksi.con);
            JasperViewer.viewReport(JasPri, false);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_reportActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        Hapus();
        new FRiwayat().setVisible(true);
    }//GEN-LAST:event_hapusActionPerformed

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
            java.util.logging.Logger.getLogger(FRiwayat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRiwayat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRiwayat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRiwayat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRiwayat().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox dokter;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jenis;
    private javax.swing.JTextField no;
    private javax.swing.JComboBox pasien;
    private javax.swing.JButton report;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabelriwayat;
    // End of variables declaration//GEN-END:variables
}
