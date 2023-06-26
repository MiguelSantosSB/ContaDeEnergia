package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Cliente;
import br.com.contaDeEnergia.dao.ClienteDao;

import java.util.Scanner;

public class ClasseCliente {
    public static void main(String[] args) {

        Scanner escolha = new Scanner(System.in);

        System.out.println("Digite a opcao desejada: "+
                "\n 1 / Criar novo dado."+
                "\n 2 / Deletar algum dado."+
                "\n 3 / Atualizar dado escolhido."+
                "\n 4 / Ler dados."
        );
        int opcao = escolha.nextInt();
        switch (opcao){
            case 1:
                // Create
                ClienteDao clienteDao = new ClienteDao();
                Cliente cliente = new Cliente();

                cliente.setNum_documento("229839678");
                cliente.setNum_cliente("1");
                cliente.setPessoa_id(1);

                clienteDao.Create(cliente);
                break;
            case 2:
                // Delete
                ClienteDao clienteDaoDelete = new ClienteDao();

                System.out.println("Informe o Id do dado a ser deletado: ");
                Scanner dado = new Scanner(System.in);
                int id = dado.nextInt();

                clienteDaoDelete.Delete(id);
                break;
            case 3:
                // Update
                ClienteDao upgradeDao = new ClienteDao();
                Cliente cliente1 = new Cliente();

                System.out.println("Informe o Id do dado a ser atualizado: ");
                Scanner data = new Scanner(System.in);
                int idUp = data.nextInt();

                cliente1.setNum_documento("229846987");
                cliente1.setNum_cliente("2");
                cliente1.setId(idUp);

                upgradeDao.Update(cliente1);
                break;
            case 4:
                // Read
                ClienteDao readDao = new ClienteDao();

                for(Cliente c : readDao.ReadCliente()){
                    System.out.println("Cliente:"+c.getId());
                    System.out.println("Cliente: "+c.getNum_cliente());
                    System.out.println("Cliente: "+c.getNum_documento());
                }
                break;
            default:
                System.out.println("Opcao escolhida invalida");
        }
    }
}
