/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Aluno
 */
public class Cidade implements Serializable {
    private static final long serialVersion = 1L;
    private int id;
    private Estado estado;
    private String nome;
    private Long populacao;
    private Calendar fundacao;
    private int ibge;

    public Cidade(Estado estado, String nome, Long populacao, Calendar fundacao, int ibge) {
        this.estado = estado;
        this.nome = nome;
        this.populacao = populacao;
        this.fundacao = fundacao;
        this.ibge = ibge;
    }

    
    
    public Cidade() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Long populacao) {
        this.populacao = populacao;
    }

    public Calendar getFundacao() {
        return fundacao;
    }

    public void setFundacao(Calendar fundacao) {
        this.fundacao = fundacao;
    }

    public int getIbge() {
        return ibge;
    }

    public void setIbge(int ibge) {
        this.ibge = ibge;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade(int id, Long populacao, Calendar fundacao, int ibge, Estado estado) {
        this.id = id;
        this.populacao = populacao;
        this.fundacao = fundacao;
        this.ibge = ibge;
        this.estado = estado;
    }
}
