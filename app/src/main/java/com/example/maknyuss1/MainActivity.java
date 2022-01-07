package com.example.maknyuss1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.textViewDate);
        textViewDate.setText(currentDate);
    }

    public void Pindah(View view) {
        Intent intent = new Intent(MainActivity.this,resepmasakan.class);
        startActivity(intent);
    }

    public void Pindah1(View view) {
        Intent intent = new Intent(MainActivity.this,rencanamasak.class);
        startActivity(intent);
    }

    public void Pindah2(View view) {
        Intent intent = new Intent(MainActivity.this,saran.class);
        startActivity(intent);
    }
}