package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Cobranca;
import br.com.contaDeEnergia.Model.Contrato;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratoDao {
    public void create(Contrato contrato){

        String sql = "INSERT INTO contrato(descricao, data_inicio, data_criacao) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, contrato.getDescricao());
            pstm.setDate(2, new Date(contrato.getData_inicio().getTime()));
            pstm.setDate(3, new Date(contrato.getData_criacao().getTime()));
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

    public List<Contrato> ReadContrato(){

        String sql = "SELECT * FROM contrato";

        List<Contrato> contratos = new ArrayList<Contrato>();

        Connection conn = null;
        PreparedStatement pstm = null;
        // recuperar os dados do banco
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                Contrato contrato = new Contrato();
                //Pegar o id
                contrato.setId(rset.getInt("id"));
                contrato.setDescricao(rset.getString("descricao"));
                contrato.setData_inicio(rset.getDate("data_inicio"));
                contrato.setData_criacao(rset.getDate("data_criacao"));

                contratos.add(contrato);
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
        return contratos;
    }
}
