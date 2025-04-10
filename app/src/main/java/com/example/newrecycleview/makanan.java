package com.example.newrecycleview;

import androidx.recyclerview.widget.RecyclerView;

public class makanan {
    String nama;

    String harga;

    int image;



    public makanan(String nama, String harga,int image) {
        this.nama = nama;
        this.harga = harga;
        this.image = image;

    }
    public int getImage() {
        return image;
    }
    public String getNama() {
        return nama;
    }

    public String getHarga() {
        return harga;
    }
}
