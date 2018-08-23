/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import modelo.Cidade;
import modelo.CidadeTableModel;
import remoto.ICidadeService;
import util.DataUtil;
import view.CidadeEditarTela;
import view.CidadePrincipalTela;

/**
 *
 * @author Aluno
 */
public class CidadeController {
    private Cidade cidade = new Cidade();
    private List<Cidade> cidades = new ArrayList<>();
    private ICidadeService service;
    
//CONSTRUTOR
    public CidadeController() {
        try {
            this.service = (ICidadeService) Naming.lookup("rmi://localhost:1099/CidadeService");
            
            
        } catch (NotBoundException ex) {
            System.out.println("Não suportada operação remota");
        } catch (MalformedURLException ex) {
            System.out.println("URL não correta");
        } catch (RemoteException ex) {
            System.out.println("Erro de classe remota");
        }
    }
    
    
// GETTERS E SETTERS DE  CIDADES E CIDADE    
    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
    
    public void setCidade(Cidade c) {
       this.cidade = c;
    }

    public Cidade getCidade() {
        return this.cidade;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

//CARREGA TABELA E LISTA DE CIDADES    
    public TableModel carregaTabela(){
        CidadeTableModel tableModel = new CidadeTableModel(this.cidades);
        return tableModel;
    }
    
    public void carregaCidades(){
        try {
            this.cidades = service.listarCidade();
        } catch (RemoteException ex) {
            Logger.getLogger(CidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//OPERAÇÕES BÁSICAS
    public boolean inserir(){
        try {
            service.insereCidade(cidade);
        } catch (RemoteException ex) {
            Logger.getLogger(CidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public boolean excluir() {
        
        try {
            service.removerCidade(cidade);
        } catch (RemoteException ex) {
            Logger.getLogger(CidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
    
    public boolean busca(String busca){
        try {
            this.cidades.clear();
            this.cidades = service.consultaCidade(busca);
           
            
            
        } catch (RemoteException ex) {
            Logger.getLogger(CidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean editar() {
        try {
            service.alterarCidade(this.cidade);
        } catch (RemoteException ex) {
            Logger.getLogger(CidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
