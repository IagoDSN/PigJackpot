/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.modelo.dao;

import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Conquista;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 13410289682
 */
public class ConquistaDAO extends GenericoDAO<Conquista> {

    public void salvar(Conquista objConquista) {
        String sql = "INSERT INTO CONQUISTA(NOME, DESCRICAO, RECOMPENSA) VALUES(?,?,?)";
        save(sql, objConquista.getNome(), 
                  objConquista.getDescricao(), 
                  objConquista.getRecompensa());
    }

    public void alterar(Conquista objConquista) {
        String sql = "UPDATE CONQUISTA SET NOME = ?, DESCRICAO = ?, RECOMPENSA = ? WHERE ID_CONQUISTA = ?";
        save(sql, objConquista.getNome(), 
                  objConquista.getDescricao(), 
                  objConquista.getRecompensa(), 
                  objConquista.getId_conquista());
    }

    public void excluir(Conquista objConquista) {
        String sql = "DELETE FROM CONQUISTA WHERE ID_CONQUISTA = ?";
        save(sql, objConquista.getId_conquista());
    }

    private static class ConquistaRowMapper implements RowMapper<Conquista> {

        @Override
        public Conquista mapRow(ResultSet rs) throws SQLException {
            Conquista objConquista = new Conquista();
            objConquista.setId_conquista(rs.getInt("ID_CONQUISTA"));
            objConquista.setNome(rs.getString("NOME"));
            objConquista.setDescricao(rs.getString("DESCRICAO"));
            objConquista.setRecompensa(rs.getDouble("RECOMPENSA"));
            
            System.out.println("Mapeando o objeto conquista: " + objConquista.toString());
            return objConquista;
        }
    }

    public List<Conquista> buscarTodasConquistas() {
        String sql = "SELECT * FROM CONQUISTA";
        return buscarTodos(sql, new ConquistaRowMapper());
    }

    public Conquista buscarConquistaPorId(int id) {
        String sql = "SELECT * FROM CONQUISTA WHERE ID_CONQUISTA = ?";
        return buscarPorId(sql, new ConquistaRowMapper(), id);
    }
}