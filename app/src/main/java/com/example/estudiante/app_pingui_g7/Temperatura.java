package com.example.estudiante.app_pingui_g7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.HeaderViewListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Header;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Temperatura extends AppCompatActivity {
    private RequestQueue mQueue;
    private String token = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura );
        mQueue = Volley.newRequestQueue(this);
        Intent login = getIntent();
        this.token = (String)login.getExtras().get("token");
        consultarTemperatura();
    }


    private void consultarTemperatura(){


        final TextView tem1 = (TextView) findViewById(R.id.tem_1);
        final TextView tem2 = (TextView) findViewById(R.id.tem_2);
        final TextView tem3 = (TextView) findViewById(R.id.tem_3);




            String url1 = " https://amstdb.herokuapp.com/db/registroDeFrios/1";
        String url2 = " https://amstdb.herokuapp.com/db/registroDeFrios/2";
        String url3 = " https://amstdb.herokuapp.com/db/registroDeFrios/3";


            JsonObjectRequest request = new JsonObjectRequest(

                    Request.Method.GET, url1, null,

                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            System.out.println(response);
                            try {

                                    tem1.setText(response.getString("temperatura"));



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

                            tem2.setText(response.getString("temperatura"));



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

                            tem3.setText(response.getString("temperatura"));



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

