package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.TipoFase;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TipoFaseDao {
    public void Create(TipoFase tipo_fase){
        String sql = "INSERT INTO tipofase(descricao) VALUES (?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, tipo_fase.getDescricao());

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
    
    public void Delete(int id){
        String sql = " DELETE FROM tipofase WHERE id = ?";

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

    public void Update(TipoFase tipoFase){

        String sql = "UPDATE tipofase SET descricao = ? "+
                "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            // Adicionar os valores para atualizar
            pstm.setString(1, tipoFase.getDescricao());
            // Qual id do registro que vai ser atualizado
            pstm.setInt(2, tipoFase.getId());

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

    public List<TipoFase> ReadTipoFase(){

        String sql = "SELECT * FROM tipofase";

        List<TipoFase> tipoFases = new ArrayList<TipoFase>();

        Connection conn = null;
        PreparedStatement pstm = null;
        // recuper os dados do banco
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                TipoFase tipoFase = new TipoFase();
                //Pegar o id
                tipoFase.setId(rset.getInt("id"));
                tipoFase.setDescricao(rset.getString("descricao"));

                tipoFases.add(tipoFase);
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
        return tipoFases;
    }
}
