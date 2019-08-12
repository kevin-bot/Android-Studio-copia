package com.example.myprimeraapp;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtFisica;
    private EditText txtQuimica;
    private EditText txtMatematica;
    private TextView txtresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtFisica=(EditText) findViewById(R.id.txtFisica);
        txtMatematica=(EditText) findViewById(R.id.txtMatematica);
        txtQuimica=(EditText) findViewById(R.id.txtQuimica);
        txtresultado=(TextView) findViewById(R.id.txtResultadoEstatus);

        }


        // METODO QUE CALCULA EL PROMEDIO DE LAS TRES NOTAS
        public void Calcular(View view){

            String txtfisica=txtFisica.getText().toString();
            String txtmatematica=txtMatematica.getText().toString();
            String txtquimica=txtQuimica.getText().toString();

            int notafisica=Integer.parseInt(txtfisica);
            int notamatematica=Integer.parseInt(txtmatematica);
            int notaquimica=Integer.parseInt(txtquimica);

            int resultadoDeLasNotas=(notafisica+notamatematica+notaquimica)/3;

            if(resultadoDeLasNotas>=6){
                txtresultado.setText("Estatus alumno Aprovado con "+resultadoDeLasNotas);
            }else if(resultadoDeLasNotas<=5){
                txtresultado.setText("Estatus alumno Reprovado con "+resultadoDeLasNotas);
            }





        }

}
