package com.example.maknyuss1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public  class DatabaseHelper extends SQLiteOpenHelper {
    //nama database

    public static final String DATABASE_NAME = "maknyuss.db";

    //nama table

    public static final String TABLE_NAME = "maknyuss_table";

    //versi database

    private static final int DATABASE_VERSION = 1;

    //table field

    public static final String COL_1 = "id";

    public static final String COL_2 = "nama";

    public static final String COL_3 = "namamasakan";

    public static final String COL_4 = "date";



    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        SQLiteDatabase db = this.getWritableDatabase();

    }



    @Override

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(id integer primary key,nama text,namamasakan text,date text)");
    }



    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);

        onCreate(db);

    }



    //metode untuk tambah data

    public boolean insertData(String nama, String namamasakan, String date) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2,nama);

        contentValues.put(COL_3,namamasakan);

        contentValues.put(COL_4,date);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1)

            return false;

        else

            return true;

    }



    //metode untuk mengambil data

    public Cursor getAllData() {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("select * from maknyuss_table", null);

        return res;

    }



    //metode untuk merubah data

    public boolean updateData(String id,String nama,String namamasakan,String date) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1,id);

        contentValues.put(COL_2,nama);

        contentValues.put(COL_3,namamasakan);

        contentValues.put(COL_4,date);

        db.update(TABLE_NAME,contentValues,"ID = ?",new String[] {id});

        return true;

    }



    //metode untuk menghapus data

    public int deleteData (String id) {

        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME, "ID = ?", new String[] {id});

    }
}
