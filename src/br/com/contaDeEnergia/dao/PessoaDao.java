package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Pessoa;
import br.com.contaDeEnergia.Model.Tipo_Pessoa;
import br.com.contaDeEnergia.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PessoaDao {

    public void create(Pessoa pessoa){
        String sql = "INSERT INTO pessoa(nome, cpf, cnpj) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, pessoa.getNome());
            pstm.setString(2, pessoa.getCpf());
            pstm.setString(3, pessoa.getCnpj());

            // Executa a query
            pstm.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
