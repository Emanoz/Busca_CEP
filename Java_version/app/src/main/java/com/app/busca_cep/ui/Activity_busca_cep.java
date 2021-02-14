package com.app.busca_cep.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.busca_cep.controller.CepController;
import com.app.busca_cep.entity.CepEntity;
import com.app.busca_cep.retrofit.RetrofitInicializer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_busca_cep extends AppCompatActivity {

    private CepController cepController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_cep);
        setTitle("Buscar informações do CEP");
        cepController = new CepController();

        Button buttonBuscar = findViewById(R.id.activity_busca_cep_button_buscar);
        EditText textCep = findViewById(R.id.activity_busca_cep);
        TextView textUf = findViewById(R.id.activity_busca_cep_uf);
        TextView textBairro = findViewById(R.id.activity_busca_cep_bairro);

        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cepController.validaTamanhoCep(textCep.length())) {
                    Toast.makeText(Activity_busca_cep.this, "Favor preencher o CEP com 8 dígitos", Toast.LENGTH_LONG).show();
                    return;
                }
                if(cepController.validaListaNegra(textCep.getText().toString())) {
                    Toast.makeText(Activity_busca_cep.this, "Este CEP está na lista negra", Toast.LENGTH_LONG).show();
                    return;
                }

                Call call = new RetrofitInicializer().getCepService().getByCEP(textCep.getText().toString());
                call.enqueue(new Callback<CepEntity>() {
                    @Override
                    public void onResponse(Call<CepEntity> call, Response<CepEntity> response) {
                        Log.i("SUCESSO", "Requisição feita com sucesso");

                        if (cepController.validaRestricoesCep(response.body().getUf(), response.body().getBairro())){
                            Toast.makeText(Activity_busca_cep.this, "ERRO: Não é possível apresentar as informações deste CEP", Toast.LENGTH_LONG).show();
                            return;
                        }

                        TextView logradouro = findViewById(R.id.activity_busca_cep_logradouro);
                        logradouro.setText(response.body().getLogradouro());

                        TextView complemento = findViewById(R.id.activity_busca_cep_complemento);
                        complemento.setText(response.body().getComplemento());

                        TextView bairro = findViewById(R.id.activity_busca_cep_bairro);
                        bairro.setText(response.body().getBairro());

                        TextView localidade = findViewById(R.id.activity_busca_cep_localidade);
                        localidade.setText(response.body().getLocalidade());

                        TextView uf = findViewById(R.id.activity_busca_cep_uf);
                        uf.setText(response.body().getUf());

                        TextView ibge = findViewById(R.id.activity_busca_cep_ibge);
                        ibge.setText(response.body().getIbge());

                        TextView gia = findViewById(R.id.activity_busca_cep_gia);
                        gia.setText(response.body().getGia());

                        TextView ddd = findViewById(R.id.activity_busca_cep_ddd);
                        ddd.setText(response.body().getDdd());

                        TextView siafi = findViewById(R.id.activity_busca_cep_siafi);
                        siafi.setText(response.body().getSiafi());
                    }

                    @Override
                    public void onFailure(Call<CepEntity> call, Throwable t) {
                        Log.i("FALHA", "Requisição falhou");
                        Toast.makeText(Activity_busca_cep.this, "Web Service falhou. Por gentileza, tentar novamente", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}