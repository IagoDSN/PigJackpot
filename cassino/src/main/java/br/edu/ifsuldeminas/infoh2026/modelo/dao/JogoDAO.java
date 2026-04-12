/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.modelo.dao;

import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Jogo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 13410289682
 */
public class JogoDAO extends GenericoDAO<Jogo> {

    public void salvar(Jogo objJogo) {
        String sql = "INSERT INTO JOGO(NOME, TIPO, DESCRICAO) VALUES(?,?,?)";
        save(sql, objJogo.getNome(), 
                  objJogo.getTipo(), 
                  objJogo.getDescricao());
    }

    public void alterar(Jogo objJogo) {
        String sql = "UPDATE JOGO SET NOME = ?, TIPO = ?, DESCRICAO = ? WHERE ID_JOGO = ?";
        save(sql, objJogo.getNome(), 
                  objJogo.getTipo(), 
                  objJogo.getDescricao(), 
                  objJogo.getId_jogo());
    }

    public void excluir(Jogo objJogo) {
        String sql = "DELETE FROM JOGO WHERE ID_JOGO = ?";
        save(sql, objJogo.getId_jogo());
    }

    private static class JogoRowMapper implements RowMapper<Jogo> {

        @Override
        public Jogo mapRow(ResultSet rs) throws SQLException {
            Jogo objJogo = new Jogo();
            objJogo.setId_jogo(rs.getInt("ID_JOGO"));
            objJogo.setNome(rs.getString("NOME"));
            objJogo.setTipo(rs.getString("TIPO"));
            objJogo.setDescricao(rs.getString("DESCRICAO"));
            
            return objJogo;
        }
    }

    public List<Jogo> buscarTodosJogos() {
        String sql = "SELECT * FROM JOGO";
        return buscarTodos(sql, new JogoRowMapper());
    }

    public Jogo buscarJogoPorId(int id) {
        String sql = "SELECT * FROM JOGO WHERE ID_JOGO = ?";
        return buscarPorId(sql, new JogoRowMapper(), id);
    }
}
