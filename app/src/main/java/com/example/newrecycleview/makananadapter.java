package com.example.newrecycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
                                                                        //ini nama class ynag dibawah(ViewHolder)
public class makananadapter extends RecyclerView.Adapter<makananadapter.ViewHolder> {
    ArrayList<makanan>listmakanan;


    private final OnItemClickListener listener;

    //class yang masih kosong
    public interface OnItemClickListener {
        void onItemClick(makanan makananModel);
    }

//konstruktor untuk mengisi parameter dari main menuju adapter
 public makananadapter(ArrayList<makanan> listmakanan, OnItemClickListener listener){
    this.listmakanan = listmakanan;
     this.listener = listener;
 }
    @NonNull
    @Override
    //dijalankan sekali
    //untuk menyambungkan ke item_layout.xml
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    //memasang data sesuai urutan di item_layout.xml
    //dijalankan sesuai banyak data
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        makanan item = listmakanan.get(position);
        holder.tvMakanan.setText(item.getNama());
        holder.tvHarga.setText(item.getHarga());
        holder.tvImage.setImageResource(item.getImage());

        //action
        holder.itemView.setOnClickListener(v -> listener.onItemClick(item));
    }

    //mencari jumlah datanya ke recycler view
    @Override
    public int getItemCount() {
        return this.listmakanan.size();
    }

    //ini adalah inner class ( class dalam class)
    // memasangkan data sesuai id
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvMakanan;
        TextView tvHarga;
        ImageView tvImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMakanan = itemView.findViewById(R.id.tvMakanan);
            tvHarga = itemView.findViewById(R.id.tvHarga);
            tvImage = itemView.findViewById(R.id.tvImage);
        }
    }
}

