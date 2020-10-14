package com.example.yaniv.wildout4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class Adaptor extends BaseAdapter {
    Context context;
    ArrayList<Club> clbList;
    private static LayoutInflater inflater = null;

    public Adaptor(Context context, ArrayList<Club> clbList) {
        this.context = context;
        this.clbList = clbList;
        //inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return clbList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View v;
        if (convertView == null) {
            //convertView = inflater.inflate(R.layout.layout_grid_club2, null);
            LayoutInflater inflater = ((AppCompatActivity) context).getLayoutInflater();
            v = inflater.inflate(R.layout.singleitem, null, true);
            ImageView imageView = (ImageView)v.findViewById(R.id.img);
            TextView nameTextView = (TextView)v.findViewById(R.id.item);

            Club e;
            e = clbList.get(position);
            byte[] Image = e.getImg();
            Bitmap bitmap = BitmapFactory.decodeByteArray(Image, 0, Image.length);
            //imageView.setImageResource(R.drawable.loginbtn);
            imageView.setImageBitmap(bitmap);
            nameTextView.setText("Name: " + e.getName());
        }
        else{
            v = (View) convertView;
        }
        return v;
    }
}