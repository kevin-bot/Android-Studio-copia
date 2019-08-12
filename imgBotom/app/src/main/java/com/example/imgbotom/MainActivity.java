package com.example.imgbotom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnmano;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Mensajegikipedia(View view){
            Toast.makeText(getApplicationContext(),"La geekipedia de ernesto",Toast.LENGTH_SHORT).show();
    }
    public void Mensajemanio(){
        Toast.makeText(getApplicationContext(),"La geekipedia de ernesto",Toast.LENGTH_SHORT).show();
    }
}
