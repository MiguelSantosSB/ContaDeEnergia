package br.com.contaDeEnergia.tabelas;

import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

public class TabelaTarefa_Rota {
    public static void main(String[] args) {

        Connection conn = null;
        Statement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.createStatement();

            String sql = "CREATE TABLE tarefa_rota" +
                    "(id SERIAL NOT NULL," +
                    "observacao VARCHAR(45) NULL,"+
                    "data_inicio TIMESTAMP NULL,"+
                    "data_fim DATE NULL)";

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
