package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Contrato;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratoDao {
    public void Create(Contrato contrato){

        String sql = "INSERT INTO contrato(descricao, data_inicio, data_criacao, medidor_id, classe_id, cliente_id) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, contrato.getDescricao());
            pstm.setDate(2, new Date(contrato.getData_inicio().getTime()));
            pstm.setDate(3, new Date(contrato.getData_criacao().getTime()));
            pstm.setInt(4, contrato.getMedidor_id());
            pstm.setInt(5, contrato.getClasse_id());
            pstm.setInt(6, contrato.getCliente_id());

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
        String sql = " DELETE FROM contrato WHERE id = ?";

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

    public void Update(Contrato contrato){

        String sql = "UPDATE contrato SET descricao = ?, data_inicio = ?, data_criacao = ? "+
                "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            // Adicionar os valores para atualizar
            pstm.setString(1, contrato.getDescricao());
            // Qual id do registro que vai ser atualizado
            pstm.setDate(2, new Date(contrato.getData_inicio().getTime()));
            pstm.setDate(3, new Date(contrato.getData_criacao().getTime()));
            pstm.setInt(4, contrato.getId());

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
                contrato.setCliente_id(rset.getInt("cliente_id"));
                contrato.setClasse_id(rset.getInt("classe_id"));
                contrato.setMedidor_id(rset.getInt("medidor_id"));


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
