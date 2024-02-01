/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Koneksi;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.DriverManager;

/**
 *
 * @author Martogi Jekson
 */
public class Koneksi {
    
    private static Connection con; // variabel con untuk koneksi
    private static String host, db, user, pass, port; // variabel untuk akses database
    public static Connection sambung() throws SQLException{
        
        host = "localhost";
        db = "siswa";
        user = "root";
        pass = "";
        port = "3306";
        
        if (con == null) {
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                con = (Connection) DriverManager.
                getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, pass);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        
    return con;
   }
}