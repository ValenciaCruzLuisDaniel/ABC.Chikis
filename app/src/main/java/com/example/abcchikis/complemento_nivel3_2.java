package com.example.abcchikis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abcchikis.db.dbhelper;

public class complemento_nivel3_2 extends AppCompatActivity {
    Button seguir,regreso;
    dbhelper hola=new dbhelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_sinBarra);
        setContentView(R.layout.activity_complemento_nivel3_2);


        seguir=findViewById(R.id.SIGUENTE);
        regreso=findViewById(R.id.back);


        regreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bas=new Intent(getApplicationContext(),complemento_nivel3.class);
                startActivity(bas);
            }
        });
        seguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hola.obtenerProgresoActualizadoPorNivel(3)>75){
                    Intent ultimo= new Intent(getApplicationContext(), complemento_nivel3_3.class);
                    startActivity(ultimo);}
                else{
                    hola.actualizarProgreso(3,75);
                    Intent ultimo= new Intent(getApplicationContext(), complemento_nivel3_3.class);
                    startActivity(ultimo);


                }

            }
        });

    }
}