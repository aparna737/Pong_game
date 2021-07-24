package com.example.deltatask_2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {

    private Button restart;
    private TextView score;

    private String displayScore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        displayScore = getIntent().getExtras().get("score").toString();

        restart = (Button) findViewById(R.id.restart);
        score = (TextView) findViewById(R.id.score) ;

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainintent = new Intent(result.this,MainActivity.class);
                startActivity(mainintent);

            }
        });
        score.setText(displayScore);



        


    }
}