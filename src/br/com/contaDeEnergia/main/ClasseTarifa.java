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
        tarifa.setClasse_id(1);

        tarifaDao.Create(tarifa);

        // Update
        Tarifa tarifa1 = new Tarifa();
        tarifa1.setTaxa("");
        tarifa1.setLei("");
        tarifa1.setData_inicio("");
        tarifa1.setData_fim("");
        tarifa1.setAliquota_ICMS("");
        tarifa1.setId(1);

        //tarifaDao.Update(tarifa1);

        // Read
        for(Tarifa c : tarifaDao.ReadTarifa()){

            System.out.println("Id tarifa: "+c.getId() +", Taxa: "+c.getTaxa()+", Lei: "+c.getLei());
            System.out.println("Data inicio: "+c.getData_inicio()+", Data fim: "+c.getData_fim());
            System.out.println("Aliquosa: "+c.getAliquota_ICMS()+", Id classe: "+c.getClasse_id());
        }
    }
}
