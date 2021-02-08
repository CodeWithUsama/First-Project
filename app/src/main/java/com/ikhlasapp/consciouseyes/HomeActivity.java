package com.ikhlasapp.consciouseyes;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {
 public Button button1 , button2 , button3 , button4 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
      button1 = findViewById(R.id.button2);
    button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(HomeActivity.this , InviteFriend.class);
            startActivity(intent);
        }
    });
 button2 = findViewById(R.id.button3);
 button2.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         Intent intent = new Intent (HomeActivity.this , ViewHistory.class);
         startActivity(intent);
     }
 });

        button3 = findViewById(R.id.button4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (HomeActivity.this , AddFriend.class);
                startActivity(intent);
            }
        });


        button4 = findViewById(R.id.button5);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (HomeActivity.this , TrackProgress.class);
                startActivity(intent);
            }
        });






    }
}