package com.example.navegaractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SegundoActyvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo_actyvity);
    }

    public void Primeracitivity(View view){
        Intent intentAnterior= new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intentAnterior);
    }
}
