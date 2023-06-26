package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Classe;
import br.com.contaDeEnergia.dao.ClasseDao;

import java.util.Scanner;

public class ClasseClasse {
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
                ClasseDao classeDao = new ClasseDao();
                Classe classe = new Classe();

                classe.setDescricao("completa");
                classe.setTipo_fase_id(1);

                classeDao.Create(classe);
                break;
            case 2:
                // Delete
                ClasseDao classeDaoDelete = new ClasseDao();

                System.out.println("Informe o Id do dado a ser deletado: ");
                Scanner dado = new Scanner(System.in);
                int id = dado.nextInt();

                classeDaoDelete.Delete(id);
                break;
            case 3:
                // Update
                ClasseDao upgradeDao = new ClasseDao();
                Classe classe1 = new Classe();

                System.out.println("Informe o Id do dado a ser atualizado: ");
                Scanner data = new Scanner(System.in);
                int idUp = data.nextInt();

                classe1.setDescricao("b");
                classe1.setId(idUp);

                upgradeDao.Update(classe1);
                break;
            case 4:
                // Read
                ClasseDao readDao = new ClasseDao();

                for(Classe c : readDao.ReadClasse()){

                    System.out.println("Classe "+c.getId() +": "+c.getDescricao());
                }
                break;
            default:
                System.out.println("Opcao escolhida invalida");
        }
    }
}
