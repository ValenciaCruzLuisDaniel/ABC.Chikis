package com.example.abcchikis;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abcchikis.db.dbhelper;

public class nivel3 extends AppCompatActivity {
    VideoView abecedario;
    String urlvideo;
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
        setContentView(R.layout.activity_nivel3);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        MediaController mediaController = new MediaController(this);

        abecedario = findViewById(R.id.abecedario);
        String urlVideo = "android.resource://" + getPackageName() + "/" + R.raw.abecedario;
        abecedario.setVideoURI(Uri.parse(urlVideo));


        abecedario.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if(hola.obtenerProgresoActualizadoPorNivel(3)>25){

                    Intent intent=new Intent(getApplicationContext(), complemento_nivel3.class);
                    startActivity(intent);
                }else{
                    hola.actualizarProgreso(3,25);

                    Intent intent=new Intent(getApplicationContext(), complemento_nivel3.class);
                    startActivity(intent);
                }

            }
        });
        mediaController.setAnchorView(abecedario); // Vincula el MediaController al VideoView
        abecedario.setMediaController(mediaController);
        abecedario.start();







    }
}