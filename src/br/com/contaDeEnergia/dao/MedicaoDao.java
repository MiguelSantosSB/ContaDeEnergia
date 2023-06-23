package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Medicao;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class MedicaoDao {
    public void create(Medicao medicao){

        String sql = "INSERT INTO medicao(mes, ano, data_medicao, consumo) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, medicao.getMes());
            pstm.setString(2, medicao.getAno());
            pstm.setDate(3, new Date(medicao.getData_medicao().getTime()));
            pstm.setString(4, medicao.getConsumo());

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
