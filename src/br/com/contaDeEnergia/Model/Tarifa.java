package br.com.contaDeEnergia.Model;

public class Tarifa {

    private int id;
    private String taxa;
    private String lei;
    private String data_inicio;
    private String data_fim;
    private String aliquota_ICMS;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaxa() {
        return taxa;
    }

    public void setTaxa(String taxa) {
        this.taxa = taxa;
    }

    public String getLei() {
        return lei;
    }

    public void setLei(String lei) {
        this.lei = lei;
    }

    public String getData_inicio() {
        return data_inicio;
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

    public String getAliquota_ICMS() {
        return aliquota_ICMS;
    }

    public void setAliquota_ICMS(String aliquota_ICMS) {
        this.aliquota_ICMS = aliquota_ICMS;
    }
}
