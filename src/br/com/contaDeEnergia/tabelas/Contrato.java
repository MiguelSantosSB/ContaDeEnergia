package br.com.contaDeEnergia.tabelas;

import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

public class Contrato {
    public static void main(String[] args) {

        Connection conn = null;
        Statement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.createStatement();

            String sql = "CREATE TABLE contrato"+
                    " (id INT NOT NULL AUTO_INCREMENT, "+
                    " descricao VARCHAR(45), "+
                    " data_inicio TIMESTAMP, "+
                    " data_criacao TIMESTAMP, "+
                    " medidor_id INT NULL, "+
                    " classe_id INT NULL, "+
                    " cliente_id INT NULL, "+

                    " PRIMARY KEY (id), "+
                    " FOREIGN KEY (medidor_id)"+
                    " REFERENCES medidor(id),"+
                    " FOREIGN KEY (classe_id)"+
                    " REFERENCES classe(id),"+
                    " FOREIGN KEY (cliente_id)"+
                    " REFERENCES cliente(id))";


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
