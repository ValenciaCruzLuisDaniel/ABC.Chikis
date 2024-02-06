package com.example.abcchikis;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abcchikis.db.dbhelper;

public class listaniveles extends AppCompatActivity {

    String titulo = "Niveles";
    dbhelper hola;
    adaptador adaptadorLista;

    ListView lista;

    String[][] datos = {
            {"Conozcamos las vocales", "En este nivel vamos a conocer las vocales y como se pronuncia cada una", ""},
            {"Palabras con vocales", "En este nivel aprenderemos palabras con las vocales que aprendimos VAMOS!", ""},
            {"Conozcamos el abecedario!", "En esta nivel vamos a conocer las letras del abecedario", ""},
            {"Hagamos ejercicios!!", "Veamos que aprendimos identifiquemos las letras del abecedario y aprendamos", ""}
    };

    int[] datosimg = {
            R.drawable.vocales,
            R.drawable.nivel1,
            R.drawable.nivel3,
            R.drawable.nivel4
    };

    public void onBackPressed() {
        finishAffinity(); // Cierra todas las actividades en la pila
        System.exit(0); // Cierra la aplicación por completo
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle(titulo);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listaniveles);

        hola = new dbhelper(this);

        lista = (ListView) findViewById(R.id.niveles);

        adaptadorLista = new adaptador(this, datos, datosimg);
        lista.setAdapter(adaptadorLista);

        obtenerProgresoActualizadoPorNivel();

    }

    private void obtenerProgresoActualizadoPorNivel() {
        datos[0][2] = String.valueOf(hola.obtenerProgresoActualizadoPorNivel(1));
        datos[1][2] = String.valueOf(hola.obtenerProgresoActualizadoPorNivel(2));
        datos[2][2] = String.valueOf(hola.obtenerProgresoActualizadoPorNivel(3));
        datos[3][2] = String.valueOf(hola.obtenerProgresoActualizadoPorNivel(4));

        adaptadorLista.notifyDataSetChanged();
    }
}
