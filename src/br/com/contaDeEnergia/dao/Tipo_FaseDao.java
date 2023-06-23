package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Tipo_Fase;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Tipo_FaseDao {
    public void save(Tipo_Fase tipo_fase){
        String sql = "INSERT INTO tipo_fase(descricao) VALUES (?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, tipo_fase.getDescricao());

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
