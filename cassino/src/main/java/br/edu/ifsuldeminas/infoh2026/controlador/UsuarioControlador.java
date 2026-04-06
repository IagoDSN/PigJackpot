/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.controlador;

import br.edu.ifsuldeminas.infoh2026.servico.WebConstante;
import br.edu.ifsuldeminas.infoh2026.modelo.dao.UsuarioDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author 13410289682
 */

@WebServlet(WebConstante.BASE_PATH + "/UsuarioControlador")
//designar uma classe como um servelts, mapeando de URL no Servidor Web(GlassFish)
public class UsuarioControlador extends HttpServlet {

    Usuario objUsuario = new Usuario();
    UsuarioDAO objUsuarioDao = new UsuarioDAO();

    String id_usuario = "";
    String nome = "";
    String senha = "";
    String email = "";
    String endereco = "";
    String cpf = "";
    String data_cadastro = "";
    String dataNascimento = "";
    String opcao = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            opcao = request.getParameter("opcao");
            if (opcao == null || opcao.isEmpty()) {
                opcao = "cadastrar";
            }

            id_usuario = request.getParameter("id_usuario");
            nome = request.getParameter("nome");
            senha = request.getParameter("senha");
            email = request.getParameter("email");
            endereco = request.getParameter("endereco");
            cpf = request.getParameter("cpf");
            data_cadastro = request.getParameter("data_cadastro");
            dataNascimento = request.getParameter("dataNascimento");

            switch (opcao) {
                case "cadastrar":
                    cadastrar(request, response);
                    break;

                case "enviarAlterar":
                    enviarAlterar(request, response);
                    break;

                case "enviarExcluir":
                    enviarExcluir(request, response);
                    break;

                case "confirmarAlterar":
                    confirmarAlterar(request, response);
                    break;

                case "confirmarExcluir":
                    confirmarExcluir(request, response);
                    break;

                case "cancelar":
                    cancelar(request, response);
                    break;

                default:
                    throw new IllegalArgumentException("Opção inválida: " + opcao);
            }

        } catch (Exception e) {
            response.getWriter().println("Erro: " + e.getMessage());
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        objUsuario.setNome(nome);
        objUsuario.setSenha(senha);
        objUsuario.setEmail(email);
        objUsuario.setEndereco(endereco);
        objUsuario.setCpf(cpf);
        objUsuario.setData_cadastro(Date.valueOf(data_cadastro));
        objUsuario.setDataNascimento(Date.valueOf(dataNascimento));

        objUsuarioDao.salvar(objUsuario);

        request.setAttribute("mensagem", "Usuário cadastrado com sucesso!");
        encaminharParaPagina(request, response);
    }

    private void enviarAlterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("id_usuario", id_usuario);
        request.setAttribute("nome", nome);
        request.setAttribute("senha", senha);
        request.setAttribute("email", email);
        request.setAttribute("endereco", endereco);
        request.setAttribute("cpf", cpf);
        request.setAttribute("data_cadastro", data_cadastro);
        request.setAttribute("dataNascimento", dataNascimento);

        request.setAttribute("opcao", "confirmarAlterar");
        request.setAttribute("mensagem", "Edite os dados e clique em salvar");

        encaminharParaPagina(request, response);
    }

    private void enviarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("id_usuario", id_usuario);
        request.setAttribute("nome", nome);

        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("mensagem", "Confirme para excluir");

        encaminharParaPagina(request, response);
    }

    private void confirmarAlterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        objUsuario.setId_usuario(Integer.valueOf(id_usuario));
        objUsuario.setNome(nome);
        objUsuario.setSenha(senha);
        objUsuario.setEmail(email);
        objUsuario.setEndereco(endereco);
        objUsuario.setCpf(cpf);
        objUsuario.setData_cadastro(Date.valueOf(data_cadastro));
        objUsuario.setDataNascimento(Date.valueOf(dataNascimento));

        objUsuarioDao.alterar(objUsuario);

        encaminharParaPagina(request, response);
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        objUsuario.setId_usuario(Integer.valueOf(id_usuario));
        objUsuarioDao.excluir(objUsuario);

        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Usuario> usuarios = objUsuarioDao.buscarTodosUsuarios();
        request.setAttribute("usuarios", usuarios);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroUsuario.jsp");
        dispatcher.forward(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("id_usuario", "0");
        request.setAttribute("nome", "");
        request.setAttribute("senha", "");
        request.setAttribute("email", "");
        request.setAttribute("endereco", "");
        request.setAttribute("cpf", "");
        request.setAttribute("data_cadastro", "");
        request.setAttribute("dataNascimento", "");
        request.setAttribute("opcao", "cadastrar");

        encaminharParaPagina(request, response);
    }
}
