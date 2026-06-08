/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.controlador;

import br.edu.ifsuldeminas.infoh2026.modelo.dao.SaqueDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Saque;
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
 * @author 12409864678
 */
@WebServlet(WebConstante.BASE_PATH + "/SaqueControlador")

public class SaqueControlador extends HttpServlet {

    Saque objSaque;
    SaqueDAO objSaqueDao;
    String idSaque = "";
    String dataSaque = "";
    String valorTotalSaque = "";
    String opcao = "";

    @Override
    public void init() throws ServletException {
        objSaque = new Saque();
        objSaqueDao = new SaqueDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            opcao = request.getParameter("opcao");

            if (opcao == null || opcao.isEmpty()) {
                opcao = "cadastrar";
            }

            idSaque = request.getParameter("idSaque");
            dataSaque = request.getParameter("dataSaque");
            valorTotalSaque = request.getParameter("valorTotalSaque");

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
                    + e.getMessage()
            );
        } catch (IllegalArgumentException e) {
            response.getWriter().println("Erro: " + e.getMessage());
        }
    }

    private void cadastrar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        objSaque.setData(Date.valueOf(dataSaque));
        objSaque.setValor_total(Double.valueOf(valorTotalSaque));

        objSaqueDao.salvar(objSaque);

        request.setAttribute("mensagem", "Saque cadastrado com sucesso!");

        encaminharParaPagina(request, response);
    }

    private void enviarAlterar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("idSaque", idSaque);
        request.setAttribute("dataSaque", dataSaque);
        request.setAttribute("valorTotalSaque", valorTotalSaque);

        request.setAttribute("opcao", "confirmarAlterar");
        request.setAttribute("mensagem", "Edite os dados e clique em Salvar");

        encaminharParaPagina(request, response);
    }

    private void enviarExcluir(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("idSaque", idSaque);
        request.setAttribute("dataSaque", dataSaque);
        request.setAttribute("valorTotalSaque", valorTotalSaque);

        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("mensagem",
                "Confirme os dados e clique em Salvar para excluir");

        encaminharParaPagina(request, response);
    }

    private void confirmarAlterar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        objSaque.setId_saque(Integer.valueOf(idSaque));
        objSaque.setData(Date.valueOf(dataSaque));
        objSaque.setValor_total(Double.valueOf(valorTotalSaque));

        objSaqueDao.alterar(objSaque);

        encaminharParaPagina(request, response);
    }

    private void confirmarExcluir(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        objSaque.setId_saque(Integer.valueOf(idSaque));

        objSaqueDao.excluir(objSaque);

        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Saque> listaSaque = objSaqueDao.buscarTodosSaques();

        request.setAttribute("listaSaque", listaSaque);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/CadastroSaque.jsp");

        dispatcher.forward(request, response);
    }

    private void cancelar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("idSaque", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("dataSaque", "");
        request.setAttribute("valorTotalSaque", "");

        encaminharParaPagina(request, response);
    }
}