package servico;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import remoto.CidadeService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class ServicoDeNomes {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        
        LocateRegistry.createRegistry(1099);
        Naming.rebind("CidadeService",new CidadeService());
        System.out.println("Serviço de nomes executando...");
        
    }
    
}
