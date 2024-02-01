/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;

import Controller.ImplementSiswa;
import Model.MSiswa;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Martogi Jekson
 */
public class Siswa extends javax.swing.JInternalFrame {
    
    //1.
    List<MSiswa> record = new ArrayList<>();
    Interface.InterfaceSiswa SiswaService;
    int row;
    int nilai_tabel;

    /**
     * Creates new form Siswa
     */
    public Siswa() {
        initComponents();
        
        //4.
        SiswaService = new ImplementSiswa();
        
        //5.
        this.awal();
        this.auto_number();
        
        //11.panggil refresh data
        this.refreshdata();
    }
    
    //2.
    void awal(){
        jTextField_NoPendaftaran.setEnabled(false);
        jTextField_Nama.setText("");
        jTextField_TptLahir.setText("");
        jDateChooser_TglLahir.setDate(null);
        jComboBox_JK.setSelectedIndex(0);
        jTextField_Alamat.setText("");
        jTextField_AsalSekolah.setText("");
        jTextField_Nilai.setText("");
        jTextField_OrgTua.setText("");
        jTextField_NoTelp.setText("");
        
        jButton_Simpan.setEnabled(true);
        jButton_Edit.setEnabled(false);
        jButton_Hapus.setEnabled(false);
    }
    
    //3.
    void auto_number()
    {
        try {
            jTextField_NoPendaftaran.setText(SiswaService.autonumber());
        } catch (SQLException ex) {
            Logger.getLogger(Siswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //6.buat struktur tabel
    public void Tabel(javax.swing.JTable tb, int lebar[]){
        tb.setAutoResizeMode(tb.AUTO_RESIZE_OFF);
        int kolom = tb.getColumnCount();
        for (int i=0; i<kolom; i++) {
            javax.swing.table.TableColumn tbc = tb.getColumnModel().getColumn(i);
            tbc.setPreferredWidth(lebar[i]);
            tb.setRowHeight(17);
        }
    }
    
    private javax.swing.table.DefaultTableModel getDefaultTabelModel_Siswa() {
        
        return new javax.swing.table.DefaultTableModel (
                new Object[][]{},
                new String[]{"no_pendaftaran", "nama_lengkap", "tempat_lahir", "tgl_lahir", "jns_kelamin",
                    "alamat", "asal_sekolah", "nilai_uan", "nama_ortu_wali", "no_telp"}) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false
            };
            
            public boolean isCellEdittable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
    }
    
    private javax.swing.table.DefaultTableModel
            tbModel_Siswa = getDefaultTabelModel_Siswa();
    
    //Tutup Struktur Tabel
    
    //7.Panggil data
    void panggildata() {
        try {
            record = SiswaService.tampil();
        } catch (Exception e) {
            System.err.println("" + e);
        }
    }
    
    //8.
    void isitabel() {
        Object data[][] = new Object [record.size()][10];
        int x = 0;
        for (MSiswa o : record) {
            data[x][0] = o.getNo_pendaftaran();
            data[x][1] = o.getNama_lengkap();
            data[x][2] = o.getTempat_lahir();
            data[x][3] = o.getTgl_lahir();
            data[x][4] = o.getJns_kelamin();
            data[x][5] = o.getAlamat();
            data[x][6] = o.getAsal_sekolah();
            data[x][7] = o.getNilai_uan();
            data[x][8] = o.getNama_ortu_wali();
            data[x][9] = o.getNo_telp();
            
            x++;
            String judul[] = {"No Pendaftaran", "Nama", "Tempat Lahir", "Tgl Lahir", "Jenis Kelamin",
                    "Alamat", "Asal Sekolah", "Nilai", "Nama_ortu_wali", "No telp"};
            jTable_Siswa.setModel(new DefaultTableModel(data, judul));
        }
    }
    
    //9.
    void refreshdata() {
        panggildata();
        isitabel();
        auto_number();
    }
    
    //10.
    void caridata(){
        try{
            record = SiswaService.tampil_cari(jTextField_Cari.getText());
            jTable_Siswa.setModel(tbModel_Siswa);
            isitabel();
        } catch (Exception e) {
            System.err.println("" + e);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField_Nama = new javax.swing.JTextField();
        jTextField_TptLahir = new javax.swing.JTextField();
        jTextField_Alamat = new javax.swing.JTextField();
        jTextField_AsalSekolah = new javax.swing.JTextField();
        jTextField_Nilai = new javax.swing.JTextField();
        jTextField_OrgTua = new javax.swing.JTextField();
        jTextField_NoTelp = new javax.swing.JTextField();
        jComboBox_JK = new javax.swing.JComboBox<>();
        jDateChooser_TglLahir = new com.toedter.calendar.JDateChooser();
        jButton_Simpan = new javax.swing.JButton();
        jButton_Edit = new javax.swing.JButton();
        jButton_Hapus = new javax.swing.JButton();
        jButton_Keluar = new javax.swing.JButton();
        jButton_Refresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Siswa = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jTextField_Cari = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_NoPendaftaran = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Siswa");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("PENDAFTARAN SISWA BARU");

        jLabel2.setText("NAMA");

        jLabel3.setText("TEMPAT/TGL LAHIR");

        jLabel5.setText("JENIS KELAMIN");

        jLabel6.setText("ALAMAT");

        jLabel7.setText("ASAL SEKOLAH");

        jLabel8.setText("NILAI UAN");

        jLabel9.setText("NAMA  ORANGTUA/WALI");

        jLabel10.setText("NO TELEPON");

        jComboBox_JK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "L", "P" }));

        jDateChooser_TglLahir.setDateFormatString("yyyy-MM-dd");

        jButton_Simpan.setText("SIMPAN");
        jButton_Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SimpanActionPerformed(evt);
            }
        });

        jButton_Edit.setText("EDIT");
        jButton_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EditActionPerformed(evt);
            }
        });

        jButton_Hapus.setText("HAPUS");
        jButton_Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HapusActionPerformed(evt);
            }
        });

        jButton_Keluar.setText("KELUAR");
        jButton_Keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_KeluarActionPerformed(evt);
            }
        });

        jButton_Refresh.setText("REFRESH");
        jButton_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RefreshActionPerformed(evt);
            }
        });

        jTable_Siswa.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_Siswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_SiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Siswa);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("DATA SISWA");

        jTextField_Cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_CariKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setText("CARI DATA SISWA (NAMA)");

        jLabel4.setText("NO PENDAFTARAN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(265, 265, 265))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jTextField_Cari))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Nama)
                            .addComponent(jTextField_Alamat)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox_JK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_AsalSekolah, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_Nilai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField_TptLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jDateChooser_TglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(jTextField_OrgTua)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_NoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton_Refresh)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton_Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField_NoPendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 105, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_NoPendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTextField_TptLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser_TglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox_JK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_AsalSekolah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField_Nilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField_OrgTua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField_NoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Cari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RefreshActionPerformed
        // TODO add your handling code here:
        this.awal();
        this.refreshdata();
    }//GEN-LAST:event_jButton_RefreshActionPerformed

    private void jButton_KeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_KeluarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton_KeluarActionPerformed

    private void jButton_SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SimpanActionPerformed
        // TODO add your handling code here:
        if (jTextField_NoPendaftaran.getText().equals("")
                || jTextField_Nama.getText().equals("")
                || jTextField_Nilai.getText().equals("")
                || jTextField_OrgTua.getText().equals("")) {
            JOptionPane.showMessageDialog
        (this, "Mohon Maaf, ada data yang belum anda inputkan"
        + "\n" +"Silahkan coba kembali", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            MSiswa o = new MSiswa();
            o.setNo_pendaftaran(jTextField_NoPendaftaran.getText());
            o.setNama_lengkap(jTextField_Nama.getText());
            o.setTempat_lahir(jTextField_TptLahir.getText());
            o.setTgl_lahir(jDateChooser_TglLahir.getDate().toString());
            o.setJns_kelamin(jComboBox_JK.getSelectedItem().toString());
            o.setAlamat(jTextField_Alamat.getText());
            o.setAsal_sekolah(jTextField_AsalSekolah.getText());
            o.setNilai_uan(jTextField_Nilai.getText());
            o.setNama_ortu_wali(jTextField_OrgTua.getText());
            o.setNo_telp(jTextField_NoTelp.getText());
            try {
                SiswaService.simpan(o);
                JOptionPane.showMessageDialog
                (this, "Data berhasil ditambahkan", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                awal();
                refreshdata();
                auto_number();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Mohon Maaf" + "\n" + "ada kesalahan pada" + e, 
                "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton_SimpanActionPerformed

    private void jButton_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EditActionPerformed
        // TODO add your handling code here:
        if (jTextField_NoPendaftaran.getText().equals("")
                || jTextField_Nama.getText().equals("")
                || jTextField_Nilai.getText().equals("")
                || jTextField_OrgTua.getText().equals("")) {
            JOptionPane.showMessageDialog
        (this, "Mohon Maaf, ada data yang belum anda inputkan"
        + "\n" +"Silahkan coba kembali", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            MSiswa o = new MSiswa();
            o.setNo_pendaftaran(jTextField_NoPendaftaran.getText());
            o.setNama_lengkap(jTextField_Nama.getText());
            o.setTempat_lahir(jTextField_TptLahir.getText());
            o.setTgl_lahir(jDateChooser_TglLahir.getDate().toString());
            o.setJns_kelamin(jComboBox_JK.getSelectedItem().toString());
            o.setAlamat(jTextField_Alamat.getText());
            o.setAsal_sekolah(jTextField_AsalSekolah.getText());
            o.setNilai_uan(jTextField_Nilai.getText());
            o.setNama_ortu_wali(jTextField_OrgTua.getText());
            o.setNo_telp(jTextField_NoTelp.getText());
            try {
                SiswaService.edit(o);
                JOptionPane.showMessageDialog
                (this, "Data berhasil diubah", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                awal();
                refreshdata();
                auto_number();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Mohon Maaf" + "\n" + "ada kesalahan pada" + e, 
                "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton_EditActionPerformed

    private void jTable_SiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_SiswaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
        jButton_Edit.setEnabled(true);
        jButton_Hapus.setEnabled(true);
        jButton_Simpan.setEnabled(false);
        nilai_tabel = jTable_Siswa.getSelectedRow();
        jTextField_NoPendaftaran.setText(jTable_Siswa.getValueAt(nilai_tabel, 0).toString());
        jTextField_Nama.setText(jTable_Siswa.getValueAt(nilai_tabel, 1).toString());
        jTextField_TptLahir.setText(jTable_Siswa.getValueAt(nilai_tabel, 2).toString());
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Sesuaikan dengan format tgl lahir dari tabel

        try {
        // Mengonversi string tgl lahir dari tabel menjadi objek Date
        Date tanggalLahir = formatter.parse(jTable_Siswa.getValueAt(nilai_tabel, 3).toString());

        // Menetapkan nilai tgl lahir ke jDateChooser
        jDateChooser_TglLahir.setDate(tanggalLahir);
            } catch (ParseException e) {
                    e.printStackTrace(); // Tindakan yang sesuai jika terjadi kesalahan parsing
            }

        
        jComboBox_JK.setSelectedItem(jTable_Siswa.getValueAt(nilai_tabel, 4).toString());
        jTextField_Alamat.setText(jTable_Siswa.getValueAt(nilai_tabel, 5).toString());
        jTextField_AsalSekolah.setText(jTable_Siswa.getValueAt(nilai_tabel, 6).toString());
        jTextField_Nilai.setText(jTable_Siswa.getValueAt(nilai_tabel, 7).toString());
        jTextField_OrgTua.setText(jTable_Siswa.getValueAt(nilai_tabel, 8).toString());
        jTextField_NoTelp.setText(jTable_Siswa.getValueAt(nilai_tabel, 9).toString());
    }
    }//GEN-LAST:event_jTable_SiswaMouseClicked

    private void jButton_HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HapusActionPerformed
        // TODO add your handling code here:
        try {
        SiswaService.hapus(jTextField_NoPendaftaran.getText());
        JOptionPane.showMessageDialog(this, "berhasil menghapus data",
                "Sukses", JOptionPane.INFORMATION_MESSAGE);
        
        // Buat model tabel baru atau dapatkan model tabel yang valid
        DefaultTableModel tblModel_Siswa = new DefaultTableModel();
        // Isi model tabel dengan data yang sesuai
        
        jTable_Siswa.setModel(tblModel_Siswa); // Atur model tabel yang valid
        this.awal();
        this.refreshdata();
        jButton_Edit.setEnabled(false);
        jButton_Hapus.setEnabled(false);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Mohon Maaf" + "\n" + 
                "ada kesalahan pada" + e, "Kesalahan", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton_HapusActionPerformed

    private void jTextField_CariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CariKeyReleased
        // TODO add your handling code here:
        caridata();
    }//GEN-LAST:event_jTextField_CariKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Edit;
    private javax.swing.JButton jButton_Hapus;
    private javax.swing.JButton jButton_Keluar;
    private javax.swing.JButton jButton_Refresh;
    private javax.swing.JButton jButton_Simpan;
    private javax.swing.JComboBox<String> jComboBox_JK;
    private com.toedter.calendar.JDateChooser jDateChooser_TglLahir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Siswa;
    private javax.swing.JTextField jTextField_Alamat;
    private javax.swing.JTextField jTextField_AsalSekolah;
    private javax.swing.JTextField jTextField_Cari;
    private javax.swing.JTextField jTextField_Nama;
    private javax.swing.JTextField jTextField_Nilai;
    private javax.swing.JTextField jTextField_NoPendaftaran;
    private javax.swing.JTextField jTextField_NoTelp;
    private javax.swing.JTextField jTextField_OrgTua;
    private javax.swing.JTextField jTextField_TptLahir;
    // End of variables declaration//GEN-END:variables
}
