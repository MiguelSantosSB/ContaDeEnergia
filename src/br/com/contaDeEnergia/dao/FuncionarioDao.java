package br.com.contaDeEnergia.dao;

import br.com.contaDeEnergia.Model.Funcionario;
import br.com.contaDeEnergia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {
    public void Create(Funcionario funcionario){

        String sql = "INSERT INTO funcionario(codigo_funcional, pessoa_id) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //cria conexão com o bd
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcionario.getCodigo_funcional());
            pstm.setInt(2, funcionario.getPessoa_id());


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
    public List<Funcionario> ReadFuncionario(){

        String sql = "SELECT * FROM funcionario";

        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        Connection conn = null;
        PreparedStatement pstm = null;
        // recuper os dados do banco
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                Funcionario funcionario = new Funcionario();
                //Pegar o id
                funcionario.setId(rset.getInt("id"));
                funcionario.setCodigo_funcional(rset.getString("codigo_funcional"));
                funcionario.setPessoa_id(rset.getInt("pessoa_id"));

                funcionarios.add(funcionario);
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
        return funcionarios;
    }
}
