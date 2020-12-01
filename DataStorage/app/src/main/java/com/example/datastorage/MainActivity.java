package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.textclassifier.TextClassifierEvent;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private final static String PREFS_SETTINGS = "prefs_settings";
    private SharedPreferences prefsUser, prefsApp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefsUser = getSharedPreferences(PREFS_SETTINGS, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefsUser.edit();
        editor.putInt("KEY1", 10);
        editor.putString("KEY2", "hello there! \n General Kenobi");
        editor.putBoolean("KEY3", true);
        editor.putFloat("KEY4", 3.1415926f);
        editor.commit(); // synchronous

        prefsUser.edit().putLong("KEY5", 1000000L).apply(); // asynch
        prefsApp = getPreferences(Context.MODE_PRIVATE);

        int randomInt = prefsUser.getInt("KEY1", 0);
        String name = prefsUser.getString("KEY2", "nu avem");

        String filename = "settings";
        String content = "Hello there! Kill me";
        FileOutputStream outputStream;

        try{
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}