package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.TipoPessoa;
import br.com.contaDeEnergia.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TipoPessoaDao {

    public void Create(TipoPessoa tipo_pessoa) {
        String sql = "INSERT INTO tipopessoa(descricao) VALUES (?)";

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

    public void Delete(int id){
        String sql = " DELETE FROM tipopessoa WHERE id = ?";

        Connection conn = null;

        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (pstm != null){
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void Update(TipoPessoa tipoPessoa){

        String sql = "UPDATE tipopessoa SET descricao = ? "+
                "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            // Adicionar os valores para atualizar
            pstm.setString(1, tipoPessoa.getDescricao());
            // Qual id do registro que vai ser atualizado
            pstm.setInt(2, tipoPessoa.getId());

            pstm.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try
            {
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

    public List<TipoPessoa> ReadTipoPessoa(){

        String sql = "SELECT * FROM tipopessoa";

        List<TipoPessoa> tipoPessoas = new ArrayList<TipoPessoa>();

        Connection conn = null;
        PreparedStatement pstm = null;
        // recuper os dados do banco
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                TipoPessoa tipoPessoa = new TipoPessoa();
                //Pegar o id
                tipoPessoa.setId(rset.getInt("id"));
                tipoPessoa.setDescricao(rset.getString("descricao"));

                tipoPessoas.add(tipoPessoa);
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
        return tipoPessoas;
    }
}
