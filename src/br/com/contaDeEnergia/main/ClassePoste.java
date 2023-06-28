package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Poste;
import br.com.contaDeEnergia.dao.PosteDao;

import java.util.Scanner;

public class ClassePoste {
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
                PosteDao posteDao = new PosteDao();
                Poste poste = new Poste();

                poste.setLatitude("50.5024");
                poste.setLongitude("7.6327");
                poste.setCodigo("89702326990");
                poste.setObservacao("");

                posteDao.Create(poste);
                break;
            case 2:
                // Delete
                PosteDao posteDaoDelete = new PosteDao();

                System.out.println("Informe o Id do dado a ser deletado: ");
                Scanner dado = new Scanner(System.in);
                int id = dado.nextInt();

                posteDaoDelete.Delete(id);
                break;
            case 3:
                // Update
                PosteDao posteDaoUpdate = new PosteDao();
                Poste poste1 = new Poste();

                poste1.setLatitude("87.8593");
                poste1.setLongitude("-140.8365");
                poste1.setCodigo("61202290787");
                poste1.setObservacao("");
                poste1.setId(1);

                posteDaoUpdate.Update(poste1);
                break;
            case 4:
                // Read
                PosteDao readDao = new PosteDao();

                for(Poste c : readDao.ReadPoste()){

                    System.out.println("Id poste: "+c.getId() +", latitude: "+c.getLatitude()+", longitude: "+c.getLongitude());
                    System.out.println("Codigo: "+c.getCodigo()+", Observacao: "+c.getObservacao());
                }
                break;
            default:
                System.out.println("Opcao escolhida invalida");
        }
    }
}
