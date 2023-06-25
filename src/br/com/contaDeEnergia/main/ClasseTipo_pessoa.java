package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.TipoPessoa;
import br.com.contaDeEnergia.dao.TipoPessoaDao;

public class ClasseTipo_pessoa {
    public static void main(String[] args) {

        TipoPessoaDao tipo_pessoaDao = new TipoPessoaDao();

        TipoPessoa tipo_pessoa = new TipoPessoa();
        //funcionario ou cliente
        tipo_pessoa.setDescricao("cliente");

        //tipo_pessoaDao.Create(tipo_pessoa);
        // Read
        for(TipoPessoa c : tipo_pessoaDao.ReadTipoPessoa()){

            System.out.println("Id tipo pessoa: "+c.getId() +", Descricao: "+c.getDescricao());
        }
    }
}
