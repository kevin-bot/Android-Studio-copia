package com.example.app_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText edt1,edt2;
    private TextView tv1;
    private RadioButton rb1,rb2;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=(EditText)findViewById(R.id.txtnum1);
        edt2=(EditText) findViewById(R.id.txtnum2);
        rb1=(RadioButton) findViewById(R.id.rbsumar);
        rb2=(RadioButton)findViewById(R.id.rbrestar);
        tv1=(TextView)findViewById(R.id.lblresultado);
    }

    public void calcular(View vista){
        String numero1_String=edt1.getText().toString();
        String numero2_String=edt2.getText().toString();

        int numero1_int=Integer.parseInt(numero1_String);
        int numero2_int=Integer.parseInt(numero2_String);


        if(rb1.isChecked()==true){
            int suma=numero1_int+numero2_int;
            tv1.setText(""+suma);
        }else if(rb2.isChecked()==true){
            int resta=numero1_int-numero2_int;
            tv1.setText(""+resta);
        }
    }
}
