package br.com.contaDeEnergia.Model;

public class Classe {
    private int id;
    private String descricao;
    private int tipo_fase_id;

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

    public int getTipo_fase_id() {
        return tipo_fase_id;
    }

    public void setTipo_fase_id(int tipo_fase_id) {
        this.tipo_fase_id = tipo_fase_id;
    }
}
