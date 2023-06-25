package br.com.contaDeEnergia.dao;


import br.com.contaDeEnergia.Model.Pessoa;
import br.com.contaDeEnergia.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PessoaDao {

    public void Create(Pessoa pessoa){
        String sql = "INSERT INTO pessoa(nome, cpf, cnpj, tipo_pessoa_id) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, pessoa.getNome());
            pstm.setString(2, pessoa.getCpf());
            pstm.setString(3, pessoa.getCnpj());
            pstm.setInt(4, pessoa.getTipo_pessoa_id());

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
    public List<Pessoa> ReadPessoa(){

        String sql = "SELECT * FROM pessoa";

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        Connection conn = null;
        PreparedStatement pstm = null;
        // recuper os dados do banco
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                Pessoa pessoa = new Pessoa();
                //Pegar o id
                pessoa.setId(rset.getInt("id"));
                pessoa.setNome(rset.getString("nome"));
                pessoa.setCpf(rset.getString("cpf"));
                pessoa.setCnpj(rset.getString("cnpj"));
                pessoa.setTipo_pessoa_id(rset.getInt("tipo_pessoa_id"));

                pessoas.add(pessoa);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(rset!=null){
                    rset.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
                if (conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return pessoas;
    }
}
