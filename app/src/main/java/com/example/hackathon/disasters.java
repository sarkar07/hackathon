package com.example.hackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class disasters extends AppCompatActivity {


    RecyclerView mrv;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference mref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disasters);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Funds");
        mrv = findViewById(R.id.rv);

        mrv.setLayoutManager(new LinearLayoutManager(this));
        mrv.setHasFixedSize(true);
        firebaseDatabase = FirebaseDatabase.getInstance();
        mref = firebaseDatabase.getReference("fund-bc84f");



    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Model,ViewHolder> firebaseRecyclerAdapter=
                new FirebaseRecyclerAdapter<Model, ViewHolder>(Model.class,R.layout.row,ViewHolder.class,mref) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int i) {
                        viewHolder.setDetail(getApplicationContext(),model.getName(),model.getImage());


                    }
                };
        mrv.setAdapter(firebaseRecyclerAdapter);
    }





}