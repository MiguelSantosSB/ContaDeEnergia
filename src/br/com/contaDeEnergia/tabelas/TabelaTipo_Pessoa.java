package br.com.contaDeEnergia.tabelas;

import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.*;

public class TabelaTipo_Pessoa {

    public static void main(String[] args){

        Connection conn = null;
        Statement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.createStatement();

            String sql = "CREATE TABLE tipo_pessoa" +
                    "(id SERIAL not null," +
                    "descricao VARCHAR(45),"+
                    "CONSTRAINT tipo_pessoa_key PRIMARY KEY(id))";


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
