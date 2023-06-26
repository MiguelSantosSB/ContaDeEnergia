package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Rota;
import br.com.contaDeEnergia.dao.RotaDao;

import java.util.Scanner;

public class ClasseRota {
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
                RotaDao rotaDao = new RotaDao();
                Rota rota = new Rota();

                rota.setDescricao("rua tal, numero tal, bairro tal");

                rotaDao.Create(rota);
                break;
            case 2:
                // Delete
                RotaDao rotaDaoDelete = new RotaDao();

                System.out.println("Informe o Id do dado a ser deletado: ");
                Scanner dado = new Scanner(System.in);
                int id = dado.nextInt();

                rotaDaoDelete.Delete(id);
                break;
            case 3:
                // Update
                RotaDao updateDao = new RotaDao();
                Rota rota1 = new Rota();

                System.out.println("Informe o Id do dado a ser atualizado: ");
                Scanner data = new Scanner(System.in);
                int idUp = data.nextInt();

                rota1.setDescricao("");
                rota1.setId(1);

                updateDao.Update(rota1);
                break;
            case 4:
                // Read
                RotaDao readDao = new RotaDao();

                for(Rota c : readDao.ReadRota()){

                    System.out.println("Id: "+c.getId() +"| Descricao da rota: "+c.getDescricao());

                }
                break;
            default:
                System.out.println("Opcao escolhida invalida");
        }

    }
}
