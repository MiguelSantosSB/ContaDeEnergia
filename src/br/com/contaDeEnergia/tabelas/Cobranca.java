package br.com.contaDeEnergia.tabelas;

import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

public class Cobranca {
    public static void main(String[] args) {

        Connection conn = null;
        Statement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.createStatement();

            String sql = " CREATE TABLE cobranca "+
                    " (id INT NOT NULL AUTO_INCREMENT, "+
                    " mes_referencia VARCHAR(45) NOT NULL, "+
                    " ano_referencia VARCHAR(45) NOT NULL, "+
                    " tarifa_id INT , "+

                    " PRIMARY KEY (id), "+
                    " FOREIGN KEY (tarifa_id) "+
                    " REFERENCES tarifa(id)) ";





            pstm.executeUpdate(sql);
        }catch(SQLDataException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm!=null){
                    conn.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }try{
            if(conn!=null){
                conn.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
