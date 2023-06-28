package br.com.contaDeEnergia.Model;

import java.sql.Date;

public class TarefaRota {

    private int id;
    private String observacao;
    private String data_inicio;
    private String data_fim;
    private int rota_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_fim() {
        return data_fim;
    }

    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public int getRota_id() {
        return rota_id;
    }

    public void setRota_id(int rota_id) {
        this.rota_id = rota_id;
    }
}
