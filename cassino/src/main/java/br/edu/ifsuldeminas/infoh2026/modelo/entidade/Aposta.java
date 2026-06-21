/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.modelo.entidade;

/**
 *
 * @author Iagod
 */
public class Aposta {
 
    private Integer id_aposta;
    private double valor;
    private String resultado;
    
    private Partida partida = new Partida();

    public Integer getId_aposta() {
        return id_aposta;
    }

    public void setId_aposta(Integer id_aposta) {
        this.id_aposta = id_aposta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
    
    
}
