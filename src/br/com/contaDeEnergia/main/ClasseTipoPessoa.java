package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.TipoPessoa;
import br.com.contaDeEnergia.dao.TipoPessoaDao;

public class ClasseTipoPessoa {
    public static void main(String[] args) {

        TipoPessoaDao tipoPessoaDao = new TipoPessoaDao();

        TipoPessoa tipoPessoa = new TipoPessoa();
        //funcionario ou cliente
        tipoPessoa.setDescricao("cliente");

        //tipoPessoaDao.Create(tipoPessoa);

        // Update
        TipoPessoa tipoPessoa1 = new TipoPessoa();
        tipoPessoa1.setDescricao("");
        tipoPessoa1.setId(1);

        tipoPessoaDao.Update(tipoPessoa1);

        // Read
        for(TipoPessoa c : tipoPessoaDao.ReadTipoPessoa()){

            System.out.println("Id tipo pessoa: "+c.getId() +", Descricao: "+c.getDescricao());
        }
    }
}
