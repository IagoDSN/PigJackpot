/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.modelo.dao;

import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Carteira;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Iagod
 */

public class CarteiraDAO extends GenericoDAO<Carteira> {

    public void salvar(Carteira objCarteira) {

        String sql = "INSERT INTO CARTEIRA(SALDO, ID_USUARIO) VALUES(?,?)";

        save(sql,
                objCarteira.getSaldo(),
                objCarteira.getUsuario().getId_usuario());
    }

    public void alterar(Carteira objCarteira) {

        String sql = "UPDATE CARTEIRA "
                + "SET SALDO=?, ID_USUARIO=? "
                + "WHERE ID_CARTEIRA=?";

        save(sql,
                objCarteira.getSaldo(),
                objCarteira.getUsuario().getId_usuario(),
                objCarteira.getId_carteira());
    }

    public void excluir(Carteira objCarteira) {

        String sql = "DELETE FROM CARTEIRA WHERE ID_CARTEIRA=?";

        save(sql, objCarteira.getId_carteira());
    }

    private static class CarteiraRowMapper implements RowMapper<Carteira> {

        UsuarioDAO usuarioDao = new UsuarioDAO();

        @Override
        public Carteira mapRow(ResultSet rs) throws SQLException {

            Carteira objCarteira = new Carteira();

            objCarteira.setId_carteira(
                    rs.getInt("ID_CARTEIRA"));

            objCarteira.setSaldo(
                    rs.getDouble("SALDO"));

            objCarteira.setUsuario(
                    usuarioDao.buscarUsuarioPorId(
                            rs.getInt("ID_USUARIO")
                    )
            );

            return objCarteira;
        }
    }

    public List<Carteira> buscarTodasCarteiras() {

        String sql = "SELECT * FROM CARTEIRA";

        return buscarTodos(sql, new CarteiraRowMapper());
    }

    public Carteira buscarCarteiraPorId(int id) {

        String sql = "SELECT * FROM CARTEIRA WHERE ID_CARTEIRA = ?";

        return buscarPorId(sql, new CarteiraRowMapper(), id);
    }

}