package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Cobranca;
import br.com.contaDeEnergia.dao.CobrancaDao;

import java.util.Scanner;

public class ClasseCobranca {
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
                CobrancaDao cobrancaDao = new CobrancaDao();
                Cobranca cobranca = new Cobranca();

                cobranca.setMes_referencia("");
                cobranca.setAno_referencia("");
                cobranca.setTarifa_id(1);

                cobrancaDao.Create(cobranca);
                break;
            case 2:
                // Delete
                CobrancaDao cobrancaDaoDelete = new CobrancaDao();

                System.out.println("Informe o Id do dado a ser deletado: ");
                Scanner dado = new Scanner(System.in);
                int id = dado.nextInt();

                cobrancaDaoDelete.Delete(id);
                break;
            case 3:
                // Update
                CobrancaDao updateDao = new CobrancaDao();
                Cobranca cobranca1 = new Cobranca();

                System.out.println("Informe o Id do dado a ser atualizado: ");
                Scanner data = new Scanner(System.in);
                int idUp = data.nextInt();

                cobranca1.setMes_referencia("julho");
                cobranca1.setAno_referencia("2023");
                cobranca1.setId(idUp);

                updateDao.Update(cobranca1);
                break;
            case 4:
                // Read
                CobrancaDao readDao = new CobrancaDao();

                for(Cobranca c : readDao.ReadCobranca()){
                    System.out.println("Cobanca:"+c.getId());
                    System.out.println("Cobranca: "+ c.getMes_referencia());
                    System.out.println("Cobranca: "+c.getAno_referencia());
                }
                break;
            default:
                System.out.println("Opcao escolhida invalida");
        }
    }
}
