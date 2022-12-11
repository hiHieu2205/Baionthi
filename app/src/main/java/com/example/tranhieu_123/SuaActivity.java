package com.example.tranhieu_123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SuaActivity extends AppCompatActivity {
    private SqlliteDB_2206 database = new SqlliteDB_2206(this);
    private EditText editTextKhuyenmai,editTextDongia,editTextSoxe,editTextQuangduong;
    private Button buttonSua,buttonQuaylai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua);
        editTextSoxe = (EditText) findViewById(R.id.editTextSoxe);
        editTextDongia = (EditText) findViewById(R.id.editTextDongia);
        editTextKhuyenmai = (EditText) findViewById(R.id.editTextKhuyenmai);
        editTextQuangduong = (EditText) findViewById(R.id.editTextQuangduong);
        buttonQuaylai = (Button) findViewById(R.id.buttonQuaylai);
        buttonSua = (Button) findViewById(R.id.buttonSua);
        Intent intent = getIntent();
        int ma = intent.getIntExtra("ID", 0);
        String soxe = intent.getStringExtra("SOXE");
        float quangduong = intent.getFloatExtra("QUANGDUONG",0);
        int dongia = intent.getIntExtra("DONGIA",0);
        int khuyenmai = intent.getIntExtra("KHUYENMAI",0);
        editTextSoxe.setText(soxe);
        editTextQuangduong.setText(quangduong+"");
        editTextDongia.setText(dongia + "");
        editTextKhuyenmai.setText(khuyenmai + "");
        buttonSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Taxi_123 taxi = new Taxi_123(ma,editTextSoxe.getText().toString(),
                        Float.parseFloat(editTextQuangduong.getText().toString()),
                        Integer.parseInt(editTextDongia.getText().toString()),
                        Integer.parseInt(editTextKhuyenmai.getText().toString()));
                database.update(taxi);
                Intent it = new Intent(SuaActivity.this,MainActivity.class);
                startActivity(it);
            }
        });
        buttonQuaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(SuaActivity.this,MainActivity.class);
                startActivity(it);
            }
        });
    }
}