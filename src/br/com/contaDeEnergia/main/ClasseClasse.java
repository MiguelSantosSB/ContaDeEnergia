package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Classe;
import br.com.contaDeEnergia.dao.ClasseDao;

public class ClasseClasse {
    public static void main(String[] args) {

        // Create
        ClasseDao classeDao = new ClasseDao();

        Classe classe = new Classe();
        classe.setDescricao("a");
        classe.setTipo_fase_id(1);

        //classeDao.Create(classe);

        // Update
        Classe classe1 = new Classe();
        classe1.setDescricao("b");
        classe1.setId(2);

        //classeDao.Update(classe1);

        // Read
        for(Classe c : classeDao.ReadClasse()){

            System.out.println("Classe "+c.getId() +": "+c.getDescricao());
        }


    }
}
