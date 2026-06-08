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
public class SaqueDAO extends GenericoDAO<Saque> {

    public void salvar(Saque objSaque) {
        String sql = "INSERT INTO SAQUE(DATA, VALOR_TOTAL, ID_USUARIO) VALUES(?,?,?)";

        save(sql,
                objSaque.getData(),
                objSaque.getValor_total(),
                objSaque.getUsuario().getId_usuario());
    }

    public void alterar(Saque objSaque) {
        String sql = "UPDATE SAQUE "
                + "SET DATA=?, VALOR_TOTAL=?, ID_USUARIO=? "
                + "WHERE ID_SAQUE=?";

        save(sql,
                objSaque.getData(),
                objSaque.getValor_total(),
                objSaque.getUsuario().getId_usuario(),
                objSaque.getId_saque());
    }

    public void excluir(Saque objSaque) {
        String sql = "DELETE FROM SAQUE WHERE ID_SAQUE=?";

        save(sql, objSaque.getId_saque());
    }

    private static class SaqueRowMapper implements RowMapper<Saque> {

        UsuarioDAO usuarioDao = new UsuarioDAO();

        @Override
        public Saque mapRow(ResultSet rs) throws SQLException {

            Saque objSaque = new Saque();

            objSaque.setId_saque(rs.getInt("ID_SAQUE"));
            objSaque.setData(rs.getDate("DATA"));
            objSaque.setValor_total(rs.getDouble("VALOR_TOTAL"));

            objSaque.setUsuario(
                    usuarioDao.buscarUsuarioPorId(
                            rs.getInt("ID_USUARIO")
                    )
            );

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