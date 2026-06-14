/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.modelo.dao;

import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Transacao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 12409864678
 */
public class TransacaoDAO extends GenericoDAO<Transacao> {

    public void salvar(Transacao objTransacao) {
        String sql = "INSERT INTO TRANSACAO(VALOR, TIPO, DATA, ID_USUARIO) VALUES(?,?,?,?)";

        save(sql,
                objTransacao.getValor(),
                objTransacao.getTipo(),
                objTransacao.getData(),
                objTransacao.getUsuario().getId_usuario());
    }

    public void alterar(Transacao objTransacao) {
        String sql = "UPDATE TRANSACAO "
                + "SET VALOR=?, TIPO=?, DATA=?, ID_USUARIO=? "
                + "WHERE ID_TRANSACAO=?";

        save(sql,
                objTransacao.getValor(),
                objTransacao.getTipo(),
                objTransacao.getData(),
                objTransacao.getUsuario().getId_usuario(),
                objTransacao.getId_transacao());
    }

    public void excluir(Transacao objTransacao) {
        String sql = "DELETE FROM TRANSACAO WHERE ID_TRANSACAO=?";

        save(sql, objTransacao.getId_transacao());
    }

    private static class TransacaoRowMapper implements RowMapper<Transacao> {

        UsuarioDAO usuarioDao = new UsuarioDAO();

        @Override
        public Transacao mapRow(ResultSet rs) throws SQLException {

            Transacao objTransacao = new Transacao();

            objTransacao.setId_transacao(
                    rs.getInt("ID_TRANSACAO"));

            objTransacao.setValor(
                    rs.getDouble("VALOR"));

            objTransacao.setTipo(
                    rs.getString("TIPO"));

            objTransacao.setData(
                    rs.getDate("DATA"));

            objTransacao.setUsuario(
                    usuarioDao.buscarUsuarioPorId(
                            rs.getInt("ID_USUARIO")
                    )
            );

            return objTransacao;
        }
    }

    public List<Transacao> buscarTodasTransacoes() {
        String sql = "SELECT * FROM TRANSACAO";
        return buscarTodos(sql, new TransacaoRowMapper());
    }

    public Transacao buscarTransacaoPorId(int id) {
        String sql = "SELECT * FROM TRANSACAO WHERE ID_TRANSACAO = ?";
        return buscarPorId(sql, new TransacaoRowMapper(), id);
    }
}