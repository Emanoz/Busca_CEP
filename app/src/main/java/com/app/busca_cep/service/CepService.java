package com.app.busca_cep.service;

import com.app.busca_cep.entity.CepEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CepService {

    @GET("{cep}/json/")
    Call<CepEntity> getByCEP(@Path("cep") String cep);
}
