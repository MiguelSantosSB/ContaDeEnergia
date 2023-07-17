package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.TimeRota;
import br.com.contaDeEnergia.dao.TimeRotaDao;

import java.util.Scanner;

public class TimeRotaExecute {

    //public static int num = 3;
    public static void main(String[] args) {

        Scanner escolha = new Scanner(System.in);

        System.out.println("Digite a opcao desejada: "+
                "\n 1 / Criar novo dado."+
                "\n 2 / Deletar algum dado."+
                "\n 3 / Ler dados."
        );
        int opcao = escolha.nextInt();
        switch (opcao){
            case 1:
                // Create
                TimeRotaDao timeRotaDao = new TimeRotaDao();
                TimeRota timeRota = new TimeRota();

                timeRota.setFuncionario_id(1);
                timeRota.setTarefa_rota_id(3);

                timeRotaDao.Create(timeRota);
                break;
            case 2:
                // Delete
                TimeRotaDao tRotaDao = new TimeRotaDao();

                System.out.println("Informe o Id do dado a ser deletado: ");
                Scanner dado = new Scanner(System.in);
                int id = dado.nextInt();

                tRotaDao.Delete(id);
                break;
            case 3:
                // Read
                TimeRotaDao readDao = new TimeRotaDao();

                for(TimeRota c : readDao.ReadTimeRota()){

                    System.out.println("Id Time rota: "+c.getId() +", Id funcionario: "+c.getFuncionario_id()+"Id Tarefa rota"+c.getTarefa_rota_id());

                }
                break;
            default:
                System.out.println("Opcao escolhida invalida");
        }
    }
}
