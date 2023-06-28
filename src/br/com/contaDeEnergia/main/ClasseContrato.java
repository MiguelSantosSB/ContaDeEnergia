package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Contrato;
import br.com.contaDeEnergia.dao.ContratoDao;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class ClasseContrato {
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
                ContratoDao contratoDao = new ContratoDao();
                Contrato contrato = new Contrato();

                contrato.setDescricao("Contrato referente a compra de servico de energina.");
                //contrato.setData_criacao(Date.from(Instant.from(LocalDate.now())));
                contrato.setData_criacao(new Date());
                //contrato.setData_inicio(Date.from(Instant.from(LocalDate.now().plusMonths(1))));
                contrato.setData_inicio(new Date());
                contrato.setMedidor_id(num);
                contrato.setClasse_id(num);
                contrato.setCliente_id(num);

                contratoDao.Create(contrato);
                break;
            case 2:
                // Delete
                ContratoDao contratoDaoDelete = new ContratoDao();

                System.out.println("Informe o Id do dado a ser deletado: ");
                Scanner dado = new Scanner(System.in);
                int id = dado.nextInt();

                contratoDaoDelete.Delete(id);
                break;
            case 3:
                // Update
                ContratoDao upgradeDao = new ContratoDao();
                Contrato contrato1 = new Contrato();

                System.out.println("Informe o Id do dado a ser atualizado: ");
                Scanner data = new Scanner(System.in);
                int idUp = data.nextInt();

                contrato1.setDescricao("");
                contrato1.setData_inicio(new Date());
                contrato1.setData_criacao(new Date());
                contrato1.setId(idUp);

                upgradeDao.Update(contrato1);
                break;
            case 4:
                // Read
                ContratoDao readDao = new ContratoDao();

                for(Contrato c : readDao.ReadContrato()){

                    System.out.println("Contrato: "+c.getId() +" Criacao: "+c.getData_criacao()+ " Inicio: "+c.getData_inicio());
                    System.out.println("Id medidor: "+c.getMedidor_id()+" Id classe: "+c.getClasse_id()+" Id Cliente: "+c.getCliente_id());

                }
                break;
            default:
                System.out.println("Opcao escolhida invalida");
        }
    }
}
