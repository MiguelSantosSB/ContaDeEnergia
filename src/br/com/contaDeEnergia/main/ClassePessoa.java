package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Pessoa;
import br.com.contaDeEnergia.dao.PessoaDao;

public class ClassePessoa {
    public static void main(String[] args) {

        PessoaDao pessoaDao = new PessoaDao();

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Pedro");
        pessoa.setCpf("57679294080");
        pessoa.setCnpj("29296788000106");
        pessoa.setTipo_pessoa_id(1);

        pessoaDao.Create(pessoa);

        // Update
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("");
        pessoa1.setCpf("");
        pessoa1.setCnpj("");
        pessoa1.setId(1);

        //pessoaDao.Update(pessoa1);

        // Read
        for(Pessoa c : pessoaDao.ReadPessoa()){

            System.out.println("Pessoa id: "+c.getId() +", Cpf: "+c.getCpf()+", Cnpj: "+c.getCnpj());
            System.out.println("Tipo: "+c.getTipo_pessoa_id());

        }
    }
}
