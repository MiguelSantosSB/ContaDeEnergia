package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Cobranca;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class CobrancaDao {
    public void create(Cobranca cobranca){

        String sql = "INSERT INTO cobranca(mes_referencia, ano_referencia) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cobranca.getMes_referencia());
            pstm.setString(2, cobranca.getAno_referencia());

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
