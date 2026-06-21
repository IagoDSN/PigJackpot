/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.modelo.dao;

import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Aposta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Iagod
 */

public class ApostaDAO extends GenericoDAO<Aposta> {

    public void salvar(Aposta objAposta) {

        String sql = "INSERT INTO APOSTA(VALOR, RESULTADO, ID_PARTIDA) "
                   + "VALUES(?,?,?)";

        save(sql,
                objAposta.getValor(),
                objAposta.getResultado(),
                objAposta.getPartida().getId_partida());
    }

    public void alterar(Aposta objAposta) {

        String sql = "UPDATE APOSTA "
                   + "SET VALOR=?, RESULTADO=?, ID_PARTIDA=? "
                   + "WHERE ID_APOSTA=?";

        save(sql,
                objAposta.getValor(),
                objAposta.getResultado(),
                objAposta.getPartida().getId_partida(),
                objAposta.getId_aposta());
    }

    public void excluir(Aposta objAposta) {

        String sql = "DELETE FROM APOSTA "
                   + "WHERE ID_APOSTA=?";

        save(sql, objAposta.getId_aposta());
    }

    private static class ApostaRowMapper implements RowMapper<Aposta> {

        PartidaDAO partidaDao = new PartidaDAO();

        @Override
        public Aposta mapRow(ResultSet rs) throws SQLException {

            Aposta objAposta = new Aposta();

            objAposta.setId_aposta(
                    rs.getInt("ID_APOSTA"));

            objAposta.setValor(
                    rs.getDouble("VALOR"));

            objAposta.setResultado(
                    rs.getString("RESULTADO"));

            objAposta.setPartida(
                    partidaDao.buscarPartidaPorId(
                            rs.getInt("ID_PARTIDA"))
            );

            return objAposta;
        }
    }

    public List<Aposta> buscarTodasApostas() {

        String sql = "SELECT * FROM APOSTA";

        return buscarTodos(sql, new ApostaRowMapper());
    }

    public Aposta buscarApostaPorId(int id) {

        String sql = "SELECT * FROM APOSTA "
                   + "WHERE ID_APOSTA = ?";

        return buscarPorId(sql, new ApostaRowMapper(), id);
    }

}
