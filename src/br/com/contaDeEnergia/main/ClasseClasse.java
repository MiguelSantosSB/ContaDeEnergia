package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Classe;
import br.com.contaDeEnergia.dao.ClasseDao;

public class ClasseClasse {
    public static void main(String[] args) {

        // Create
        ClasseDao classeDao = new ClasseDao();

        Classe classe = new Classe();
        classe.setDescricao("a");

        classeDao.create(classe);

        // Read
        for(Classe c : classeDao.readClasse()){
            System.out.println("Classe: "+c.getDescricao());
        }


    }
}
