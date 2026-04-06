/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.modelo.dao;

import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Cidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Tulio Dias
 */
public class CidadeDao extends GenericoDAO<Cidade>{
    public void salvar(Cidade objCidade){
        String sql = "INSERT INTO CIDADE(NOME, UF) VALUES(?,?)";
        save(sql, objCidade.getNomeCidade(), objCidade.getUfCidade());
        
    }
    
    public void alterar(Cidade objCidade){
        String sql = "UPDATE CIDADE SET NOME = ? , UF = ? WHERE CODIGO=?";
        save(sql, objCidade.getNomeCidade(), objCidade.getUfCidade());
        
    }
    public void excluir(Cidade objCidade){
        String sql = "DELETE FROM CIDADE WHERE CODIGO=?";
        save(sql, objCidade.getNomeCidade(), objCidade.getUfCidade());
        
    }
    
    private static class CidadeRowMapper implements RowMapper<Cidade>{

        @Override
        public Cidade mapRow(ResultSet rs) throws SQLException {
           Cidade objCidade = new Cidade();
           objCidade.setcodCidade(rs.getInt("CODIGO"));
           objCidade.setNomeCidade(rs.getString("NOME"));
           objCidade.setUfCidade(rs.getString("UF"));
           System.out.println("Mapeando o objeto cidade"+objCidade.toString());
           return objCidade;
        }
        
    }
    
    public List<Cidade> buscarTodasCidade(){
        String sql = "SELECT * FROM CIDADE";
        return buscarTodos(sql, new CidadeRowMapper());
    }
    
    public Cidade buscarCidadePorId(int id){
        String sql = "SELECT * FROM CIDADE WHERE CODIGO=? ";
        return buscarPorId(sql, new CidadeRowMapper(), id);
    }
}
