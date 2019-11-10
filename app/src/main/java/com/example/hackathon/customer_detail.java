package com.example.hackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class customer_detail extends AppCompatActivity {
private TextView goal;
private TextView amtrch;
    private TextView m1;
    private TextView m2;
    private TextView m3;
    private TextView m4;
    private TextView m5;
    private TextView m6;

DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        goal=(TextView)findViewById(R.id.goal_a);
        amtrch=(TextView)findViewById(R.id.amt);
        m1=(TextView)findViewById(R.id.m2);
        m2=(TextView)findViewById(R.id.m2);
        m3=(TextView)findViewById(R.id.m2);
        m4=(TextView)findViewById(R.id.m4);
        m5=(TextView)findViewById(R.id.m5);
        m6=(TextView)findViewById(R.id.m6);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("bihar");

    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String gl=dataSnapshot.child("goal").getValue().toString();
                String res=dataSnapshot.child("reaches").getValue().toString();
                String fg=dataSnapshot.child("foodper").getValue().toString();
                String sg=dataSnapshot.child("shelterper").getValue().toString();
                String cg=dataSnapshot.child("clothesper").getValue().toString();
                String fr=dataSnapshot.child("food").child("reached").toString();
                String cr=dataSnapshot.child("clothes").child("reached").getValue().toString();
                String sr=dataSnapshot.child("shelter").child("reached").getValue().toString();
                m1.setText(fg);
                m2.setText(fr);
                m3.setText(sg);
                m4.setText(sr);
                m5.setText(cg);
                m6.setText(cr);
                goal.setText(gl);
                amtrch.setText(res);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void bill(View view)
    {
       final AlertDialog.Builder alert=new AlertDialog.Builder(this);
       View mview=getLayoutInflater().inflate(R.layout.customer_bill,null);
        final EditText txt1 =(EditText) mview.findViewById(R.id.d1);
       final EditText txt2 =(EditText) mview.findViewById(R.id.d2);
        Button btn_k=(Button)mview.findViewById(R.id.ok);
        Button btn_can=(Button)mview.findViewById(R.id.c);




        alert.setView(mview);
        final AlertDialog alertDialog=alert.create();
        alertDialog.setCanceledOnTouchOutside(false);
        btn_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();


            }
        });
        btn_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String n=txt1.getText().toString();
                String m=txt2.getText().toString();



            }
        });

       alertDialog.show();


    }

}
