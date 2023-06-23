package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Contrato;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ContratoDao {
    public void create(Contrato contrato){

        String sql = "INSERT INTO contrato(descricao, data_inicio, data_criacao) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, contrato.getDescricao());
            pstm.setDate(2, new Date(contrato.getData_inicio().getTime()));
            pstm.setDate(3, new Date(contrato.getData_criacao().getTime()));
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
