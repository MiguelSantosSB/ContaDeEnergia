package br.com.contaDeEnergia.main;


import br.com.contaDeEnergia.Model.Cobranca;
import br.com.contaDeEnergia.dao.ClienteDao;
import br.com.contaDeEnergia.dao.CobrancaDao;

public class ClasseCobranca {
    public static void main(String[] args) {

        CobrancaDao cobrancaDao = new CobrancaDao();

        Cobranca cobranca = new Cobranca();
        cobranca.setMes_referencia("");
        cobranca.setAno_referencia("");

        //cobrancaDao.Create(cobranca);

        // Read
        for(Cobranca c : cobrancaDao.ReadCobranca()){
            System.out.println("Cobanca:"+c.getId());
            System.out.println("Cobranca: "+ c.getMes_referencia());
            System.out.println("Cobranca: "+c.getAno_referencia());
        }

    }
}
