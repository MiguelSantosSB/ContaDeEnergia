package br.com.contaDeEnergia.tabelas;

import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

public class Medicao {
    public static void main(String[] args) {

        Connection conn = null;
        Statement pstm = null;
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.createStatement();

            String sql = "CREATE TABLE medicao"+
                    " (id INT NOT NULL AUTO_INCREMENT,"+
                    " mes VARCHAR(45) NOT NULL,"+
                    " ano VARCHAR(45) NOT NULL,"+
                    " data_medicao VARCHAR(45) NOT NULL,"+
                    " consumo VARCHAR(45) NOT NULL,"+
                    " medidor_id INT NULL,"+
                    " time_rota_id INT NULL,"+

                    " PRIMARY KEY (id), "+
                    " FOREIGN KEY (medidor_id)"+
                    " REFERENCES medidor(id),"+
                    " FOREIGN KEY (time_rota_id)"+
                    " REFERENCES timerota(id))";

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
