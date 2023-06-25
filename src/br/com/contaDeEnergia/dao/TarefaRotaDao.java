package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.TarefaRota;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TarefaRotaDao {
    public void Create(TarefaRota tarefarota){

        String sql = "INSERT INTO tarefarota(observacao, data_inicio, data_fim, rota_id) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, tarefarota.getObservacao());
            pstm.setDate(2, new Date(tarefarota.getData_inicio().getTime()));
            pstm.setDate(3, new Date(tarefarota.getData_fim().getTime()));
            pstm.setInt(4, tarefarota.getRota_id());

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

    public void Update(TarefaRota tarefaRota){

        String sql = "UPDATE tarefarota SET observacao = ?, data_inicio = ?, data_fim = ? "+
                "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            // Adicionar os valores para atualizar
            pstm.setString(1, tarefaRota.getObservacao());
            pstm.setDate(2, new Date(tarefaRota.getData_inicio().getTime()));
            pstm.setDate(3, new Date(tarefaRota.getData_fim().getTime()));
            // Qual id do registro que vai ser atualizado
            pstm.setInt(4, tarefaRota.getId());

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

    public List<TarefaRota> ReadTarefa(){

        String sql = "SELECT * FROM tarefarota";

        List<TarefaRota> tarefaRotas = new ArrayList<TarefaRota>();

        Connection conn = null;
        PreparedStatement pstm = null;
        // recuper os dados do banco
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                TarefaRota tarefaRota = new TarefaRota();
                //Pegar o id
                tarefaRota.setId(rset.getInt("id"));
                tarefaRota.setObservacao(rset.getString("observacao"));
                tarefaRota.setData_inicio(rset.getDate("data_inicio"));
                tarefaRota.setData_fim(rset.getDate("data_fim"));
                tarefaRota.setRota_id(rset.getInt("rota_id"));

                tarefaRotas.add(tarefaRota);
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
        return tarefaRotas;
    }
}
