package com.example.hackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class receive extends AppCompatActivity {
    DatabaseReference databaseReference;
    Button button;
    EditText editText;
    int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_receive);

        button=(Button)findViewById(R.id.enok);
        editText=(EditText)findViewById(R.id.ukey);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("items");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                del();
            }
        });

    }

    public void del()
    {
        String s2=editText.getText().toString();
        databaseReference.child("bihar").child(s2).removeValue();
        count=count+1;
        databaseReference.child("bihar").child("count").setValue(count);




    }

}
