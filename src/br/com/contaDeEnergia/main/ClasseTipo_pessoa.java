package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Tipo_Pessoa;
import br.com.contaDeEnergia.dao.Tipo_PessoaDao;

public class ClasseTipo_pessoa {
    public static void main(String[] args) {

        Tipo_PessoaDao  tipo_pessoaDao = new Tipo_PessoaDao();

        Tipo_Pessoa tipo_pessoa = new Tipo_Pessoa();
        tipo_pessoa.setId(55);
        //funcionario ou cliente
        tipo_pessoa.setDescricao("cliente");

        tipo_pessoaDao.save(tipo_pessoa);
    }
}
