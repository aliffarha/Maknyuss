package com.example.maknyuss1;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;


import android.os.Bundle;
import android.view.View;

import android.widget.ListView;

import java.util.ArrayList;

public class resepmasakan extends AppCompatActivity {

    ListView  listView;

    private RecyclerView listresepmasakan;
    private ArrayList<daftarresep> listresep;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resepmasakan);

        listresepmasakan = findViewById(R.id.listresepmasakan);
        initData();
        listresepmasakan.setAdapter(new resepmasakanAdapter(listresep));
        listresepmasakan.setLayoutManager(new LinearLayoutManager(this));







    }

    private void initData() {
        this.listresep = new ArrayList<>();
        listresep.add(new daftarresep("1","Tumis Buncis Udang","Bahan & Cara Membuat",R.drawable.tumisbuncisudangimg,R.drawable.tumisbuncisresep));
        listresep.add(new daftarresep("2","Sayur Asem Sambal Terasi","Bahan & Cara Membuat",R.drawable.sayurasemimg,R.drawable.sayurasemresep));
        listresep.add(new daftarresep("3","Oseng Tempe Kacang","Bahan & Cara Membuat",R.drawable.osengtempekacangimg,R.drawable.osengtemperesep));
        listresep.add(new daftarresep("4","Chicken Kriuk Cabai Garam","Bahan & Cara Membuat",R.drawable.chickenkriukimg,R.drawable.chickenkriukresep));
        listresep.add(new daftarresep("5","Tumis Tofu Saus Tiram","Bahan & Cara Membuat",R.drawable.tumistofuimg,R.drawable.tumistofuresep));
        listresep.add(new daftarresep("6","Tumis Jamur Sosis","Bahan & Cara Membuat",R.drawable.tumisjamurimg,R.drawable.tumissosisresep));
        listresep.add(new daftarresep("7","Telur Sambal","Bahan & Cara Membuat",R.drawable.telursambalimg,R.drawable.telursambalresep));
        listresep.add(new daftarresep("8","Bening Bayam","Bahan & Cara Membuat",R.drawable.beningbayamimg,R.drawable.beningbayamresep));
        listresep.add(new daftarresep("9","Bobor Pucuk Labu","Bahan & Cara Membuat",R.drawable.boborpucuklabuimg,R.drawable.boborpucukresep));
        listresep.add(new daftarresep("10","Sup Jagung Sosis","Bahan & Cara Membuat",R.drawable.supjagungsosisimg,R.drawable.supjagungsosisresep));

    }



    public void Pindah(View view) {
        Intent intent = new Intent(resepmasakan.this,MainActivity.class);
        startActivity(intent);
    }
    public void PindahHome(View view) {
        Intent intent = new Intent(resepmasakan.this,MainActivity.class);
        startActivity(intent);
    }
}