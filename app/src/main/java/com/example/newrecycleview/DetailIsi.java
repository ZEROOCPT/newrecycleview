package com.example.newrecycleview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailIsi extends AppCompatActivity {
    TextView tvnama;
    TextView tvharga;
    ImageView tvimage;
    Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_isi);

        tvnama = findViewById(R.id.namakanandetail);
        tvharga = findViewById(R.id.hargamakanan);
        tvimage = findViewById(R.id.gambarmakan);
        exit = findViewById(R.id.exit);

        //menangkap data dari intent main
        Intent intent = getIntent();
        String nama = intent.getStringExtra("namamakanan");
        String harga = intent.getStringExtra("hargamakan");
        int gambar = intent.getIntExtra("gambarmakan",0);


        tvnama.setText(nama);
        tvharga.setText(harga);
        tvimage.setImageResource(gambar);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(DetailIsi.this,MainActivity.class);
                startActivity(in);
            }
        });
    }
}