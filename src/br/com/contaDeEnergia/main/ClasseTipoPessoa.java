package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.TipoPessoa;
import br.com.contaDeEnergia.dao.TipoPessoaDao;

import java.util.Scanner;

public class ClasseTipoPessoa {
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
                TipoPessoaDao tipoPessoaDao = new TipoPessoaDao();
                TipoPessoa tipoPessoa = new TipoPessoa();

                //funcionario ou cliente
                tipoPessoa.setDescricao("cliente");

                tipoPessoaDao.Create(tipoPessoa);
                break;
            case 2:
                // Delete
                TipoPessoaDao tpDelete = new TipoPessoaDao();

                System.out.println("Informe o Id do dado a ser deletado: ");
                Scanner dado = new Scanner(System.in);
                int id = dado.nextInt();

                tpDelete.Delete(id);
                break;
            case 3:
                // Update
                TipoPessoaDao updateDao = new TipoPessoaDao();
                TipoPessoa tipoPessoa1 = new TipoPessoa();

                System.out.println("Informe o Id do dado a ser atualizado: ");
                Scanner data = new Scanner(System.in);
                int idUp = data.nextInt();

                tipoPessoa1.setDescricao("");
                tipoPessoa1.setId(idUp);

                updateDao.Update(tipoPessoa1);
                break;
            case 4:
                // Read
                TipoPessoaDao  readDao = new TipoPessoaDao();

                for(TipoPessoa c : readDao.ReadTipoPessoa()){

                    System.out.println("Id: "+c.getId() +"| Descricao: "+c.getDescricao());

                }
                break;
            default:
                System.out.println("Opcao escolhida invalida");
        }
    }
}
