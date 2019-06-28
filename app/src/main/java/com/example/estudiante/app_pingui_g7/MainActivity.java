package com.example.estudiante.app_pingui_g7;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class MainActivity extends AppCompatActivity {
    private RequestQueue mQueue;
    private String token = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        mQueue = Volley.newRequestQueue(this);
    }

    private void login(String usuario, String password){
        Map<String, String> params = new HashMap();

        params.put("username", usuario);

        params.put("password", password);

        JSONObject parameters = new JSONObject(params);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST, "https://amstdb.herokuapp.com/db/nuevo-jwt", parameters,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println(response);
                        try {
                            token = response.getString("token");

                            System.out.println(token);
                            Intent menuPrincipal = new
                                    Intent(getBaseContext(), Menu.class);

                            menuPrincipal.putExtra("token", token);
                            startActivity(menuPrincipal);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast toast = Toast.makeText(getApplicationContext()," USUARIO NO ENCONTRADO", Toast.LENGTH_LONG);
                toast.show();



            }
        });
        mQueue.add(request);
    }
    public void menuBTN(View v){
        final EditText username = (EditText) findViewById(R.id.txt_username);
        final EditText password = (EditText) findViewById(R.id.txt_password);

        String text = username.getText().toString();
        String pass = password.getText().toString();
        login(text,pass);
    }
}