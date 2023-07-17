package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Medidor;
import br.com.contaDeEnergia.dao.MedidorDao;

import java.util.Scanner;

public class MedidorExecute {
    private static int num = 3;
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
                MedidorDao medidorDao = new MedidorDao();
                Medidor medidor = new Medidor();

                medidor.setDescricao("medidor valido");
                medidor.setRota_id(num);
                medidor.setPoste_id(num);

                medidorDao.Create(medidor);
            break;
            case 2:
                // Delete
                MedidorDao medidorDelete = new MedidorDao();

                System.out.println("Informe o Id do dado a ser deletado: ");
                Scanner dado = new Scanner(System.in);
                int id = dado.nextInt();

                medidorDelete.Delete(id);
                break;
            case 3:
                // Update
                MedidorDao updateDao = new MedidorDao();
                Medidor medidor1 = new Medidor();

                System.out.println("Informe o Id do dado a ser atualizado: ");
                Scanner data = new Scanner(System.in);
                int idUp = data.nextInt();

                medidor1.setDescricao("");
                medidor1.setId(idUp);

                updateDao.Update(medidor1);
                break;
            case 4:
            // Read
            MedidorDao readDao = new MedidorDao();

            for(Medidor c : readDao.ReadMedidor()){

                System.out.println("Id Medidor: "+c.getId() +" descricao: "+c.getDescricao());
                System.out.println("Id rota: "+c.getRota_id()+" Id poste: "+c.getPoste_id());
            }
            default:
                System.out.println("Opcao escolhida invalida");
        }
    }
}
