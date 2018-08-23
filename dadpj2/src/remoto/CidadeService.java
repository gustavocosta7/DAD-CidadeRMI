/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import dao.CidadeDAO;
import dao.EstadoDAO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cidade;
import modelo.Estado;

/**
 *
 * @author Aluno
 */
public class CidadeService extends UnicastRemoteObject implements ICidadeService{

    public CidadeService() throws RemoteException{
        super();
    }
    
    

    @Override
    public void insereCidade(Cidade c) {
        CidadeDAO dao = new CidadeDAO();
        dao.insereCidade(c);
        
    }

    @Override
    public void removerCidade(Cidade c) {
        
        CidadeDAO dao = new CidadeDAO();
        dao.removerCidade(c);
    }

    @Override
    public void alterarCidade(Cidade c) {
        
        CidadeDAO dao = new CidadeDAO();
        dao.alterarCidade(c);
     }

    @Override
    public List<Cidade> consultaCidade(String pesquisa) throws RemoteException {
        
        CidadeDAO dao = new CidadeDAO();
        return dao.consultaCidade(pesquisa);
        
        
     }

    @Override
    public List<Estado> listarEstado() {
        List<Estado>estados = new ArrayList<>();
        EstadoDAO dao = new EstadoDAO();
        try {
            estados =  dao.listarEstados();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()+ex.getLocalizedMessage());
        }
        
        return estados;
    }

    @Override
    public List<Cidade> listarCidade() throws RemoteException {
        List<Cidade>cidades = new ArrayList<>();
        CidadeDAO dao = new CidadeDAO();
        try {
            cidades = dao.listarCidades();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()+ex.getLocalizedMessage());
        }
        
        return cidades;
    
    }
    
    
        
    
}
