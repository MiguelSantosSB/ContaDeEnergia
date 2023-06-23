package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Tarefa_Rota;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class Tarefa_RotaDao {
    public void save(Tarefa_Rota tarefa_rota){

        String sql = "INSERT INTO tarefa_rota(observacao, data_inicio, data_fim) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, tarefa_rota.getObservacao());
            pstm.setDate(2, new Date(tarefa_rota.getData_inicio().getTime()));
            pstm.setDate(3, new Date(tarefa_rota.getData_fim().getTime()));

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
