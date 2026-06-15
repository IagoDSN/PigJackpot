/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.modelo.entidade;

import java.sql.Date;

/**
 *
 * @author 13410289682
 */
public class Partida {
    private Integer id_partida;
    private Date data;
    private String resultado;
    
    private Usuario usuario = new Usuario();
    private Jogo jogo = new Jogo();

    public Integer getId_partida() {
        return id_partida;
    }

    public void setId_partida(Integer id_partida) {
        this.id_partida = id_partida;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
    
    
    
}
