/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.modelo.dao;

import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 13410289682
 */
public class UsuarioDAO extends GenericoDAO<Usuario> {

    public void salvar(Usuario objUsuario) {
        String sql = "INSERT INTO USUARIO(NOME, SENHA, EMAIL, ENDERECO, CPF, DATA_CADASTRO, DATA_NASCIMENTO) VALUES(?,?,?,?,?,?,?)";
        save(sql, objUsuario.getNome(), 
                  objUsuario.getSenha(), 
                  objUsuario.getEmail(), 
                  objUsuario.getEndereco(), 
                  objUsuario.getCpf(), 
                  objUsuario.getData_cadastro(), 
                  objUsuario.getDataNascimento());
    }

    public void alterar(Usuario objUsuario) {
        String sql = "UPDATE USUARIO SET NOME = ?, SENHA = ?, EMAIL = ?, ENDERECO = ?, CPF = ?, DATA_CADASTRO = ?, DATA_NASCIMENTO = ? WHERE ID_USUARIO = ?";
        save(sql, objUsuario.getNome(), 
                  objUsuario.getSenha(), 
                  objUsuario.getEmail(), 
                  objUsuario.getEndereco(), 
                  objUsuario.getCpf(), 
                  objUsuario.getData_cadastro(), 
                  objUsuario.getDataNascimento(), 
                  objUsuario.getId_usuario());
    }

    public void excluir(Usuario objUsuario) {
        String sql = "DELETE FROM USUARIO WHERE ID_USUARIO = ?";
        save(sql, objUsuario.getId_usuario());
    }

    private static class UsuarioRowMapper implements RowMapper<Usuario> {

        @Override
        public Usuario mapRow(ResultSet rs) throws SQLException {
            Usuario objUsuario = new Usuario();
            objUsuario.setId_usuario(rs.getInt("ID_USUARIO"));
            objUsuario.setNome(rs.getString("NOME"));
            objUsuario.setSenha(rs.getString("SENHA"));
            objUsuario.setEmail(rs.getString("EMAIL"));
            objUsuario.setEndereco(rs.getString("ENDERECO"));
            objUsuario.setCpf(rs.getString("CPF"));
            objUsuario.setData_cadastro(rs.getDate("DATA_CADASTRO"));
            objUsuario.setDataNascimento(rs.getDate("DATA_NASCIMENTO"));
            
            System.out.println("Mapeando o objeto usuario: " + objUsuario.toString());
            return objUsuario;
        }
    }

    public List<Usuario> buscarTodosUsuarios() {
        String sql = "SELECT * FROM USUARIO";
        return buscarTodos(sql, new UsuarioRowMapper());
    }

    public Usuario buscarUsuarioPorId(int id) {
        String sql = "SELECT * FROM USUARIO WHERE ID_USUARIO = ?";
        return buscarPorId(sql, new UsuarioRowMapper(), id);
    }
}