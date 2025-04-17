package com.example.newrecycleview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements makananadapter.OnItemClickListener {


    RecyclerView rvList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //menacari recycler view dan membuat object
        rvList = findViewById(R.id.listmakan);
        ArrayList<makanan> listmakanan = new ArrayList<>();
        listmakanan.add(new makanan("Kue","Rp.12.000.00",R.drawable.kue));
        listmakanan.add(new makanan("Coklat","Rp.15.000.00",R.drawable.coklat));
        listmakanan.add(new makanan("Beng beng","Rp.10.000.00",R.drawable.bengbeng));
        listmakanan.add(new makanan("Eskrim","Rp.8.000.00",R.drawable.eskrim));
        listmakanan.add(new makanan("Tiramisu","10.000.00",R.drawable.tiramisi));


        //memanggil adapter
        rvList.setLayoutManager(new LinearLayoutManager(this));
        makananadapter makananAdapter = new makananadapter(listmakanan,this);
        rvList.setAdapter(makananAdapter);
    }

    @Override
    public void onItemClick(makanan makananModel) {
        Toast.makeText(this, makananModel.getNama(), Toast.LENGTH_SHORT).show();
        //dari main activity ke DetailIsi
        Intent in = new Intent(MainActivity.this,DetailIsi.class);
        //memberikan data

        in.putExtra("namamakanan",makananModel.getNama());
        in.putExtra("hargamakan",makananModel.getHarga());
        in.putExtra("gambarmakan",makananModel.getImage());

        startActivity(in);
    }
}
