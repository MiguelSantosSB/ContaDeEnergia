package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Poste;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PosteDao {
    public void create(Poste poste){

        String sql = "INSERT INTO poste(latitude, longitude, codigo, observacao) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, poste.getLatitude());
            pstm.setString(2, poste.getLongitude());
            pstm.setString(3, poste.getCodigo());
            pstm.setString(4, poste.getObservacao());

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
