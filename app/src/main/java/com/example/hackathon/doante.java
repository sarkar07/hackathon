package com.example.hackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class doante extends AppCompatActivity {
    private EditText state;
    private EditText money;
    private Button don;
    private int extras;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user= mAuth.getCurrentUser();
    DatabaseReference databaseReference;
    private  float gl, res, sg, fg,cg,fr,cr,sr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doante);
        state=(EditText)findViewById(R.id.state);
        money=(EditText)findViewById(R.id.money);
        don=(Button) findViewById(R.id.ok);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("disaster");

        don.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change();
            }
        });
    }
    public void change()

    {

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                gl=Float.parseFloat(dataSnapshot.child("bihar").child("goal").getValue().toString());
                res=Float.parseFloat(dataSnapshot.child("bihar").child("reached").getValue().toString());
                fg=Float.parseFloat(dataSnapshot.child("bihar").child("foodper").getValue().toString());
                sg=Float.parseFloat(dataSnapshot.child("bihar").child("shelterper").getValue().toString());
                cg=Float.parseFloat(dataSnapshot.child("bihar").child("clothesper").getValue().toString());
                fr=Float.parseFloat(dataSnapshot.child("bihar").child("food").child("reached").getValue().toString());
                cr=Float.parseFloat(dataSnapshot.child("bihar").child("clothes").child("reached").getValue().toString());
                sr=Float.parseFloat(dataSnapshot.child("bihar").child("shelter").child("reached").getValue().toString());

                int mon=Integer.parseInt(money.getText().toString());
                if ((fr>=fg)&&(cr>=cg)&&(sr>=sg))
                {
                    databaseReference.child("bihar").child("extras").child("amount").setValue(mon);
                    databaseReference.child("bihar").child("extras").child("donor").child("id").push().setValue(user.getUid());
                }


                fr=fr+(fg/gl)*mon;
                cr=cr+(cg/gl)*mon;
                sr=sr+(sg/gl)*mon;

                Toast.makeText(getApplicationContext(),Float.toString(mon),Toast.LENGTH_LONG).show();
                databaseReference.child("bihar").child("food").child("reached").setValue(33);
                databaseReference.child("bihar").child("food").child("donor").child("id").push().setValue(user.getUid());
                databaseReference.child("bihar").child("clothes").child("reached").setValue(cr);
                databaseReference.child("bihar").child("clothes").child("donor").child("id").push().setValue(user.getUid());
                databaseReference.child("bihar").child("shelter").child("reached").setValue(sr);
                databaseReference.child("bihar").child("shelter").child("donor").child("id").push().setValue(user.getUid());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });







    }
}
