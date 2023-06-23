package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Cliente;
import br.com.contaDeEnergia.dao.ClienteDao;

public class ClasseCliente {
    public static void main(String[] args) {

        ClienteDao clienteDao = new ClienteDao();

        Cliente cliente = new Cliente();
        cliente.setId(55);
        cliente.setNum_documento("229839678");
        cliente.setNum_cliente("1");

        clienteDao.save(cliente);
    }
}
