package com.example.estudiante.app_pingui_g7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
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


        final TextView tem1 = (TextView) findViewById(R.id.txt_view_temperatura);





            String url1 = " https://amstdb.herokuapp.com/db/registroDeFrios";
        String url2 = " https://amstdb.herokuapp.com/db/registroDeFrios/2";
        String url3 = " https://amstdb.herokuapp.com/db/registroDeFrios/3";


            JsonArrayRequest request = new JsonArrayRequest(

                    Request.Method.GET, url1, null,

                    new Response.Listener<JSONArray>() {

                        @Override
                        public void onResponse(JSONArray response) {
                            System.out.println(response);
                            try {

                                int len = response.length();
                                for (int i = 0 ; i<len; i++){
                                    JSONObject x1 = (JSONObject) response.get(i);
                                    //System.out.println(x1.toString());
                                   // (x1.getString("temperatura\n"));
                                    tem1.append("Id: "+x1.getString("id")+
                                            "\t\t\t\tFecha: "+ x1.getString("fecha_registro")
                                            +"\t\t\t\tTemperatura: "+ x1.getString("temperatura")
                                            +"\t\t\t\tRecorrido: "+ x1.getString("recorrido") +"\n\n");

                                }

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
                    //System.out.println(token);
                    return params;
                }
            };;
            mQueue.add(request);

    }}

