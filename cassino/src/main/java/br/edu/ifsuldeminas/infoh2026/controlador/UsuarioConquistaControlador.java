/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.controlador;

import br.edu.ifsuldeminas.infoh2026.modelo.dao.UsuarioConquistaDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.dao.UsuarioDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.dao.ConquistaDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.UsuarioConquista;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Usuario;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Conquista;
import br.edu.ifsuldeminas.infoh2026.servico.WebConstante;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Iagod
 */

@WebServlet(WebConstante.BASE_PATH + "/UsuarioConquistaControlador")
public class UsuarioConquistaControlador extends HttpServlet {

    UsuarioConquista objUsuarioConquista;
    UsuarioDAO objUsuarioDao;
    ConquistaDAO objConquistaDao;
    UsuarioConquistaDAO objUsuarioConquistaDao;

    String idUsuarioConquista = "";
    String dataConquista = "";
    String usuarioConquista = "";
    String conquistaUsuario = "";
    String opcao = "";

    @Override
    public void init() throws ServletException {

        objUsuarioDao = new UsuarioDAO();
        objConquistaDao = new ConquistaDAO();
        objUsuarioConquista = new UsuarioConquista();
        objUsuarioConquistaDao = new UsuarioConquistaDAO();

    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            opcao = request.getParameter("opcao");

            if (opcao == null || opcao.isEmpty()) {
                opcao = "cadastrar";
            }

            idUsuarioConquista = request.getParameter("idUsuarioConquista");
            dataConquista = request.getParameter("dataConquista");
            usuarioConquista = request.getParameter("usuarioConquista");
            conquistaUsuario = request.getParameter("conquistaUsuario");

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
                    throw new IllegalArgumentException("Opção inválida " + opcao);
            }

        } catch (NumberFormatException e) {

            response.getWriter().println(
                    "Erro: parâmetro inválido. " + e.getMessage());

        } catch (IllegalArgumentException e) {

            response.getWriter().println("Erro: " + e.getMessage());

        }

    }

    private void cadastrar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        objUsuarioConquista.setData_conquista(
                java.sql.Date.valueOf(dataConquista));

        objUsuarioConquista.getUsuario()
                .setId_usuario(Integer.valueOf(usuarioConquista));

        objUsuarioConquista.getConquista()
                .setId_conquista(Integer.valueOf(conquistaUsuario));

        objUsuarioConquistaDao.salvar(objUsuarioConquista);

        request.setAttribute("mensagem",
                "Usuário conquista cadastrado com sucesso!");

        encaminharParaPagina(request, response);
    }

    private void enviarAlterar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("idUsuarioConquista", idUsuarioConquista);
        request.setAttribute("dataConquista", dataConquista);
        request.setAttribute("usuarioConquista", usuarioConquista);
        request.setAttribute("conquistaUsuario", conquistaUsuario);

        request.setAttribute("opcao", "confirmarAlterar");
        request.setAttribute("mensagem",
                "Edite os dados e clique em Salvar");

        encaminharParaPagina(request, response);
    }

    private void enviarExcluir(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("idUsuarioConquista", idUsuarioConquista);
        request.setAttribute("dataConquista", dataConquista);
        request.setAttribute("usuarioConquista", usuarioConquista);
        request.setAttribute("conquistaUsuario", conquistaUsuario);

        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("mensagem",
                "Confirme os dados e clique em Salvar para excluir");

        encaminharParaPagina(request, response);
    }

    private void confirmarAlterar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        objUsuarioConquista.setId_usuarioConquista(
                Integer.valueOf(idUsuarioConquista));

        objUsuarioConquista.setData_conquista(
                java.sql.Date.valueOf(dataConquista));

        objUsuarioConquista.getUsuario()
                .setId_usuario(Integer.valueOf(usuarioConquista));

        objUsuarioConquista.getConquista()
                .setId_conquista(Integer.valueOf(conquistaUsuario));

        objUsuarioConquistaDao.alterar(objUsuarioConquista);

        encaminharParaPagina(request, response);
    }

    private void confirmarExcluir(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        objUsuarioConquista.setId_usuarioConquista(
                Integer.valueOf(idUsuarioConquista));

        objUsuarioConquistaDao.excluir(objUsuarioConquista);

        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Usuario> listaUsuario =
                objUsuarioDao.buscarTodosUsuarios();
        request.setAttribute("listaUsuario", listaUsuario);

        List<Conquista> listaConquista =
                objConquistaDao.buscarTodasConquistas();
        request.setAttribute("listaConquista", listaConquista);

        List<UsuarioConquista> listaUsuarioConquista =
                objUsuarioConquistaDao.buscarTodasUsuarioConquistas();
        request.setAttribute("listaUsuarioConquista", listaUsuarioConquista);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/CadastroUsuarioConquista.jsp");

        dispatcher.forward(request, response);
    }

    private void cancelar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("idUsuarioConquista", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("dataConquista", "");
        request.setAttribute("usuarioConquista", "");
        request.setAttribute("conquistaUsuario", "");

        encaminharParaPagina(request, response);
    }
}
