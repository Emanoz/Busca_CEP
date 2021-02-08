package com.app.busca_cep.entity;

public class CepEntity {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public CepEntity(){

    }

    public String getCep() {
        if(cep == null ||cep.isEmpty())
            return "Nenhuma informação encontrada";
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        if(logradouro == null || logradouro.isEmpty())
            return "Nenhuma informação encontrada";
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        if(complemento == null || complemento.isEmpty())
            return "Nenhuma informação encontrada";
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        if(bairro == null || bairro.isEmpty())
            return "Nenhuma informação encontrada";
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        if(localidade == null || localidade.isEmpty())
            return "Nenhuma informação encontrada";
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        if(uf == null || uf.isEmpty())
            return "Nenhuma informação encontrada";
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getIbge() {
        if(ibge == null || ibge.isEmpty())
            return "Nenhuma informação encontrada";
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        if(gia == null || gia.isEmpty())
            return "Nenhuma informação encontrada";
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getDdd() {
        if(ddd == null || ddd.isEmpty())
            return "Nenhuma informação encontrada";
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getSiafi() {
        if(siafi == null || siafi.isEmpty())
            return "Nenhuma informação encontrada";
        return siafi;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }
}
