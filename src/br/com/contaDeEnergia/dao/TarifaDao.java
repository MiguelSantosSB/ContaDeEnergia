package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Tarifa;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TarifaDao {
    public void Create(Tarifa tarifa){
        String sql = "INSERT INTO tarifa(id ,taxa, lei, data_inicio, data_fim, aliquota_ICMS, classe_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, tarifa.getId());
            pstm.setString(2, tarifa.getTaxa());
            pstm.setString(3, tarifa.getLei());
            pstm.setString(4, tarifa.getData_inicio());
            pstm.setString(5, tarifa.getData_fim());
            pstm.setString(6, tarifa.getAliquota_ICMS());
            pstm.setInt(7, tarifa.getClasse_id());

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
        String sql = " DELETE FROM tarifa WHERE id = ?";

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

    public void Update(Tarifa tarifa){

        String sql = "UPDATE tarifa SET taxa = ?, lei = ?, data_inicio = ?, data_fim = ?, aliquota_ICMS = ? "+
                "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            // Adicionar os valores para atualizar
            pstm.setString(1, tarifa.getTaxa());
            pstm.setString(2, tarifa.getLei());
            pstm.setString(3, tarifa.getData_inicio());
            pstm.setString(4, tarifa.getData_fim());
            pstm.setString(5, tarifa.getAliquota_ICMS());
            // Qual id do registro que vai ser atualizado
            pstm.setInt(6, tarifa.getId());

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

    public List<Tarifa> ReadTarifa(){

        String sql = "SELECT * FROM tarifa";

        List<Tarifa> tarifas = new ArrayList<Tarifa>();

        Connection conn = null;
        PreparedStatement pstm = null;
        // recuper os dados do banco
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                Tarifa tarifa = new Tarifa();
                //Pegar o id
                tarifa.setId(rset.getInt("id"));
                tarifa.setTaxa(rset.getString("taxa"));
                tarifa.setClasse_id(rset.getInt("classe_id"));
                tarifa.setLei(rset.getString("lei"));
                tarifa.setData_inicio(rset.getString("data_inicio"));
                tarifa.setData_fim(rset.getString("data_fim"));
                tarifa.setAliquota_ICMS(rset.getString("aliquota_ICMS"));

                tarifas.add(tarifa);
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
        return tarifas;
    }
}
