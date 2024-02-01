package dbapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLAccess {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  public void readDataBase() throws Exception {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost/db_oop","root","madearsa");
      
      statement = connect.createStatement();
      resultSet = statement.executeQuery("select * from pelanggan");
      writeResultSet(resultSet);

      preparedStatement = connect.prepareStatement("insert into pelanggan values (?, ?, ?, ?)");
      preparedStatement.setString(1, "P0006");
      preparedStatement.setString(2, "Budi Hartanto");
      preparedStatement.setString(3, "Denpasar");
      preparedStatement.setString(4, "+628180407847");
      preparedStatement.executeUpdate();

      preparedStatement = connect.prepareStatement("select * from pelanggan");
      resultSet = preparedStatement.executeQuery();
      writeResultSet(resultSet);
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }

  private void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
    while (resultSet.next()) {
      String idpel = resultSet.getString("id_pelanggan");
      String namapel = resultSet.getString("nama_pelanggan");
      String alamat = resultSet.getString("alamat");
      String nohp = resultSet.getString("no_hp");
      System.out.println("ID Pelanggan: " + idpel);
      System.out.println("Nama Pelanggan: " + namapel);
      System.out.println("Alamat: " + alamat);
      System.out.println("NoHP: " + nohp);
      System.out.println("\n");
    }
  }

  // You need to close the resultSet
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {
        e.printStackTrace();
    }
  }

}