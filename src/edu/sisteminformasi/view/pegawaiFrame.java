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
public class pegawaiFrame extends javax.swing.JFrame {

   //deklarasi variable
    koneksi dbsetting;
    String driver, database, user, pass;
    Object tabel;
    
    public pegawaiFrame() {
        initComponents();
        
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        tbl_anggota.setModel(tableAnggota);
        tbl_buku.setModel(tableBuku);
        tbl_karyawan.setModel(tablePegawai);
        
        
        //Visibilitas
        panelTambahAnggota.setVisible(false);
        lbl_cari.setVisible(false);
        txt_cari.setVisible(false);
        btn_batal.setVisible(false);
        lbl_cari_buku.setVisible(false);
        btn_batal_buku.setVisible(false);
        txt_cari_buku.setVisible(false);
        panelTambahBuku.setVisible(false);
        lbl_cari_karyawan.setVisible(false);
        txt_cari_karyawan.setVisible(false);
        btn_batal_karyawan.setVisible(false);
        
        //Enablelitas
        txt_judul_ubah.setEnabled(false);
        txt_pengarang_ubah.setEnabled(false);
        txt_penerbit_ubah.setEnabled(false);
        txt_tahun_buku_ubah.setEnabled(false);
        txt_banyak_buku_ubah.setEnabled(false);
        txt_edisi_ubah.setEnabled(false);
        txt_ubah_nama_pegawai.setEnabled(false);
        txt_ubah_alamat_pegawai.setEnabled(false);
        txt_ubah_tahun_pegawai.setEnabled(false);
        txt_ubah_telp_pegawai.setEnabled(false);
        
        
        
        settableloadanggota();
        settableloadbuku();
        settableloadpegawai();
    }

    
    @SuppressWarnings("unchecked")
    
     //Table Anggota
   private javax.swing.table.DefaultTableModel tableAnggota = getDefaultTableAnggota();
    
   private javax.swing.table.DefaultTableModel getDefaultTableAnggota()
   {
        //membuat judul header
        return new javax.swing.table.DefaultTableModel
        (
            new Object [] [] {},
            new String [] {"Nama Anggota",
                           "Jenis Kelamin",
                           "Alamat",
                           "Nomor Telepon",
                           "Tanggal Lahir"} 
                            
        
        )
        // disable perubahan pada grid
        {
            boolean[] canEdit = new boolean[]
            {
                false, false, false, false, false
            };
            
            public boolean isCellEditable( int rowIndex, int columnIndex)
            {
                return canEdit[columnIndex];
            }        
        
        };        
    
    
    } 
   
