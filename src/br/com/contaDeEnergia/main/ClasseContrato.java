package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Contrato;
import br.com.contaDeEnergia.dao.ContratoDao;

import java.util.Date;

public class ClasseContrato {
    private static int num = 2;
    public static void main(String[] args) {

        ContratoDao contratoDao = new ContratoDao();

        Contrato contrato = new Contrato();
        contrato.setDescricao("ta pagoooo");
        contrato.setData_criacao(new Date());
        contrato.setData_inicio(new Date());
        contrato.setMedidor_id(num);
        contrato.setClasse_id(num);
        contrato.setCliente_id(num);

        contratoDao.Create(contrato);

        // Update
        Contrato contrato1 = new Contrato();
        contrato1.setDescricao("");
        //contrato1.setData_inicio();
        //contrato1.setData_criacao('2023-06-25');
        contrato1.setId(1);

        //contratoDao.Update(contrato1);


        //Read
        for(Contrato c : contratoDao.ReadContrato()){

        System.out.println("Contrato: "+c.getId() +" Criacao: "+c.getData_criacao()+ " Inicio: "+c.getData_inicio());
        System.out.println("Id medidor: "+c.getMedidor_id()+" Id classe: "+c.getClasse_id()+" Id Cliente: "+c.getCliente_id());
        }
    }
}
