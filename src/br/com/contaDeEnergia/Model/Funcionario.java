package br.com.contaDeEnergia.Model;

public class Funcionario {

    private int id;
    private String codigo_funcional;
    private int pessoa_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo_funcional() {
        return codigo_funcional;
    }

    public void setCodigo_funcional(String codigo_funcional) {
        this.codigo_funcional = codigo_funcional;
    }

    public int getPessoa_id() {
        return pessoa_id;
    }

    public void setPessoa_id(int pessoa_id) {
        this.pessoa_id = pessoa_id;
    }
}
