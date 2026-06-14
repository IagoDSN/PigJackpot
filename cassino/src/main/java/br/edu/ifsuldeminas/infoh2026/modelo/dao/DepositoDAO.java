/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.modelo.dao;

import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Deposito;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Iagod
 */
public class DepositoDAO extends GenericoDAO<Deposito> {

    public void salvar(Deposito objDeposito) {

        String sql = "INSERT INTO DEPOSITO(DATA, VALOR_TOTAL, ID_USUARIO) "
                   + "VALUES(?,?,?)";

        save(sql,
                objDeposito.getData(),
                objDeposito.getValor_total(),
                objDeposito.getUsuario().getId_usuario());
    }

    public void alterar(Deposito objDeposito) {

        String sql = "UPDATE DEPOSITO "
                   + "SET DATA=?, VALOR_TOTAL=?, ID_USUARIO=? "
                   + "WHERE ID_DEPOSITO=?";

        save(sql,
                objDeposito.getData(),
                objDeposito.getValor_total(),
                objDeposito.getUsuario().getId_usuario(),
                objDeposito.getId_deposito());
    }

    public void excluir(Deposito objDeposito) {

        String sql = "DELETE FROM DEPOSITO "
                   + "WHERE ID_DEPOSITO=?";

        save(sql, objDeposito.getId_deposito());
    }

    private static class DepositoRowMapper implements RowMapper<Deposito> {

        UsuarioDAO usuarioDao = new UsuarioDAO();

        @Override
        public Deposito mapRow(ResultSet rs) throws SQLException {

            Deposito objDeposito = new Deposito();

            objDeposito.setId_deposito(
                    rs.getInt("ID_DEPOSITO"));

            objDeposito.setData(
                    rs.getDate("DATA"));

            objDeposito.setValor_total(
                    rs.getDouble("VALOR_TOTAL"));

            objDeposito.setUsuario(
                    usuarioDao.buscarUsuarioPorId(
                            rs.getInt("ID_USUARIO"))
            );

            return objDeposito;
        }
    }

    public List<Deposito> buscarTodosDepositos() {

        String sql = "SELECT * FROM DEPOSITO";

        return buscarTodos(sql, new DepositoRowMapper());
    }

    public Deposito buscarDepositoPorId(int id) {

        String sql = "SELECT * FROM DEPOSITO "
                   + "WHERE ID_DEPOSITO = ?";

        return buscarPorId(sql, new DepositoRowMapper(), id);
    }
}
