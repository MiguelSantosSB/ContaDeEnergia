package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Medidor;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedidorDao {
    public void Create(Medidor medidor){

        String sql = "INSERT INTO medidor(descricao, rota_id, poste_id) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, medidor.getDescricao());
            pstm.setInt(2, medidor.getRota_id());
            pstm.setInt(3, medidor.getPoste_id());

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

    public void Update(Medidor medidor){

        String sql = "UPDATE medidor SET descricao = ? "+
                "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            // Adicionar os valores para atualizar
            pstm.setString(1, medidor.getDescricao());
            // Qual id do registro que vai ser atualizado
            pstm.setInt(2, medidor.getId());

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

    public List<Medidor> ReadMedidor(){

        String sql = "SELECT * FROM medidor";

        List<Medidor> medidores = new ArrayList<Medidor>();

        Connection conn = null;
        PreparedStatement pstm = null;
        // recuper os dados do banco
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                Medidor medidor = new Medidor();
                //Pegar o id
                medidor.setId(rset.getInt("id"));
                medidor.setDescricao(rset.getString("descricao"));
                medidor.setPoste_id(rset.getInt("poste_id"));
                medidor.setRota_id(rset.getInt("rota_id"));

                medidores.add(medidor);
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
        return medidores;
    }
}
