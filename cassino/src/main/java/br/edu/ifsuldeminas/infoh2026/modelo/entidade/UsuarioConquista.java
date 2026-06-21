/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.modelo.entidade;

import java.sql.Date;

/**
 *
 * @author Iagod
 */
public class UsuarioConquista {
    
    private Integer id_usuarioConquista;
    private Date data_conquista;
    
    private Usuario usuario = new Usuario();
    private Conquista conquista = new Conquista();

    
    public Integer getId_usuarioConquista() {
        return id_usuarioConquista;
    }

    public void setId_usuarioConquista(Integer id_usuarioConquista) {
        this.id_usuarioConquista = id_usuarioConquista;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Conquista getConquista() {
        return conquista;
    }

    public void setConquista(Conquista conquista) {
        this.conquista = conquista;
    }

    public Date getData_conquista() {
        return data_conquista;
    }

    public void setData_conquista(Date data_conquista) {
        this.data_conquista = data_conquista;
    }

}
