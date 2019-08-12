package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtnum1;
    private EditText txtnum2;
    private TextView txtresultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnum1=(EditText) findViewById(R.id.txtnum1);
        txtnum2=(EditText) findViewById(R.id.txtnum2);
        txtresultado=(TextView) findViewById(R.id.txt_resultado);

    }

    // este metodo realiza la suma
    public void Sumar(View vista){
        String valor1=txtnum1.getText().toString();
        String valor2=txtnum2.getText().toString();

        int num1=Integer.parseInt(valor1);
        int num2=Integer.parseInt(valor2);
        int suma=num1+num2;

        String resultado= String.valueOf(suma);

        txtresultado.setText(resultado);
    }
}
