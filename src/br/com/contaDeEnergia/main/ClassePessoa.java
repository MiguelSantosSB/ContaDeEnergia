package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Pessoa;
import br.com.contaDeEnergia.dao.PessoaDao;
import br.com.contaDeEnergia.main.ClasseTipo_pessoa;

public class ClassePessoa {
    public static void main(String[] args) {

        PessoaDao pessoaDao = new PessoaDao();


        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Miguel");
        pessoa.setId(55);
        pessoa.setCpf("57679294089");
        pessoa.setCnpj("29296788000107");


        pessoaDao.save(pessoa);
    }
}
