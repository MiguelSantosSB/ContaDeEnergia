package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Poste;
import br.com.contaDeEnergia.dao.PosteDao;

public class ClassePoste {
    public static void main(String[] args) {

        PosteDao posteDao = new PosteDao();

        Poste poste = new Poste();
        poste.setLatitude("41.3144");
        poste.setLongitude("43.0029");
        poste.setCodigo("5562322");
        poste.setObservacao("poste ok viu, nao caiu");

        posteDao.create(poste);
    }
}
