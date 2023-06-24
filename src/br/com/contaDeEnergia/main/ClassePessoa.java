package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Pessoa;
import br.com.contaDeEnergia.dao.PessoaDao;

public class ClassePessoa {
    public static void main(String[] args) {

        PessoaDao pessoaDao = new PessoaDao();

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Miguel");
        pessoa.setCpf("57679294089");
        pessoa.setCnpj("29296788000107");
        //pessoa.setTipo_pessoa_id(1);

        pessoaDao.create(pessoa);
    }
}
