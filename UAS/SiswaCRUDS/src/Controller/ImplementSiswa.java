/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Interface.InterfaceSiswa;
import Koneksi.Koneksi;
import Model.MSiswa;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Martogi Jekson
 */
public class ImplementSiswa implements InterfaceSiswa {

    private String nama_lengkap;

    @Override
    public MSiswa simpan(MSiswa o) throws SQLException {
    try {
        // Format yang cocok dengan "Tue Jan 02 20:07:00 WIB 2024"
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        SimpleDateFormat mysqlDateFormatter = new SimpleDateFormat("yyyy-MM-dd");

        PreparedStatement st = Koneksi.sambung().prepareStatement("INSERT INTO pendaftaran_siswa (no_pendaftaran, nama_lengkap, tempat_lahir, tgl_lahir, jns_kelamin, alamat, asal_sekolah, nilai_uan, nama_ortu_wali, no_telp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        st.setString(1, o.getNo_pendaftaran());
        st.setString(2, o.getNama_lengkap());
        st.setString(3, o.getTempat_lahir());
        
        // Mengubah format tanggal ke format yang diharapkan oleh MySQL
        java.util.Date tanggal = formatter.parse(o.getTgl_lahir());
        String mysqlFormattedDate = mysqlDateFormatter.format(tanggal);
        java.sql.Date sqlDate = java.sql.Date.valueOf(mysqlFormattedDate);
        st.setDate(4, sqlDate);
        
        st.setString(5, o.getJns_kelamin());
        st.setString(6, o.getAlamat());
        st.setString(7, o.getAsal_sekolah());
        st.setString(8, o.getNilai_uan());
        st.setString(9, o.getNama_ortu_wali());
        st.setString(10, o.getNo_telp());

        st.executeUpdate();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Eror Simpan pada : " + e);
    }
    return o;
}

    @Override
    public void edit(MSiswa o) throws SQLException {
    try {
        Connection connection = (Connection) Koneksi.sambung();
        String query = "UPDATE pendaftaran_siswa SET "
                + "nama_lengkap=?, "
                + "tempat_lahir=?, "
                + "tgl_lahir=?, "
                + "jns_kelamin=?, "
                + "alamat=?, "
                + "asal_sekolah=?, "
                + "nilai_uan=?, "
                + "nama_ortu_wali=?, "
                + "no_telp=? "
                + "WHERE no_pendaftaran=?";

        PreparedStatement st = connection.prepareStatement(query);
        st.setString(1, o.getNama_lengkap());
        st.setString(2, o.getTempat_lahir());
        
        // Mengubah format tanggal ke format yang diharapkan oleh MySQL
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        SimpleDateFormat mysqlDateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date tanggal = formatter.parse(o.getTgl_lahir());
        String mysqlFormattedDate = mysqlDateFormatter.format(tanggal);
        java.sql.Date sqlDate = java.sql.Date.valueOf(mysqlFormattedDate);
        st.setDate(3, sqlDate);
        
        st.setString(4, o.getJns_kelamin());
        st.setString(5, o.getAlamat());
        st.setString(6, o.getAsal_sekolah());
        st.setString(7, o.getNilai_uan());
        st.setString(8, o.getNama_ortu_wali());
        st.setString(9, o.getNo_telp());
        st.setString(10, o.getNo_pendaftaran());

        st.executeUpdate();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error Edit pada: " + e);
    }
}

    @Override
    public void hapus(String nomor_pendaftaran) throws SQLException {
    try {
        PreparedStatement st = Koneksi.sambung().prepareStatement("DELETE from pendaftaran_siswa WHERE no_pendaftaran=?");
        st.setString(1, nomor_pendaftaran); // Menggunakan indeks parameter 1 untuk nama_lengkap
        st.executeUpdate();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Eror Hapus pada : " + e);
    }
}
    @Override
    public String autonumber() throws SQLException {
       String j = null;   
        try {
            Statement stm = (Statement) Koneksi.sambung().createStatement();
            // Mendapatkan tanggal hari ini
            java.util.Date currentDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
            String formattedDate = new java.text.SimpleDateFormat("yyMMdd").format(sqlDate);
            // Mengambil urutan terakhir berdasarkan tanggal hari ini
            ResultSet rs = stm.executeQuery("SELECT MAX(SUBSTRING(no_pendaftaran, 7)) AS no FROM pendaftaran_siswa WHERE MID(no_pendaftaran, 1, 6) = '" + formattedDate + "'");
            int urutan = 1; // Nilai default jika tidak ada data sebelumnya
            while(rs.next()) {
                if(rs.getString("no") != null) {
                    urutan = Integer.parseInt(rs.getString("no")) + 1;
                }
            }
            // Mengonversi urutan menjadi format 4 digit dengan leading zeros
            String urutanFormatted = String.format("%04d", urutan);

            // Menggabungkan tahun, bulan, tanggal, dan urutan untuk mendapatkan nomor pendaftaran baru
            j = formattedDate + urutanFormatted;

            rs.close();
            stm.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }
        return j;
    }

    @Override
    public List<MSiswa> tampil() throws SQLException {
        List<MSiswa> listsiswa = new ArrayList<>();
        try {
            Statement stm = (Statement) Koneksi.sambung().createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM pendaftaran_siswa ORDER BY no_pendaftaran ASC");
            while (rst.next()){
                MSiswa c = new MSiswa();
                c.setNo_pendaftaran(rst.getString("no_pendaftaran"));
                c.setNama_lengkap(rst.getString("nama_lengkap"));
                c.setTempat_lahir(rst.getString("tempat_lahir"));
                c.setTgl_lahir(rst.getString("tgl_lahir"));
                c.setJns_kelamin(rst.getString("jns_kelamin"));
                c.setAlamat(rst.getString("alamat"));
                c.setAsal_sekolah(rst.getString("asal_sekolah"));
                c.setNilai_uan(rst.getString("nilai_uan"));
                c.setNama_ortu_wali(rst.getString("nama_ortu_wali"));
                c.setNo_telp(rst.getString("no_telp"));
                
                listsiswa.add(c);
                
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Eror Tampil pada : " + e);
        }
        return listsiswa;
    }

    @Override
    public List<MSiswa> tampil_cari(String cari) throws SQLException {
        List<MSiswa> listsiswa = new ArrayList<>();
        try {
            PreparedStatement ps = Koneksi.sambung().prepareStatement("SELECT * FROM pendaftaran_siswa WHERE nama_lengkap LIKE ?");
            ps.setString(1, "%" + cari + "%");
            ResultSet rst = ps.executeQuery();

            while (rst.next()){
                MSiswa c = new MSiswa();
                c.setNo_pendaftaran(rst.getString("no_pendaftaran"));
                c.setNama_lengkap(rst.getString("nama_lengkap"));
                c.setTempat_lahir(rst.getString("tempat_lahir"));
                c.setTgl_lahir(rst.getString("tgl_lahir"));
                c.setJns_kelamin(rst.getString("jns_kelamin"));
                c.setAlamat(rst.getString("alamat"));
                c.setAsal_sekolah(rst.getString("asal_sekolah"));
                c.setNilai_uan(rst.getString("nilai_uan"));
                c.setNama_ortu_wali(rst.getString("nama_ortu_wali"));
                c.setNo_telp(rst.getString("no_telp"));
                
                listsiswa.add(c);
                
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Eror Tampil pada : " + e);
        }
        return listsiswa;
    }
    
}
