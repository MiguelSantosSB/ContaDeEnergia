package br.com.contaDeEnergia.tabelas;

import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

public class TabelaRota {
    public static void main(String[] args) {

        Connection conn = null;
        Statement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.createStatement();

            String sql = "CREATE TABLE rota" +
                    "(id SERIAL NOT NULL," +
                    "descricao VARCHAR(45) NULL)";

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
