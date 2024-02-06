package com.example.abcchikis;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abcchikis.db.dbhelper;

public class MainActivity extends AppCompatActivity {
    Button inicioSecion,nuevoUsuario;
    EditText usuri,pass;




    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_sinBarra);
        setContentView(R.layout.activity_main);

//declaracion de variables
        inicioSecion=findViewById(R.id.inicio);
        nuevoUsuario=findViewById(R.id.usunuevo);
        usuri=findViewById(R.id.user);
        pass=findViewById(R.id.pass);
        firebase firebaseInstance = new firebase();

        inicioSecion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbhelper dbhelper=new dbhelper(MainActivity.this);

                SQLiteDatabase escribirBase = dbhelper.getWritableDatabase();
                //declaracion de variables del boton
                Toast camposVacioMensaje, loginExitoso, loginErroneo;
                camposVacioMensaje=Toast.makeText(getApplicationContext(), "Uno de los campos estan vacios", Toast.LENGTH_SHORT);
                loginExitoso=Toast.makeText(getApplicationContext(), "bienvenido", Toast.LENGTH_SHORT);
                loginErroneo=Toast.makeText(getApplicationContext(), "error con el inicio ", Toast.LENGTH_SHORT);
                String consulta, usu, contra;
                usu = usuri.getText().toString();
                contra = pass.getText().toString();
                //procedimiento

                if (TextUtils.isEmpty(usu) && TextUtils.isEmpty(contra)) {
                    camposVacioMensaje.show();
                } else {
                    dbhelper base= new dbhelper(MainActivity.this);


                   // if (base.ConsultaLogin(usu,contra)) {  //base sqlite
                    if(firebaseInstance.iniciarSesion(usu,contra)){

                    loginExitoso.show();
                    base.setUsuario(usu);

                    Intent nivel = new Intent(getApplicationContext(), listaniveles.class);
                    startActivity(nivel);


                } else {
                    loginErroneo.show();

                }
            }
            }
        });

        nuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbhelper dbhelper=new dbhelper(MainActivity.this);
                SQLiteDatabase escribirBase = dbhelper.getWritableDatabase();
                Toast errorBase=Toast.makeText(getApplicationContext(), "error con la base de datos", Toast.LENGTH_SHORT);
                Intent actividadRegistro= new Intent(getApplicationContext(),registro.class);

                if(escribirBase!=null){
                    startActivity(actividadRegistro);

                }else{
                    errorBase.show();
                }



            }
        });


    }
}