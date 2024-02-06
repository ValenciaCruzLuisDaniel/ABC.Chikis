package com.example.abcchikis;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abcchikis.db.dbhelper;

import java.util.Random;

public class complementoN1 extends AppCompatActivity {
    Button vocala, vocale, vocali, vocalo, vocalu;
    int oportunidades = 7;
    int recorrido = 0;
    int vocalCorrecta;
    MediaPlayer mediaPlayer;
   dbhelper hola = new dbhelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complemento_n1);

        vocala = findViewById(R.id.vocal_a);
        vocale = findViewById(R.id.vocal_e);
        vocali = findViewById(R.id.vocal_i);
        vocalo = findViewById(R.id.vocal_o);
        vocalu = findViewById(R.id.vocal_u);

        vocala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarVocalSeleccionada("a");
            }
        });

        vocale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarVocalSeleccionada("e");
            }
        });

        vocali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarVocalSeleccionada("i");
            }
        });

        vocalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarVocalSeleccionada("o");
            }
        });

        vocalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarVocalSeleccionada("u");
            }
        });

        generarNuevaVocalAleatoria();
    }

    private void verificarVocalSeleccionada(String vocalSeleccionada) {
        if (recorrido < oportunidades) {
            if (vocalSeleccionada.equalsIgnoreCase(getVocalCorrecta())) {
                Toast.makeText(complementoN1.this, "¡CORRECTO!", Toast.LENGTH_SHORT).show();
                recorrido++;
                if (recorrido < oportunidades) {
                    generarNuevaVocalAleatoria();
                } else {


                    if(hola.obtenerProgresoActualizadoPorNivel(1)>100){

                        Toast.makeText(complementoN1.this, "¡Felicidades, has completado el ejercicio!", Toast.LENGTH_SHORT).show();
                        Intent regresomenu= new Intent(complementoN1.this, listaniveles.class);
                        startActivity(regresomenu);
                    }else{
                        hola.actualizarProgreso(1,100);
                        Toast.makeText(complementoN1.this, "¡Felicidades, has completado el ejercicio!", Toast.LENGTH_SHORT).show();
                        Intent regresomenu= new Intent(complementoN1.this, listaniveles.class);
                        startActivity(regresomenu);

                    }

                }
            } else {
                Toast.makeText(complementoN1.this, "¡INCORRECTO!", Toast.LENGTH_SHORT).show();
                recorrido++;
            }
        } else {
            Toast.makeText(complementoN1.this, "Has agotado tus oportunidades.", Toast.LENGTH_SHORT).show();
        }
    }

    private void generarNuevaVocalAleatoria() {
        Random random = new Random();
        vocalCorrecta = random.nextInt(5);

        // Reproducir mensaje de audio para la vocal aleatoria
        switch (vocalCorrecta+1) {
            case 1:
                mediaPlayer = MediaPlayer.create(this, R.raw.vocal_a);
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(this, R.raw.vocal_e);
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(this, R.raw.vocal_i);
                break;
            case 4:
                mediaPlayer = MediaPlayer.create(this, R.raw.vocal_o);
                break;
            case 5:
                mediaPlayer = MediaPlayer.create(this, R.raw.vocal_u);
                break;
        }
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });

            mediaPlayer.start();
        }

        // Restablecer el estado de los botones de las vocales
        vocala.setEnabled(true);
        vocale.setEnabled(true);
        vocali.setEnabled(true);
        vocalo.setEnabled(true);
        vocalu.setEnabled(true);
    }

    private String getVocalCorrecta() {
        switch (vocalCorrecta+1) {
            case 1:
                return "a";
            case 2:
                return "e";
            case 3:
                return "i";
            case 4:
                return "o";
            case 5:
                return "u";
            default:
                return "";
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}

//selected para comprobar el estado de un boton utilizado

