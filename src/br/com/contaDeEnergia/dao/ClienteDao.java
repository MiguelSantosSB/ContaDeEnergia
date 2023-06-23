package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Cliente;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClienteDao {
    public void create(Cliente cliente){
        String sql = "INSERT INTO cliente(num_documento, num_cliente) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cliente.getNum_documento());
            pstm.setString(2, cliente.getNum_cliente());

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
}
