/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.modelo.dao;

import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Saque;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 12409864678
 */
public class SaqueDAO extends GenericoDAO<Saque>{

    public void salvar(Saque objSaque) {
        String sql = "INSERT INTO SAQUE(DATA, VALOR_TOTAL) VALUES(?,?)";
        save(sql, objSaque.getData(), objSaque.getValor_total());
    }

    public void alterar(Saque objSaque) {
        String sql = "UPDATE SAQUE SET DATA=?, VALOR_TOTAL=? WHERE ID_SAQUE=?";
        save(sql, objSaque.getData(),
                objSaque.getValor_total(),
                objSaque.getId_saque());
    }

    public void excluir(Saque objSaque) {
        String sql = "DELETE FROM SAQUE WHERE ID_SAQUE=?";
        save(sql, objSaque.getId_saque());
    }

    private static class SaqueRowMapper implements RowMapper<Saque> {

        @Override
        public Saque mapRow(ResultSet rs) throws SQLException {
            Saque objSaque = new Saque();

            objSaque.setId_saque(rs.getInt("ID_SAQUE"));
            objSaque.setData(rs.getDate("DATA"));
            objSaque.setValor_total(rs.getDouble("VALOR_TOTAL"));

            return objSaque;
        }
    }

    public List<Saque> buscarTodosSaques() {
        String sql = "SELECT * FROM SAQUE";
        return buscarTodos(sql, new SaqueRowMapper());
    }

    public Saque buscarSaquePorId(int id) {
        String sql = "SELECT * FROM SAQUE WHERE ID_SAQUE = ?";
        return buscarPorId(sql, new SaqueRowMapper(), id);
    }
}
