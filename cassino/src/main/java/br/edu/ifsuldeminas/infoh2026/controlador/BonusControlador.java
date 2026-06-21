/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.controlador;

import br.edu.ifsuldeminas.infoh2026.modelo.dao.BonusDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.dao.UsuarioDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Bonus;
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

@WebServlet(WebConstante.BASE_PATH + "/BonusControlador")
public class BonusControlador extends HttpServlet {

    Bonus objBonus;
    UsuarioDAO objUsuarioDao;
    BonusDAO objBonusDao;

    String idBonus = "";
    String valorBonus = "";
    String tipoBonus = "";
    String usuarioBonus = "";
    String opcao = "";

    @Override
    public void init() throws ServletException {

        objUsuarioDao = new UsuarioDAO();
        objBonus = new Bonus();
        objBonusDao = new BonusDAO();

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

            idBonus = request.getParameter("idBonus");
            valorBonus = request.getParameter("valorBonus");
            tipoBonus = request.getParameter("tipoBonus");
            usuarioBonus = request.getParameter("usuarioBonus");

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

        objBonus.setValor(Double.valueOf(valorBonus));
        objBonus.setTipo(tipoBonus);
        objBonus.getUsuario().setId_usuario(Integer.valueOf(usuarioBonus));

        objBonusDao.salvar(objBonus);

        request.setAttribute("mensagem",
                "Bônus cadastrado com sucesso!");

        encaminharParaPagina(request, response);

    }

    private void enviarAlterar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("idBonus", idBonus);
        request.setAttribute("valorBonus", valorBonus);
        request.setAttribute("tipoBonus", tipoBonus);
        request.setAttribute("usuarioBonus", usuarioBonus);

        request.setAttribute("opcao", "confirmarAlterar");
        request.setAttribute("mensagem",
                "Edite os dados e clique em Salvar");

        encaminharParaPagina(request, response);

    }

    private void enviarExcluir(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("idBonus", idBonus);
        request.setAttribute("valorBonus", valorBonus);
        request.setAttribute("tipoBonus", tipoBonus);
        request.setAttribute("usuarioBonus", usuarioBonus);

        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("mensagem",
                "Confirme os dados e clique em Salvar para excluir");

        encaminharParaPagina(request, response);

    }

    private void confirmarAlterar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        objBonus.setId_bonus(Integer.valueOf(idBonus));
        objBonus.setValor(Double.valueOf(valorBonus));
        objBonus.setTipo(tipoBonus);
        objBonus.getUsuario().setId_usuario(Integer.valueOf(usuarioBonus));

        objBonusDao.alterar(objBonus);

        encaminharParaPagina(request, response);

    }

    private void confirmarExcluir(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        objBonus.setId_bonus(Integer.valueOf(idBonus));

        objBonusDao.excluir(objBonus);

        encaminharParaPagina(request, response);

    }

    private void encaminharParaPagina(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Usuario> listaUsuario =
                objUsuarioDao.buscarTodosUsuarios();
        request.setAttribute("listaUsuario", listaUsuario);

        List<Bonus> listaBonus =
                objBonusDao.buscarTodosBonus();
        request.setAttribute("listaBonus", listaBonus);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/CadastroBonus.jsp");

        dispatcher.forward(request, response);

    }

    private void cancelar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("idBonus", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("valorBonus", "");
        request.setAttribute("tipoBonus", "");
        request.setAttribute("usuarioBonus", "");

        encaminharParaPagina(request, response);

    }

}