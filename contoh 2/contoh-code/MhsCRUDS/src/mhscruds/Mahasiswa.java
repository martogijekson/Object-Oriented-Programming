/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mhscruds;

import java.util.Date;

public class Mahasiswa {
    private String _nim;
    private String _nama;
    private Date _tglLahir;
    private String _noHP;
    private String _jnsKelamin;
    private String _alamat;
    private String _jurusan;

    public String getNim() {
        return _nim;
    }

    public void setNim(String nim) {
        this._nim = nim;
    }

    public String getNama() {
        return _nama;
    }

    public void setNama(String nama) {
        this._nama = nama;
    }

    public Date getTglLahir() {
        return _tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this._tglLahir = tglLahir;
    }

    public String getNoHP() {
        return _noHP;
    }

    public void setNoHP(String noHP) {
        this._noHP = noHP;
    }
    
    public String getJnsKelamin() {
        return _jnsKelamin;
    }
  
    public void setJnsKelamin(String jnsKelamin) {
        this._jnsKelamin = jnsKelamin;
    }

    public String getAlamat() {
        return _alamat;
    }

    public void setAlamat(String alamat) {
        this._alamat = alamat;
    }

    public String getJurusan() {
        return _jurusan;
    }

    public void setJurusan(String jurusan) {
        this._jurusan = jurusan;
    }
   
    public Mahasiswa()
    {
        _nim = "";
        _nama = "";
        _tglLahir = new Date();
        _noHP = "";
        _jnsKelamin = "";
        _alamat = "";
        _jurusan = "";
    }
   
    public Mahasiswa(String NIM, String Nama, Date TglLahir, String NoHP, String JnsKelamin, String Alamat, String Jurusan)
    {
        _nim = NIM;
        _nama = Nama;
        _tglLahir = TglLahir;
        _noHP = NoHP;
        _jnsKelamin = JnsKelamin;
        _alamat = Alamat;
        _jurusan = Jurusan;
    }      
}
