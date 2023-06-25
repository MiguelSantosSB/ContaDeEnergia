package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Medidor;
import br.com.contaDeEnergia.dao.MedidorDao;

public class ClasseMedidor {
    private static int num =1;
    public static void main(String[] args) {

        MedidorDao medidorDao = new MedidorDao();

        Medidor medidor = new Medidor();
        medidor.setDescricao("medidor funcionando");
        medidor.setRota_id(num);
        medidor.setPoste_id(num);

        //medidorDao.Create(medidor);

        // Update
        Medidor medidor1 = new Medidor();
        medidor1.setDescricao("");
        medidor1.setId(1);

        medidorDao.Update(medidor1);

        // Read
        for(Medidor c : medidorDao.ReadMedidor()){

            System.out.println("Id Medidor: "+c.getId() +" descricao: "+c.getDescricao());
            System.out.println("Id rota: "+c.getRota_id()+" Id poste: "+c.getPoste_id());
        }
    }
}
