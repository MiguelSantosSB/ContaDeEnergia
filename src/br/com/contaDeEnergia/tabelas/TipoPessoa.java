package br.com.contaDeEnergia.tabelas;

import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.*;

public class TipoPessoa {

    public static void main(String[] args){

        Connection conn = null;
        Statement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.createStatement();

            String sql = "CREATE TABLE tipopessoa" +
                    " (id INT NOT NULL AUTO_INCREMENT, " +
                    " descricao VARCHAR(45), "+
                    " PRIMARY KEY(id)) ";


            pstm.executeUpdate(sql);
        }catch (SQLDataException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm!=null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }try{
            if (conn!=null){
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
