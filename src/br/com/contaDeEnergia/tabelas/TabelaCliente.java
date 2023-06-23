package br.com.contaDeEnergia.tabelas;

import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

public class TabelaCliente {
    public static void main(String[] args) {

        Connection conn = null;
        Statement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.createStatement();

            String sql = "CREATE TABLE cliente"+
                    "(id INTEGER PRIMARY KEY AUTO_INCREMENT,"+
                    "num_documento VARCHAR(45) NOT NULL,"+
                    "num_cliente VARCHAR(45) NOT NULL)";

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