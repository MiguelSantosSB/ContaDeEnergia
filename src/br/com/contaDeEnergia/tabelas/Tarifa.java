package br.com.contaDeEnergia.tabelas;

import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

public class Tarifa {
    public static void main(String[] args) {

        Connection conn = null;
        Statement pstm = null;
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.createStatement();

            String sql = "CREATE TABLE tarifa"+
                    " (id INT NOT NULL UNIQUE, "+
                    " taxa VARCHAR(45) NOT NULL, "+
                    " lei VARCHAR(45) NOT NULL, "+
                    " data_inicio VARCHAR(45) NOT NULL, "+
                    " data_fim VARCHAR(45) NOT NULL, "+
                    " aliquota_ICMS VARCHAR(45), "+
                    " classe_id INT NULL UNIQUE,"+

                    " PRIMARY KEY (id), "+
                    " FOREIGN KEY (classe_id)"+
                    " REFERENCES classe(id))";

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
