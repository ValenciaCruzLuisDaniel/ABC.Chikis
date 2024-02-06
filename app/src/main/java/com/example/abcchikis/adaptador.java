package com.example.abcchikis;

import android.content.Context;
import android.content.Intent;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.HashMap;

public class adaptador extends BaseAdapter {

    private static LayoutInflater inflater=null;
    Context contexto;
    String [][] datos;
    int [] datosimg;

    public adaptador(Context contexto, String[][] datos,int[]imagenes){
        this.contexto=contexto;
        this.datos=datos;
        this.datosimg=imagenes;
        inflater=(LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);



    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        // Agregar el efecto de retroalimentación táctil
        TypedValue typedValue = new TypedValue();


        final View vista = inflater.inflate(R.layout.elementolista, null);
        TextView titulo = vista.findViewById(R.id.tituNivel);
        TextView descripcion = vista.findViewById(R.id.deslevel);
        ImageView imagen = vista.findViewById(R.id.imngnivel);
        ProgressBar progreso = vista.findViewById(R.id.barrapro);

        titulo.setText(datos[i][0]);
        descripcion.setText(datos[i][1]);
        imagen.setImageResource(datosimg[i]);

        progreso.setProgress(Integer.valueOf(datos[i][2]));

        vista.getContext().getTheme().resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true);
        vista.setBackgroundResource(typedValue.resourceId);


        vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String titulo=datos[i][0];

            //declaracion del mapa
                HashMap <String,Class<?>> activinivel=new HashMap<>();


                //declaracion de niveles y su clase con layout
                activinivel.put("Conozcamos las vocales",nivel1.class);
                activinivel.put("Palabras con vocales", nivel2.class);
                activinivel.put("Conozcamos el abecedario!", nivel3.class);
                activinivel.put("Hagamos ejercicios!!",nivel4.class);

                //obtenemos el titulo de la actividad y la relacion con la clase
                Class <?> actividad= activinivel.get(titulo);


                if(actividad!=null){
                    Intent redireccionamiento= new Intent(v.getContext(),actividad);
                    v.getContext().startActivity(redireccionamiento);
                }else{
                    Intent in=new Intent(v.getContext(), error.class);
                    v.getContext().startActivity(in);
                }




            }
        });

        return vista;
    }


    @Override
    public int getCount() {
        return datosimg.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}
