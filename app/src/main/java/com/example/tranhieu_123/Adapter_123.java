package com.example.tranhieu_123;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter_123 extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Taxi_123> arrayList;

    public Adapter_123(Context context, int layout, ArrayList<Taxi_123> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        TextView textViewQuangduong = (TextView) view.findViewById(R.id.textViewQuangduong);
        TextView textViewBienso = (TextView) view.findViewById(R.id.textViewBienso);
        TextView textViewGiatien = (TextView) view.findViewById(R.id.textViewGiatien);
        Taxi_123 taxi = arrayList.get(i);
        textViewBienso.setText(taxi.getBienso());
        textViewQuangduong.setText("Quãng đường: "+taxi.getQuangduong());
        float x = (taxi.getDongia()*taxi.getQuangduong()*(100-taxi.getKhuyenmai())/100);
        textViewGiatien.setText(String.valueOf(x) +"");
        return view;
    }
}
