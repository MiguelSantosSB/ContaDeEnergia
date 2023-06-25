package br.com.contaDeEnergia.Model;

import java.util.Date;

public class TarefaRota {

    private int id;
    private String observacao;
    private Date data_inicio;
    private Date data_fim;
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

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public int getRota_id() {
        return rota_id;
    }

    public void setRota_id(int rota_id) {
        this.rota_id = rota_id;
    }
}
