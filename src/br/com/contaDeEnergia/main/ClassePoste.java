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

        //posteDao.Create(poste);

        // Update
        Poste poste1 = new Poste();
        poste1.setLatitude("");
        poste1.setLongitude("");
        poste1.setCodigo("");
        poste1.setObservacao("");
        poste1.setId(1);

        posteDao.Update(poste1);

        // Read
        for(Poste c : posteDao.ReadPoste()){

            System.out.println("Id poste: "+c.getId() +", latitude: "+c.getLatitude()+", longitude: "+c.getLongitude());
            System.out.println("Codigo: "+c.getCodigo()+", Observacao: "+c.getObservacao());
        }
    }
}
