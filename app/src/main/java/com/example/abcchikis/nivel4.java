package com.example.abcchikis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abcchikis.db.dbhelper;

public class nivel4 extends AppCompatActivity {

    ImageView imagenes;
    Button opa,opb;
    int recorrido=1,intentos, errores;
    dbhelper hola=new dbhelper(this);


    public void onBackPressed() {
        Intent intent = new Intent(this, listaniveles.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_sinBarra);
        setContentView(R.layout.activity_nivel4);

        recorrido=1;
        imagenes=findViewById(R.id.imagenab);
        opa=findViewById(R.id.opciona);
        opb=findViewById(R.id.opcionb);


        opa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarBoton("a");

            }
        });

        opb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarBoton("b");

            }
        });

        siguiente();









    }
    private void validarBoton(String letra){

        if (errores==20){
            Toast.makeText(this, "Haz cometido 20 errores volvamos a intentarlo", Toast.LENGTH_LONG).show();

            Intent menu= new Intent(getApplicationContext(), listaniveles.class );
            startActivity(menu);
        }else{

            if(recorrido<27){
                if(!letra.equalsIgnoreCase(correcto())){
                    Toast.makeText(this, "error vuelve a intentar",Toast.LENGTH_LONG).show();
                    errores++;
                }else {
                    Toast.makeText(this, "correcto", Toast.LENGTH_LONG).show();
                    recorrido++;
                    siguiente();
                }
            }else{

                if(hola.obtenerProgresoActualizadoPorNivel(4)>50){
                    Toast.makeText(this, "tarea completa bien hecho", Toast.LENGTH_LONG).show();
                    Intent menu= new Intent(getApplicationContext(), complemento_nivel4.class);
                    startActivity(menu);
                }
                else{
                        hola.actualizarProgreso(4,50);
                    Toast.makeText(this, "tarea completa bien hecho", Toast.LENGTH_LONG).show();
                    Intent menu= new Intent(getApplicationContext(), complemento_nivel4.class);
                    startActivity(menu);
                }

            }

        }


    }








    private void siguiente() {

        switch (recorrido){
            case 1:
                imagenes.setBackgroundResource(R.drawable.a_2);
                opa.setBackgroundResource(R.drawable.ardillita);
                opb.setBackgroundResource(R.drawable.ballenita);

                opa.setTag("a");
                opb.setTag("b");


                break;
            case 2:

                imagenes.setBackgroundResource(R.drawable.b_2);
                opa.setBackgroundResource(R.drawable.leon);
                opb.setBackgroundResource(R.drawable.barquito);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 3:

                imagenes.setBackgroundResource(R.drawable.c_2);
                opa.setBackgroundResource(R.drawable.ambulancia);
                opb.setBackgroundResource(R.drawable.canguro);
                opa.setTag("a");
                opb.setTag("b");


                break;
            case 4:

                imagenes.setBackgroundResource(R.drawable.d_2);
                opa.setBackgroundResource(R.drawable.dado);
                opb.setBackgroundResource(R.drawable.koala);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 5:


                imagenes.setBackgroundResource(R.drawable.e_2);
                opa.setBackgroundResource(R.drawable.escobita);
                opb.setBackgroundResource(R.drawable.rana);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 6:

                imagenes.setBackgroundResource(R.drawable.f_2);
                opa.setBackgroundResource(R.drawable.foca);
                opb.setBackgroundResource(R.drawable.quesadilla);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 7:

                imagenes.setBackgroundResource(R.drawable.g_2);
                opa.setBackgroundResource(R.drawable.vaca);
                opb.setBackgroundResource(R.drawable.gato);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 8:

                imagenes.setBackgroundResource(R.drawable.h_2);
                opa.setBackgroundResource(R.drawable.helado);
                opb.setBackgroundResource(R.drawable.leon);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 9:

                imagenes.setBackgroundResource(R.drawable.i_2);
                opa.setBackgroundResource(R.drawable.iglusito);
                opb.setBackgroundResource(R.drawable.nariz);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 10:

                imagenes.setBackgroundResource(R.drawable.j_2);
                opa.setBackgroundResource(R.drawable.rana);
                opb.setBackgroundResource(R.drawable.jabon);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 11:

                imagenes.setBackgroundResource(R.drawable.k_2);
                opa.setBackgroundResource(R.drawable.ardillita);
                opb.setBackgroundResource(R.drawable.koala);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 12:

                imagenes.setBackgroundResource(R.drawable.l_2);
                opa.setBackgroundResource(R.drawable.lobo);
                opb.setBackgroundResource(R.drawable.ambulancia);
                opa.setTag("a");
                opb.setTag("b");

                break;

            case 13:

                imagenes.setBackgroundResource(R.drawable.m_2);
                opa.setBackgroundResource(R.drawable.mango);
                opb.setBackgroundResource(R.drawable.zanahorias);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 14:

                imagenes.setBackgroundResource(R.drawable.n_2);
                opa.setBackgroundResource(R.drawable.dado);
                opb.setBackgroundResource(R.drawable.nariz);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 15:

                imagenes.setBackgroundResource(R.drawable.letra_n_quenoexiste_ingles);
                opa.setBackgroundResource(R.drawable.letran_ingles);
                opb.setBackgroundResource(R.drawable.unicornio);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 16:

                imagenes.setBackgroundResource(R.drawable.o_2);
                opa.setBackgroundResource(R.drawable.ovejiya);
                opb.setBackgroundResource(R.drawable.yogurt);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 17:

                imagenes.setBackgroundResource(R.drawable.p_2);
                opa.setBackgroundResource(R.drawable.web);
                opb.setBackgroundResource(R.drawable.pollito);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 18:

                imagenes.setBackgroundResource(R.drawable.q_2);
                opa.setBackgroundResource(R.drawable.queso);
                opb.setBackgroundResource(R.drawable.escobita);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 19:

                imagenes.setBackgroundResource(R.drawable.r_2);
                opa.setBackgroundResource(R.drawable.raton);
                opb.setBackgroundResource(R.drawable.foca);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 20:

                imagenes.setBackgroundResource(R.drawable.s_2);
                opa.setBackgroundResource(R.drawable.sol);
                opb.setBackgroundResource(R.drawable.helado);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 21:

                imagenes.setBackgroundResource(R.drawable.t_2);
                opa.setBackgroundResource(R.drawable.koala);
                opb.setBackgroundResource(R.drawable.taza);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 22:

                imagenes.setBackgroundResource(R.drawable.u_2);
                opa.setBackgroundResource(R.drawable.ardillita);
                opb.setBackgroundResource(R.drawable.uno);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 23:

                imagenes.setBackgroundResource(R.drawable.v_2);
                opa.setBackgroundResource(R.drawable.ventana);
                opb.setBackgroundResource(R.drawable.jabon);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 24:

                imagenes.setBackgroundResource(R.drawable.w_w);
                opa.setBackgroundResource(R.drawable.wifi);
                opb.setBackgroundResource(R.drawable.ballenita);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 25:

                imagenes.setBackgroundResource(R.drawable.x_2);
                opa.setBackgroundResource(R.drawable.xilofono);
                opb.setBackgroundResource(R.drawable.canguro);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 26:

                imagenes.setBackgroundResource(R.drawable.y_2);
                opa.setBackgroundResource(R.drawable.ardillita);
                opb.setBackgroundResource(R.drawable.yoyo);
                opa.setTag("a");
                opb.setTag("b");

                break;
            case 27:

                imagenes.setBackgroundResource(R.drawable.z_2);
                opa.setBackgroundResource(R.drawable.tigre);
                opb.setBackgroundResource(R.drawable.zanahorias);
                opa.setTag("a");
                opb.setTag("b");

                break;


        }
        opa.setEnabled(true);
        opb.setEnabled(true);


    }
    public String correcto(){
        switch (recorrido){
            case 1:
                return"a";
            case 2:
                return"b";
            case 3:
                return"b";
            case 4:
                return"a";
            case 5:
                return"a";
            case 6:
                return"a";
            case 7:
                return"b";
            case 8:
                return"a";
            case 9:
                return"a";
            case 10:
                return"b";
            case 11:
                return"b";
            case 12:
                return"a";
            case 13:
                return"a";
            case 14:
                return"b";
            case 15:
                return"a";
            case 16:
                return"a";
            case 17:
                return"b";
            case 18:
                return"a";
            case 19:
                return"a";
            case 20:
                return"a";
            case 21:
                return"b";
            case 22:
                return"b";
            case 23:
                return"a";
            case 24:
                return"a";
            case 25:
                return"a";
            case 26:
                return"b";
            case 27:
                return"b";
            default:
                return "";
        }




    }
}