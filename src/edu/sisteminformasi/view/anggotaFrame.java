/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sisteminformasi.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Jemmy
 */
public class anggotaFrame extends javax.swing.JFrame {

    /**
     * Creates new form anggotaFrame
     */
     koneksi dbsetting;
    String driver, database, user, pass;
    Object tabel;
    String kode_ubah, judul_ubah, tahun_ubah, edisi_ubah, banyak_ubah, penerbit_ubah, pengarang_ubah;
    
    public anggotaFrame() {
        initComponents();
        
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        tbl_anggota.setModel(tableBuku);
        
        settableloadbuku();
        login2.setVisible(false);
        
    }
    
    
   private javax.swing.table.DefaultTableModel tableBuku = getDefaultTableBuku();
    
   private javax.swing.table.DefaultTableModel getDefaultTableBuku()
   {
        //membuat judul header
        return new javax.swing.table.DefaultTableModel
        (
            new Object [] [] {},
            new String [] {"Kode Buku",
                           "Judul Buku",
                           "Nama Penerbit",
                           "Edisi",
                           "Tahun Masuk",
                           "Stock",
                           "Nama Pengarang" } 
                            
        
        )
        // disable perubahan pada grid
        {
            boolean[] canEdit = new boolean[]
            {
                false, false, false, false, false, false, false
            };
            
            public boolean isCellEditable( int rowIndex, int columnIndex)
            {
                return canEdit[columnIndex];
            }        
        
        };        
    
    
    }
   
   
    String data_buku[] = new String[7];
    private void settableloadbuku()
    {
        String stat = "";
        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            
            Statement stt = kon.createStatement();
            String SQL = "select* from buku";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next())
            {
                data_buku[0] = res.getString(1);
                data_buku[1] = res.getString(2);
                data_buku[2] = res.getString(3);
                data_buku[3] = res.getString(4);
                data_buku[4] = res.getString(5);
                data_buku[5] = res.getString(6);
                data_buku[6] = res.getString(7);
                tableBuku.addRow(data_buku);
                
            }
            res.close();
            stt.close();
            kon.close();
        }
        catch (Exception ex)
        {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            
            System.exit(0);
        }
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_anggota = new javax.swing.JTable();
        cmb_cari = new javax.swing.JComboBox<>();
        txt_cari = new javax.swing.JTextField();
        login2 = new javax.swing.JLabel();
        login1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_anggota.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_anggota);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 600, 307));

        cmb_cari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Judul Buku", "Pengarang", "Penerbit" }));
        jPanel1.add(cmb_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 131, -1));

        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
        });
        jPanel1.add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 234, -1));

        login2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/sisteminformasi/view/logintombol22.png"))); // NOI18N
        login2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login2MouseClicked(evt);
            }
        });
        jPanel1.add(login2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, -1));

        login1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/sisteminformasi/view/logintombol1.png"))); // NOI18N
        login1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                login1MouseExited(evt);
            }
        });
        jPanel1.add(login1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/sisteminformasi/view/bgpencarian.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
        // TODO add your handling code here:
         //menghapus seluruh isi data dalam jtable
        tableBuku.setRowCount(0);
        
        //inisialisasi combo box
        int pilihan = cmb_cari.getSelectedIndex();
        String SQL="";
        switch(pilihan){
            case(0) :
                SQL = "SELECT * FROM `buku` WHERE judul LIKE '%"+txt_cari.getText()+"%'";
            break;
            case (1) :
                SQL = "SELECT * FROM `buku` WHERE nama_pengarang LIKE '%"+txt_cari.getText()+"%'";
            break;
            case (2) :
                SQL = "SELECT * FROM `buku` WHERE penerbit LIKE '%"+txt_cari.getText()+"%'";
            break;    
        
        }
        
        //gunakan query untuk mencari
        try 
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();          
            ResultSet res = stt.executeQuery(SQL);
            while(res.next())
            {
                data_buku[0] = res.getString(1);
                data_buku[1] = res.getString(2);
                data_buku[2] = res.getString(3);
                data_buku[3] = res.getString(4);
                data_buku[4] = res.getString(5);
                data_buku[5] = res.getString(6);
                data_buku[6] = res.getString(7);
                tableBuku.addRow(data_buku);
            }
            res.close();
            stt.close();
            kon.close();
        } catch (Exception ex) 
        {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);  
        };  
    }//GEN-LAST:event_txt_cariKeyReleased

    private void login1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login1MouseEntered
        // TODO add your handling code here:
        login1.setVisible(false);
        login2.setVisible(true);
    }//GEN-LAST:event_login1MouseEntered

    private void login1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login1MouseExited
        // TODO add your handling code here:
        login2.setVisible(false);
        login1.setVisible(true);
    }//GEN-LAST:event_login1MouseExited

    private void login2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login2MouseClicked
        // TODO add your handling code here:
        anggotaFrame r = new anggotaFrame();
        
        login l = new login();
        l.setVisible(true);
        r.dispose();
    }//GEN-LAST:event_login2MouseClicked

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
            java.util.logging.Logger.getLogger(anggotaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(anggotaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(anggotaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(anggotaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new anggotaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_cari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel login1;
    private javax.swing.JLabel login2;
    private javax.swing.JTable tbl_anggota;
    private javax.swing.JTextField txt_cari;
    // End of variables declaration//GEN-END:variables
}
