/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.modelo.dao;

import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Bonus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Iagod
 */

public class BonusDAO extends GenericoDAO<Bonus> {

    public void salvar(Bonus objBonus) {

        String sql = "INSERT INTO BONUS(VALOR, TIPO, ID_USUARIO) "
                + "VALUES(?,?,?)";

        save(sql,
                objBonus.getValor(),
                objBonus.getTipo(),
                objBonus.getUsuario().getId_usuario());
    }

    public void alterar(Bonus objBonus) {

        String sql = "UPDATE BONUS "
                + "SET VALOR=?, TIPO=?, ID_USUARIO=? "
                + "WHERE ID_BONUS=?";

        save(sql,
                objBonus.getValor(),
                objBonus.getTipo(),
                objBonus.getUsuario().getId_usuario(),
                objBonus.getId_bonus());
    }

    public void excluir(Bonus objBonus) {

        String sql = "DELETE FROM BONUS "
                + "WHERE ID_BONUS=?";

        save(sql, objBonus.getId_bonus());
    }

    private static class BonusRowMapper implements RowMapper<Bonus> {

        UsuarioDAO usuarioDao = new UsuarioDAO();

        @Override
        public Bonus mapRow(ResultSet rs) throws SQLException {

            Bonus objBonus = new Bonus();

            objBonus.setId_bonus(
                    rs.getInt("ID_BONUS"));

            objBonus.setValor(
                    rs.getDouble("VALOR"));

            objBonus.setTipo(
                    rs.getString("TIPO"));

            objBonus.setUsuario(
                    usuarioDao.buscarUsuarioPorId(
                            rs.getInt("ID_USUARIO"))
            );

            return objBonus;
        }
    }

    public List<Bonus> buscarTodosBonus() {

        String sql = "SELECT * FROM BONUS";

        return buscarTodos(sql, new BonusRowMapper());
    }

    public Bonus buscarBonusPorId(int id) {

        String sql = "SELECT * FROM BONUS "
                + "WHERE ID_BONUS = ?";

        return buscarPorId(sql, new BonusRowMapper(), id);
    }

}
