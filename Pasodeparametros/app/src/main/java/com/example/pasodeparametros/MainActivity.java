package com.example.pasodeparametros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviardatos2(){
        Intent  intent= new Intent(getApplicationContext(),Main2Activity.class);
        intent.putExtra("dato",)
    }
}
