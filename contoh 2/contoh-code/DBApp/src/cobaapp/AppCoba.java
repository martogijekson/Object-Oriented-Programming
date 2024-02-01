
package cobaapp;
import dbapp.MySQLAccess;

public class AppCoba {
  public static void main(String[] args) {
    try{
        MySQLAccess dao = new MySQLAccess();
        dao.readDataBase();
    }catch(Exception e){
        e.printStackTrace();
    }
  }


} 
