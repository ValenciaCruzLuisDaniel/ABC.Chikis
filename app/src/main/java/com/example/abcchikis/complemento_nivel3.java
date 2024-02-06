package com.example.abcchikis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abcchikis.db.dbhelper;

public class complemento_nivel3 extends AppCompatActivity {

    Button a,b,c,d,e,f,g,h,i,select;
    dbhelper hola=new dbhelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_sinBarra);
        setContentView(R.layout.activity_complemento_nivel3);

        a=findViewById(R.id.A);
        b=findViewById(R.id.B);
        c=findViewById(R.id.C);
        d=findViewById(R.id.D);
        e=findViewById(R.id.E);
        f=findViewById(R.id.F);
        g=findViewById(R.id.G);
        h=findViewById(R.id.H);
        i=findViewById(R.id.I);


        select=findViewById(R.id.SIGUENTE);


        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(hola.obtenerProgresoActualizadoPorNivel(3)>50){
                Intent seguir=new Intent(getApplicationContext(), complemento_nivel3_2.class);

                startActivity(seguir);}
                else{

                    hola.actualizarProgreso(3,50);
                    Intent seguir=new Intent(getApplicationContext(), complemento_nivel3_2.class);

                    startActivity(seguir);


                }


            }
        });









    }
}