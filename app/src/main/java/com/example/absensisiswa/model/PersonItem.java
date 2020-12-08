package com.example.absensisiswa.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonItem {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("nama")
    @Expose
    private String nama;

    @SerializedName("kelas")
    @Expose
    private String kelas;

    @SerializedName("pelajaran")
    @Expose
    private String pelajaran;

    @SerializedName("keterangan_masuk")
    @Expose
    private String keterangan_masuk;

    @SerializedName("tanggal")
    @Expose
    private String tanggal;

    public PersonItem() {

    }

    public PersonItem(int id, String nama, String kelas, String pelajaran, String keterangan_masuk, String tanggal) {
        this.id = id;
        this.nama = nama;
        this.kelas = kelas;
        this.pelajaran = pelajaran;
        this.keterangan_masuk = keterangan_masuk;
        this.tanggal = tanggal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getKelas() {
        return kelas;
    }

    public void setPelajaran(String pelajaran) {
        this.pelajaran = pelajaran;
    }

    public String getPelajaran() {
        return pelajaran;
    }

    public void setKeterangan_masuk(String keterangan_masuk) {
        this.keterangan_masuk = keterangan_masuk;
    }

    public String getKeterangan_masuk() {
        return keterangan_masuk;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTanggal() {
        return tanggal;
    }
}
