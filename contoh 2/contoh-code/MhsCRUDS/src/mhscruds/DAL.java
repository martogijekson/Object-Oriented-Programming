/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mhscruds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAL {

    private Connection myConnection;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public DAL() {        
    }

    private void init() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost/db_oop", "root", "");
        } catch (Exception e) {
            System.out.println("Gagal menginisialisasi koneksi");
            e.printStackTrace();
        }
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (myConnection != null) {
                myConnection.close();
            }
        } catch (SQLException se) {
        } catch (Exception ex) {
        }
    }

    public List<Mahasiswa> GetAllDataMahasiswa() {
        try {            
            init();
            List<Mahasiswa> retValue = new ArrayList<>();
            
            statement = myConnection.createStatement();
            resultSet = statement.executeQuery("SELECT nim,nama,tgl_lahir,no_hp,jns_kelamin,alamat,jurusan FROM mahasiswa ORDER BY NIM");
                       
            while (resultSet.next()) {
                retValue.add(new Mahasiswa(resultSet.getString("nim"),resultSet.getString("nama"),resultSet.getTimestamp("tgl_lahir"),resultSet.getString("no_hp"),resultSet.getString("jns_kelamin"),resultSet.getString("alamat"),resultSet.getString("jurusan")));
            }
            
            return retValue;
            
        } catch (SQLException se) {
            return null;
        } catch (Exception ex) {            
            return null;
        } finally {
            close();
        }
    }
    
     public Mahasiswa GetDataMahasiswa(String NIM) {
        try {     
            init();
            Mahasiswa retValue = null;
            
            preparedStatement = myConnection.prepareStatement("SELECT * FROM mahasiswa WHERE nim = ?");            
            preparedStatement.setString(1, NIM);
            resultSet =  preparedStatement.executeQuery();
                       
            while (resultSet.next()) {
                retValue = new Mahasiswa(resultSet.getString("nim"),resultSet.getString("nama"),resultSet.getTimestamp("tgl_lahir"),resultSet.getString("no_hp"),resultSet.getString("jns_kelamin"),resultSet.getString("alamat"),resultSet.getString("jurusan"));
            }
            
            return retValue;
            
        } catch (SQLException se) {
            return null;
        } catch (Exception ex) {            
            return null;
        } finally {
            close();
        }
    }
    
    public int InsertDataMahasiswa(Mahasiswa newMhs)
    {
        try
        {
            init();
            
            preparedStatement = myConnection.prepareStatement("INSERT INTO mahasiswa VALUES(?,?,?,?,?,?,?)");            
            preparedStatement.setString(1, newMhs.getNim());
            preparedStatement.setString(2, newMhs.getNama());
            preparedStatement.setDate(3, new java.sql.Date(newMhs.getTglLahir().getTime()));
            preparedStatement.setString(4, newMhs.getNoHP());
            preparedStatement.setString(5, newMhs.getJnsKelamin());
            preparedStatement.setString(6, newMhs.getAlamat());
            preparedStatement.setString(7, newMhs.getJurusan());
            preparedStatement.executeUpdate();
            
            return 1;
            
        } catch (SQLException se) {
            return -1;
        } catch (Exception ex) {            
            return -1;
        } finally {
            close();
        }
    }
  
}
