package com.example.maknyuss1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.Cursor;

import android.os.Bundle;



import android.view.Menu;

import android.view.MenuItem;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.Toast;
import android.app.AlertDialog;


import android.os.Bundle;

public class rencanamasak extends AppCompatActivity {

    DatabaseHelper myDb;

    EditText editNama,editNamamasakan,editDate,editTextId;

    Button btnAddData;

    Button btnViewAll;

    Button btnUpdate;

    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rencanamasak);
        myDb = new DatabaseHelper(this);

        editNama = (EditText)findViewById(R.id.editText_nama);

        editNamamasakan = (EditText)findViewById(R.id.editText_namamasakan);

        editDate = (EditText)findViewById(R.id.editText_date);

        editTextId = (EditText)findViewById(R.id.editTextId);

        btnAddData = (Button)findViewById(R.id.button_add);

        btnViewAll = (Button)findViewById(R.id.button_view);

        btnUpdate = (Button)findViewById(R.id.button_update);

        btnDelete = (Button)findViewById(R.id.button_delete);

        AddData();

        viewAll();

        UpdateData();

        deleteData();

    }



    //fungsi hapus

    public void deleteData() {

        btnDelete.setOnClickListener(

                new View.OnClickListener() {

                    @Override

                    public void onClick(View v) {

                        Integer deletedRows = myDb.deleteData(editTextId.getText().toString());

                        if (deletedRows > 0)

                            Toast.makeText(rencanamasak.this,"Data Deleted",Toast.LENGTH_LONG).show();

                        else

                            Toast.makeText(rencanamasak.this,"Data Failed to Deleted!",Toast.LENGTH_LONG).show();

                    }

                }

        );

    }



    //fungsi update

    public void UpdateData() {

        btnUpdate.setOnClickListener(

                new View.OnClickListener() {

                    @Override

                    public void onClick(View v) {

                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(),

                                editNama.getText().toString(),

                                editNamamasakan.getText().toString(),

                                editDate.getText().toString());

                        if(isUpdate == true)

                            Toast.makeText(rencanamasak.this,"Data Updated",Toast.LENGTH_LONG).show();

                        else

                            Toast.makeText(rencanamasak.this,"Data Failed to Update",Toast.LENGTH_LONG).show();

                    }

                }

        );

    }



    //fungsi tambah

    public void AddData() {

        btnAddData.setOnClickListener(

                new View.OnClickListener() {

                    @Override

                    public void onClick(View v) {

                        boolean isInserted = myDb.insertData(editNama.getText().toString(),

                                editNamamasakan.getText().toString(),

                                editDate.getText().toString() );

                        if(isInserted == true)

                            Toast.makeText(rencanamasak.this,"Data Iserted",Toast.LENGTH_LONG).show();

                        else

                            Toast.makeText(rencanamasak.this,"Data Not Iserted",Toast.LENGTH_LONG).show();

                    }

                }

        );

    }



    //fungsi menampilkan data

    public void viewAll() {

        btnViewAll.setOnClickListener(

                new View.OnClickListener(){

                    @Override

                    public void onClick(View v) {

                        Cursor res = myDb.getAllData();

                        if(res.getCount() == 0) {

                            // show message

                            showMessage("Error","Noting Found");

                            return;

                        }



                        StringBuffer buffer = new StringBuffer();

                        while (res.moveToNext() ) {

                            buffer.append("Id :"+ res.getString(0)+"\n");

                            buffer.append("Nama :"+ res.getString(1)+"\n");

                            buffer.append("Nama Masakan :"+ res.getString(2)+"\n");

                            buffer.append("Date :"+ res.getString(3)+"\n\n");

                        }



                        // show all data

                        showMessage("Data",buffer.toString());

                    }

                }

        );

    }



    //membuat alert dialog

    public void showMessage(String title, String Message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(true);

        builder.setTitle(title);

        builder.setMessage(Message);

        builder.show();

    }
    public void PindahHome(View view) {
        Intent intent = new Intent(rencanamasak.this,MainActivity.class);
        startActivity(intent);
    }
}