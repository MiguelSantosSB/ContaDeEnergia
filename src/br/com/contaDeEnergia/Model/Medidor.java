package br.com.contaDeEnergia.Model;

public class Medidor {
    private int id;
    private String descricao;
    private int rota_id;
    private int poste_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getRota_id() {
        return rota_id;
    }

    public void setRota_id(int rota_id) {
        this.rota_id = rota_id;
    }

    public int getPoste_id() {
        return poste_id;
    }

    public void setPoste_id(int poste_id) {
        this.poste_id = poste_id;
    }
}
