/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.controlador;

import br.edu.ifsuldeminas.infoh2026.modelo.dao.DepositoDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.dao.UsuarioDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Deposito;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Usuario;
import br.edu.ifsuldeminas.infoh2026.servico.WebConstante;
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
 * @author Iagod
 */
@WebServlet(WebConstante.BASE_PATH + "/DepositoControlador")
public class DepositoControlador extends HttpServlet {

    Deposito objDeposito;
    UsuarioDAO objUsuarioDao;
    DepositoDAO objDepositoDao;

    String idDeposito = "";
    String dataDeposito = "";
    String valorTotalDeposito = "";
    String usuarioDeposito = "";
    String opcao = "";

    @Override
    public void init() throws ServletException {

        objUsuarioDao = new UsuarioDAO();
        objDeposito = new Deposito();
        objDepositoDao = new DepositoDAO();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            opcao = request.getParameter("opcao");

            if (opcao == null || opcao.isEmpty()) {
                opcao = "cadastrar";
            }

            idDeposito = request.getParameter("idDeposito");
            dataDeposito = request.getParameter("dataDeposito");
            valorTotalDeposito = request.getParameter("valorTotalDeposito");
            usuarioDeposito = request.getParameter("usuarioDeposito");

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
                    "Erro: um ou mais parâmetros não são números válidos. "
                    + e.getMessage());

        } catch (IllegalArgumentException e) {

            response.getWriter().println("Erro: " + e.getMessage());

        }

    }

    private void cadastrar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        objDeposito.setData(Date.valueOf(dataDeposito));
        objDeposito.setValor_total(Double.valueOf(valorTotalDeposito));
        objDeposito.getUsuario().setId_usuario(Integer.valueOf(usuarioDeposito));

        objDepositoDao.salvar(objDeposito);

        request.setAttribute("mensagem",
                "Depósito cadastrado com sucesso!");

        encaminharParaPagina(request, response);

    }

    private void enviarAlterar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("idDeposito", idDeposito);
        request.setAttribute("dataDeposito", dataDeposito);
        request.setAttribute("valorTotalDeposito", valorTotalDeposito);
        request.setAttribute("usuarioDeposito", usuarioDeposito);

        request.setAttribute("opcao", "confirmarAlterar");
        request.setAttribute("mensagem",
                "Edite os dados e clique em Salvar");

        encaminharParaPagina(request, response);

    }

    private void enviarExcluir(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("idDeposito", idDeposito);
        request.setAttribute("dataDeposito", dataDeposito);
        request.setAttribute("valorTotalDeposito", valorTotalDeposito);
        request.setAttribute("usuarioDeposito", usuarioDeposito);

        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("mensagem",
                "Confirme os dados e clique em Salvar para excluir");

        encaminharParaPagina(request, response);

    }

    private void confirmarAlterar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        objDeposito.setId_deposito(Integer.valueOf(idDeposito));
        objDeposito.setData(Date.valueOf(dataDeposito));
        objDeposito.setValor_total(Double.valueOf(valorTotalDeposito));
        objDeposito.getUsuario().setId_usuario(Integer.valueOf(usuarioDeposito));

        objDepositoDao.alterar(objDeposito);

        encaminharParaPagina(request, response);

    }

    private void confirmarExcluir(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        objDeposito.setId_deposito(Integer.valueOf(idDeposito));

        objDepositoDao.excluir(objDeposito);

        encaminharParaPagina(request, response);

    }

    private void encaminharParaPagina(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Usuario> listaUsuario = objUsuarioDao.buscarTodosUsuarios();
        request.setAttribute("listaUsuario", listaUsuario);

        List<Deposito> listaDeposito = objDepositoDao.buscarTodosDepositos();
        request.setAttribute("listaDeposito", listaDeposito);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/CadastroDeposito.jsp");

        dispatcher.forward(request, response);

    }

    private void cancelar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("idDeposito", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("dataDeposito", "");
        request.setAttribute("valorTotalDeposito", "");
        request.setAttribute("usuarioDeposito", "");

        encaminharParaPagina(request, response);

    }

}