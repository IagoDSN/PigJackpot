/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.modelo.entidade;


/**
 *
 * @author 13410289682
 */
public class Conquista {
     private Integer id_conquista;
     private String nome, descricao;
     private double recompensa;

    public Integer getId_conquista() {
        return id_conquista;
    }

    public void setId_conquista(Integer id_conquista) {
        this.id_conquista = id_conquista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(double recompensa) {
        this.recompensa = recompensa;
    }

}
