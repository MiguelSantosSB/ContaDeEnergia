package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Classe;
import br.com.contaDeEnergia.dao.ClasseDao;

public class ClasseClasse {
    public static void main(String[] args) {

        ClasseDao classeDao = new ClasseDao();

        Classe classe = new Classe();
        classe.setId(55);
        classe.setDescricao("");

        classeDao.save(classe);
    }
}
