/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import modelo.Cidade;
import modelo.Estado;

/**
 *
 * @author Aluno
 */
public interface ICidadeService extends Remote{
    
   public void insereCidade(Cidade c)throws RemoteException;
   public void removerCidade(Cidade c)throws RemoteException;
   public void alterarCidade(Cidade c)throws RemoteException;
   public List<Cidade> consultaCidade(String cidade) throws RemoteException;
   public List<Estado> listarEstado()throws RemoteException;
   public List<Cidade> listarCidade()throws RemoteException;
   
}