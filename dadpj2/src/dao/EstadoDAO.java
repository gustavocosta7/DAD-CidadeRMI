/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Estado;

/**
 *
 * @author Aluno
 */
public class EstadoDAO {

    private final Connection conexao;

    public EstadoDAO() {
        conexao = FabricaConexao.getConnection();

    }
/*
    public void insereEstdo(Estado e) {
        try {

            String comando = "INSERT INTO ESTADO (estid, estnome, estsigla, estibge)VALUES(0,?,?,?)";
            PreparedStatement instrucao = conexao.prepareStatement(comando);

            instrucao.setInt(1, e.getId());
            instrucao.setString(2, e.getNome());
            instrucao.setString(2, e.getSigla());
            instrucao.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
  */  
     public List<Estado> listarEstados() throws SQLException {
        
        List<Estado> estados = new ArrayList<>();
        try {
            
            String sql="SELECT estid, estnome, estsigla, estibge FROM estado";
            PreparedStatement instrucao=conexao.prepareStatement(sql);
            
            ResultSet resultados=instrucao.executeQuery();
            while(resultados.next()){
                Estado e = new Estado();
                e.setId(resultados.getInt("estid"));
                e.setNome(resultados.getString("estnome"));
                e.setSigla(resultados.getString("estsigla"));
                e.setIbge(resultados.getInt("estibge"));
                estados.add(e);
            }
          
        } catch (SQLException ex) {
            System.out.println("não conectado");
        }
        return estados;
    }
     
     
    public Estado pesquisaEstado(Estado e){
        Estado estado = new Estado();
        try {

            String sql = "SELECT estid, estsigla, estnome, estibge FROM estado WHERE estid  = ?";

            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setInt(1,e.getId());
            ResultSet resultados = instrucao.executeQuery();

            if (resultados.next()) {
                
                estado.setId(resultados.getInt("estid"));
                estado.setSigla(resultados.getString("estsigla"));
                estado.setNome(resultados.getString("estnome"));
                estado.setIbge(resultados.getInt("estibge"));
                
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        
        return estado;

    }
    
    public Estado pesquisaEstadoId(Estado e){

        try {

            String sql = "SELECT estid, estnome, estsigla, estibge FROM estado WHERE estid = ?";

            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setInt(1, e.getId());
            ResultSet resultados = instrucao.executeQuery();

            if (resultados != null) {
                Estado estado = new Estado();
                estado.setId(resultados.getInt("estid"));
                estado.setSigla(resultados.getString("estsigla"));
                estado.setNome(resultados.getString("estnome"));
                estado.setIbge(resultados.getInt("estibge"));
                
                return estado;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar Estado no BD");
            return null;
        }

    }

}

