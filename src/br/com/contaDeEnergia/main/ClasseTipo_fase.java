package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.TipoFase;
import br.com.contaDeEnergia.dao.TipoFaseDao;

public class ClasseTipo_fase {
    public static void main(String[] args) {

        TipoFaseDao tipoFaseDao = new TipoFaseDao();

        TipoFase tipo_fase = new TipoFase();
        tipo_fase.setDescricao("nao sei");

        //tipoFaseDao.Create(tipo_fase);
        // Read
        for (TipoFase c : tipoFaseDao.ReadTipoFase()) {

            System.out.println("Id tipo fase: " + c.getId() + ", Descricao: " + c.getDescricao());
        }
    }
}