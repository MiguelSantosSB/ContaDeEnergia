package br.com.contaDeEnergia.tabelas;

import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

public class TabelaMedicao {
    public static void main(String[] args) {

        Connection conn = null;
        Statement pstm = null;
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.createStatement();

            String sql = "CREATE TABLE medicao"+
                    "(id SERIAL not null,"+
                    "mes VARCHAR(45) NOT NULL,"+
                    "ano VARCHAR(45) NOT NULL,"+
                    "data_medicao TIMESTAMP NOT NULL,"+
                    "consumo VARCHAR(45) NOT NULL)";

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
