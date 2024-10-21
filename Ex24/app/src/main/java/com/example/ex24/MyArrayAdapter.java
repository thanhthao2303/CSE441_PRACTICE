package com.example.ex24;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<TyGia> {
    private Activity context;
    private int resource;
    private ArrayList<TyGia> objects;

    public MyArrayAdapter(Activity context, int resource, ArrayList<TyGia> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View row = inflater.inflate(resource, null);

        TextView txtType = row.findViewById(R.id.txtType);
        TextView txtMuaTM = row.findViewById(R.id.txtMuaTM);
        TextView txtBanTM = row.findViewById(R.id.txtBanTM);

        TyGia tyGia = objects.get(position);

        txtType.setText(tyGia.getType());
        txtMuaTM.setText(tyGia.getMuatm());
        txtBanTM.setText(tyGia.getBantm());

        return row;
    }
}
