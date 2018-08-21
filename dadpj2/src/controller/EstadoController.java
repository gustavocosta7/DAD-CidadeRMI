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
import modelo.Estado;
import remoto.ICidadeService;

/**
 *
 * @author Aluno
 */
public class EstadoController {
    private Estado estado = new Estado();
    List<Estado> estados = new ArrayList<>();

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public void listarEstado(){
        try {
            ICidadeService service = (ICidadeService) Naming.lookup("rmi://localhost:1099/CidadeService");
            this.estados = service.listarEstado();
            
        } catch (NotBoundException ex) {
            System.out.println("Operação não suportada, classe Estado Controller");
        } catch (MalformedURLException ex) {
            System.out.println("URL mal informada");
        } catch (RemoteException ex) {
            System.out.println("Erro de classe remota");
        }
    }
    
}
