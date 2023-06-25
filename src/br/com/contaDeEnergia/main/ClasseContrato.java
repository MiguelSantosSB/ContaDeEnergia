package br.com.contaDeEnergia.main;


import br.com.contaDeEnergia.Model.Contrato;
import br.com.contaDeEnergia.dao.ContratoDao;

import java.util.Date;

public class ClasseContrato {
    private static int num = 1;
    public static void main(String[] args) {

        ContratoDao contratoDao = new ContratoDao();

        Contrato contrato = new Contrato();
        contrato.setDescricao("ta pagoooo");
        contrato.setData_criacao(new Date());
        contrato.setData_inicio(new Date());
        contrato.setMedidor_id(num);
        contrato.setClasse_id(num);
        contrato.setCliente_id(num);

        //contratoDao.Create(contrato);

        //Read
        for(Contrato c : contratoDao.ReadContrato()){

        System.out.println("Contrato: "+c.getId() +" Criacao: "+c.getData_criacao()+ " Inicio: "+c.getData_inicio());
        System.out.println("Id medidor: "+c.getMedidor_id()+" Id classe: "+c.getClasse_id()+" Id Cliente: "+c.getCliente_id());
        }
    }
}
