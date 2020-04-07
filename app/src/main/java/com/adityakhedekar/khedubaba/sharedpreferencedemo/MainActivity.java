package com.adityakhedekar.khedubaba.sharedpreferencedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.adityakhedekar.khedubaba.sharedpreferencedemo",
                Context.MODE_PRIVATE);

        sharedPreferences.edit().putString("username", "khedu");
        String username = sharedPreferences.getString("username", "defaultvalueifusernameisempty");
        Log.i(TAG, "username: "+username);

        ArrayList<String> friends = new ArrayList<String>();
        friends.addAll(Arrays.asList("Khem", "Lobo", "Nitin", "Saurabh"));

        try {
            sharedPreferences.edit().putString("friends",ObjectSerializer.serialize(friends)).apply();
            Log.i(TAG, "friends: " + ObjectSerializer.serialize(friends));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<String> newFriends = new ArrayList<String>();
        try {
            newFriends = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("friends",
                    ObjectSerializer.serialize(new ArrayList<String>())));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        Log.i(TAG, "new friends: "+newFriends.toString());

    }
}
