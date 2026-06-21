/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.modelo.entidade;

/**
 *
 * @author Iagod
 */
public class Bonus {
   private Integer id_bonus;
   private double valor;
   private String tipo;
   
   private Usuario usuario = new Usuario();

    public Integer getId_bonus() {
        return id_bonus;
    }

    public void setId_bonus(Integer id_bonus) {
        this.id_bonus = id_bonus;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
   
   
}
