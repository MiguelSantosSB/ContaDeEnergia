package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Funcionario;
import br.com.contaDeEnergia.dao.FuncionarioDao;

public class ClasseFuncionario {
    public static void main(String[] args) {

        FuncionarioDao funcionarioDao = new FuncionarioDao();

        Funcionario funcionario = new Funcionario();
        funcionario.setCodigo_funcional("40028922");

        funcionarioDao.create(funcionario);
    }
}
