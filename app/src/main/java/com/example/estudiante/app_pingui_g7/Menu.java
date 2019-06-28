package com.example.estudiante.app_pingui_g7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {
    String token = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();
        this.token = intent.getExtras().getString("token");
    }

    public void temperaturaBTN(View view){
        Intent intent = new Intent(this,Temperatura.class);
        intent.putExtra("token",token);
        startActivity(intent);
    }
    public void recorridoBTN(View view){
        Intent intent = new Intent(this,Recorrido.class);
        intent.putExtra("token",token);
        startActivity(intent);
    }
    public void exit (View v){
        System.exit(1);
    }
}
