package br.com.contaDeEnergia.main;

import br.com.contaDeEnergia.Model.Rota;
import br.com.contaDeEnergia.dao.RotaDao;

public class ClasseRota {
    public static void main(String[] args) {

        RotaDao rotaDao = new RotaDao();

        Rota rota = new Rota();
        rota.setDescricao("rua tal, numero tal, bairro tal");

        rotaDao.Create(rota);
        // Read
        for(Rota c : rotaDao.ReadRota()){

            System.out.println("Id rota: "+c.getId() +", Descricao da rota: "+c.getDescricao());
        }
    }
}
