package com.app.busca_cep.controller;

import com.app.busca_cep.AppDatabase;
import com.app.busca_cep.dao.UsuarioDAO;
import com.app.busca_cep.entity.UsuarioEntity;

public class UsuarioController {

    private AppDatabase db;
    private UsuarioDAO usuarioDAO;

    public UsuarioController(AppDatabase db){
        this.db = db;
        usuarioDAO = this.db.usuarioDAO();

        // Inserts de usuários pré definidos
        //db.usuarioDAO().insert(new UsuarioEntity(1, "Tantto", "123456"));
        //db.usuarioDAO().insert(new UsuarioEntity(2, "Emanuel", "1234567"));
        //db.usuarioDAO().insert(new UsuarioEntity(3, "Lucas", "123"));
    }

    public boolean autenticaUsuario(String usuario_nome, String senha){
        UsuarioEntity usuario = usuarioDAO.findUsuario(usuario_nome, senha);

        /*
        RETORNO:
        True: usuário com as informações inseridas não existe
        False: usuário existente
         */
        if(usuario == null)
            return true;
        usuario.estaAtivo = true;
        usuarioDAO.update(usuario);
        return false;
    }

    public UsuarioEntity findUsuarioActive(){
        return usuarioDAO.findUsuarioActive();
    }

    public void logout(UsuarioEntity usuario){
        usuario.estaAtivo = false;
        usuarioDAO.update(usuario);
    }
}
