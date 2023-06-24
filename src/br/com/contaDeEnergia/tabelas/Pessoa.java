package br.com.contaDeEnergia.tabelas;

import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.*;

public class Pessoa {

    public static void main(String[] args) {

        Connection conn = null;
        Statement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.createStatement();

            String sql = " CREATE TABLE pessoa " +
                        " (id INT NOT NULL AUTO_INCREMENT, " +
                        " nome VARCHAR(45) NOT NULL, " +
                        " cpf VARCHAR(45) UNIQUE NULL, " +
                        " cnpj VARCHAR(45) UNIQUE NULL, " +
                        " tipo_pessoa_id INT NOT NULL, "+

                        " PRIMARY KEY (id),"+
                        " FOREIGN KEY (tipo_pessoa_id) "+
                        " REFERENCES tipopessoa(id)) ";

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
