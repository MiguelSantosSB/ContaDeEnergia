package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Contrato;
import br.com.contaDeEnergia.dao.ContratoDao;

import java.util.Date;

public class ClasseContrato {
    public static void main(String[] args) {

        ContratoDao contratoDao = new ContratoDao();

        Contrato contrato = new Contrato();
        contrato.setId(55);
        contrato.setDescricao("ta pagoooo");
        contrato.setData_criacao(new Date());
        contrato.setData_inicio(new Date());

        contratoDao.save(contrato);
    }
}
