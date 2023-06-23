package br.com.contaDeEnergia.Model;

import java.util.Date;

public class Medicao {
    private int id;
    private String mes;
    private String ano;
    private Date data_medicao;
    private String consumo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Date getData_medicao() {
        return data_medicao;
    }

    public void setData_medicao(Date data_medicao) {
        this.data_medicao = data_medicao;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }
}
