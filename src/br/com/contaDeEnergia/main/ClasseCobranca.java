package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Cobranca;
import br.com.contaDeEnergia.dao.CobrancaDao;

public class ClasseCobranca {
    public static void main(String[] args) {

        CobrancaDao cobrancaDao = new CobrancaDao();

        Cobranca cobranca = new Cobranca();
        cobranca.setMes_referencia("");
        cobranca.setAno_referencia("");
        cobranca.setTarifa_id(1);

        //cobrancaDao.Create(cobranca);

        // Update
        Cobranca cobranca1 = new Cobranca();
        cobranca1.setMes_referencia("julho");
        cobranca1.setAno_referencia("2023");
        cobranca1.setId(1);

        cobrancaDao.Update(cobranca1);


        // Read
        for(Cobranca c : cobrancaDao.ReadCobranca()){
            System.out.println("Cobanca:"+c.getId());
            System.out.println("Cobranca: "+ c.getMes_referencia());
            System.out.println("Cobranca: "+c.getAno_referencia());
        }

    }
}
