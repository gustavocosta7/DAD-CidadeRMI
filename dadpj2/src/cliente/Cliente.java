/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import remoto.ICidadeService;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class Cliente {
     public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException{
        ICidadeService servico = (ICidadeService) Naming.lookup("rmi://localhost:1099/CidadeService");
        
    }
}