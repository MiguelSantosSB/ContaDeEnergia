package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Pessoa;
import br.com.contaDeEnergia.dao.PessoaDao;

import java.util.Scanner;

public class PessoaExecute {
    public static void main(String[] args) {

        Scanner escolha = new Scanner(System.in);

        System.out.println("Digite a opcao desejada: "+
                "\n 1 / Criar novo dado."+
                "\n 2 / Deletar algum dado."+
                "\n 3 / Atualizar dado escolhido."+
                "\n 4 / Ler dados."
        );
        int opcao = escolha.nextInt();
        switch (opcao){
            case 1:
                // Create
                PessoaDao pessoaDao = new PessoaDao();
                Pessoa pessoa = new Pessoa();

                pessoa.setNome("João Paulo Abreu de Sousa");
                pessoa.setCpf("184.586.100-00");
                pessoa.setCnpj("73.801.952/0001-88");
                pessoa.setTipo_pessoa_id(5);

                pessoaDao.Create(pessoa);
                break;
            case 2:
                // Delete
                PessoaDao pessoaDaoDelete = new PessoaDao();

                System.out.println("Informe o Id do dado a ser deletado: ");
                Scanner dado = new Scanner(System.in);
                int id = dado.nextInt();

                pessoaDaoDelete.Delete(id);
                break;
            case 3:
                // Update
                PessoaDao updateDao = new PessoaDao();
                Pessoa pessoa1 = new Pessoa();

                System.out.println("Informe o Id do dado a ser atualizado: ");
                Scanner data = new Scanner(System.in);
                int idUp = data.nextInt();

                pessoa1.setNome("");
                pessoa1.setCpf("");
                pessoa1.setCnpj("");
                pessoa1.setId(idUp);

                updateDao.Update(pessoa1);
                break;
            case 4:
                // Read
                PessoaDao readDao = new PessoaDao();

                for(Pessoa c : readDao.ReadPessoa()){

                        System.out.println("Pessoa id: "+c.getId() +", Cpf: "+c.getCpf()+", Cnpj: "+c.getCnpj());
                        System.out.println("Tipo: "+c.getTipo_pessoa_id());

                }
                break;
            default:
                System.out.println("Opcao escolhida invalida");
        }
    }
}
