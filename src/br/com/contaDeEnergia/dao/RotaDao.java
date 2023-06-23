package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Poste;
import br.com.contaDeEnergia.Model.Rota;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RotaDao {
    public void create(Rota rota){

        String sql = "INSERT INTO rota(descricao) VALUES (?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, rota.getDescricao());

            // Executa a query
            pstm.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
