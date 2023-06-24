package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Classe;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClasseDao {
    public void create(Classe classe){
        String sql = "INSERT INTO classe(descricao) VALUES (?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, classe.getDescricao());

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

    public List<Classe> readClasse(){

        String sql = "SELECT * FROM classe";

        List<Classe> classes = new ArrayList<Classe>();

        Connection conn = null;
        PreparedStatement pstm = null;
        // recuper os dados do banco
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
               Classe classe = new Classe();
               //Pegar o id
               classe.setId(rset.getInt("id"));
               classe.setDescricao(rset.getString("descricao"));

               classes.add(classe);
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
        return classes;
    }
}
