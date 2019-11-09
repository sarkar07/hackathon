package com.example.hackathon;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public  class  ViewHolder extends RecyclerView.ViewHolder {
    View mView;

    public ViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
    }

    public void setDetail(Context cx, String name, String image) {
        TextView mTitle = mView.findViewById(R.id.tv);
        ImageView img = mView.findViewById(R.id.img);
        mTitle.setText(name);
        Picasso.get().load(image).into(img);


    }


}