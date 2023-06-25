package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Rota;
import br.com.contaDeEnergia.dao.RotaDao;

public class ClasseRota {
    public static void main(String[] args) {

        RotaDao rotaDao = new RotaDao();

        Rota rota = new Rota();
        rota.setDescricao("rua tal, numero tal, bairro tal");

        //rotaDao.Create(rota);

        // Update
        Rota rota1 = new Rota();
        rota1.setDescricao("");
        rota1.setId(1);

        rotaDao.Update(rota1);

        // Read
        for(Rota c : rotaDao.ReadRota()){
            System.out.println("Id rota: "+c.getId() +", Descricao da rota: "+c.getDescricao());
        }
    }
}
