package com.adityakhedekar.khedubaba.sharedpreferencedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.adityakhedekar.khedubaba.sharedpreferencedemo",
                Context.MODE_PRIVATE);
    }
}
