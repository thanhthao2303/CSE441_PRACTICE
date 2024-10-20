package com.example.btth04;


public class SinhVien {
    public String hoten;
    public String mssv;
    public String lop;
    public double diem;

    public SinhVien() {
        // Bắt buộc cho Firebase
    }

    public SinhVien(String hoten, String mssv, String lop, double diem) {
        this.hoten = hoten;
        this.mssv = mssv;
        this.lop = lop;
        this.diem = diem;
    }
}

