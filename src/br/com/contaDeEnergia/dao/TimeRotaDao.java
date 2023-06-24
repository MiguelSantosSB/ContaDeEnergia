package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.TimeRota;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TimeRotaDao {
    public void create(TimeRota timeRota){
        String sql = "INSERT INTO timerota(funcionario_id, tarefa_rota_id) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, timeRota.getFuncionario_id());
            pstm.setInt(2, timeRota.getTarefa_rota_id());

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
