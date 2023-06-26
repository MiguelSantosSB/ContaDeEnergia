package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.TipoFase;
import br.com.contaDeEnergia.dao.TipoFaseDao;

import java.util.Scanner;

public class ClasseTipoFase {
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
                TipoFaseDao tipoFaseDao = new TipoFaseDao();
                TipoFase tipoFase = new TipoFase();

                tipoFase.setDescricao("nao sei");

                tipoFaseDao.Create(tipoFase);
                break;
            case 2:
                // Delete
                TipoFaseDao tfDelete = new TipoFaseDao();

                System.out.println("Informe o Id do dado a ser deletado: ");
                Scanner dado = new Scanner(System.in);
                int id = dado.nextInt();

                tfDelete.Delete(id);
                break;
            case 3:
                // Update
                TipoFaseDao updateDao = new TipoFaseDao();
                TipoFase tipoFase1 = new TipoFase();

                System.out.println("Informe o Id do dado a ser atualizado: ");
                Scanner data = new Scanner(System.in);
                int idUp = data.nextInt();

                tipoFase1.setDescricao("agora eu sei");
                tipoFase1.setId(idUp);

                updateDao.Update(tipoFase1);
                break;
            case 4:
                // Read
                TipoFaseDao readDao = new TipoFaseDao();

                for (TipoFase c : readDao.ReadTipoFase()) {

                    System.out.println("Id: " + c.getId() + "| Descricao: " + c.getDescricao());

                }
                break;
            default:
                System.out.println("Opcao escolhida invalida");
        }
    }
}