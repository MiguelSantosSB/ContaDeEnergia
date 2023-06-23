package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Medicao;
import br.com.contaDeEnergia.dao.MedicaoDao;

import java.util.Date;

public class ClasseMedicao {
    public static void main(String[] args) {

        MedicaoDao medicaoDao = new MedicaoDao();

        Medicao medicao = new Medicao();
        medicao.setMes("");
        medicao.setAno("");
        medicao.setData_medicao(new Date());
        medicao.setConsumo("");

        medicaoDao.save(medicao);
    }
}
