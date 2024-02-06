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

public class nivel1 extends AppCompatActivity {
    VideoView vocal;
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
        setContentView(R.layout.activity_nivel1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        MediaController mediaController = new MediaController(this);

            vocal = findViewById(R.id.vocales);
            String urlVideo = "android.resource://" + getPackageName() + "/" + R.raw.vocalespresentacion;
            vocal.setVideoURI(Uri.parse(urlVideo));


            vocal.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    if(hola.obtenerProgresoActualizadoPorNivel(1)>50){

                        Intent intent=new Intent(getApplicationContext(), complementoN1.class);
                        startActivity(intent);
                    }else{
                    hola.actualizarProgreso(1,50);

                    Intent intent=new Intent(getApplicationContext(), complementoN1.class);
                    startActivity(intent);
                    }

                }
            });
        mediaController.setAnchorView(vocal); // Vincula el MediaController al VideoView
        vocal.setMediaController(mediaController);
            vocal.start();








    }
}