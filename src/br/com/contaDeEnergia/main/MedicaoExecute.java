package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Medicao;
import br.com.contaDeEnergia.dao.MedicaoDao;

import java.util.Scanner;

public class MedicaoExecute {
    //private static int num = 2;
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
                MedicaoDao medicaoDao = new MedicaoDao();
                Medicao medicao = new Medicao();

                medicao.setMes("junho");
                medicao.setAno("2023");
                medicao.setData_medicao("1/07/2023");
                medicao.setConsumo("2500W");
                medicao.setMedidor_id(3);
                medicao.setTime_rota_id(4);

                medicaoDao.Create(medicao);
                break;
            case 2:
                // Delete
                MedicaoDao medicaoDaoDelete = new MedicaoDao();

                System.out.println("Informe o Id do dado a ser deletado: ");
                Scanner dado = new Scanner(System.in);
                int id = dado.nextInt();

                medicaoDaoDelete.Delete(id);
                break;
            case 3:
                // Update
                MedicaoDao updateDao = new MedicaoDao();
                Medicao medicao1 = new Medicao();

                System.out.println("Informe o Id do dado a ser atualizado: ");
                Scanner data = new Scanner(System.in);
                int idUp = data.nextInt();

                medicao1.setMes("");
                medicao1.setAno("");
                //medicao1.setData_medicao();
                medicao1.setConsumo("");
                medicao1.setId(idUp);

                updateDao.Update(medicao1);
                break;
            case 4:
                // Read
                MedicaoDao readDao = new MedicaoDao();

                for(Medicao c : readDao.ReadMedicao()){

                    System.out.println("Id medicao: "+c.getId() +" Mes: "+c.getMes()+" Ano: "+c.getAno());
                    System.out.println("Consumo: "+c.getConsumo()+" Id medidor: "+c.getMedidor_id());
                    System.out.println("Id time de rota: "+c.getTime_rota_id());

                }
                break;
            default:
                System.out.println("Opcao escolhida invalida");
        }
    }
}
