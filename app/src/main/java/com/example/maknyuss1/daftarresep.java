package com.example.maknyuss1;

public class daftarresep {

    private String id,nama,keterangan;
    private  int id_gambar , gambarresep;

    public daftarresep(String id,String nama,String keterangan, int id_gambar ,int gambarresep){
        this.id = id;
        this.nama = nama;
        this.keterangan = keterangan;
        this.id_gambar = id_gambar;
        this.gambarresep = gambarresep;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getId_gambar() {
        return id_gambar;
    }

    public void setId_gambar(int id_gambar) {
        this.id_gambar = id_gambar;
    }

    public int getGambarresep() {
        return gambarresep;
    }

    public void setGambarresep(int gambarresep) {
        this.gambarresep = gambarresep;
    }
}
