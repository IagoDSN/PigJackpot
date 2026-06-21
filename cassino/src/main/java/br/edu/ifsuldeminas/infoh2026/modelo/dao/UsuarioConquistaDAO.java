/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.modelo.dao;

import br.edu.ifsuldeminas.infoh2026.modelo.entidade.UsuarioConquista;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Iagod
 */

public class UsuarioConquistaDAO extends GenericoDAO<UsuarioConquista> {

    public void salvar(UsuarioConquista objUsuarioConquista) {

        String sql = "INSERT INTO USUARIO_CONQUISTA(DATA_CONQUISTA, ID_USUARIO, ID_CONQUISTA) "
                   + "VALUES(?,?,?)";

        save(sql,
                objUsuarioConquista.getData_conquista(),
                objUsuarioConquista.getUsuario().getId_usuario(),
                objUsuarioConquista.getConquista().getId_conquista());
    }

    public void alterar(UsuarioConquista objUsuarioConquista) {

        String sql = "UPDATE USUARIO_CONQUISTA "
                   + "SET DATA_CONQUISTA=?, ID_USUARIO=?, ID_CONQUISTA=? "
                   + "WHERE ID_USUARIOCONQUISTA=?";

        save(sql,
                objUsuarioConquista.getData_conquista(),
                objUsuarioConquista.getUsuario().getId_usuario(),
                objUsuarioConquista.getConquista().getId_conquista(),
                objUsuarioConquista.getId_usuarioConquista());
    }

    public void excluir(UsuarioConquista objUsuarioConquista) {

        String sql = "DELETE FROM USUARIO_CONQUISTA "
                   + "WHERE ID_USUARIOCONQUISTA=?";

        save(sql, objUsuarioConquista.getId_usuarioConquista());
    }

    private static class UsuarioConquistaRowMapper implements RowMapper<UsuarioConquista> {

        UsuarioDAO usuarioDao = new UsuarioDAO();
        ConquistaDAO conquistaDao = new ConquistaDAO();

        @Override
        public UsuarioConquista mapRow(ResultSet rs) throws SQLException {

            UsuarioConquista obj = new UsuarioConquista();

            obj.setId_usuarioConquista(
                    rs.getInt("ID_USUARIOCONQUISTA"));

            obj.setData_conquista(
                    rs.getDate("DATA_CONQUISTA"));

            obj.setUsuario(
                    usuarioDao.buscarUsuarioPorId(
                            rs.getInt("ID_USUARIO"))
            );

            obj.setConquista(
                    conquistaDao.buscarConquistaPorId(
                            rs.getInt("ID_CONQUISTA"))
            );

            return obj;
        }
    }

    public List<UsuarioConquista> buscarTodasUsuarioConquistas() {

        String sql = "SELECT * FROM USUARIO_CONQUISTA";

        return buscarTodos(sql, new UsuarioConquistaRowMapper());
    }

    public UsuarioConquista buscarUsuarioConquistaPorId(int id) {

        String sql = "SELECT * FROM USUARIO_CONQUISTA "
                   + "WHERE ID_USUARIOCONQUISTA = ?";

        return buscarPorId(sql, new UsuarioConquistaRowMapper(), id);
    }
}
