package br.com.contaDeEnergia.tabelas;

import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

public class Poste {
    public static void main(String[] args) {

        Connection conn = null;
        Statement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.createStatement();

            String sql = "CREATE TABLE poste" +
                    " (id INT NOT NULL AUTO_INCREMENT, " +
                    " latitude VARCHAR(45) NULL, "+
                    " longitude VARCHAR(45) NULL, "+
                    " codigo VARCHAR(45) NULL, "+
                    " observacao VARCHAR(45) NULL, "+
                    " PRIMARY KEY (id)) ";

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