package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Tarefa_Rota;
import br.com.contaDeEnergia.dao.Tarefa_RotaDao;

import java.util.Date;

public class ClasseTarefa_rota {
    public static void main(String[] args) {

        Tarefa_RotaDao tarefaRotaDao = new Tarefa_RotaDao();

        Tarefa_Rota tarefaRota = new Tarefa_Rota();
        tarefaRota.setObservacao("esqueci");
        tarefaRota.setData_inicio(new Date());
        tarefaRota.setData_fim(new Date(2023-6-27));

        tarefaRotaDao.save(tarefaRota);
    }
}
