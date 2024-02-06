package com.example.abcchikis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abcchikis.db.dbhelper;

public class complemento_nivel3_3 extends AppCompatActivity {
Button regresonivel,regresar;
dbhelper hola=new dbhelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_sinBarra);
        setContentView(R.layout.activity_complemento_nivel3_3);




        regresonivel=findViewById(R.id.SIGUENTE);
        regresar=findViewById(R.id.regresa);

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back2 =new Intent(getApplicationContext(),complemento_nivel3_2.class);

                startActivity(back2);
            }
        });

        regresonivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(hola.obtenerProgresoActualizadoPorNivel(3)>100){
                    Intent intent= new Intent(getApplicationContext(), listaniveles.class);
                    startActivity(intent);}
                else{

                    hola.actualizarProgreso(3,100);
                    Intent intent= new Intent(getApplicationContext(), listaniveles.class);
                    startActivity(intent);


                }

            }
        });
    }
}