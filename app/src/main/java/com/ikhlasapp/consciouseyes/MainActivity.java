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

public class MainActivity extends AppCompatActivity {
    EditText email , password;
    Button buttonSignUp;
    TextView textviewSignIn;
    FirebaseAuth nFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nFirebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editText1);
        password = findViewById(R.id.editText2);
        buttonSignUp = findViewById(R.id.button);
        textviewSignIn = findViewById(R.id.textView);
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
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

                    Toast.makeText(MainActivity.this, "Fields are Empty", Toast.LENGTH_SHORT).show();
                } else if (!(password1.isEmpty() && email1.isEmpty())) {
                  nFirebaseAuth.createUserWithEmailAndPassword(email1 , password1).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                      @Override
                      public void onComplete(@NonNull Task<AuthResult> task) {
                          if (task.isSuccessful()){

                              Toast.makeText(MainActivity.this, "Sign Up Unsuccessful , Please Try again", Toast.LENGTH_SHORT).show();
                          }
                          else{

                            startActivity(new Intent(MainActivity.this,HomeActivity.class));
                          }
                      }
                  });
                }
                else{
                    Toast.makeText(MainActivity.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        textviewSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this , LoginActivity.class);
            startActivity(i);
            }
        });
    }
}