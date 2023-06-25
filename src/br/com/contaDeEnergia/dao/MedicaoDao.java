package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Medicao;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedicaoDao {
    public void Create(Medicao medicao){

        String sql = "INSERT INTO medicao(mes, ano, data_medicao, consumo, medidor_id, time_rota_id) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, medicao.getMes());
            pstm.setString(2, medicao.getAno());
            pstm.setDate(3, new Date(medicao.getData_medicao().getTime()));
            pstm.setString(4, medicao.getConsumo());
            pstm.setInt(5, medicao.getMedidor_id());
            pstm.setInt(6, medicao.getTime_rota_id());

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
        String sql = " DELETE FROM medicao WHERE id = ?";

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

    public void Update(Medicao medicao){

        String sql = "UPDATE medicao SET mes = ?, ano = ?, data_medicao = ?, consumo = ? "+
                "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            // Adicionar os valores para atualizar
            pstm.setString(1, medicao.getMes());
            pstm.setString(2, medicao.getAno());
            pstm.setDate(3, new Date(medicao.getData_medicao().getTime()));
            pstm.setString(4, medicao.getConsumo());
            // Qual id do registro que vai ser atualizado
            pstm.setInt(5, medicao.getId());

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

    public List<Medicao> ReadMedicao(){

        String sql = "SELECT * FROM medicao";

        List<Medicao> medicoes = new ArrayList<Medicao>();

        Connection conn = null;
        PreparedStatement pstm = null;
        // recuper os dados do banco
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                Medicao medicao = new Medicao();
                //Pegar o id
                medicao.setId(rset.getInt("id"));
                medicao.setMes(rset.getString("mes"));
                medicao.setAno(rset.getString("ano"));
                medicao.setData_medicao(rset.getDate("data_medicao"));
                medicao.setConsumo(rset.getString("consumo"));
                medicao.setMedidor_id(rset.getInt("medidor_id"));
                medicao.setTime_rota_id(rset.getInt("time_rota_id"));

                medicoes.add(medicao);
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
        return medicoes;
    }
}
