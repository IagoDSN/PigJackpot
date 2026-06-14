/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.controlador;

import br.edu.ifsuldeminas.infoh2026.modelo.dao.CarteiraDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.dao.UsuarioDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Carteira;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Usuario;
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

@WebServlet(WebConstante.BASE_PATH + "/CarteiraControlador")
public class CarteiraControlador extends HttpServlet {

    Carteira objCarteira;
    UsuarioDAO objUsuarioDao;
    CarteiraDAO objCarteiraDao;

    String idCarteira = "";
    String saldoCarteira = "";
    String usuarioCarteira = "";
    String opcao = "";

    @Override
    public void init() throws ServletException {

        objUsuarioDao = new UsuarioDAO();
        objCarteira = new Carteira();
        objCarteiraDao = new CarteiraDAO();

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

            idCarteira = request.getParameter("idCarteira");
            saldoCarteira = request.getParameter("saldoCarteira");
            usuarioCarteira = request.getParameter("usuarioCarteira");

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
                    throw new IllegalArgumentException(
                            "Opção inválida " + opcao);
            }

        } catch (NumberFormatException e) {

            response.getWriter().println(
                    "Erro: um ou mais parâmetros não são números válidos. "
                    + e.getMessage());

        } catch (IllegalArgumentException e) {

            response.getWriter().println(
                    "Erro: " + e.getMessage());

        }

    }

    private void cadastrar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        objCarteira.setSaldo(
                Double.valueOf(saldoCarteira));

        objCarteira.getUsuario().setId_usuario(
                Integer.valueOf(usuarioCarteira));

        objCarteiraDao.salvar(objCarteira);

        request.setAttribute(
                "mensagem",
                "Carteira cadastrada com sucesso!");

        encaminharParaPagina(request, response);

    }

    private void enviarAlterar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "idCarteira", idCarteira);

        request.setAttribute(
                "saldoCarteira", saldoCarteira);

        request.setAttribute(
                "usuarioCarteira", usuarioCarteira);

        request.setAttribute(
                "opcao", "confirmarAlterar");

        request.setAttribute(
                "mensagem",
                "Edite os dados e clique em Salvar");

        encaminharParaPagina(request, response);

    }

    private void enviarExcluir(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "idCarteira", idCarteira);

        request.setAttribute(
                "saldoCarteira", saldoCarteira);

        request.setAttribute(
                "usuarioCarteira", usuarioCarteira);

        request.setAttribute(
                "opcao", "confirmarExcluir");

        request.setAttribute(
                "mensagem",
                "Confirme os dados e clique em Salvar para excluir");

        encaminharParaPagina(request, response);

    }

    private void confirmarAlterar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        objCarteira.setId_carteira(
                Integer.valueOf(idCarteira));

        objCarteira.setSaldo(
                Double.valueOf(saldoCarteira));

        objCarteira.getUsuario().setId_usuario(
                Integer.valueOf(usuarioCarteira));

        objCarteiraDao.alterar(objCarteira);

        encaminharParaPagina(request, response);

    }

    private void confirmarExcluir(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        objCarteira.setId_carteira(
                Integer.valueOf(idCarteira));

        objCarteiraDao.excluir(objCarteira);

        encaminharParaPagina(request, response);

    }

    private void encaminharParaPagina(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Usuario> listaUsuario =
                objUsuarioDao.buscarTodosUsuarios();

        request.setAttribute(
                "listaUsuario",
                listaUsuario);

        List<Carteira> listaCarteira =
                objCarteiraDao.buscarTodasCarteiras();

        request.setAttribute(
                "listaCarteira",
                listaCarteira);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/CadastroCarteira.jsp");

        dispatcher.forward(request, response);

    }

    private void cancelar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "idCarteira", "0");

        request.setAttribute(
                "saldoCarteira", "");

        request.setAttribute(
                "usuarioCarteira", "");

        request.setAttribute(
                "opcao", "cadastrar");

        encaminharParaPagina(request, response);

    }

}