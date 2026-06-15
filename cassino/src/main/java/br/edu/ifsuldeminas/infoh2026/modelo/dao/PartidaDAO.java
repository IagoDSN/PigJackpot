/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.modelo.dao;

import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Partida;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 13410289682
 */

public class PartidaDAO extends GenericoDAO<Partida> {

    public void salvar(Partida objPartida) {

        String sql = "INSERT INTO PARTIDA(DATA, RESULTADO, ID_USUARIO, ID_JOGO) "
                   + "VALUES(?,?,?,?)";

        save(sql,
                objPartida.getData(),
                objPartida.getResultado(),
                objPartida.getUsuario().getId_usuario(),
                objPartida.getJogo().getId_jogo());
    }

    public void alterar(Partida objPartida) {

        String sql = "UPDATE PARTIDA "
                   + "SET DATA=?, RESULTADO=?, ID_USUARIO=?, ID_JOGO=? "
                   + "WHERE ID_PARTIDA=?";

        save(sql,
                objPartida.getData(),
                objPartida.getResultado(),
                objPartida.getUsuario().getId_usuario(),
                objPartida.getJogo().getId_jogo(),
                objPartida.getId_partida());
    }

    public void excluir(Partida objPartida) {

        String sql = "DELETE FROM PARTIDA "
                   + "WHERE ID_PARTIDA=?";

        save(sql, objPartida.getId_partida());
    }

    private static class PartidaRowMapper implements RowMapper<Partida> {

        UsuarioDAO usuarioDao = new UsuarioDAO();
        JogoDAO jogoDao = new JogoDAO();

        @Override
        public Partida mapRow(ResultSet rs) throws SQLException {

            Partida objPartida = new Partida();

            objPartida.setId_partida(
                    rs.getInt("ID_PARTIDA"));

            objPartida.setData(
                    rs.getDate("DATA"));

            objPartida.setResultado(
                    rs.getString("RESULTADO"));

            objPartida.setUsuario(
                    usuarioDao.buscarUsuarioPorId(
                            rs.getInt("ID_USUARIO"))
            );

            objPartida.setJogo(
                    jogoDao.buscarJogoPorId(
                            rs.getInt("ID_JOGO"))
            );

            return objPartida;
        }
    }

    public List<Partida> buscarTodasPartidas() {

        String sql = "SELECT * FROM PARTIDA";

        return buscarTodos(sql, new PartidaRowMapper());
    }

    public Partida buscarPartidaPorId(int id) {

        String sql = "SELECT * FROM PARTIDA "
                   + "WHERE ID_PARTIDA = ?";

        return buscarPorId(sql, new PartidaRowMapper(), id);
    }
}