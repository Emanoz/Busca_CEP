package com.app.busca_cep.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.busca_cep.AppDatabase;
import com.app.busca_cep.controller.CepController;
import com.app.busca_cep.controller.UsuarioController;
import com.app.busca_cep.entity.UsuarioEntity;

public class Activity_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");

        // Criação do banco de dados do projeto que contém os dados dos usuários pré inseridos
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "db_busca_cep").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        UsuarioController usuarioController = new UsuarioController(db);

        // Verifica se há um usuário já logado
        UsuarioEntity usuarioActive = usuarioController.findUsuarioActive();
        if(usuarioActive != null){
            usuarioController.autenticaUsuario(usuarioActive.usuario, usuarioActive.senha);
            startActivity(new Intent(Activity_login.this, Activity_dashboard.class));
        }

        EditText textUsuario = findViewById(R.id.activity_login_usuario);
        EditText textSenha = findViewById(R.id.activity_login_senha);
        Button buttonEntrar = findViewById(R.id.activity_login_button_login);
        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usuarioController.autenticaUsuario(textUsuario.getText().toString(), textSenha.getText().toString())){
                    Toast.makeText(Activity_login.this, "Usuário ou senha incorretos. Tente novamente", Toast.LENGTH_LONG).show();
                    textUsuario.clearComposingText();
                    textSenha.clearComposingText();
                }
                else{
                    startActivity(new Intent(Activity_login.this, Activity_dashboard.class));
                }
            }
        });
    }
}