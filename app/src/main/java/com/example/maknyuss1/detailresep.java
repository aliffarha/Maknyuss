package com.example.maknyuss1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class detailresep<daftarresep> extends AppCompatActivity {


    ImageView gambarmakanan_masuk;
    TextView idmakanan_masuk;
    TextView namamakanan_masuk;
    TextView keteranganmakanan_masuk;


    String id_kunci="idresep";
    String nm_kunci="namaresep";
    String ket_kunci="keteranganresep";
    int gambarresep;

    String idresepmasakan;
    String namarepmasakan;
    String keteranganresepmasakan;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailresep);
        gambarmakanan_masuk = findViewById(R.id.getId_gambar);
        idmakanan_masuk = findViewById(R.id.getId);
        namamakanan_masuk = findViewById(R.id.getNama);
        keteranganmakanan_masuk = findViewById(R.id.getKeterangan);

        Bundle bundle = getIntent().getExtras();

        gambarresep=bundle.getInt(String.valueOf("gambarresep"));
        gambarmakanan_masuk.setImageResource(gambarresep);
        idresepmasakan= bundle.getString("idresep");
        idmakanan_masuk.setText(idresepmasakan);
        namarepmasakan = bundle.getString("namaresep");
        namamakanan_masuk.setText(namarepmasakan);
        keteranganresepmasakan = bundle.getString("keteranganresep");
        keteranganmakanan_masuk.setText(keteranganresepmasakan);


    }


}
