package com.example.navegaractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnsiguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsiguiente=(Button)findViewById(R.id.button);
        btnsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguiente();
            }
        });
    }

    public void siguiente(){
        Intent intentSiguiente= new Intent(getApplicationContext(),SegundoActyvity.class);
        startActivity(intentSiguiente);
    }
}
