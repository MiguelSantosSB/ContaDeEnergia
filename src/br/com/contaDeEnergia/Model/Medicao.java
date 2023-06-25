package br.com.contaDeEnergia.Model;

import java.util.Date;

public class Medicao {
    private int id;
    private String mes;
    private String ano;
    private Date data_medicao;
    private String consumo;
    private int medidor_id;
    private int time_rota_id;

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

    public int getMedidor_id() {
        return medidor_id;
    }

    public void setMedidor_id(int medidor_id) {
        this.medidor_id = medidor_id;
    }

    public int getTime_rota_id() {
        return time_rota_id;
    }

    public void setTime_rota_id(int time_rota_id) {
        this.time_rota_id = time_rota_id;
    }
}
