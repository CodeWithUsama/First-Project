package com.ikhlasapp.consciouseyes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class LoginActivity extends AppCompatActivity {


    EditText email , password;
    Button buttonSignIn;
    TextView textviewSignUp;
    FirebaseAuth nFirebaseAuth;
private  FirebaseAuth.AuthStateListener nAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nFirebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editText1);
        password = findViewById(R.id.editText2);
        buttonSignIn = findViewById(R.id.button);
        textviewSignUp = findViewById(R.id.textView);

  nAuthStateListener = new FirebaseAuth.AuthStateListener() {


      @Override
      public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
          FirebaseUser nFirebaseUser = nFirebaseAuth.getCurrentUser();
     if(nFirebaseUser != null) {
     Toast.makeText(LoginActivity.this , "You are Logged In " , Toast.LENGTH_SHORT).show();
      Intent i = new Intent (LoginActivity.this , HomeActivity.class);
           startActivity(i);
     }

     else{
         Toast.makeText(LoginActivity.this , "Please Log In " , Toast.LENGTH_SHORT).show();
          }
          }
       };
    buttonSignIn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String email1 = email.getText().toString();
            String password1 = password.getText().toString();

            if (email1.isEmpty()) {

                email.setError("Please Enter Email ID");
                email.requestFocus();
            } else if (password1.isEmpty()) {
                password.setError("Please Enter Password");
                password.requestFocus();

            } else if (password1.isEmpty() && email1.isEmpty()) {

                Toast.makeText(LoginActivity.this, "Fields are Empty", Toast.LENGTH_SHORT).show();
            } else if (!(password1.isEmpty() && email1.isEmpty())) {
                nFirebaseAuth.signInWithEmailAndPassword(email1 ,password1).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(!task.isSuccessful()){

                            Toast.makeText(LoginActivity.this, "Log In Error , Please Log In Again!", Toast.LENGTH_SHORT).show();
                        }
                    else {

                        Intent intToHome = new Intent (LoginActivity.this ,HomeActivity.class);
                        startActivity(intToHome);
                    }
                    }
                });

            }
            else{
                Toast.makeText(LoginActivity.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
            }
        }
    });
        textviewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Intent intSignUp = new Intent(LoginActivity.this , MainActivity.class);
           startActivity(intSignUp);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        nFirebaseAuth.addAuthStateListener(nAuthStateListener);

    }
}