package br.com.contaDeEnergia.tabelas;

import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

public class Medidor {
    public static void main(String[] args) {

        Connection conn = null;
        Statement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.createStatement();

            String sql = "CREATE TABLE medidor"+
                    " (id INT NOT NULL AUTO_INCREMENT,"+
                    " descricao VARCHAR(45) NOT NULL,"+
                    " rota_id INT NOT NULL, "+
                    " poste_id INT NOT NULL ,"+

                    " PRIMARY KEY (id),"+
                    " FOREIGN KEY (rota_id)"+
                    " REFERENCES rota(id),"+
                    " FOREIGN KEY (poste_id)"+
                    " REFERENCES poste(id))";

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
