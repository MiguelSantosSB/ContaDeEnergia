package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Tipo_Pessoa;
import br.com.contaDeEnergia.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Tipo_PessoaDao {

    public void create(Tipo_Pessoa tipo_pessoa) {
        String sql = "INSERT INTO tipo_pessoa(descricao) VALUES (?)";

        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, tipo_pessoa.getDescricao());

            pstm.execute();
        }catch(
                Exception e)

        {
            e.printStackTrace();
        }finally

        {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
