package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.TarefaRota;
import br.com.contaDeEnergia.dao.TarefaRotaDao;

import java.util.Date;

public class ClasseTarefa_rota {
    public static void main(String[] args) {

        TarefaRotaDao tarefaRotaDao = new TarefaRotaDao();

        TarefaRota tarefaRota = new TarefaRota();
        tarefaRota.setObservacao("esqueci");
        tarefaRota.setData_inicio(new Date());
        tarefaRota.setData_fim(new Date());
        tarefaRota.setRota_id(1);

        //tarefaRotaDao.Create(tarefaRota);

        // Update
        TarefaRota tarefaRota1 = new TarefaRota();
        tarefaRota1.setObservacao("");
        //tarefaRota1.setData_inicio();
       // tarefaRota1.setData_fim();
        tarefaRota1.setId(1);

        tarefaRotaDao.Update(tarefaRota1);

        // Read
        for(TarefaRota c : tarefaRotaDao.ReadTarefa()){

            System.out.println("Id tarefa rota: "+c.getId() +", Observacao: "+c.getObservacao());
            System.out.println("Data inicio: "+c.getData_inicio()+", data fim: "+c.getData_fim());
            System.out.println("rota id: "+c.getRota_id());
        }
    }
}
