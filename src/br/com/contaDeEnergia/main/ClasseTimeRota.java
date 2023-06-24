package br.com.contaDeEnergia.main;


import br.com.contaDeEnergia.Model.TimeRota;
import br.com.contaDeEnergia.dao.TimeRotaDao;

public class ClasseTimeRota {

    public static int num = 1;
    public static void main(String[] args) {
        TimeRotaDao timeRotaDao = new TimeRotaDao();

        TimeRota timeRota = new TimeRota();
        timeRota.setFuncionario_id(num);
        timeRota.setTarefa_rota_id(num);
    }
}
