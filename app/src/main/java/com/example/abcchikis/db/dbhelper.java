package com.example.abcchikis.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {
    private static final int database_version=1;
    private static final String nombre="chikis";
    public static final String table_usuario="usuario";
    public static final String table_progreso="progreso";




    public dbhelper(@Nullable Context context) {
        super(context, nombre, null, database_version);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + table_usuario +
                "(id_usuario INTEGER PRIMARY KEY AUTOINCREMENT, usuario TEXT NOT NULL, password TEXT NOT NULL)"
        );
        sqLiteDatabase.execSQL("CREATE TABLE " + table_progreso +
                "(id_usuario TEXT NOT NULL, nivel INTEGER, progreso INTEGER)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



    public long insertardb(String usuarioAinsertar, String contraseñaAinsertar){
        SQLiteDatabase db =this.getWritableDatabase();



        ContentValues valores= new ContentValues();
        valores.put("usuario", usuarioAinsertar);
        valores.put("password", contraseñaAinsertar);


        return db.insert(table_usuario, null, valores);


    }

    public long insertarpro( String usuario) {
        String consultapro;
        SQLiteDatabase db = this.getWritableDatabase();

        consultapro = "INSERT INTO progreso (id_usuario, nivel, progreso) VALUES (?,?, ?)";

        ContentValues values = new ContentValues();
        values.put("id_usuario", usuario);
        values.put("nivel", 1);
        values.put("progreso", 0);

        long result = db.insert("progreso", null, values);

        consultapro="INSERT INTO progreso (id_usuario, nivel, progreso) VALUES (?,?, ?)";


        values.put("id_usuario", usuario);
        values.put("nivel", 2);
        values.put("progreso", 0);
        result = db.insert("progreso", null, values);

        consultapro="INSERT INTO progreso (id_usuario, nivel, progreso) VALUES (?,?, ?)";


        values.put("id_usuario", usuario);
        values.put("nivel", 3);
        values.put("progreso", 0);
        result = db.insert("progreso", null, values);

        consultapro="INSERT INTO progreso (id_usuario, nivel, progreso) VALUES (?,?, ?)";


        values.put("id_usuario", usuario);
        values.put("nivel", 4);
        values.put("progreso", 0);
        result = db.insert("progreso", null, values);



        db.close();

        return result;
    }

    public boolean ConsultaLogin (String usuarioAconsultar , String contraseñaAconsultar){
        String Consultalogin;
        Cursor cursor;
        SQLiteDatabase db =this.getWritableDatabase();


        Consultalogin= "select * from usuario where usuario=? and password=?";
        cursor=db.rawQuery(Consultalogin,new String[]{usuarioAconsultar,contraseñaAconsultar});




        return cursor.moveToNext();
    }


    private static String nomUsuario;

    public static void setUsuario(String value) {
        nomUsuario = value;
    }

    public static String getUsuario() {
        return nomUsuario;
    }




    public void actualizarProgreso(int nivel, int nuevoProgreso) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("progreso", nuevoProgreso);

        String whereClause = "id_usuario = ? AND nivel = ?";
        String[] whereArgs = {getUsuario(), String.valueOf(nivel)};

        int rowsAffected = db.update("progreso", values, whereClause, whereArgs);

        db.close();
    }

    public int obtenerProgresoActualizadoPorNivel(int nivel) {
        String usuario = getUsuario();

        SQLiteDatabase db = this.getReadableDatabase();

        String[] columnas = {"progreso"};
        String seleccion = "nivel = ? AND id_usuario = ?";
        String[] argumentos = {String.valueOf(nivel), usuario};

        Cursor cursor = db.query("progreso", columnas, seleccion, argumentos, null, null, null);

        int progreso = 0;

        if (cursor.moveToFirst()) {
            progreso = cursor.getInt(cursor.getColumnIndex("progreso"));
        }

        cursor.close();
        db.close();

        return progreso;
    }
}
