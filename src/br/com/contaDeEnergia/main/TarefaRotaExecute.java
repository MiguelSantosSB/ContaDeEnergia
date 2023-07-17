package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.TarefaRota;
import br.com.contaDeEnergia.dao.TarefaRotaDao;

import java.util.Scanner;

public class TarefaRotaExecute {
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
                TarefaRotaDao tarefaRotaDao = new TarefaRotaDao();
                TarefaRota tarefaRota = new TarefaRota();

                tarefaRota.setObservacao("...");
                tarefaRota.setData_inicio("28/06/2023");
                tarefaRota.setData_fim("24/07/2023");
                tarefaRota.setRota_id(3);
//  TODO sei la

                tarefaRotaDao.Create(tarefaRota);
                break;
            case 2:
                // Delete
                TarefaRotaDao tarefaRotaDaoDelete = new TarefaRotaDao();

                System.out.println("Informe o Id do dado a ser deletado: ");
                Scanner dado = new Scanner(System.in);
                int id = dado.nextInt();

                tarefaRotaDaoDelete.Delete(id);
                break;
            case 3:
                // Update
                TarefaRotaDao updateTarefaRota = new TarefaRotaDao();
                TarefaRota tarefaRota1 = new TarefaRota();

                System.out.println("Informe o Id do dado a ser atualizado: ");
                Scanner data = new Scanner(System.in);
                int idUp = data.nextInt();

                tarefaRota1.setObservacao("...");
                tarefaRota1.setData_inicio("28/06/2023");
                tarefaRota1.setData_fim("29/07/2023");
                tarefaRota1.setId(idUp);

                updateTarefaRota.Update(tarefaRota1);
                break;
            case 4:
                // Read
                TarefaRotaDao readDao = new TarefaRotaDao();

                for(TarefaRota c : readDao.ReadTarefa()){

                    System.out.println("Id tarefa rota: "+c.getId() +", Observacao: "+c.getObservacao());
                    System.out.println("Data inicio: "+c.getData_inicio()+", data fim: "+c.getData_fim());
                    System.out.println("rota id: "+c.getRota_id());
                }
                break;
            default:
                System.out.println("Opcao escolhida invalida");
        }
    }
}
