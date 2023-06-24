package br.com.contaDeEnergia.Model;

public class Pessoa {

    private int id;
    private String nome;
    private String cpf;
    private String cnpj;
    private int tipo_pessoa_id;

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getTipo_pessoa_id() {
        return tipo_pessoa_id;
    }

    public void setTipo_pessoa_id(int tipo_pessoa_id) {
        this.tipo_pessoa_id = tipo_pessoa_id;
    }
}

