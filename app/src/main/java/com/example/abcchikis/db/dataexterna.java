package com.example.abcchikis.db;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dataexterna extends AsyncTask<String, Void, Void> {

    @Override
    protected Void doInBackground(String... params) {
        String usudo = params[0];
        String pasi = params[1];

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexión = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10626602","sql10626602","zxYHp15NTi");

            String consulta = "INSERT INTO user (username, password) VALUES (?, ?)";

            // Preparar la sentencia SQL
            PreparedStatement sentencia = conexión.prepareStatement(consulta);
            sentencia.setString(1, usudo);
            sentencia.setString(2, pasi);

            // Ejecutar la sentencia SQL
            sentencia.executeUpdate();

            conexión.close(); // Cierra la conexión cuando hayas terminado
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}