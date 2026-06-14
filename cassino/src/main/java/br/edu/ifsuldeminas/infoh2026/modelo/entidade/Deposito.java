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
public class Deposito {
    private Integer id_deposito;
    private Date data;
    private Double valor_total;
    private Usuario usuario = new Usuario();

    public Integer getId_deposito() {
        return id_deposito;
    }

    public void setId_deposito(Integer id_deposito) {
        this.id_deposito = id_deposito;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
