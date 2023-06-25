package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Medicao;
import br.com.contaDeEnergia.dao.MedicaoDao;

import java.util.Date;

public class ClasseMedicao {
    private static int num = 1;
    public static void main(String[] args) {

        MedicaoDao medicaoDao = new MedicaoDao();

        Medicao medicao = new Medicao();
        medicao.setMes("julho");
        medicao.setAno("2023");
        medicao.setData_medicao(new Date(2002,9,10));
        medicao.setConsumo("2500W");
        medicao.setMedidor_id(num);
        medicao.setTime_rota_id(num);

        medicaoDao.Create(medicao);

        // Update
        Medicao medicao1 = new Medicao();
        medicao1.setMes("");
        medicao1.setAno("");
        //medicao1.setData_medicao();
        medicao1.setConsumo("");
        medicao1.setId(1);

        //medicaoDao.Update(medicao1);

        // Read
        for(Medicao c : medicaoDao.ReadMedicao()){

            System.out.println("Id medicao: "+c.getId() +" Mes: "+c.getMes()+" Ano: "+c.getAno());
            System.out.println("Consumo: "+c.getConsumo()+" Id medidor: "+c.getMedidor_id());
            System.out.println("Id time de rota: "+c.getTime_rota_id());
        }
    }
}
