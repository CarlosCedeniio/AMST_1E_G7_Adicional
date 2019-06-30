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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

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


        final TextView recorrido = (TextView) findViewById(R.id.txt_view_recorrido);





        String url1 = " https://amstdb.herokuapp.com/db/recorrido";



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
                                recorrido.append("Id: "+x1.getString("id")+
                                        "\t\t\t\t\t\tCamion: "+ x1.getString("camion")+"\n"
                                        +"Inicio: "+ x1.getString("fecha_inicio")+"\n"
                                        +"Fin: "+ x1.getString("fecha_fin")+"\n"
                                        +"Origen: "+ x1.getString("origen")
                                        +"\t\t\t\t\t\tDestino: "+ x1.getString("destino")
                                        +"\n\n");

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
                System.out.println(token);
                return params;
            }
        };;
        mQueue.add(request);


    }

}