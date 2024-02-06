package com.example.abcchikis;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abcchikis.db.dataexterna;
import com.example.abcchikis.db.dbhelper;


public class registro extends AppCompatActivity {
    Button regis;
    String usuarioCadena,contraseñaCadena;
   dbhelper dbhelper=new dbhelper(registro.this);
   dataexterna db= new dataexterna();

    firebase firebaseInstance = new firebase();

   EditText obtenerusu, obtenerpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_sinBarra);
        setContentView(R.layout.activity_registro);



        final Intent login=new Intent(getApplicationContext(), MainActivity.class);
        obtenerusu=findViewById(R.id.usunuevo);
        obtenerpass=findViewById(R.id.pasnew);
        regis=findViewById(R.id.button);
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuarioCadena=obtenerusu.getText().toString();
                contraseñaCadena=obtenerpass.getText().toString();
                Toast errorvacio, error;

                errorvacio=Toast.makeText(getApplicationContext(), "Uno de los campos estan vacios", Toast.LENGTH_SHORT);

              if(TextUtils.isEmpty(usuarioCadena)){

                  errorvacio.show();
              }else if(TextUtils.isEmpty(contraseñaCadena)){

                  errorvacio.show();

              }else
              if (usuarioCadena.length() < 6 ) {
                      error = Toast.makeText(getApplicationContext(), "El usuario debe ser de al menos 6 caracteres", Toast.LENGTH_SHORT);
                      error.show();
              } else if (contraseñaCadena.length()<8){
                    error=Toast.makeText(getApplicationContext(), "la contraseña debe tener al menos 8 caracteres", Toast.LENGTH_SHORT);
                      error.show();
                  }
                  else {
                      dbhelper.insertardb(usuarioCadena,contraseñaCadena);
                      dbhelper.insertarpro(usuarioCadena);
                      firebaseInstance.insertarDatos(usuarioCadena,contraseñaCadena);


                      Toast registroExitoso=Toast.makeText(getApplicationContext(),"el registro fue exitoso",Toast.LENGTH_LONG);
                        registroExitoso.show();
                        startActivity(login);


                  }

            }
        });
    }
}