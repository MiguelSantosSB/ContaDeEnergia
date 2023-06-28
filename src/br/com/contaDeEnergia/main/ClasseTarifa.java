package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Tarifa;
import br.com.contaDeEnergia.dao.TarifaDao;

import java.util.Scanner;

public class ClasseTarifa {
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
                TarifaDao tarifaDao = new TarifaDao();
                Tarifa tarifa = new Tarifa();

                tarifa.setTaxa("100 kWh - R$ 14,20");
                tarifa.setLei("lei n°12.212, decreto n°7.583");
                tarifa.setData_inicio("2011-10-13");
                tarifa.setData_fim("---");
                tarifa.setAliquota_ICMS("12%");
                tarifa.setClasse_id(3);

                tarifaDao.Create(tarifa);
                break;
            case 2:
                // Delete
                TarifaDao tarifaDelete = new TarifaDao();

                System.out.println("Informe o Id do dado a ser deletado: ");
                Scanner dado = new Scanner(System.in);
                int id = dado.nextInt();

                tarifaDelete.Delete(id);
                break;
            case 3:
                // Update
                TarifaDao updateDao = new TarifaDao();
                Tarifa tarifa1 = new Tarifa();

                System.out.println("Informe o Id do dado a ser atualizado: ");
                Scanner data = new Scanner(System.in);
                int idUp = data.nextInt();

                tarifa1.setTaxa("");
                tarifa1.setLei("");
                tarifa1.setData_inicio("");
                tarifa1.setData_fim("");
                tarifa1.setAliquota_ICMS("");
                tarifa1.setId(idUp);

                updateDao.Update(tarifa1);
                break;
            case 4:
                // Read
                TarifaDao readDao = new TarifaDao();

                for(Tarifa c : readDao.ReadTarifa()){

                    System.out.println("Id tarifa: "+c.getId() +", Taxa: "+c.getTaxa()+", Lei: "+c.getLei());
                    System.out.println("Data inicio: "+c.getData_inicio()+", Data fim: "+c.getData_fim());
                    System.out.println("Aliquosa: "+c.getAliquota_ICMS()+", Id classe: "+c.getClasse_id());
                }
                break;
            default:
                System.out.println("Opcao escolhida invalida");
        }
    }
}
