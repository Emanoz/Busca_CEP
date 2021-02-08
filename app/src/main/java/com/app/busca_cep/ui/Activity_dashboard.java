package com.app.busca_cep.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.app.busca_cep.AppDatabase;
import com.app.busca_cep.controller.UsuarioController;
import com.app.busca_cep.entity.UsuarioEntity;

public class Activity_dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setTitle("Busca de CEP");

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "db_busca_cep").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        UsuarioController usuarioController = new UsuarioController(db);

        UsuarioEntity usuario = usuarioController.findUsuarioActive();
        TextView textMensagem = findViewById(R.id.activity_dashboard_mensagem);
        textMensagem.setText("Olá, " + usuario.usuario + "!\nBem-vindo ao app Busca CEP\n\n\nPara iniciar seu uso, clique no botão PESQUISAR CEP, informe o CEP desejado no campo e clique em BUSCAR\n\nCaso queira sair, clique em LOGOUT.");

        Button pesquisarButton = findViewById(R.id.activity_dashboard_fab_pesquisar);
        Button buttonLogout = findViewById(R.id.activity_dashboard_fab_logout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuarioController.logout(usuarioController.findUsuarioActive());
                startActivity(new Intent(Activity_dashboard.this, Activity_login.class));
            }
        });
        pesquisarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_dashboard.this, Activity_busca_cep.class));
            }
        });
    }
}