package com.josueriofrio.projetz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.josueriofrio.projetz.modelo.usuario;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText edtUsuario, edtPassword;
    Button btnLogin, btnRegistarse;
    String usuario, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario= findViewById(R.id.edtUsuario);
        edtPassword= findViewById(R.id.edtPassword);
        btnLogin= findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                usuario = edtUsuario.getText().toString();
                password = edtPassword.getText().toString();

                if (!usuario.isEmpty() && !password.isEmpty()){

                    validarUsuario("http://192.168.1.1/proyecto_inventario/validar_usuario.php");

                }else{
                    Toast.makeText(MainActivity.this, "No se permiten campos vacios", Toast.LENGTH_SHORT).show();
                }
            }
        });

        };

    public void validarUsuario(String URL){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
             public void onResponse(String response) {

                if (!response.isEmpty()){
                    Intent intent = new Intent(getApplicationContext(), ActivityPrincipal.class);
                }else{
                    Toast.makeText( MainActivity.this, "Username o Contraseña incorrectas", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("usuario", edtUsuario.getText().toString());
                parametros.put("password", edtPassword.getText().toString());
                return super.getParams();
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}