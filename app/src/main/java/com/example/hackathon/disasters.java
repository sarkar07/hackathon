package com.example.hackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class disasters extends AppCompatActivity {


    RecyclerView mrv;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference mref;
    TextView tv;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disasters);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Funds");
        //mrv = findViewById(R.id.rv);

        mrv.setLayoutManager(new LinearLayoutManager(this));
        mrv.setHasFixedSize(true);
        firebaseDatabase = FirebaseDatabase.getInstance();
        mref = firebaseDatabase.getReference().child("disaster").child("bihar");
        tv=(TextView)findViewById(R.id.yu);
        //img = (ImageView)findViewById(R.id.img);



    }

    @Override
    protected void onStart() {
        super.onStart();
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name=dataSnapshot.child("name").getValue().toString();
                tv.setText(name);
                //Picasso.get().load(dataSnapshot.child("image").getValue().toString()).into(img);

                //Log.d(dataSnapshot.child("image").getValue().toString(),"iamge");



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }





}