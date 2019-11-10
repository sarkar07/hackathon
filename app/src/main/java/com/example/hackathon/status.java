package com.example.hackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class status extends AppCompatActivity {
    DatabaseReference databaseReference;
    private TextView foo;
    private TextView clt;
    private  TextView sh;

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user= mAuth.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        foo=(TextView)findViewById(R.id.foo);
        clt=(TextView)findViewById(R.id.clt);
        sh=(TextView)findViewById(R.id.sh);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("disaster").child("bihar");
        //Toast.makeText(getApplicationContext(),databaseReference.child("food").child("donor").child("id").getKey(),Toast.LENGTH_SHORT).show();

        databaseReference.child("food").child("donor").child("id").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot i: dataSnapshot.getChildren())

                {
                   if ( i.getValue().toString().equals(user.getUid()))

                   {
                       //Toast.makeText(getApplicationContext(),"d",Toast.LENGTH_LONG).show();
                       foo.setText("Yes");
                       break;
                   }




                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        databaseReference.child("clothes").child("donor").child("id").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot i: dataSnapshot.getChildren())

                {
                    if ( i.getValue().toString().equals(user.getUid()))
                    {
                        clt.setText("Yes");
                        break;
                    }




                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        databaseReference.child("shelter").child("donor").child("id").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot i: dataSnapshot.getChildren())

                {
                    if ( i.getValue().toString().equals(user.getUid()))
                    {
                        sh.setText("Yes");
                        break;
                    }




                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
}
