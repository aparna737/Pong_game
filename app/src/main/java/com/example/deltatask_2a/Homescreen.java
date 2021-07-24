package com.example.deltatask_2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Homescreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {

                    sleep(3000);

                } catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent mainintent = new Intent(Homescreen.this,MainActivity.class);
                    startActivity(mainintent);
                }

                }
            };
        thread.start();


    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
