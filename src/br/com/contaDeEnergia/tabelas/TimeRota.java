package br.com.contaDeEnergia.tabelas;

import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

public class TimeRota {
    public static void main(String[] args) {

        Connection conn = null;
        Statement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.createStatement();

            String sql = "CREATE TABLE timerota" +
                    " (id INT NOT NULL AUTO_INCREMENT, " +
                    " funcionario_id INT NULL,"+
                    " tarefa_rota_id INT NULL,"+

                    " PRIMARY KEY (id),"+
                    " FOREIGN KEY (tarefa_rota_id)"+
                    " REFERENCES tarefarota(id),"+
                    " FOREIGN KEY (funcionario_id)"+
                    " REFERENCES funcionario(id))";


            pstm.executeUpdate(sql);
        } catch (SQLDataException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
