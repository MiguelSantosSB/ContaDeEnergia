package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Cliente;
import br.com.contaDeEnergia.dao.ClienteDao;

public class ClasseCliente {
    public static void main(String[] args) {

        ClienteDao clienteDao = new ClienteDao();

        Cliente cliente = new Cliente();
        cliente.setNum_documento("229839678");
        cliente.setNum_cliente("1");
        cliente.setPessoa_id(1);

        clienteDao.Create(cliente);

        // Update
        Cliente cliente1 = new Cliente();
        cliente1.setNum_documento("229846987");
        cliente1.setNum_cliente("2");
        cliente1.setId(1);

        //clienteDao.Update(cliente1);

        // Delete
        clienteDao.Delete(1);

        // Read
        for(Cliente c : clienteDao.ReadCliente()){
            System.out.println("Cliente:"+c.getId());
            System.out.println("Cliente: "+c.getNum_cliente());
            System.out.println("Cliente: "+c.getNum_documento());
        }
    }
}
