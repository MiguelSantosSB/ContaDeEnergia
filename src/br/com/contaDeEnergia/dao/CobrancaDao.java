package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Cobranca;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CobrancaDao {
    public void Create(Cobranca cobranca){

        String sql = "INSERT INTO cobranca(mes_referencia, ano_referencia, tarifa_id) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cobranca.getMes_referencia());
            pstm.setString(2, cobranca.getAno_referencia());
            pstm.setInt(3, cobranca.getTarifa_id());

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

    public List<Cobranca> ReadCobranca(){

        String sql = "SELECT * FROM cobranca";

        List<Cobranca> cobrancas = new ArrayList<Cobranca>();

        Connection conn = null;
        PreparedStatement pstm = null;
        // recuperar os dados do banco
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                Cobranca cobranca = new Cobranca();
                //Pegar o id
                cobranca.setId(rset.getInt("id"));
                cobranca.setMes_referencia(rset.getString("mes_referencia"));
                cobranca.setAno_referencia(rset.getString("ano_referencia"));
                cobranca.setTarifa_id(rset.getInt("tarifa_id"));

                cobrancas.add(cobranca);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(rset!=null){
                    rset.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
                if (conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return cobrancas;
    }
}
