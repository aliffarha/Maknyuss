package com.example.maknyuss1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class detailmakanan extends AppCompatActivity {


    ImageView gambarmakanan_masuk;
    ImageView gambarresep_masuk;
    TextView idmakanan_masuk;
    TextView namamakanan_masuk;
    TextView keteranganmakanan_masuk;


    String id_kunci="idresep";
    String nm_kunci="namaresep";
    String ket_kunci="keteranganresep";
    int gambarresep;
    int gambarresep2;

    String idresepmasakan;
    String namarepmasakan;
    String keteranganresepmasakan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailmakanan);

        gambarmakanan_masuk = findViewById(R.id.getId_gambar);
        gambarresep_masuk = findViewById(R.id.getgambarresep);
        idmakanan_masuk = findViewById(R.id.getId);
        namamakanan_masuk = findViewById(R.id.getNama);
        keteranganmakanan_masuk = findViewById(R.id.getKeterangan);

        Bundle bundle = getIntent().getExtras();

        gambarresep=bundle.getInt(String.valueOf("gambarresep"));
        gambarmakanan_masuk.setImageResource(gambarresep);
        gambarresep2=bundle.getInt(String.valueOf("gambarresep2"));
        gambarresep_masuk.setImageResource(gambarresep2);
        idresepmasakan= bundle.getString("idresep");
        idmakanan_masuk.setText(idresepmasakan);
        namarepmasakan = bundle.getString("namaresep");
        namamakanan_masuk.setText(namarepmasakan);
        keteranganresepmasakan = bundle.getString("keteranganresep");
        keteranganmakanan_masuk.setText(keteranganresepmasakan);
    }

    public void PindahHome(View view) {
        Intent intent = new Intent(detailmakanan.this,MainActivity.class);
        startActivity(intent);
    }
}