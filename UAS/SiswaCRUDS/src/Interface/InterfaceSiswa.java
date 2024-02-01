/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.sql.SQLException;
import Model.MSiswa;
import java.util.List;

/**
 *
 * @author Martogi Jekson
 */
public interface InterfaceSiswa {
    
    MSiswa simpan(MSiswa o)throws SQLException;
    void edit(MSiswa o)throws SQLException;
    void hapus(String no_pendaftaran)throws SQLException;
    String autonumber() throws SQLException;
    List<MSiswa> tampil() throws SQLException;
    List<MSiswa> tampil_cari(String cari) throws SQLException;
}
