package com.example.abcchikis;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abcchikis.db.dbhelper;

import java.util.Random;

public class complemento_nivel2 extends AppCompatActivity {
    private TypedArray vocales_array;
    private ImageView visor;
    private Button opcion_a, opcion_b;
    int imagenrandom;
    int recorrido=0, intentos=8;
    int errores=0;
dbhelper hola=new  dbhelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complemento_nivel2);
        setTheme(R.style.AppTheme_sinBarra);

        vocales_array = getResources().obtainTypedArray(R.array.vocales);
        visor=(ImageView)findViewById(R.id.visor);
        opcion_a=(Button)findViewById(R.id.aopcion);
        opcion_b=(Button)findViewById(R.id.bopcion);
        cambiarImagen();


        opcion_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { validarBoton("A");   }
        });
        opcion_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {validarBoton("b");}
        });





    }
    private void validarBoton(String vocalboton){

        if (errores==5){
            Toast.makeText(this, "Haz cometido 5 errores volvamos a intentarlo", Toast.LENGTH_LONG).show();

            Intent menu= new Intent(getApplicationContext(), listaniveles.class );
            startActivity(menu);
        }else{

            if(recorrido<intentos){
                if(vocalboton.equalsIgnoreCase(getVocalCorrecta())){
                    Toast.makeText(this, "error vuelve a intentar",Toast.LENGTH_LONG).show();
                    errores++;
                    cambiarImagen();
                }else {
                    Toast.makeText(this, "correcto", Toast.LENGTH_LONG).show();
                    cambiarImagen();
                    recorrido++;
                }
            }else{

                if(hola.obtenerProgresoActualizadoPorNivel(2)>=100){Toast.makeText(this, "tarea completa bien hecho", Toast.LENGTH_LONG).show();
                    Intent menu= new Intent(getApplicationContext(), listaniveles.class );
                    startActivity(menu);}
                else{
                    hola.actualizarProgreso(2,100);

                    Toast.makeText(this, "tarea completa bien hecho", Toast.LENGTH_LONG).show();
                    Intent menu= new Intent(getApplicationContext(), listaniveles.class );
                    startActivity(menu);
                }

            }

        }


    }

    private void cambiarImagen() {
        Random numero = new Random();
     imagenrandom = numero.nextInt(10);
        visor.setBackgroundResource(vocales_array.getResourceId(imagenrandom,1));

        switch (imagenrandom+1){
            case 1:
                //A
                opcion_b.setBackgroundResource(R.drawable.abejita);
                opcion_b.setTag("A");
                opcion_a.setBackgroundResource(R.drawable.iguana);
                opcion_a.setTag("b");

                break;
            case 2:
                //E
                opcion_b.setBackgroundResource(R.drawable.elotito);
                opcion_b.setTag("A");
                opcion_a.setBackgroundResource(R.drawable.ojos);
                opcion_a.setTag("b");
                break;
            case 3:
                //I
                opcion_b.setBackgroundResource(R.drawable.aviosito);
                opcion_b.setTag("A");
                opcion_a.setBackgroundResource(R.drawable.iglusito);
                opcion_a.setTag("b");
                break;
            case 4:
                //O
                opcion_b.setBackgroundResource(R.drawable.unas);
                opcion_b.setTag("A");
                opcion_a.setBackgroundResource(R.drawable.osito);
                opcion_a.setTag("b");
                break;
            case 5:
                //U
                opcion_b.setBackgroundResource(R.drawable.uvitas);
                opcion_b.setTag("A");
                opcion_a.setBackgroundResource(R.drawable.elefantebebe);
                opcion_a.setTag("b");
                break;
            case 6:
                //A
                opcion_b.setBackgroundResource(R.drawable.uno);
                opcion_b.setTag("A");
                opcion_a.setBackgroundResource(R.drawable.ardillita);
                opcion_a.setTag("b");

                break;
            case 7:
                //E
                opcion_b.setBackgroundResource(R.drawable.estrella);
                opcion_b.setTag("A");
                opcion_a.setBackgroundResource(R.drawable.olita);
                opcion_a.setTag("b");
                break;
            case 8:
                //I
                opcion_b.setBackgroundResource(R.drawable.ambulancia);
                opcion_b.setTag("A");
                opcion_a.setBackgroundResource(R.drawable.isla);
                opcion_a.setTag("b");
                break;
            case 9:
                //O
                opcion_b.setBackgroundResource(R.drawable.ovejiya);
                opcion_b.setTag("A");
                opcion_a.setBackgroundResource(R.drawable.estrella);
                opcion_a.setTag("b");
                break;
            case 10:
                //U
                opcion_b.setBackgroundResource(R.drawable.unicornio);
                opcion_b.setTag("A");
                opcion_a.setBackgroundResource(R.drawable.escobita);
                opcion_a.setTag("b");
                break;

        }

        opcion_a.setEnabled(true);
        opcion_b.setEnabled(true);


    }
    private String getVocalCorrecta() {
        switch (imagenrandom+1) {
            case 1:
                return "A";
            case 2:
                return "A";
            case 3:
                return "b";
            case 4:
                return "b";
            case 5:
                return "A";
            case 6:
                return "b";
            case 7:
                return "A";
            case 8:
                return "b";
            case 9:
                return "A";
            case 10:
                return "A";
            default:
                return "";
        }
    }

}