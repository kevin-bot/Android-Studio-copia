package com.example.kevinweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText txt_codigo;
    private EditText txt_producto;
    private EditText txt_precio;
    private EditText txt_fabricante;
    private Button btn_insertar,btn_buscar,btn_eliminar,btn_actualizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_codigo=(EditText)findViewById(R.id.txt_codigo);
        txt_producto=(EditText)findViewById(R.id.txt_producto);
        txt_precio=(EditText)findViewById(R.id.txt_precio);
        txt_fabricante=(EditText)findViewById(R.id.txt_fabricante);
        btn_insertar=(Button)findViewById(R.id.btn_insertar);
        btn_buscar=(Button)findViewById(R.id.btn_buscar);
        btn_actualizar=(Button)findViewById(R.id.btn_actualizar);
        btn_eliminar=(Button)findViewById(R.id.btn_eliminar);

        btn_insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!txt_codigo.getText().toString().equals("")||!txt_producto.getText().toString().equals("")||!txt_fabricante.getText().toString().equals("")||!txt_fabricante.getText().toString().equals("")){

                    RegistrarPorducto("http://192.168.1.115/Webservices2CRUD/insertar_producto.php");
                }else{
                    Toast.makeText(getApplicationContext(),"CAMPOS BACIOS",Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //buscarProducto("http://138.122.202.170/App/consultar_producto.php/?txt_codigo="+txt_codigo.getText()+"");


                if(!txt_codigo.getText().toString().equals("")){
                    //buscarProducto("http://192.168.1.115/Webservices2CRUD/consultar_producto.php/?txt_codigo="+txt_codigo.getText());
                }else{
                    Toast.makeText(getApplicationContext(),"CODIGO BACIO",Toast.LENGTH_SHORT).show();

                }

            }
        });


    }

    public void RegistrarPorducto(String URL){
        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(),"Exito",Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros= new HashMap<String,String>();
                parametros.put("txt_codigo",txt_codigo.getText().toString());
                parametros.put("txt_producto",txt_producto.getText().toString());
                parametros.put("txt_precio",txt_precio.getText().toString());
                parametros.put("txt_fabricante",txt_fabricante.getText().toString());

                return parametros;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void buscarProducto(String URL){
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        txt_producto.setText(jsonObject.getString("producto"));
                        txt_precio.setText(jsonObject.getString("precio"));
                        txt_fabricante.setText(jsonObject.getString("fabricante"));
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    public void buscarproducto(String URL){

        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                    JSONObject jsonObject= null;
             }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

}
