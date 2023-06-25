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
        medicao.setData_medicao(new Date());
        medicao.setConsumo("2500W");
        medicao.setMedidor_id(num);
        medicao.setTime_rota_id(num);

        //medicaoDao.Create(medicao);

        // Read
        for(Medicao c : medicaoDao.ReadMedicao()){

            System.out.println("Id medicao: "+c.getId() +" Mes: "+c.getMes()+" Ano: "+c.getAno());
            System.out.println("Consumo: "+c.getConsumo()+" Id medidor: "+c.getMedidor_id());
            System.out.println("Id time de rota: "+c.getTime_rota_id());
        }
    }
}
