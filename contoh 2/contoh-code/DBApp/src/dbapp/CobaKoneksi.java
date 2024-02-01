package dbapp;

import java.sql.Connection;

/**
 *
 * @author dearsa
 */
public class CobaKoneksi  {
   
     public static void main(String args[]) {
         try {
             MyDBConnection c = new MyDBConnection();
             c.init();
             Connection conn=c.getMyConnection();
             if (conn != null) {
		System.out.println("Koneksi berhasil!");
            } else {
                System.out.println("Koneksi gagal!");
            }
            c.destroy();
         }
         catch (Exception e) {
             e.printStackTrace();
         }  
    }
}
