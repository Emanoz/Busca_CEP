package com.app.busca_cep.retrofit;

import com.app.busca_cep.service.CepService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInicializer {

    private final Retrofit retrofit;

    public RetrofitInicializer(){
        retrofit = new Retrofit.Builder().baseUrl("https://viacep.com.br/ws/").addConverterFactory(GsonConverterFactory.create()).build();
    }

    public CepService getCepService(){
        return retrofit.create(CepService.class);
    }
}
