package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Medidor;
import br.com.contaDeEnergia.dao.MedidorDao;

public class ClasseMedidor {
    public static void main(String[] args) {

        MedidorDao medidorDao = new MedidorDao();

        Medidor medidor = new Medidor();
        medidor.setDescricao("medidor funcionando");

        medidorDao.save(medidor);
    }
}
