/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mhscruds;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MahasiswaTableModel extends AbstractTableModel {

    private String[] columnNames = {"NIM",
        "Nama",
        "Tgl Lahir",
        "No HP",
        "Jenis Kelamin",
        "Alamat",
        "Jurusan"};

    private List<Mahasiswa> data = null;

    public void SetData(List<Mahasiswa> _data) {
        data = _data;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Object ret = null;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        
        switch (col) {
            case 0:
                ret = data.get(row).getNim();
                break;
            case 1:
                ret = data.get(row).getNama();
                break;
            case 2:
                ret = df.format(data.get(row).getTglLahir());
                break;
            case 3:
                ret = data.get(row).getNoHP();
                break;  
            case 4:
                ret = data.get(row).getJnsKelamin();
                break;
            case 5:
                ret = data.get(row).getAlamat();
                break;
            case 6:
                ret = data.get(row).getJurusan();
                break;
            default:
                break;
        }

        return ret;
    }

    public Class getColumnClass(int c) {        
        return getValueAt(0, c).getClass();
    }
}
