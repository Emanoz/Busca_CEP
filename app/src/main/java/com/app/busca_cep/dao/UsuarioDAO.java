package com.app.busca_cep.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.app.busca_cep.entity.UsuarioEntity;

@Dao
public interface UsuarioDAO {

    @Query("SELECT * FROM usuario WHERE usuario = :usuario AND senha = :senha")
    UsuarioEntity findUsuario(String usuario, String senha);

    @Query("SELECT * FROM usuario WHERE estaAtivo = 1")
    UsuarioEntity findUsuarioActive();

    @Insert
    void insert(UsuarioEntity usuario);

    @Update
    void update(UsuarioEntity usuario);
}
