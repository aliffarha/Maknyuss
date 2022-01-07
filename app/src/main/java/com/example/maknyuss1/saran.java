package com.example.maknyuss1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class saran extends AppCompatActivity {

    EditText enama, ekritik , esaran;
    Button btnsimpan;
    DatabaseReference dbref;

    kritiksaran kritiksaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saran);

        enama = findViewById(R.id.inputnama);
        ekritik = findViewById(R.id.inputkritik);
        esaran = findViewById(R.id.inputsaran);
        btnsimpan = findViewById(R.id.btnkirim);

        kritiksaran = new kritiksaran();

        dbref = FirebaseDatabase.getInstance().getReference().child("Kritik Saran");


        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kritiksaran.setNamauser(enama.getText().toString().trim());
                kritiksaran.setKritikuser(ekritik.getText().toString().trim());
                kritiksaran.setSaranuser(esaran.getText().toString().trim());

                dbref.push().setValue(kritiksaran);
            }
        });
    }
    public void PindahHome(View view) {
        Intent intent = new Intent(saran.this,MainActivity.class);
        startActivity(intent);
    }
}