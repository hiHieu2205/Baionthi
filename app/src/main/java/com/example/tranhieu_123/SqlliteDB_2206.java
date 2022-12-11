package com.example.tranhieu_123;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SqlliteDB_2206 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "HDTaxi";
    private static final String TABLE_NAME = "Taxii";
    private static final String MA = "MA";
    private static final String BIENSO = "BIENSO";
    private static final String QUANGDUONG = "QUANGDUONG";
    private static final String DONGIA = "DONGIA";
    private static final String KHUYENMAI = "KHUYENMAI";
    private Context context;

    public SqlliteDB_2206(@Nullable Context context) {
        super(context, DATABASE_NAME,null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                MA + " integer primary key AUTOINCREMENT, " +
                BIENSO + " TEXT, " +
                QUANGDUONG + " float, " +
                DONGIA + " float, " +
                KHUYENMAI + " float)";
        sqLiteDatabase.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("delete from Taxi");
    }
    public void xoaToanbo(){
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("delete from Taxi");
    }
    public void add(Taxi_123 taxi){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BIENSO,taxi.getBienso());
        values.put(QUANGDUONG, taxi.getQuangduong());
        values.put(DONGIA,taxi.getDongia());
        values.put(KHUYENMAI,taxi.getKhuyenmai());
        database.insert(TABLE_NAME,null,values);
        database.close();
    }
    public void update(Taxi_123 taxi){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MA, taxi.getMa());
        values.put(BIENSO, taxi.getBienso());
        values.put(QUANGDUONG,taxi.getQuangduong());
        values.put(DONGIA,taxi.getDongia());
        values.put(KHUYENMAI,taxi.getKhuyenmai());
        database.update(TABLE_NAME,values,"MA = ?",new String[]{String.valueOf(taxi.getMa())});
        database.close();
    }

    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public void deletebyID(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("delete from Taxi where MA = " + id);
    }
    public List<Taxi_123> getAll(){
        List<Taxi_123> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()) {
            do {
                Taxi_123 taxi = new Taxi_123();
                taxi.setMa(cursor.getInt(0));
                taxi.setBienso(cursor.getString(1));
                taxi.setQuangduong(cursor.getFloat(2));
                taxi.setDongia(cursor.getInt(3));
                taxi.setKhuyenmai(cursor.getInt(4));
                list.add(taxi);
            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return list;
    }
}
