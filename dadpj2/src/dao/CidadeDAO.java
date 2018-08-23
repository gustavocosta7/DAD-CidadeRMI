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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.Cidade;
import modelo.Estado;

/**
 *
 * @author Aluno
 */
public class CidadeDAO {
    
    private final Connection conexao;
    
    public CidadeDAO() {
        conexao = FabricaConexao.getConnection();
    }

    /*cidid
    cidid int not null auto_increment,
    cidestid int not null,
    
    cidpopulacao long not null,
    cidfundacao date,
    cidibge int not null,
     */
    public void insereCidade(Cidade c) {
        
        String sql = "INSERT INTO CIDADE (cidestid, cidnome, cidpopulacao, cidfundacao, cidibge) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, c.getEstado().getId());
            ps.setString(2, c.getNome());
            ps.setLong(3, c.getPopulacao());
            ps.setDate(4, new java.sql.Date(c.getFundacao().getTimeInMillis()));
            ps.setInt(5,c.getIbge());
            ps.execute();
            conexao.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void removerCidade(Cidade c) {
        
        try {
            String ref = "DELETE FROM cidade WHERE cidid=?";
            PreparedStatement intencao = conexao.prepareStatement(ref);
            intencao.setInt(1, c.getId());
            intencao.execute();
        } catch (SQLException ex) {
            System.out.println("não conectado");
        } 
        
    }
    
    public void alterarCidade(Cidade c) {
        
         try {
            
            String sql="UPDATE cidade SET cidnome=?, cidpopulacao=?, cidfundacao=?, cidibge=?, cidestid=? WHERE cidid=?";
            PreparedStatement instrucao=conexao.prepareStatement(sql);
            
            instrucao.setString(1, c.getNome());
            instrucao.setLong(2, c.getPopulacao());
            instrucao.setDate(3, new java.sql.Date(c.getFundacao().getTimeInMillis()));
            instrucao.setInt(4, c.getIbge());
            instrucao.setInt(5, c.getEstado().getId());
            instrucao.setInt(6, c.getId());
            instrucao.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        
    }
    
    public List<Cidade> consultaCidade(String pesquisa) {
        List<Cidade> cid = new ArrayList<>();
        try {
            
            String sql = "SELECT cidid,cidnome, cidpopulacao, cidfundacao, cidibge, cidestid FROM cidade WHERE cidnome LIKE ?";
            
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setString(1, "%"+pesquisa+"%");
            ResultSet resultados = instrucao.executeQuery();
            
            while (resultados.next()) {
                Cidade c = new Cidade();
                c.setId(resultados.getInt("cidid"));
                c.setNome(resultados.getString("cidnome"));
                c.setPopulacao(resultados.getLong("cidpopulacao"));
                
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                format.format(resultados.getDate("cidfundacao"));
                c.setFundacao(format.getCalendar());
                c.setIbge(resultados.getInt("cidibge"));
                
                c.setEstado(new EstadoDAO().pesquisaEstadoId(new Estado(resultados.getInt("cidestid"),"", 0)));
                cid.add(c);
            } 
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return cid;
    }
    
    public List<Estado> listarEstados() throws SQLException {
        
        return new EstadoDAO().listarEstados();
        
    }
    
    
     public List<Cidade> listarCidades() throws SQLException {
        List<Cidade> cidades = new ArrayList<>();
        
        try {
            
            String sql="SELECT cidid, cidnome, cidpopulacao, cidfundacao, cidibge, cidestid FROM cidade";
            PreparedStatement instrucao=conexao.prepareStatement(sql);
            
            ResultSet resultados=instrucao.executeQuery();
            while(resultados.next()){
                Cidade c = new Cidade();
                c.setId(resultados.getInt("cidid"));
                c.setNome(resultados.getString("cidnome"));
                c.setPopulacao(resultados.getLong("cidpopulacao"));
                c.setIbge(resultados.getInt("cidibge"));
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                format.format(resultados.getDate("cidfundacao"));
                c.setFundacao(format.getCalendar());
                c.setEstado(new EstadoDAO().pesquisaEstado(new Estado(resultados.getInt("cidestid"), "", 0)));
                
                cidades.add(c);
            }
          
        } catch (SQLException ex) {
            System.out.println("Erro BD");
            return null;
        }
        return cidades;
    }
        
        
    
}

