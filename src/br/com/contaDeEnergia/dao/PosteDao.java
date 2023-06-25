package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Poste;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PosteDao {
    public void Create(Poste poste){

        String sql = "INSERT INTO poste(latitude, longitude, codigo, observacao) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, poste.getLatitude());
            pstm.setString(2, poste.getLongitude());
            pstm.setString(3, poste.getCodigo());
            pstm.setString(4, poste.getObservacao());

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

    public void Update(Poste poste){

        String sql = "UPDATE poste SET latitude = ?, longitude = ?, codigo = ?, observacao = ? "+
                "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            // Adicionar os valores para atualizar
            pstm.setString(1, poste.getLatitude());
            pstm.setString(2, poste.getLongitude());
            pstm.setString(3, poste.getCodigo());
            pstm.setString(4, poste.getObservacao());
            // Qual id do registro que vai ser atualizado
            pstm.setInt(5, poste.getId());

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

    public List<Poste> ReadPoste(){

        String sql = "SELECT * FROM poste";

        List<Poste> postes = new ArrayList<Poste>();

        Connection conn = null;
        PreparedStatement pstm = null;
        // recuper os dados do banco
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                Poste poste = new Poste();
                //Pegar o id
                poste.setId(rset.getInt("id"));
                poste.setLatitude(rset.getString("latitude"));
                poste.setLongitude(rset.getString("longitude"));
                poste.setCodigo(rset.getString("codigo"));
                poste.setObservacao(rset.getString("observacao"));

                postes.add(poste);
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
        return postes;
    }
}
