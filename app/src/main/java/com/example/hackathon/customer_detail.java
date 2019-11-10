package com.example.hackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class customer_detail extends AppCompatActivity {
private TextView goal;
private TextView amtrch;
    private TextView m1;
    private TextView m2;
    private TextView m3;
    private TextView m4;
    private TextView m5;
    private TextView m6;
    private  String gl, res, sg, fg,cg,fr,cr,sr;
    Donation donation;
    private int extras;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private  FirebaseUser user= mAuth.getCurrentUser();


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
        databaseReference= FirebaseDatabase.getInstance().getReference().child("disaster");


    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 gl=dataSnapshot.child("bihar").child("goal").getValue().toString();
                 res=dataSnapshot.child("bihar").child("reached").getValue().toString();
                 fg=dataSnapshot.child("bihar").child("foodper").getValue().toString();
                 sg=dataSnapshot.child("bihar").child("shelterper").getValue().toString();
                 cg=dataSnapshot.child("bihar").child("clothesper").getValue().toString();
                 fr=dataSnapshot.child("bihar").child("food").child("reached").getValue().toString();
                 cr=dataSnapshot.child("bihar").child("clothes").child("reached").getValue().toString();
                 sr=dataSnapshot.child("bihar").child("shelter").child("reached").getValue().toString();
                //databaseReference.child("bihar").child("extras").child("amount").setValue(200);

               //donation.setId(user.getUid());
                //databaseReference.child("bihar").child("extras").child("donor").push().setValue(donation);
                // extras=Integer.parseInt(dataSnapshot.child("bihar").child("extras").child("amount").getValue().toString());
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


        Intent intent1 = new Intent(customer_detail.this, doante.class);


        customer_detail.this.startActivity(intent1);
       /*final AlertDialog.Builder alert=new AlertDialog.Builder(this);
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


                Toast.makeText(getApplicationContext(),"cc",Toast.LENGTH_LONG).show();


                String n=txt1.getText().toString();
                int m=Integer.parseInt(txt2.getText().toString());
                Random rand = new Random();
                //databaseReference.child("bihar").child("extras").child("amount").setValue(200);








            }
        });

       alertDialog.show();*/


    }


}
