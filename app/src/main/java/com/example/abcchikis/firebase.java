package com.example.abcchikis;

import com.example.abcchikis.db.Usuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class firebase {
    private FirebaseAuth mAuth;

    private DatabaseReference mDatabase;

    public void insertarDatos(String nombreUsuario, String contrasena) {
        mDatabase = FirebaseDatabase.getInstance().getReference().child("usuarios");

        String usuarioId = mDatabase.push().getKey();

        Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasena);
        mDatabase.child(usuarioId).setValue(nuevoUsuario);
    }
    public firebase() {
        mAuth = FirebaseAuth.getInstance();
    }


    public boolean iniciarSesion(String nombreUsuario, String contrasena) {
        try {
            mAuth.signInWithEmailAndPassword(nombreUsuario, contrasena).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    // Inicio de sesión exitoso
                } else {
                    // Inicio de sesión fallido
                }
            });
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
