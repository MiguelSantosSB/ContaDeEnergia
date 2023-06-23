package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Tarifa;
import br.com.contaDeEnergia.dao.TarifaDao;

public class ClasseTarifa {
    public static void main(String[] args) {

        TarifaDao tarifaDao = new TarifaDao();

        Tarifa tarifa = new Tarifa();
        tarifa.setTaxa("");
        tarifa.setLei("");
        tarifa.setData_inicio("");
        tarifa.setData_fim("");
        tarifa.setAliquota_ICMS("");

        tarifaDao.save(tarifa);
    }
}
