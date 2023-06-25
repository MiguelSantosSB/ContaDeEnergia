package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.TipoFase;
import br.com.contaDeEnergia.dao.TipoFaseDao;

public class ClasseTipoFase {
    public static void main(String[] args) {

        TipoFaseDao tipoFaseDao = new TipoFaseDao();

        TipoFase tipoFase = new TipoFase();
        tipoFase.setDescricao("nao sei");

        tipoFaseDao.Create(tipoFase);

        //Delete
        //tipoFaseDao.Delete(1);

        // Update
        TipoFase tipoFase1 = new TipoFase();
        tipoFase1.setDescricao("agora eu sei");
        tipoFase1.setId(1);

        //tipoFaseDao.Update(tipoFase1);

        // Read
        for (TipoFase c : tipoFaseDao.ReadTipoFase()) {

            System.out.println("Id tipo fase: " + c.getId() + ", Descricao: " + c.getDescricao());
        }
    }
}