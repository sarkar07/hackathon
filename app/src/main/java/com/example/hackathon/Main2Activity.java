package com.example.hackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main2Activity extends AppCompatActivity {
    private Button log;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private EditText Email;
    private EditText Password;
    private ProgressDialog pro;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log=(Button)findViewById(R.id.signIn);
        Email=findViewById(R.id.loginEmail);
        Password=findViewById(R.id.loginPass);
        mAuth = FirebaseAuth.getInstance();
        pro=new ProgressDialog(this);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();

            }
        });


    }

private void login()
{
    final String  email = Email.getText().toString().trim();
    String password = Password.getText().toString().trim();
    if(TextUtils.isEmpty(email)){
        Toast.makeText(getApplicationContext(),"Enter Email",Toast.LENGTH_SHORT).show();
        return;

    }
    if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
        Toast.makeText(getApplicationContext(),"Enter valid email",Toast.LENGTH_SHORT).show();
        return;
    }
    if(password.isEmpty()){
        Toast.makeText(this,"Enter the password",Toast.LENGTH_SHORT).show();
        return;
    }
    pro.setMessage("Logging In...");
    pro.show();
    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {

                // Sign in success, update UI with the signed-in user's information

                Intent intent1 = new Intent(Main2Activity.this, List.class);


                Main2Activity.this.startActivity(intent1);
                pro.dismiss();

            } else {
                // If sign in fails, display a message to the user.


                Toast.makeText(getApplicationContext(), "Check Email and Password !!",
                        Toast.LENGTH_SHORT).show();
                Email.setText("");
                Password.setText("");
                pro.dismiss();
                return;
            }

            // ...
        }

    });
}


}
