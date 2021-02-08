package com.app.busca_cep;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.app.busca_cep.dao.UsuarioDAO;
import com.app.busca_cep.entity.UsuarioEntity;

@Database(entities = {UsuarioEntity.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UsuarioDAO usuarioDAO();
}
