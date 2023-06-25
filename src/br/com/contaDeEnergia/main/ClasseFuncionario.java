package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Funcionario;
import br.com.contaDeEnergia.dao.FuncionarioDao;

public class ClasseFuncionario {
    public static void main(String[] args) {

        FuncionarioDao funcionarioDao = new FuncionarioDao();

        Funcionario funcionario = new Funcionario();
        funcionario.setCodigo_funcional("40028922");
        funcionario.setPessoa_id(1);

        //funcionarioDao.Create(funcionario);

        // Update
        Funcionario funcionario1 = new Funcionario();
        funcionario1.setCodigo_funcional("");
        funcionario1.setId(1);

        funcionarioDao.Update(funcionario1);

        // Read
        for(Funcionario c : funcionarioDao.ReadFuncionario()){

            System.out.println("Id do funcionario: "+c.getId() +" Codigo funcional: "+c.getCodigo_funcional());
            System.out.println("Id pessoa: "+c.getPessoa_id());
        }
    }
}
