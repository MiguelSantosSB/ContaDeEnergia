package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Tipo_Fase;
import br.com.contaDeEnergia.dao.ClasseDao;
import br.com.contaDeEnergia.dao.Tipo_FaseDao;

public class ClasseTipo_fase {
    public static void main(String[] args) {

        Tipo_FaseDao tipoFaseDao = new Tipo_FaseDao();

        Tipo_Fase tipo_fase = new Tipo_Fase();
        tipo_fase.setDescricao("");

        tipoFaseDao.create(tipo_fase);
    }
}
