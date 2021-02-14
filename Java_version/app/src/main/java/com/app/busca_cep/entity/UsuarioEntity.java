package com.app.busca_cep.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "usuario")
public class UsuarioEntity {
        public UsuarioEntity(int id_usuario, String usuario, String senha){
                this.id_usuario = id_usuario;
                this.usuario = usuario;
                this.senha = senha;
        }

        @PrimaryKey
        public int id_usuario;

        @NonNull
        public String usuario;

        @NonNull
        public String senha;

        // Campo usado para determinar se o usuário está autenticado no dispositivo; útil para lembrar qual foi o último usuário logado e logar automaticamente no app
        @NonNull
        public boolean estaAtivo  = false;
}