    String data_anggota[] = new String[5];
    private void settableloadanggota()
    {
        String stat = "";
        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            
            Statement stt = kon.createStatement();
            String SQL = "select nama_anggota, jk_anggota, alamat_anggota, no_telp_anggota, tanggal_lahir from anggota";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next())
            {
                data_anggota[0] = res.getString(1);
                data_anggota[1] = res.getString(2);
                data_anggota[2] = res.getString(3);
                data_anggota[3] = res.getString(4);
                data_anggota[4] = res.getString(5);
                tableAnggota.addRow(data_anggota);
                
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
    
   // Table Buku
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
    
    //Table Pegawai
     private javax.swing.table.DefaultTableModel tablePegawai = getDefaultTablePegawai();
    
   private javax.swing.table.DefaultTableModel getDefaultTablePegawai()
   {
        //membuat judul header
        return new javax.swing.table.DefaultTableModel
        (
            new Object [] [] {},
            new String [] {"Kode Pegawai",
                           "Nama Pegawai",
                           "Jenis Kelamin",
                           "Alamat",
                           "Nomor Telepon",
                           "Tahun Bekerja"} 
                            
        
        )
        // disable perubahan pada grid
        {
            boolean[] canEdit = new boolean[]
            {
                false, false, false, false, false, false
            };
            
            public boolean isCellEditable( int rowIndex, int columnIndex)
            {
                return canEdit[columnIndex];
            }        
        
        };        
    
    
    }
   
   
    String data_pegawai[] = new String[6];
    private void settableloadpegawai()
    {
        String stat = "";
        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            
            Statement stt = kon.createStatement();
            String SQL = "select* from pegawai";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next())
            {
                data_pegawai[0] = res.getString(1);
                data_pegawai[1] = res.getString(2);
                data_pegawai[2] = res.getString(3);
                data_pegawai[3] = res.getString(4);
                data_pegawai[4] = res.getString(5);
                data_pegawai[5] = res.getString(6);
                tablePegawai.addRow(data_pegawai);
                
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
   
   
    
    public void membersihkan_teks()
    {
        txt_nama_anggota.setText("");
        txt_tgl.setText("");
        txt_tlp.setText("");
        txt_alamat.setText("");
        txt_kode_buku.setText("");
        txt_penerbit.setText("");
        txt_pengarang.setText("");
        txt_judul.setText("");
        txt_tahun_buku.setText("");
        txt_banyak_buku.setText("");
        txt_edisi.setText("");
        txt_kode_buku_ubah.setText("");
        txt_judul_ubah.setText("");
        txt_penerbit_ubah.setText("");
        txt_pengarang_ubah.setText("");
        txt_tahun_buku_ubah.setText("");
        txt_banyak_buku_ubah.setText("");
        txt_edisi_ubah.setText("");
        txt_tambah_alamat_pegawai.setText("");
        txt_tambah_tahun_pegawai.setText("");
        txt_kode_pegawai_tambah.setText("");
        txt_nama_pegawai_tambah.setText("");
        txt_telp_tambah_pegawai.setText("");
        txt_ubah_kode_pegawai.setText("");
        txt_ubah_nama_pegawai.setText("");
        txt_ubah_alamat_pegawai.setText("");
        txt_ubah_tahun_pegawai.setText("");
        txt_ubah_telp_pegawai.setText("");
       
   }
    
    public void nonaktif_teks()
    {
        txt_nama_anggota.setEnabled(false);
        txt_tgl.setEnabled(false);
        txt_tlp.setEnabled(false);
        txt_alamat.setEnabled(false);
        txt_kode_buku.setEnabled(false);
        txt_judul.setEnabled(false);
        txt_tahun_buku.setEnabled(false);
        txt_penerbit.setEnabled(false);
        txt_pengarang.setEnabled(false);
        txt_banyak_buku.setEnabled(false);
        txt_edisi.setEnabled(false);
    }
    
     public void aktif_teks()
    {
        txt_nama_anggota.setEnabled(true);
        txt_tgl.setEnabled(true);
        txt_tlp.setEnabled(true);
        txt_alamat.setEnabled(true);
        txt_kode_buku.setEnabled(true);
        txt_judul.setEnabled(true);
        txt_tahun_buku.setEnabled(true);
        txt_penerbit.setEnabled(true);
        txt_pengarang.setEnabled(true);
        txt_banyak_buku.setEnabled(true);
        txt_edisi.setEnabled(true);
    }
     
  int row = 0;
    public void tampil_field_buku()
    {
        row = tbl_buku.getSelectedRow();
        txt_kode_buku_ubah.setText(tableBuku.getValueAt(row, 0).toString());
        txt_judul_ubah.setText(tableBuku.getValueAt(row, 1).toString());
        txt_tahun_buku_ubah.setText(tableBuku.getValueAt(row, 2).toString());
        txt_penerbit_ubah.setText(tableBuku.getValueAt(row, 3).toString());
        txt_pengarang_ubah.setText(tableBuku.getValueAt(row, 4).toString());
        txt_edisi_ubah.setText(tableBuku.getValueAt(row, 5).toString());
        txt_banyak_buku_ubah.setText(tableBuku.getValueAt(row, 6).toString());
        aktif_teks();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelKiri = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnBuku = new javax.swing.JButton();
        btnPengembalian = new javax.swing.JButton();
        btnPeminjaman = new javax.swing.JButton();
        btnAnggota = new javax.swing.JButton();
        btnKaryawan = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        panelIsi = new javax.swing.JPanel();
        panelTambahAnggota = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_nama_anggota = new javax.swing.JTextField();
        rd_pria = new javax.swing.JRadioButton();
        rd_wanita = new javax.swing.JRadioButton();
        txt_tlp = new javax.swing.JTextField();
        txt_tgl = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_alamat = new javax.swing.JTextArea();
        btn_simpan = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_kembali = new javax.swing.JButton();
        panelHome = new javax.swing.JPanel();
        panelBuku = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_buku = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btn_cari_buku = new javax.swing.JButton();
        lbl_cari_buku = new javax.swing.JLabel();
        txt_cari_buku = new javax.swing.JTextField();
        btn_batal_buku = new javax.swing.JButton();
        btn_tambah_buku = new javax.swing.JButton();
        btn_hapus_buku = new javax.swing.JButton();
        btn_ubah_buku = new javax.swing.JButton();
        panelTambahBuku = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_kode_buku = new javax.swing.JTextField();
        txt_judul = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_penerbit = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_edisi = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_tahun_buku = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_banyak_buku = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_pengarang = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btn_simpan_buku = new javax.swing.JButton();
        btn_reset_buku = new javax.swing.JButton();
        btn_kembali_buku = new javax.swing.JButton();
        panelPengembalian = new javax.swing.JPanel();
        panelPeminjaman = new javax.swing.JPanel();
        panelKaryawan = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        lbl_cari_karyawan = new javax.swing.JLabel();
        txt_cari_karyawan = new javax.swing.JTextField();
        btn_batal_karyawan = new javax.swing.JButton();
        panelUbahBuku = new javax.swing.JPanel();
        panel_ubah_buku = new javax.swing.JPanel();
        txt_edisi_ubah = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_tahun_buku_ubah = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_kode_buku_ubah = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txt_judul_ubah = new javax.swing.JTextField();
        txt_banyak_buku_ubah = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_pengarang_ubah = new javax.swing.JTextField();
        txt_penerbit_ubah = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_simpan_ubah = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btn_cari_ubah_buku = new javax.swing.JButton();
        panelTambahPegawai = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        txt_kode_pegawai_tambah = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txt_nama_pegawai_tambah = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        rd_pegawai_pria = new javax.swing.JRadioButton();
        rd_pegawai_wanita = new javax.swing.JRadioButton();
        jLabel34 = new javax.swing.JLabel();
        txt_telp_tambah_pegawai = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txt_tambah_alamat_pegawai = new javax.swing.JTextArea();
        jLabel36 = new javax.swing.JLabel();
        txt_tambah_tahun_pegawai = new javax.swing.JTextField();
        btn_simpan_pegawai = new javax.swing.JButton();
        btn_kembali_pegawai = new javax.swing.JButton();
        btn_batal_pegawai = new javax.swing.JButton();
        panelUbahPegawai = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txt_ubah_alamat_pegawai = new javax.swing.JTextArea();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txt_ubah_nama_pegawai = new javax.swing.JTextField();
        txt_ubah_tahun_pegawai = new javax.swing.JTextField();
        btn_ubah_pegawai = new javax.swing.JButton();
        btn_kembali_ubah = new javax.swing.JButton();
        btn_batal_pegawai1 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        txt_ubah_telp_pegawai = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txt_ubah_kode_pegawai = new javax.swing.JTextField();
        btn_cari_ubah_pegawai = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        rd_ubah_pria = new javax.swing.JRadioButton();
        rd_ubah_wanita = new javax.swing.JRadioButton();
        panelAnggota = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_anggota = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_daftar = new javax.swing.JButton();
        btn_cari = new javax.swing.JButton();
        lbl_cari = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        btn_batal = new javax.swing.JButton();
        btn_ubah_anggota = new javax.swing.JButton();
        btn_hapus_anggota = new javax.swing.JButton();
        panelUbahAnggota = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        btn_simpan_anggota = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        btn_reset_anggota = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        btn_kembali_anggota = new javax.swing.JButton();
        txt_ubah_nama_anggota = new javax.swing.JTextField();
        rd_ubah_pria_anggota = new javax.swing.JRadioButton();
        rd_ubah_wanita_anggota = new javax.swing.JRadioButton();
        txt_ubah_tlp_anggota = new javax.swing.JTextField();
        txt_ubah_tgl_anggota = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txt_ubah_alamat_anggota = new javax.swing.JTextArea();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txt_ubah_kode_anggota = new javax.swing.JTextField();
        btn_cari_ubah_anggota = new javax.swing.JButton();
        panelTambahAnggota1 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txt_nama_anggota1 = new javax.swing.JTextField();
        rd_pria1 = new javax.swing.JRadioButton();
        rd_wanita1 = new javax.swing.JRadioButton();
        txt_tlp1 = new javax.swing.JTextField();
        txt_tgl1 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txt_alamat1 = new javax.swing.JTextArea();
        btn_simpan1 = new javax.swing.JButton();
        btn_reset1 = new javax.swing.JButton();
        btn_kembali1 = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        txt_kode_anggota = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(43, 77, 115));

        panelKiri.setBackground(new java.awt.Color(43, 77, 115));
        panelKiri.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        btnHome.setBackground(new java.awt.Color(0, 204, 255));
        btnHome.setText("HOME");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnBuku.setText("DATA BUKU");
        btnBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBukuActionPerformed(evt);
            }
        });

        btnPengembalian.setText("PENGEMBALIAN");
        btnPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengembalianActionPerformed(evt);
            }
        });

        btnPeminjaman.setText("PEMINJAMAN");
        btnPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeminjamanActionPerformed(evt);
            }
        });

        btnAnggota.setText("DATA ANGGOTA");
        btnAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnggotaActionPerformed(evt);
            }
        });

        btnKaryawan.setText("DATA KARYAWAN");
        btnKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaryawanActionPerformed(evt);
            }
        });

        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelKiriLayout = new javax.swing.GroupLayout(panelKiri);
        panelKiri.setLayout(panelKiriLayout);
        panelKiriLayout.setHorizontalGroup(
            panelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPeminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAnggota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnKaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelKiriLayout.setVerticalGroup(
            panelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKiriLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelIsi.setBackground(new java.awt.Color(255, 255, 255));
        panelIsi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        panelIsi.setLayout(new java.awt.CardLayout());

        panelTambahAnggota.setBackground(new java.awt.Color(204, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("NAMA ANGGOTA");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("JENIS KELAMIN ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("NOMOR TELEPON");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("TANGGAL LAHIR");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("ALAMAT");

        rd_pria.setText("Laki - Laki");

        rd_wanita.setText("Wanita");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("YYYY-MM-DD");

        txt_alamat.setColumns(20);
        txt_alamat.setRows(5);
        jScrollPane2.setViewportView(txt_alamat);

        btn_simpan.setText("SIMPAN");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_reset.setText("RESET");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_kembali.setText("KEMBALI");
        btn_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTambahAnggotaLayout = new javax.swing.GroupLayout(panelTambahAnggota);
        panelTambahAnggota.setLayout(panelTambahAnggotaLayout);
        panelTambahAnggotaLayout.setHorizontalGroup(
            panelTambahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTambahAnggotaLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelTambahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelTambahAnggotaLayout.createSequentialGroup()
                        .addGroup(panelTambahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(36, 36, 36)
                        .addGroup(panelTambahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tlp)
                            .addGroup(panelTambahAnggotaLayout.createSequentialGroup()
                                .addGroup(panelTambahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelTambahAnggotaLayout.createSequentialGroup()
                                        .addComponent(rd_pria)
                                        .addGap(37, 37, 37)
                                        .addComponent(rd_wanita))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTambahAnggotaLayout.createSequentialGroup()
                                        .addComponent(txt_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                        .addComponent(jLabel8))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_nama_anggota))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(btn_simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_kembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        panelTambahAnggotaLayout.setVerticalGroup(
            panelTambahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTambahAnggotaLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelTambahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_nama_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panelTambahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rd_pria)
                    .addComponent(rd_wanita))
                .addGap(18, 18, 18)
                .addGroup(panelTambahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_tlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panelTambahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(panelTambahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btn_simpan)
                .addGap(18, 18, 18)
                .addComponent(btn_reset)
                .addGap(18, 18, 18)
                .addComponent(btn_kembali)
                .addGap(50, 50, 50))
        );

        panelIsi.add(panelTambahAnggota, "card11");

        panelHome.setBackground(new java.awt.Color(0, 51, 255));

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        panelIsi.add(panelHome, "card2");

        panelBuku.setBackground(new java.awt.Color(255, 204, 51));
        panelBuku.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_buku.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbl_buku);

        panelBuku.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 139, 581, 209));

        jPanel3.setBackground(new java.awt.Color(255, 255, 51));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("DAFTAR BUKU PERPUSTAKAAN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel9)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        panelBuku.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 601, -1));

        btn_cari_buku.setText("CARI");
        btn_cari_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cari_bukuActionPerformed(evt);
            }
        });
        panelBuku.add(btn_cari_buku, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 435, 581, -1));

        lbl_cari_buku.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_cari_buku.setText("MASUKAN JUDUL BUKU");
        panelBuku.add(lbl_cari_buku, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 477, -1, -1));

        txt_cari_buku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cari_bukuKeyReleased(evt);
            }
        });
        panelBuku.add(txt_cari_buku, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 477, 295, -1));

        btn_batal_buku.setText("BATAL");
        btn_batal_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batal_bukuActionPerformed(evt);
            }
        });
        panelBuku.add(btn_batal_buku, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 476, 85, -1));

        btn_tambah_buku.setText("TAMBAH");
        btn_tambah_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah_bukuActionPerformed(evt);
            }
        });
        panelBuku.add(btn_tambah_buku, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 359, 581, -1));

        btn_hapus_buku.setText("HAPUS");
        btn_hapus_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_bukuActionPerformed(evt);
            }
        });
        panelBuku.add(btn_hapus_buku, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 394, 282, -1));

        btn_ubah_buku.setText("UBAH");
        btn_ubah_buku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ubah_bukuMouseClicked(evt);
            }
        });
        panelBuku.add(btn_ubah_buku, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 394, 289, -1));

        panelIsi.add(panelBuku, "card3");

        panelTambahBuku.setBackground(new java.awt.Color(51, 255, 153));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("KODE BUKU");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("JUDUL BUKU");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("PENERBIT");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("EDISI");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("(Angka)");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("TAHUN");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("(YYYY)");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("BANYAK BUKU");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("(Angka)");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("PENGARANG");

        btn_simpan_buku.setText("SIMPAN");
        btn_simpan_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan_bukuActionPerformed(evt);
            }
        });

        btn_reset_buku.setText("RESET");
        btn_reset_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reset_bukuActionPerformed(evt);
            }
        });

        btn_kembali_buku.setText("KEMBALI");
        btn_kembali_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembali_bukuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTambahBukuLayout = new javax.swing.GroupLayout(panelTambahBuku);
        panelTambahBuku.setLayout(panelTambahBukuLayout);
        panelTambahBukuLayout.setHorizontalGroup(
            panelTambahBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTambahBukuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelTambahBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_simpan_buku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelTambahBukuLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_banyak_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18))
                    .addGroup(panelTambahBukuLayout.createSequentialGroup()
                        .addGroup(panelTambahBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addComponent(jLabel19))
                        .addGap(22, 22, 22)
                        .addGroup(panelTambahBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_judul, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(txt_kode_buku)
                            .addComponent(txt_penerbit)
                            .addGroup(panelTambahBukuLayout.createSequentialGroup()
                                .addGroup(panelTambahBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_tahun_buku, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                    .addComponent(txt_edisi, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(panelTambahBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel16)))
                            .addComponent(txt_pengarang)))
                    .addComponent(btn_kembali_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reset_buku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        panelTambahBukuLayout.setVerticalGroup(
            panelTambahBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTambahBukuLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelTambahBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_kode_buku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTambahBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_judul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTambahBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(txt_penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTambahBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(19, 19, 19)
                .addGroup(panelTambahBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_edisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(panelTambahBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_tahun_buku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(panelTambahBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txt_banyak_buku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(32, 32, 32)
                .addComponent(btn_simpan_buku)
                .addGap(18, 18, 18)
                .addComponent(btn_reset_buku)
                .addGap(18, 18, 18)
                .addComponent(btn_kembali_buku)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        panelIsi.add(panelTambahBuku, "card12");

        panelPengembalian.setBackground(new java.awt.Color(102, 255, 51));

        javax.swing.GroupLayout panelPengembalianLayout = new javax.swing.GroupLayout(panelPengembalian);
        panelPengembalian.setLayout(panelPengembalianLayout);
        panelPengembalianLayout.setHorizontalGroup(
            panelPengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );
        panelPengembalianLayout.setVerticalGroup(
            panelPengembalianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        panelIsi.add(panelPengembalian, "card4");

        panelPeminjaman.setBackground(new java.awt.Color(255, 102, 153));

        javax.swing.GroupLayout panelPeminjamanLayout = new javax.swing.GroupLayout(panelPeminjaman);
        panelPeminjaman.setLayout(panelPeminjamanLayout);
        panelPeminjamanLayout.setHorizontalGroup(
            panelPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );
        panelPeminjamanLayout.setVerticalGroup(
            panelPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        panelIsi.add(panelPeminjaman, "card5");

        panelKaryawan.setBackground(new java.awt.Color(0, 204, 204));

        tbl_karyawan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tbl_karyawan);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("DATA KARYAWAN");

        jButton2.setText("TAMBAH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("UBAH");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("HAPUS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("CARI");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        lbl_cari_karyawan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cari_karyawan.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cari_karyawan.setText("MASUKAN NIP");

        txt_cari_karyawan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cari_karyawanKeyReleased(evt);
            }
        });

        btn_batal_karyawan.setText("BATAL");
        btn_batal_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batal_karyawanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelKaryawanLayout = new javax.swing.GroupLayout(panelKaryawan);
        panelKaryawan.setLayout(panelKaryawanLayout);
        panelKaryawanLayout.setHorizontalGroup(
            panelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addGroup(panelKaryawanLayout.createSequentialGroup()
                .addGroup(panelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKaryawanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelKaryawanLayout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelKaryawanLayout.createSequentialGroup()
                        .addGroup(panelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelKaryawanLayout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addComponent(jLabel30))
                            .addGroup(panelKaryawanLayout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(lbl_cari_karyawan)
                                .addGap(33, 33, 33)
                                .addComponent(txt_cari_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btn_batal_karyawan)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKaryawanLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        panelKaryawanLayout.setVerticalGroup(
            panelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKaryawanLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel30)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(11, 11, 11)
                .addGroup(panelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_cari_karyawan)
                    .addComponent(txt_cari_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal_karyawan))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        panelIsi.add(panelKaryawan, "card7");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("(Angka)");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("TAHUN");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("KODE BUKU");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("(YYYY)");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("BANYAK BUKU");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("JUDUL BUKU");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("(Angka)");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("PENERBIT");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("PENGARANG");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("EDISI");

        jButton1.setText("KEMBALI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_simpan_ubah.setText("SIMPAN");
        btn_simpan_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan_ubahActionPerformed(evt);
            }
        });

        jButton3.setText("BATAL");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btn_cari_ubah_buku.setText("UBAH");
        btn_cari_ubah_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cari_ubah_bukuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_ubah_bukuLayout = new javax.swing.GroupLayout(panel_ubah_buku);
        panel_ubah_buku.setLayout(panel_ubah_bukuLayout);
        panel_ubah_bukuLayout.setHorizontalGroup(
            panel_ubah_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ubah_bukuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_ubah_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ubah_bukuLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(83, 83, 83))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ubah_bukuLayout.createSequentialGroup()
                        .addGroup(panel_ubah_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel27)
                            .addComponent(jLabel29)
                            .addComponent(jLabel21)
                            .addComponent(jLabel28))
                        .addGap(11, 11, 11))
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(panel_ubah_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_ubah_bukuLayout.createSequentialGroup()
                        .addGroup(panel_ubah_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_ubah_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_judul_ubah)
                                .addComponent(txt_penerbit_ubah)
                                .addComponent(txt_pengarang_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panel_ubah_bukuLayout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(panel_ubah_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_tahun_buku_ubah, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                        .addComponent(txt_edisi_ubah))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel_ubah_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel20)
                                        .addComponent(jLabel23))))
                            .addGroup(panel_ubah_bukuLayout.createSequentialGroup()
                                .addComponent(txt_kode_buku_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btn_cari_ubah_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_ubah_bukuLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txt_banyak_buku_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)))
                .addGap(74, 74, 74))
            .addGroup(panel_ubah_bukuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_simpan_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_ubah_bukuLayout.setVerticalGroup(
            panel_ubah_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ubah_bukuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_ubah_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txt_kode_buku_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cari_ubah_buku))
                .addGap(18, 18, 18)
                .addGroup(panel_ubah_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txt_judul_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_ubah_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27)
                    .addComponent(txt_penerbit_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_ubah_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pengarang_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGap(19, 19, 19)
                .addGroup(panel_ubah_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txt_edisi_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(panel_ubah_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txt_tahun_buku_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(panel_ubah_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txt_banyak_buku_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(30, 30, 30)
                .addGroup(panel_ubah_bukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btn_simpan_ubah)
                    .addComponent(jButton3))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelUbahBukuLayout = new javax.swing.GroupLayout(panelUbahBuku);
        panelUbahBuku.setLayout(panelUbahBukuLayout);
        panelUbahBukuLayout.setHorizontalGroup(
            panelUbahBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_ubah_buku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelUbahBukuLayout.setVerticalGroup(
            panelUbahBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_ubah_buku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panelIsi.add(panelUbahBuku, "card8");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("NIP PEGAWAI");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("NAMA");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("JENIS KELAMIN");

        rd_pegawai_pria.setText("Pria");

        rd_pegawai_wanita.setText("Wanita");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setText("NOMOR TELEPON");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setText("ALAMAT");

        txt_tambah_alamat_pegawai.setColumns(20);
        txt_tambah_alamat_pegawai.setRows(5);
        jScrollPane5.setViewportView(txt_tambah_alamat_pegawai);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setText("TAHUN BEKERJA");

        btn_simpan_pegawai.setText("SIMPAN");
        btn_simpan_pegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan_pegawaiActionPerformed(evt);
            }
        });

        btn_kembali_pegawai.setText("KEMBALI");
        btn_kembali_pegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembali_pegawaiActionPerformed(evt);
            }
        });

        btn_batal_pegawai.setText("RESET");
        btn_batal_pegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batal_pegawaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTambahPegawaiLayout = new javax.swing.GroupLayout(panelTambahPegawai);
        panelTambahPegawai.setLayout(panelTambahPegawaiLayout);
        panelTambahPegawaiLayout.setHorizontalGroup(
            panelTambahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTambahPegawaiLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelTambahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTambahPegawaiLayout.createSequentialGroup()
                        .addGroup(panelTambahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35))
                        .addGap(27, 27, 27)
                        .addGroup(panelTambahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTambahPegawaiLayout.createSequentialGroup()
                                .addComponent(txt_telp_tambah_pegawai)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelTambahPegawaiLayout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panelTambahPegawaiLayout.createSequentialGroup()
                        .addGroup(panelTambahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelTambahPegawaiLayout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(83, 83, 83))
                            .addGroup(panelTambahPegawaiLayout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(27, 27, 27)))
                        .addGap(10, 10, 10)
                        .addGroup(panelTambahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_kode_pegawai_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nama_pegawai_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(panelTambahPegawaiLayout.createSequentialGroup()
                        .addGroup(panelTambahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTambahPegawaiLayout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(31, 31, 31)
                                .addComponent(txt_tambah_tahun_pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTambahPegawaiLayout.createSequentialGroup()
                                .addComponent(btn_simpan_pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_kembali_pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTambahPegawaiLayout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(27, 27, 27)
                                .addComponent(rd_pegawai_pria)
                                .addGap(50, 50, 50)
                                .addComponent(rd_pegawai_wanita)))
                        .addGap(0, 30, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTambahPegawaiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_batal_pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
        );
        panelTambahPegawaiLayout.setVerticalGroup(
            panelTambahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTambahPegawaiLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panelTambahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txt_kode_pegawai_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelTambahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txt_nama_pegawai_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTambahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(rd_pegawai_pria)
                    .addComponent(rd_pegawai_wanita))
                .addGap(18, 18, 18)
                .addGroup(panelTambahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txt_telp_tambah_pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panelTambahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTambahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txt_tambah_tahun_pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTambahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan_pegawai)
                    .addComponent(btn_kembali_pegawai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_batal_pegawai)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        panelIsi.add(panelTambahPegawai, "card9");

        txt_ubah_alamat_pegawai.setColumns(20);
        txt_ubah_alamat_pegawai.setRows(5);
        jScrollPane6.setViewportView(txt_ubah_alamat_pegawai);

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setText("NAMA");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setText("TAHUN BEKERJA");

        btn_ubah_pegawai.setText("SIMPAN");
        btn_ubah_pegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubah_pegawaiActionPerformed(evt);
            }
        });

        btn_kembali_ubah.setText("KEMBALI");
        btn_kembali_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembali_ubahActionPerformed(evt);
            }
        });

        btn_batal_pegawai1.setText("RESET");
        btn_batal_pegawai1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batal_pegawai1ActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setText("NOMOR TELEPON");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setText("NIP PEGAWAI");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setText("ALAMAT");

        btn_cari_ubah_pegawai.setText("UBAH");
        btn_cari_ubah_pegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cari_ubah_pegawaiActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setText("JENIS KELAMIN");

        rd_ubah_pria.setText("Pria");

        rd_ubah_wanita.setText("Wanita");

        javax.swing.GroupLayout panelUbahPegawaiLayout = new javax.swing.GroupLayout(panelUbahPegawai);
        panelUbahPegawai.setLayout(panelUbahPegawaiLayout);
        panelUbahPegawaiLayout.setHorizontalGroup(
            panelUbahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUbahPegawaiLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelUbahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUbahPegawaiLayout.createSequentialGroup()
                        .addGroup(panelUbahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel42))
                        .addGap(27, 27, 27)
                        .addGroup(panelUbahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelUbahPegawaiLayout.createSequentialGroup()
                                .addComponent(txt_ubah_telp_pegawai, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                .addGap(186, 186, 186))
                            .addGroup(panelUbahPegawaiLayout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUbahPegawaiLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_batal_pegawai1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140))
                    .addGroup(panelUbahPegawaiLayout.createSequentialGroup()
                        .addGroup(panelUbahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelUbahPegawaiLayout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addGap(31, 31, 31)
                                .addComponent(txt_ubah_tahun_pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelUbahPegawaiLayout.createSequentialGroup()
                                .addComponent(btn_ubah_pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_kembali_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelUbahPegawaiLayout.createSequentialGroup()
                                .addGroup(panelUbahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelUbahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panelUbahPegawaiLayout.createSequentialGroup()
                                            .addComponent(jLabel37)
                                            .addGap(83, 83, 83))
                                        .addGroup(panelUbahPegawaiLayout.createSequentialGroup()
                                            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(27, 27, 27)))
                                    .addComponent(jLabel39))
                                .addGap(10, 10, 10)
                                .addGroup(panelUbahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelUbahPegawaiLayout.createSequentialGroup()
                                        .addComponent(txt_ubah_kode_pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(btn_cari_ubah_pegawai))
                                    .addComponent(txt_ubah_nama_pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelUbahPegawaiLayout.createSequentialGroup()
                                        .addComponent(rd_ubah_pria)
                                        .addGap(18, 18, 18)
                                        .addComponent(rd_ubah_wanita)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelUbahPegawaiLayout.setVerticalGroup(
            panelUbahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUbahPegawaiLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelUbahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txt_ubah_kode_pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cari_ubah_pegawai))
                .addGap(28, 28, 28)
                .addGroup(panelUbahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txt_ubah_nama_pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelUbahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(rd_ubah_pria)
                    .addComponent(rd_ubah_wanita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(panelUbahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txt_ubah_telp_pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panelUbahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelUbahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txt_ubah_tahun_pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelUbahPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ubah_pegawai)
                    .addComponent(btn_kembali_ubah))
                .addGap(18, 18, 18)
                .addComponent(btn_batal_pegawai1)
                .addGap(39, 39, 39))
        );

        panelIsi.add(panelUbahPegawai, "card10");

        panelAnggota.setBackground(new java.awt.Color(204, 204, 204));
        panelAnggota.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        tbl_anggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_anggotaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_anggota);

        panelAnggota.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 129, 581, 230));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("DAFTAR ANGGOTA PERPUSTAKAAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(171, 171, 171))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        panelAnggota.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 601, -1));

        btn_daftar.setText("DAFTAR");
        btn_daftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_daftarActionPerformed(evt);
            }
        });
        panelAnggota.add(btn_daftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 460, -1));

        btn_cari.setText("CARI");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        panelAnggota.add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 460, -1));

        lbl_cari.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cari.setText("MASUKAN NAMA ANGGOTA");
        panelAnggota.add(lbl_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, 20));

        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
        });
        panelAnggota.add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 490, 230, -1));

        btn_batal.setText("BATAL");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });
        panelAnggota.add(btn_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, 80, 20));

        btn_ubah_anggota.setText("UBAH");
        btn_ubah_anggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubah_anggotaActionPerformed(evt);
            }
        });
        panelAnggota.add(btn_ubah_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 230, -1));

        btn_hapus_anggota.setText("HAPUS");
        btn_hapus_anggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_anggotaActionPerformed(evt);
            }
        });
        panelAnggota.add(btn_hapus_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 220, -1));

        panelIsi.add(panelAnggota, "card6");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("NOMOR TELEPON");

        btn_simpan_anggota.setText("SIMPAN");
        btn_simpan_anggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan_anggotaActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel44.setText("TANGGAL LAHIR");

        btn_reset_anggota.setText("RESET");
        btn_reset_anggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reset_anggotaActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel45.setText("ALAMAT");

        btn_kembali_anggota.setText("KEMBALI");
        btn_kembali_anggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembali_anggotaActionPerformed(evt);
            }
        });

        rd_ubah_pria_anggota.setText("Laki - Laki");

        rd_ubah_wanita_anggota.setText("Wanita");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel46.setText("YYYY-MM-DD");

        txt_ubah_alamat_anggota.setColumns(20);
        txt_ubah_alamat_anggota.setRows(5);
        jScrollPane7.setViewportView(txt_ubah_alamat_anggota);

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel47.setText("NAMA ANGGOTA");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setText("JENIS KELAMIN ");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel49.setText("KODE ANGGOTA");

        btn_cari_ubah_anggota.setText("UBAH");
        btn_cari_ubah_anggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cari_ubah_anggotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelUbahAnggotaLayout = new javax.swing.GroupLayout(panelUbahAnggota);
        panelUbahAnggota.setLayout(panelUbahAnggotaLayout);
        panelUbahAnggotaLayout.setHorizontalGroup(
            panelUbahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUbahAnggotaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelUbahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addGroup(panelUbahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelUbahAnggotaLayout.createSequentialGroup()
                            .addGroup(panelUbahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel47)
                                .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGap(36, 36, 36)
                            .addGroup(panelUbahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelUbahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelUbahAnggotaLayout.createSequentialGroup()
                                        .addComponent(rd_ubah_pria_anggota)
                                        .addGap(37, 37, 37)
                                        .addComponent(rd_ubah_wanita_anggota))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUbahAnggotaLayout.createSequentialGroup()
                                        .addComponent(txt_ubah_tgl_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel46))
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_ubah_nama_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txt_ubah_tlp_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelUbahAnggotaLayout.createSequentialGroup()
                                    .addComponent(txt_ubah_kode_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31)
                                    .addComponent(btn_cari_ubah_anggota))))
                        .addGroup(panelUbahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_simpan_anggota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_reset_anggota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_kembali_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        panelUbahAnggotaLayout.setVerticalGroup(
            panelUbahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUbahAnggotaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelUbahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txt_ubah_kode_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cari_ubah_anggota))
                .addGap(25, 25, 25)
                .addGroup(panelUbahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(txt_ubah_nama_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panelUbahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(rd_ubah_pria_anggota)
                    .addComponent(rd_ubah_wanita_anggota))
                .addGap(18, 18, 18)
                .addGroup(panelUbahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(txt_ubah_tlp_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panelUbahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txt_ubah_tgl_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addGap(18, 18, 18)
                .addGroup(panelUbahAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_simpan_anggota)
                .addGap(18, 18, 18)
                .addComponent(btn_reset_anggota)
                .addGap(18, 18, 18)
                .addComponent(btn_kembali_anggota)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        panelIsi.add(panelUbahAnggota, "card13");

        panelTambahAnggota1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel50.setText("NAMA ANGGOTA");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel51.setText("JENIS KELAMIN ");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("NOMOR TELEPON");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel53.setText("TANGGAL LAHIR");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel54.setText("ALAMAT");

        rd_pria1.setText("Laki - Laki");

        rd_wanita1.setText("Wanita");

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel55.setText("YYYY-MM-DD");

        txt_alamat1.setColumns(20);
        txt_alamat1.setRows(5);
        jScrollPane8.setViewportView(txt_alamat1);

        btn_simpan1.setText("SIMPAN");
        btn_simpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan1ActionPerformed(evt);
            }
        });

        btn_reset1.setText("RESET");
        btn_reset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reset1ActionPerformed(evt);
            }
        });

        btn_kembali1.setText("KEMBALI");
        btn_kembali1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembali1ActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel56.setText("KODE ANGGOTA");

        javax.swing.GroupLayout panelTambahAnggota1Layout = new javax.swing.GroupLayout(panelTambahAnggota1);
        panelTambahAnggota1.setLayout(panelTambahAnggota1Layout);
        panelTambahAnggota1Layout.setHorizontalGroup(
            panelTambahAnggota1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTambahAnggota1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelTambahAnggota1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56)
                    .addGroup(panelTambahAnggota1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelTambahAnggota1Layout.createSequentialGroup()
                            .addGroup(panelTambahAnggota1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel50)
                                .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel52)
                                .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGap(36, 36, 36)
                            .addGroup(panelTambahAnggota1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelTambahAnggota1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelTambahAnggota1Layout.createSequentialGroup()
                                        .addComponent(rd_pria1)
                                        .addGap(37, 37, 37)
                                        .addComponent(rd_wanita1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTambahAnggota1Layout.createSequentialGroup()
                                        .addComponent(txt_tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                        .addComponent(jLabel55))
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_nama_anggota1))
                                .addComponent(txt_tlp1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_kode_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(btn_simpan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_reset1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_kembali1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        panelTambahAnggota1Layout.setVerticalGroup(
            panelTambahAnggota1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTambahAnggota1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelTambahAnggota1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(txt_kode_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(panelTambahAnggota1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(txt_nama_anggota1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panelTambahAnggota1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(rd_pria1)
                    .addComponent(rd_wanita1))
                .addGap(18, 18, 18)
                .addGroup(panelTambahAnggota1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(txt_tlp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panelTambahAnggota1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(txt_tgl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55))
                .addGap(18, 18, 18)
                .addGroup(panelTambahAnggota1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_simpan1)
                .addGap(18, 18, 18)
                .addComponent(btn_reset1)
                .addGap(18, 18, 18)
                .addComponent(btn_kembali1)
                .addGap(27, 27, 27))
        );

        panelIsi.add(panelTambahAnggota1, "card11");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelKiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelIsi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelKiri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelIsi, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

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
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:

        //remove panel
        panelIsi.removeAll();
        panelIsi.repaint();
        panelIsi.revalidate();

        //add panel
        panelIsi.add(panelHome);
        panelIsi.repaint();
        panelIsi.revalidate();

    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBukuActionPerformed
        // TODO add your handling code here:

        //remove panel
        panelIsi.removeAll();
        panelIsi.repaint();
        panelIsi.revalidate();

        //add panel
        panelIsi.add(panelBuku);
        panelIsi.repaint();
        panelIsi.revalidate();
    }//GEN-LAST:event_btnBukuActionPerformed

    private void btnPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengembalianActionPerformed
        // TODO add your handling code here:

        //remove panel
        panelIsi.removeAll();
        panelIsi.repaint();
        panelIsi.revalidate();

        //add panel
        panelIsi.add(panelPengembalian);
        panelIsi.repaint();
        panelIsi.revalidate();
    }//GEN-LAST:event_btnPengembalianActionPerformed

    private void btnPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeminjamanActionPerformed
        // TODO add your handling code here:

        //remove panel
        panelIsi.removeAll();
        panelIsi.repaint();
        panelIsi.revalidate();

        //add panel
        panelIsi.add(panelPeminjaman);
        panelIsi.repaint();
        panelIsi.revalidate();
    }//GEN-LAST:event_btnPeminjamanActionPerformed

    private void btnAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnggotaActionPerformed
        // TODO add your handling code here:

        //remove panel
        panelIsi.removeAll();
        panelIsi.repaint();
        panelIsi.revalidate();

        //add panel
        panelIsi.add(panelAnggota);
        panelIsi.repaint();
        panelIsi.revalidate();
    }//GEN-LAST:event_btnAnggotaActionPerformed

    private void btnKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaryawanActionPerformed
        // TODO add your handling code here:

        //remove panel
        panelIsi.removeAll();
        panelIsi.repaint();
        panelIsi.revalidate();

        //add panel
        panelIsi.add(panelKaryawan);
        panelIsi.repaint();
        panelIsi.revalidate();
    }//GEN-LAST:event_btnKaryawanActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:

        String kelamin = "";
        if (rd_pria.isSelected()) {
            kelamin = "Pria";

        }
        else if (rd_wanita.isSelected())
        {
            kelamin = "Wanita";
        }

        String data[]  = new String[5];

        if ((txt_nama_anggota.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, silahkan dilengkapi");
            txt_nama_anggota.requestFocus();

        }
        else if ((!rd_wanita.isSelected()) && (!rd_pria.isSelected()))
        {
            JOptionPane.showMessageDialog(this,"Jenis Kelamin Harap Diisi");
        }
        else
        {
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO anggota(nama_anggota,"
                + "jk_anggota,"
                + "alamat_anggota,"
                + "no_telp_anggota,"
                + "tanggal_lahir) "
                + "VALUES "
                +"( '"+txt_nama_anggota.getText()+"',"
                +" '"+kelamin+"' ,"
                +" ' "+txt_alamat.getText()+" ',"
                +" ' "+txt_tlp.getText()+" ' ,"
                +" ' "+txt_tgl.getText()+" ')";

                stt.executeUpdate(SQL);
                data[0] = txt_nama_anggota.getText();
                data[1] = kelamin;
                data[2] = txt_alamat.getText();
                data[3] = txt_tlp.getText();
                data[4] = txt_tgl.getText();
                tableAnggota.insertRow(0, data);
                stt.close();
                kon.close();
                membersihkan_teks();
                nonaktif_teks();
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");

            } catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE );
            }

        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        membersihkan_teks();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembaliActionPerformed
        // TODO add your handling code here:

        //remove panel
        panelIsi.removeAll();
        panelIsi.repaint();
        panelIsi.revalidate();

        //add panel
        panelIsi.add(panelAnggota);
        panelIsi.repaint();
        panelIsi.revalidate();
    }//GEN-LAST:event_btn_kembaliActionPerformed

    private void btn_cari_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cari_bukuActionPerformed
        // TODO add your handling code here:
        lbl_cari_buku.setVisible(true);
        txt_cari_buku.setVisible(true);
        btn_batal_buku.setVisible(true);

    }//GEN-LAST:event_btn_cari_bukuActionPerformed

    private void txt_cari_bukuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cari_bukuKeyReleased
        // TODO add your handling code here:

        //menghapus seluruh isi data dalam jtable
        tableBuku.setRowCount(0);

        //gunakan query untuk mencari
        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM buku WHERE judul LIKE '%"+txt_cari_buku.getText()+"%'";
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
    }//GEN-LAST:event_txt_cari_bukuKeyReleased

    private void btn_batal_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batal_bukuActionPerformed
        // TODO add your handling code here:
        lbl_cari_buku.setVisible(false);
        txt_cari_buku.setVisible(false);
        btn_batal_buku.setVisible(false);
        tableBuku.setRowCount(0);
        settableloadbuku();
    }//GEN-LAST:event_btn_batal_bukuActionPerformed

    private void btn_tambah_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah_bukuActionPerformed
        // TODO add your handling code here:
        //remove panel
        panelIsi.removeAll();
        panelIsi.repaint();
        panelIsi.revalidate();

        //add panel
        panelIsi.add(panelTambahBuku);
        panelIsi.repaint();
        panelIsi.revalidate();

        //tambah
        membersihkan_teks();
        txt_kode_buku.requestFocus();
        btn_simpan_buku.setEnabled(true);
        btn_reset_buku.setEnabled(true);
        btn_kembali_buku.setEnabled(true);
        aktif_teks();
    }//GEN-LAST:event_btn_tambah_bukuActionPerformed

    private void btn_hapus_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_bukuActionPerformed
        // TODO add your handling code here:

        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "DELETE FROM buku "
            +"WHERE "
            +"kode_buku='"+tableBuku.getValueAt(row, 0).toString()+"'";
            stt.executeUpdate(SQL);
            tableBuku.removeRow(row);
            stt.close();
            kon.close();
            membersihkan_teks();
        } catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_btn_hapus_bukuActionPerformed

    private void btn_ubah_bukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ubah_bukuMouseClicked
        // TODO add your handling code here:
        //remove panel
        panelIsi.removeAll();
        panelIsi.repaint();
        panelIsi.revalidate();

        //add panel
        panelIsi.add(panel_ubah_buku);
        panelIsi.repaint();
        panelIsi.revalidate();

    }//GEN-LAST:event_btn_ubah_bukuMouseClicked

    private void btn_simpan_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan_bukuActionPerformed
        // TODO add your handling code here:

        String data[]  = new String[7];

        if ((txt_kode_buku.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, silahkan dilengkapi");
            txt_kode_buku.requestFocus();

        }
        else
        {
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO buku(kode_buku,"
                + "judul,"
                + "penerbit,"
                + "edisi,"
                + "tahun_masuk,"
                + "banyak_buku,"
                + "nama_pengarang) "
                + "VALUES "
                +"( '"+txt_kode_buku.getText()+"',"
                +" '"+txt_judul.getText()+"',"
                +" ' "+txt_penerbit.getText()+" ',"
                +" ' "+txt_edisi.getText()+" ',"
                +" ' "+txt_tahun_buku.getText()+" ',"
                +" ' "+txt_banyak_buku.getText()+" ',"
                +" ' "+txt_pengarang.getText()+" ')";

                stt.executeUpdate(SQL);
                data_buku[0] = txt_kode_buku.getText();
                data_buku[1] = txt_judul.getText();
                data_buku[2] = txt_penerbit.getText();
                data_buku[3] = txt_edisi.getText();
                data_buku[4] = txt_tahun_buku.getText();
                data_buku[5] = txt_banyak_buku.getText();
                data_buku[6] = txt_pengarang.getText();
                tableBuku.insertRow(0, data_buku);
                stt.close();
                kon.close();
                membersihkan_teks();
                nonaktif_teks();
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");

            } catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE );
            }

        }
    }//GEN-LAST:event_btn_simpan_bukuActionPerformed

    private void btn_reset_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reset_bukuActionPerformed
        // TODO add your handling code here:\
        membersihkan_teks();
    }//GEN-LAST:event_btn_reset_bukuActionPerformed

    private void btn_kembali_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembali_bukuActionPerformed
        // TODO add your handling code here:
        //remove panel
        panelIsi.removeAll();
        panelIsi.repaint();
        panelIsi.revalidate();

        //add panel
        panelIsi.add(panelBuku);
        panelIsi.repaint();
        panelIsi.revalidate();
    }//GEN-LAST:event_btn_kembali_bukuActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //remove panel
        panelIsi.removeAll();
        panelIsi.repaint();
        panelIsi.revalidate();

        //add panel
        panelIsi.add(panelTambahPegawai);
        panelIsi.repaint();
        panelIsi.revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //remove panel
        panelIsi.removeAll();
        panelIsi.repaint();
        panelIsi.revalidate();

        //add panel
        panelIsi.add(panelUbahPegawai);
        panelIsi.repaint();
        panelIsi.revalidate();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "DELETE FROM pegawai "
            +"WHERE "
            +"kode_pegawai='"+tablePegawai.getValueAt(row, 0).toString()+"'";
            stt.executeUpdate(SQL);
            tablePegawai.removeRow(row);
            stt.close();
            kon.close();
            membersihkan_teks();
        } catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        btn_batal_karyawan.setVisible(true);
        txt_cari_karyawan.setVisible(true);
        lbl_cari_karyawan.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txt_cari_karyawanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cari_karyawanKeyReleased
        // TODO add your handling code here:
        //menghapus seluruh isi data dalam jtable
        tablePegawai.setRowCount(0);

        //gunakan query untuk mencari
        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM `pegawai` WHERE nama_pegawai LIKE '%"+txt_cari_karyawan.getText()+"%'";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next())
            {
                data_pegawai[0] = res.getString(1);
                data_pegawai[1] = res.getString(2);
                data_pegawai[2] = res.getString(3);
                data_pegawai[3] = res.getString(4);
                data_pegawai[4] = res.getString(5);
                data_pegawai[5] = res.getString(6);
                tablePegawai.addRow(data_pegawai);
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

    }//GEN-LAST:event_txt_cari_karyawanKeyReleased

    private void btn_batal_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batal_karyawanActionPerformed
        // TODO add your handling code here:
        lbl_cari_karyawan.setVisible(false);
        txt_cari_karyawan.setVisible(false);
        btn_batal_karyawan.setVisible(false);
        tablePegawai.setRowCount(0);
        settableloadpegawai();
    }//GEN-LAST:event_btn_batal_karyawanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //remove panel
        panelIsi.removeAll();
        panelIsi.repaint();
        panelIsi.revalidate();

        //add panel
        panelIsi.add(panelBuku);
        panelIsi.repaint();
        panelIsi.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_simpan_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan_ubahActionPerformed
        // TODO add your handling code here:
        String kode = txt_kode_buku_ubah.getText();
        String judul = txt_judul_ubah.getText();
        String penerbit = txt_penerbit_ubah.getText();
        String edisi = txt_edisi_ubah.getText();
        String tahun = txt_tahun_buku_ubah.getText();
        String banyak = txt_banyak_buku_ubah.getText();
        String pengarang = txt_pengarang_ubah.getText();

        if ((kode.isEmpty()))
        {
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi");
            txt_kode_buku_ubah.requestFocus();
        }
        else
        {
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                String SQL = "UPDATE `buku` "
                + "SET `kode_buku`='"+kode+"',"
                + "`judul`='"+judul+"',"
                + "`penerbit`='"+penerbit+"',"
                + "`edisi`='"+edisi+"',"
                + "`tahun_masuk`='"+tahun+"',"
                + "`banyak_buku`='"+banyak+"',"
                + "`nama_pengarang`='"+pengarang+"' "
                + "WHERE "
                + "`kode_buku`='"+kode+"';";

                stt.executeUpdate(SQL);
                data_buku[0] = kode;
                data_buku[1] = judul;
                data_buku[2] = penerbit;
                data_buku[3] = edisi;
                data_buku[4] = tahun;
                data_buku[5] = banyak;
                data_buku[6] = pengarang;
                tableBuku.removeRow(row);
                tableBuku.insertRow(row, data_buku);
                stt.close();
                kon.close();
                membersihkan_teks();

                nonaktif_teks();
                JOptionPane.showMessageDialog(this,"Data berhasil Diubah");

            } catch (Exception ex)
            {
                System.err.println(ex.getMessage());
            }
        }

    }//GEN-LAST:event_btn_simpan_ubahActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        membersihkan_teks();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_cari_ubah_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cari_ubah_bukuActionPerformed
        // TODO add your handling code here:

        txt_judul_ubah.setEnabled(true);
        txt_pengarang_ubah.setEnabled(true);
        txt_penerbit_ubah.setEnabled(true);
        txt_edisi_ubah.setEnabled(true);
        txt_banyak_buku_ubah.setEnabled(true);
        txt_tahun_buku_ubah.setEnabled(true);

        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM buku WHERE kode_buku ='"+txt_kode_buku_ubah.getText()+"';";
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
            }

            txt_judul_ubah.setText(data_buku[1]);
            txt_penerbit_ubah.setText(data_buku[2]);
            txt_edisi_ubah.setText(data_buku[3]);
            txt_tahun_buku_ubah.setText(data_buku[4]);
            txt_banyak_buku_ubah.setText(data_buku[5]);
            txt_pengarang_ubah.setText(data_buku[6]);

            res.close();
            stt.close();
            kon.close();

        } catch (Exception ex)
        {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        };

    }//GEN-LAST:event_btn_cari_ubah_bukuActionPerformed

    private void btn_simpan_pegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan_pegawaiActionPerformed
        // TODO add your handling code here:
        String kelamin = "";
        if (rd_pegawai_pria.isSelected()) {
            kelamin = "Pria";

        }
        else if (rd_pegawai_wanita.isSelected())
        {
            kelamin = "Wanita";
        }

        String data_pegawai[]  = new String[6];

        if ((txt_kode_pegawai_tambah.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, silahkan dilengkapi");
            txt_kode_pegawai_tambah.requestFocus();

        }
        else if ((!rd_pegawai_pria.isSelected()) && (!rd_pegawai_wanita.isSelected()))
        {
            JOptionPane.showMessageDialog(this, "Tolong pilih Jenis Kelamin Terlebih Dahulu");
        }
        else
        {
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO pegawai(kode_pegawai,"
                + "nama_pegawai,"
                + "jk_pegawai,"
                + "alamat_pegawai,"
                + "no_telp_pegawai,"
                + "tahun_bekerja) "
                + "VALUES "
                +"( '"+txt_kode_pegawai_tambah.getText()+"',"
                +" '"+txt_nama_pegawai_tambah.getText()+"' ,"
                +" '"+kelamin+"' ,"
                +" ' "+txt_tambah_alamat_pegawai.getText()+" ',"
                +" ' "+txt_telp_tambah_pegawai.getText()+" ' ,"
                +" ' "+txt_tambah_tahun_pegawai.getText()+" ')";

                stt.executeUpdate(SQL);
                data_pegawai[0] = txt_kode_pegawai_tambah.getText();
                data_pegawai[1] = txt_nama_pegawai_tambah.getText();
                data_pegawai[2] = kelamin;
                data_pegawai[3] = txt_tambah_alamat_pegawai.getText();
                data_pegawai[4] = txt_telp_tambah_pegawai.getText();
                data_pegawai[5] = txt_tambah_tahun_pegawai.getText();
                tablePegawai.insertRow(0, data_pegawai);
                stt.close();
                kon.close();
                membersihkan_teks();
                nonaktif_teks();
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");

            } catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE );
            }

        }

    }//GEN-LAST:event_btn_simpan_pegawaiActionPerformed

    private void btn_kembali_pegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembali_pegawaiActionPerformed
        // TODO add your handling code here:
        //remove panel
        panelIsi.removeAll();
        panelIsi.repaint();
        panelIsi.revalidate();

        //add panel
        panelIsi.add(panelKaryawan);
        panelIsi.repaint();
        panelIsi.revalidate();
    }//GEN-LAST:event_btn_kembali_pegawaiActionPerformed

    private void btn_batal_pegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batal_pegawaiActionPerformed
        // TODO add your handling code here:
        membersihkan_teks();
    }//GEN-LAST:event_btn_batal_pegawaiActionPerformed

    private void btn_ubah_pegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubah_pegawaiActionPerformed
        // TODO add your handling code here:
        String kode = txt_ubah_kode_pegawai.getText();
        String nama = txt_ubah_nama_pegawai.getText();
        String jk = "";
        if (rd_ubah_pria.isSelected()) {
            jk = "Pria";
        }
        else if (rd_ubah_wanita.isSelected())
        {
            jk = "Wanita";
        }

        String data_pegawai[] = new String[6];
        String alamat = txt_ubah_alamat_pegawai.getText();
        String telp = txt_ubah_telp_pegawai.getText();
        String tahun = txt_ubah_tahun_pegawai.getText();

        if ((kode.isEmpty()))
        {
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi");
            txt_ubah_kode_pegawai.requestFocus();
        }
        else if ((!rd_ubah_pria.isSelected()) && (!rd_ubah_wanita.isSelected()))
        {
            JOptionPane.showMessageDialog(this, "Tolong Pilih Jenis Kelamin Anda");
        }

        else
        {
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                String SQL = "UPDATE `pegawai` "
                + "SET `kode_pegawai`='"+kode+"',"
                + "`nama_pegawai`='"+nama+"',"
                + "`jk_pegawai`='"+jk+"',"
                + "`alamat_pegawai`='"+alamat+"',"
                + "`no_telp_pegawai`='"+telp+"',"
                + "`tahun_bekerja`='"+tahun+"' "
                + "WHERE "
                + "`kode_pegawai`='"+kode+"';";

                stt.executeUpdate(SQL);
                data_pegawai[0] = kode;
                data_pegawai[1] = nama;
                data_pegawai[2] = jk;
                data_pegawai[3] = alamat;
                data_pegawai[4] = telp;
                data_pegawai[5] = tahun;
                tablePegawai.removeRow(row);
                tablePegawai.insertRow(row, data_pegawai);
                stt.close();
                kon.close();
                membersihkan_teks();

                nonaktif_teks();
                JOptionPane.showMessageDialog(this,"Data berhasil Diubah");

            } catch (Exception ex)
            {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btn_ubah_pegawaiActionPerformed

    private void btn_kembali_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembali_ubahActionPerformed
        // TODO add your handling code here:
        //remove panel
        panelIsi.removeAll();
        panelIsi.repaint();
        panelIsi.revalidate();

        //add panel
        panelIsi.add(panelKaryawan);
        panelIsi.repaint();
        panelIsi.revalidate();
    }//GEN-LAST:event_btn_kembali_ubahActionPerformed

    private void btn_batal_pegawai1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batal_pegawai1ActionPerformed
        // TODO add your handling code here:
        membersihkan_teks();
    }//GEN-LAST:event_btn_batal_pegawai1ActionPerformed

    private void btn_cari_ubah_pegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cari_ubah_pegawaiActionPerformed
        // TODO add your handling code here:
        txt_ubah_nama_pegawai.setEnabled(true);
        txt_ubah_alamat_pegawai.setEnabled(true);
        txt_ubah_tahun_pegawai.setEnabled(true);
        txt_ubah_telp_pegawai.setEnabled(true);

        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM pegawai WHERE kode_pegawai='"+txt_ubah_kode_pegawai.getText()+"';";
            ResultSet res = stt.executeQuery(SQL);

            while (res.next())
            {
                data_pegawai[0] = res.getString(1);
                data_pegawai[1] = res.getString(2);
                data_pegawai[2] = res.getString(3);
                data_pegawai[3] = res.getString(4);
                data_pegawai[4] = res.getString(5);
                data_pegawai[5] = res.getString(6);
            }

            txt_ubah_kode_pegawai.setText(data_pegawai[0]);
            txt_ubah_nama_pegawai.setText(data_pegawai[1]);
            txt_ubah_alamat_pegawai.setText(data_pegawai[3]);
            txt_ubah_telp_pegawai.setText(data_pegawai[4]);
            txt_ubah_tahun_pegawai.setText(data_pegawai[5]);

            res.close();
            stt.close();
            kon.close();

        } catch (Exception ex)
        {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        };
    }//GEN-LAST:event_btn_cari_ubah_pegawaiActionPerformed

    private void tbl_anggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_anggotaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount()==1) {
            row = tbl_anggota.getSelectedRow();
        }
    }//GEN-LAST:event_tbl_anggotaMouseClicked

    private void btn_daftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_daftarActionPerformed
        // TODO add your handling code here:

        //remove panel
        panelIsi.removeAll();
        panelIsi.repaint();
        panelIsi.revalidate();

        //add panel
        panelIsi.add(panelTambahAnggota);
        panelIsi.repaint();
        panelIsi.revalidate();

        //tambah
        membersihkan_teks();
        txt_nama_anggota.requestFocus();
        btn_simpan.setEnabled(true);
        btn_reset.setEnabled(true);
        btn_kembali.setEnabled(true);
        aktif_teks();
    }//GEN-LAST:event_btn_daftarActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
        lbl_cari.setVisible(true);
        txt_cari.setVisible(true);
        btn_batal.setVisible(true);

    }//GEN-LAST:event_btn_cariActionPerformed

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
        // TODO add your handling code here:
        //menghapus seluruh isi data dalam jtable
        tableAnggota.setRowCount(0);

        //gunakan query untuk mencari
        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM `anggota` WHERE nama_anggota LIKE '%"+txt_cari.getText()+"%'";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next())
            {
                data_anggota[0] = res.getString(1);
                data_anggota[1] = res.getString(2);
                data_anggota[2] = res.getString(3);
                data_anggota[3] = res.getString(4);
                data_anggota[4] = res.getString(5);
                tableAnggota.addRow(data_anggota);
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

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        lbl_cari.setVisible(false);
        txt_cari.setVisible(false);
        btn_batal.setVisible(false);
        tableAnggota.setRowCount(0);

        settableloadanggota();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_ubah_anggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubah_anggotaActionPerformed
        // TODO add your handling code here:
        //remove panel
        panelIsi.removeAll();
        panelIsi.repaint();
        panelIsi.revalidate();

        //add panel
        panelIsi.add(panelUbahAnggota);
        panelIsi.repaint();
        panelIsi.revalidate();
    }//GEN-LAST:event_btn_ubah_anggotaActionPerformed

    private void btn_hapus_anggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_anggotaActionPerformed
        // TODO add your handling code here:

        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "DELETE FROM anggota "
            +"WHERE "
            +"kode_anggota='"+tableAnggota.getValueAt(row, 0).toString()+"'";
            stt.executeUpdate(SQL);
            tableAnggota.removeRow(row);
            stt.close();
            kon.close();
            membersihkan_teks();
        } catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_btn_hapus_anggotaActionPerformed

    private void btn_simpan_anggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan_anggotaActionPerformed
        // TODO add your handling code here:
        String kode = txt_ubah_kode_anggota.getText();
        String nama = txt_ubah_nama_anggota.getText();
        String jk = "";
        if (rd_ubah_pria_anggota.isSelected()) {
            jk = "Pria";
        }
        else if (rd_ubah_wanita_anggota.isSelected())
        {
            jk = "Wanita";
        }

        String data_anggota[] = new String[6];
        String alamat = txt_ubah_alamat_anggota.getText();
        String telp = txt_ubah_tlp_anggota.getText();
        String tahun = txt_ubah_tgl_anggota.getText();

        if ((nama.isEmpty()))
        {
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi");
            txt_ubah_nama_anggota.requestFocus();
        }
        else if ((!rd_ubah_pria_anggota.isSelected()) && (!rd_ubah_wanita_anggota.isSelected()))
        {
            JOptionPane.showMessageDialog(this, "Tolong Pilih Jenis Kelamin Anda");
        }

        else
        {
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                String SQL = "UPDATE `anggota` "
                + "SET `nama_anggota`='"+nama+"',"
                + "`jk_anggota`='"+jk+"',"
                + "`alamat_anggota`='"+alamat+"',"
                + "`no_telp_anggota`='"+telp+"',"
                + "`tanggal_lahir`='"+tahun+"' "
                + "WHERE "
                + "`kode_anggota`='"+kode+"';";

                stt.executeUpdate(SQL);
                data_pegawai[0] = kode;
                data_pegawai[1] = nama;
                data_pegawai[2] = jk;
                data_pegawai[3] = alamat;
                data_pegawai[4] = telp;
                data_pegawai[5] = tahun;
                tablePegawai.removeRow(row);
                tablePegawai.insertRow(row, data_pegawai);
                stt.close();
                kon.close();
                membersihkan_teks();

                nonaktif_teks();
                JOptionPane.showMessageDialog(this,"Data berhasil Diubah");

            } catch (Exception ex)
            {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btn_simpan_anggotaActionPerformed

    private void btn_reset_anggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reset_anggotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_reset_anggotaActionPerformed

    private void btn_kembali_anggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembali_anggotaActionPerformed
        // TODO add your handling code here:
        //remove panel
        panelIsi.removeAll();
        panelIsi.repaint();
        panelIsi.revalidate();

        //add panel
        panelIsi.add(panelAnggota);
        panelIsi.repaint();
        panelIsi.revalidate();
    }//GEN-LAST:event_btn_kembali_anggotaActionPerformed

    private void btn_cari_ubah_anggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cari_ubah_anggotaActionPerformed
        // TODO add your handling code here:
        txt_ubah_nama_anggota.setEnabled(true);
        txt_ubah_alamat_anggota.setEnabled(true);
        txt_ubah_tgl_anggota.setEnabled(true);
        txt_ubah_tlp_anggota.setEnabled(true);
        txt_ubah_kode_anggota.setEnabled(false);

        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM anggota WHERE kode_anggota='"+txt_ubah_kode_anggota.getText()+"';";
            ResultSet res = stt.executeQuery(SQL);

            while (res.next())
            {
                data_anggota[0] = res.getString(1);
                data_anggota[1] = res.getString(2);
                data_anggota[2] = res.getString(3);
                data_anggota[3] = res.getString(4);
                data_anggota[4] = res.getString(5);
                data_anggota[5] = res.getString(6);
            }

            txt_ubah_kode_anggota.setText(data_anggota[0]);
            txt_ubah_nama_anggota.setText(data_anggota[1]);
            txt_ubah_alamat_anggota.setText(data_anggota[3]);
            txt_ubah_tlp_anggota.setText(data_anggota[4]);
            txt_ubah_tgl_anggota.setText(data_anggota[5]);

            res.close();
            stt.close();
            kon.close();

        } catch (Exception ex)
        {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        };
    }//GEN-LAST:event_btn_cari_ubah_anggotaActionPerformed

    private void btn_simpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan1ActionPerformed
        // TODO add your handling code here:

        String kelamin = "";
        if (rd_pria.isSelected()) {
            kelamin = "Pria";

        }
        else if (rd_wanita.isSelected())
        {
            kelamin = "Wanita";
        }

        String data[]  = new String[6];

        if ((txt_nama_anggota.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, silahkan dilengkapi");
            txt_nama_anggota.requestFocus();

        }
        else if ((!rd_wanita.isSelected()) && (!rd_pria.isSelected()))
        {
            JOptionPane.showMessageDialog(this,"Jenis Kelamin Harap Diisi");
        }
        else
        {
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO anggota(kode_anggota,"
                + "nama_anggota,"
                + "jk_anggota,"
                + "alamat_anggota,"
                + "no_telp_anggota,"
                + "tanggal_lahir) "
                + "VALUES "
                +"( '"+txt_kode_anggota.getText()+"',"
                +" '"+txt_nama_anggota.getText()+"' ,"
                +" '"+kelamin+"' ,"
                +" '"+txt_alamat.getText()+" ',"
                +" '"+txt_tlp.getText()+" ' ,"
                +" '"+txt_tgl.getText()+" ')";

                stt.executeUpdate(SQL);
                data[0] = txt_kode_anggota.getText();
                data[1] = txt_nama_anggota.getText();
                data[2] = kelamin;
                data[3] = txt_alamat.getText();
                data[4] = txt_tlp.getText();
                data[5] = txt_tgl.getText();
                tableAnggota.insertRow(0, data);
                stt.close();
                kon.close();
                membersihkan_teks();
                nonaktif_teks();
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");

            } catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE );
            }

        }
    }//GEN-LAST:event_btn_simpan1ActionPerformed

    private void btn_reset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reset1ActionPerformed
        // TODO add your handling code here:
        membersihkan_teks();
    }//GEN-LAST:event_btn_reset1ActionPerformed

    private void btn_kembali1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembali1ActionPerformed
        // TODO add your handling code here:

        //remove panel
        panelIsi.removeAll();
        panelIsi.repaint();
        panelIsi.revalidate();

        //add panel
        panelIsi.add(panelAnggota);
        panelIsi.repaint();
        panelIsi.revalidate();
    }//GEN-LAST:event_btn_kembali1ActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(pegawaiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pegawaiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pegawaiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pegawaiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pegawaiFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnggota;
    private javax.swing.JButton btnBuku;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnKaryawan;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnPeminjaman;
    private javax.swing.JButton btnPengembalian;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_batal_buku;
    private javax.swing.JButton btn_batal_karyawan;
    private javax.swing.JButton btn_batal_pegawai;
    private javax.swing.JButton btn_batal_pegawai1;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_cari_buku;
    private javax.swing.JButton btn_cari_ubah_anggota;
    private javax.swing.JButton btn_cari_ubah_buku;
    private javax.swing.JButton btn_cari_ubah_pegawai;
    private javax.swing.JButton btn_daftar;
    private javax.swing.JButton btn_hapus_anggota;
    private javax.swing.JButton btn_hapus_buku;
    private javax.swing.JButton btn_kembali;
    private javax.swing.JButton btn_kembali1;
    private javax.swing.JButton btn_kembali_anggota;
    private javax.swing.JButton btn_kembali_buku;
    private javax.swing.JButton btn_kembali_pegawai;
    private javax.swing.JButton btn_kembali_ubah;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_reset1;
    private javax.swing.JButton btn_reset_anggota;
    private javax.swing.JButton btn_reset_buku;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_simpan1;
    private javax.swing.JButton btn_simpan_anggota;
    private javax.swing.JButton btn_simpan_buku;
    private javax.swing.JButton btn_simpan_pegawai;
    private javax.swing.JButton btn_simpan_ubah;
    private javax.swing.JButton btn_tambah_buku;
    private javax.swing.JButton btn_ubah_anggota;
    private javax.swing.JButton btn_ubah_buku;
    private javax.swing.JButton btn_ubah_pegawai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lbl_cari;
    private javax.swing.JLabel lbl_cari_buku;
    private javax.swing.JLabel lbl_cari_karyawan;
    private javax.swing.JPanel panelAnggota;
    private javax.swing.JPanel panelBuku;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelIsi;
    private javax.swing.JPanel panelKaryawan;
    private javax.swing.JPanel panelKiri;
    private javax.swing.JPanel panelPeminjaman;
    private javax.swing.JPanel panelPengembalian;
    private javax.swing.JPanel panelTambahAnggota;
    private javax.swing.JPanel panelTambahAnggota1;
    private javax.swing.JPanel panelTambahBuku;
    private javax.swing.JPanel panelTambahPegawai;
    private javax.swing.JPanel panelUbahAnggota;
    private javax.swing.JPanel panelUbahBuku;
    private javax.swing.JPanel panelUbahPegawai;
    private javax.swing.JPanel panel_ubah_buku;
    private javax.swing.JRadioButton rd_pegawai_pria;
    private javax.swing.JRadioButton rd_pegawai_wanita;
    private javax.swing.JRadioButton rd_pria;
    private javax.swing.JRadioButton rd_pria1;
    private javax.swing.JRadioButton rd_ubah_pria;
    private javax.swing.JRadioButton rd_ubah_pria_anggota;
    private javax.swing.JRadioButton rd_ubah_wanita;
    private javax.swing.JRadioButton rd_ubah_wanita_anggota;
    private javax.swing.JRadioButton rd_wanita;
    private javax.swing.JRadioButton rd_wanita1;
    private javax.swing.JTable tbl_anggota;
    private javax.swing.JTable tbl_buku;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTextArea txt_alamat;
    private javax.swing.JTextArea txt_alamat1;
    private javax.swing.JTextField txt_banyak_buku;
    private javax.swing.JTextField txt_banyak_buku_ubah;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_cari_buku;
    private javax.swing.JTextField txt_cari_karyawan;
    private javax.swing.JTextField txt_edisi;
    private javax.swing.JTextField txt_edisi_ubah;
    private javax.swing.JTextField txt_judul;
    private javax.swing.JTextField txt_judul_ubah;
    private javax.swing.JTextField txt_kode_anggota;
    private javax.swing.JTextField txt_kode_buku;
    private javax.swing.JTextField txt_kode_buku_ubah;
    private javax.swing.JTextField txt_kode_pegawai_tambah;
    private javax.swing.JTextField txt_nama_anggota;
    private javax.swing.JTextField txt_nama_anggota1;
    private javax.swing.JTextField txt_nama_pegawai_tambah;
    private javax.swing.JTextField txt_penerbit;
    private javax.swing.JTextField txt_penerbit_ubah;
    private javax.swing.JTextField txt_pengarang;
    private javax.swing.JTextField txt_pengarang_ubah;
    private javax.swing.JTextField txt_tahun_buku;
    private javax.swing.JTextField txt_tahun_buku_ubah;
    private javax.swing.JTextArea txt_tambah_alamat_pegawai;
    private javax.swing.JTextField txt_tambah_tahun_pegawai;
    private javax.swing.JTextField txt_telp_tambah_pegawai;
    private javax.swing.JTextField txt_tgl;
    private javax.swing.JTextField txt_tgl1;
    private javax.swing.JTextField txt_tlp;
    private javax.swing.JTextField txt_tlp1;
    private javax.swing.JTextArea txt_ubah_alamat_anggota;
    private javax.swing.JTextArea txt_ubah_alamat_pegawai;
    private javax.swing.JTextField txt_ubah_kode_anggota;
    private javax.swing.JTextField txt_ubah_kode_pegawai;
    private javax.swing.JTextField txt_ubah_nama_anggota;
    private javax.swing.JTextField txt_ubah_nama_pegawai;
    private javax.swing.JTextField txt_ubah_tahun_pegawai;
    private javax.swing.JTextField txt_ubah_telp_pegawai;
    private javax.swing.JTextField txt_ubah_tgl_anggota;
    private javax.swing.JTextField txt_ubah_tlp_anggota;
    // End of variables declaration//GEN-END:variables
}
