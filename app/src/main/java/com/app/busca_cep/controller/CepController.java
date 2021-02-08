package com.app.busca_cep.controller;

import com.app.busca_cep.entity.CepEntity;

import java.util.ArrayList;


public class CepController {

    private CepEntity model;
    private ArrayList<String> listaNegra = new ArrayList<String>();

    public CepController(){
        model = new CepEntity();
        listaNegra.add("18010001");
        listaNegra.add("18010082");
        listaNegra.add("18013001");
        listaNegra.add("18055131");
    }

    /*
    RETORNO:
    False = Sem restrições
    True = CEPs inválidos
     */
    public boolean validaListaNegra(String cep){
        if(listaNegra.contains(cep))
            return true;
        return false;
    }

    /*
    RETORNO:
    False = Sem restrições
    True = CEP menor que o necessário
     */
    public boolean validaTamanhoCep(int tamanho){
        if(tamanho < 8)
            return true;
        return false;
    }

    public boolean validaRestricoesCep(String uf, String bairro){
        if(uf.equals("MG") || bairro.charAt(0) == 's' || bairro.charAt(0) == 'S')
            return true;
        return false;
    }
}
