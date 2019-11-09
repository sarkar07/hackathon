package com.example.hackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class customer_detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
