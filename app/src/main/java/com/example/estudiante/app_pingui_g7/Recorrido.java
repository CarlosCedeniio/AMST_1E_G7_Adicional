package com.example.estudiante.app_pingui_g7;



import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
public class Recorrido extends AppCompatActivity {
    private RequestQueue mQueue;
    private String token = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorrido);
        mQueue = Volley.newRequestQueue(this);
        Intent login = getIntent();
        this.token = (String)login.getExtras().get("token");
        consultarRecorrido();
    }


    private void consultarRecorrido(){


        final TextView ori1 = (TextView) findViewById(R.id.ori_1);
        final TextView ori2 = (TextView) findViewById(R.id.ori_2);
        final TextView ori3 = (TextView) findViewById(R.id.ori_3);
        final TextView des1 = (TextView) findViewById(R.id.des_1);
        final TextView des2 = (TextView) findViewById(R.id.des_2);
        final TextView des3 = (TextView) findViewById(R.id.des_3);




        String url1 = " https://amstdb.herokuapp.com/db/recorrido/1";
        String url2 = " https://amstdb.herokuapp.com/db/recorrido/2";
        String url3 = " https://amstdb.herokuapp.com/db/recorrido/3";


        JsonObjectRequest request = new JsonObjectRequest(

                Request.Method.GET, url1, null,

                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println(response);
                        try {

                            des1.setText(response.getString("destino"));
                            ori1.setText(response.getString("origen"));



                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "JWT " + token);
                System.out.println(token);
                return params;
            }
        };;
        mQueue.add(request);
        JsonObjectRequest request2 = new JsonObjectRequest(

                Request.Method.GET, url2, null,

                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println(response);
                        try {

                            des2.setText(response.getString("destino"));
                            ori2.setText(response.getString("origen"));



                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "JWT " + token);
                System.out.println(token);
                return params;
            }
        };;
        mQueue.add(request2);
        JsonObjectRequest request3 = new JsonObjectRequest(

                Request.Method.GET, url3, null,

                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println(response);
                        try {

                            des3.setText(response.getString("destino"));
                            ori3.setText(response.getString("origen"));



                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "JWT " + token);
                System.out.println(token);
                return params;
            }
        };;
        mQueue.add(request3);



    }

}