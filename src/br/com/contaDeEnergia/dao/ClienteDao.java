package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Cliente;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
    public void Create(Cliente cliente){
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
    public void Delete(int id){
        String sql = " DELETE FROM cliente WHERE id = ?";

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

    public void Update(Cliente cliente){

        String sql = "UPDATE cliente SET num_documento = ?, num_cliente = ? "+
                "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            // Adicionar os valores para atualizar
            pstm.setString(1, cliente.getNum_documento());
            pstm.setString(2, cliente.getNum_cliente());
            // Qual id do registro que vai ser atualizado
            pstm.setInt(3, cliente.getId());

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

    public List<Cliente> ReadCliente(){

        String sql = "SELECT * FROM cliente";

        List<Cliente> clientes = new ArrayList<Cliente>();

        Connection conn = null;
        PreparedStatement pstm = null;
        // recuper os dados do banco
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
               Cliente cliente = new Cliente();
               //Pegar o id
               cliente.setId(rset.getInt("id"));
               cliente.setNum_documento(rset.getString("num_documento"));
               cliente.setNum_cliente(rset.getString("num_cliente"));

               clientes.add(cliente);
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
        return clientes;
    }
}
