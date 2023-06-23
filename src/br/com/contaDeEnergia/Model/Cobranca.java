package br.com.contaDeEnergia.Model;

public class Cobranca {
    private int id;
    private String mes_referencia;
    private String ano_referencia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMes_referencia() {
        return mes_referencia;
    }

    public void setMes_referencia(String mes_referencia) {
        this.mes_referencia = mes_referencia;
    }

    public String getAno_referencia() {
        return ano_referencia;
    }

    public void setAno_referencia(String ano_referencia) {
        this.ano_referencia = ano_referencia;
    }
}
