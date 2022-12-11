package com.example.tranhieu_123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView listViewTaxi;
    EditText editTextTimkiem;
    Adapter_123 adapter_123;
    ArrayList<Taxi_123> arrayListTaxis;
    SqlliteDB_2206 database = new SqlliteDB_2206(this);
    int vitriDangchon = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewTaxi = (ListView) findViewById(R.id.listViewTaxi);
        editTextTimkiem = (EditText) findViewById(R.id.editTextTimkiem);

        database.add(new Taxi_123(1,"35B1-12345",30,8800,5));
        database.add(new Taxi_123(2,"29B1-45621",10,8800,5));
        database.add(new Taxi_123(3,"28B1-25142",30,8800,5));
        database.add(new Taxi_123(4,"27B1-41558",15,8800,5));
        database.add(new Taxi_123(5,"26B1-99999",22,8800,5));
        database.add(new Taxi_123(6,"20B1-12211",100,8800,5));
        arrayListTaxis = (ArrayList<Taxi_123>) database.getAll();
        Collections.sort(arrayListTaxis);
        adapter_123 = new Adapter_123(MainActivity.this,R.layout.item,arrayListTaxis);
        listViewTaxi.setAdapter(adapter_123);
        listViewTaxi.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                vitriDangchon = i;
                registerForContextMenu(listViewTaxi);
                return false;
            }
        });
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.itemXoa){
            for(int i = 0;i < arrayListTaxis.size();i++)
                if(arrayListTaxis.get(i).getBienso().compareTo(arrayListTaxis.get(vitriDangchon).getBienso()) == 0){
                    database.deletebyID(arrayListTaxis.get(i).getMa());
                }
            Toast.makeText(MainActivity.this,"Đã xóa!",Toast.LENGTH_SHORT).show();
            arrayListTaxis = (ArrayList<Taxi_123>) database.getAll();
            adapter_123 = new Adapter_123(MainActivity.this,R.layout.item,arrayListTaxis);
            listViewTaxi.setAdapter(adapter_123);
        }
        if(item.getItemId() == R.id.itemSua){
            int ma = arrayListTaxis.get(vitriDangchon).getMa();
            String soxe = arrayListTaxis.get(vitriDangchon).getBienso();
            float quangduong = arrayListTaxis.get(vitriDangchon).getQuangduong();
            int dongia = arrayListTaxis.get(vitriDangchon).getDongia();
            int khuyenmai = arrayListTaxis.get(vitriDangchon).getKhuyenmai();
            Intent it = new Intent(MainActivity.this,SuaActivity.class);
            it.putExtra("ID",ma);
            it.putExtra("SOXE", soxe);
            it.putExtra("QUANGDUONG",quangduong);
            it.putExtra("DONGIA",dongia);
            it.putExtra("KHUYENMAI",khuyenmai);
            startActivity(it);
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu,menu);
    }
}