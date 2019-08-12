package com.example.app_crud_mono.fracmento;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.app_crud_mono.R;

import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class IsertarUsuario extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener {


    EditText txtNombre,txtCedula,txtprofesion;
    Button btnRegistrar;


    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;



    public IsertarUsuario() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_isertar_usuario,container,false);
        txtCedula=(EditText)view.findViewById(R.id.campoDoc);
        txtNombre=(EditText)view.findViewById(R.id.campoNombre);
        txtprofesion=(EditText)view.findViewById(R.id.campoProfesion);
        btnRegistrar=(Button)view.findViewById(R.id.btnRegistrar);


        requestQueue= Volley.newRequestQueue(getContext());

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CargarWebservices();
            }
        });

        return view;
    }


    public void CargarWebservices( ){

        String URL="http://192.168.1.112/webservicesmono/Insertar.php";
        jsonObjectRequest=new JsonObjectRequest(Request.Method.POST,URL,null,this,this);

        requestQueue.add(jsonObjectRequest);
    }
    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(),"No se pudo Conectar "+error.toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getContext(),"Exito",Toast.LENGTH_SHORT).show();

    }
}
