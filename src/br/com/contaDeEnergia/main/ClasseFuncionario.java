package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Funcionario;
import br.com.contaDeEnergia.dao.FuncionarioDao;

import java.util.Date;
import java.util.Scanner;

public class ClasseFuncionario {
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
                FuncionarioDao funcionarioDao = new FuncionarioDao();
                Funcionario funcionario = new Funcionario();

                funcionario.setCodigo_funcional("04923340304");
                funcionario.setPessoa_id(4);;

                funcionarioDao.Create(funcionario);
                break;
            case 2:
                // Delete
                FuncionarioDao funcionarioDaoDelete = new FuncionarioDao();

                System.out.println("Informe o Id do dado a ser deletado: ");
                Scanner dado = new Scanner(System.in);
                int id = dado.nextInt();

                funcionarioDaoDelete.Delete(id);
                break;
            case 3:
                // Update
                FuncionarioDao upgradeDao = new FuncionarioDao();
                Funcionario funcionario1 = new Funcionario();

                System.out.println("Informe o Id do dado a ser atualizado: ");
                Scanner data = new Scanner(System.in);
                int idUp = data.nextInt();

                funcionario1.setCodigo_funcional("4002345634");
                funcionario1.setId(idUp);

                upgradeDao.Update(funcionario1);
                break;
            case 4:
                // Read
                FuncionarioDao readDao = new FuncionarioDao();

                for(Funcionario c : readDao.ReadFuncionario()){

                    System.out.println("Id do funcionario: "+c.getId() +" Codigo funcional: "+c.getCodigo_funcional());
                    System.out.println("Id pessoa: "+c.getPessoa_id());

                }
                break;
            default:
                System.out.println("Opcao escolhida invalida");
        }
    }
}
