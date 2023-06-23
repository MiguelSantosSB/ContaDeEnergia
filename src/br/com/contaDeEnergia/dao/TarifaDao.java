package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Tarifa;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TarifaDao {
    public void create(Tarifa tarifa){
        String sql = "INSERT INTO tarifa(taxa, lei, data_inicio, data_fim, aliquota_ICMS) VALUES (?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, tarifa.getTaxa());
            pstm.setString(2, tarifa.getLei());
            pstm.setString(3, tarifa.getData_inicio());
            pstm.setString(4, tarifa.getData_fim());
            pstm.setString(5, tarifa.getAliquota_ICMS());

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
