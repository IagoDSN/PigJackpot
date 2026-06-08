/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.controlador;

import br.edu.ifsuldeminas.infoh2026.modelo.dao.TransacaoDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.dao.TransacaoDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Transacao;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Transacao;
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
@WebServlet(WebConstante.BASE_PATH + "/TransacaoControlador")
public class TransacaoControlador extends HttpServlet {

    Transacao objTransacao;
    TransacaoDAO objTransacaoDao;

    String idTransacao = "";
    String valorTransacao = "";
    String tipoTransacao = "";
    String dataTransacao = "";
    String opcao = "";

    @Override
    public void init() throws ServletException {

        objTransacao = new Transacao();
        objTransacaoDao = new TransacaoDAO();

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

            idTransacao = request.getParameter("idTransacao");
            valorTransacao = request.getParameter("valorTransacao");
            tipoTransacao = request.getParameter("tipoTransacao");
            dataTransacao = request.getParameter("dataTransacao");

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

        objTransacao.setValor(
                Double.valueOf(valorTransacao));

        objTransacao.setTipo(
                tipoTransacao);

        objTransacao.setData(
                Date.valueOf(dataTransacao));

        objTransacaoDao.salvar(objTransacao);

        request.setAttribute(
                "mensagem",
                "Transação cadastrada com sucesso!");

        encaminharParaPagina(request, response);
    }

    private void enviarAlterar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "idTransacao",
                idTransacao);

        request.setAttribute(
                "valorTransacao",
                valorTransacao);

        request.setAttribute(
                "tipoTransacao",
                tipoTransacao);

        request.setAttribute(
                "dataTransacao",
                dataTransacao);

        request.setAttribute(
                "opcao",
                "confirmarAlterar");

        request.setAttribute(
                "mensagem",
                "Edite os dados e clique em Salvar");

        encaminharParaPagina(request, response);
    }

    private void enviarExcluir(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "idTransacao",
                idTransacao);

        request.setAttribute(
                "valorTransacao",
                valorTransacao);

        request.setAttribute(
                "tipoTransacao",
                tipoTransacao);

        request.setAttribute(
                "dataTransacao",
                dataTransacao);

        request.setAttribute(
                "opcao",
                "confirmarExcluir");

        request.setAttribute(
                "mensagem",
                "Confirme os dados e clique em Salvar para excluir");

        encaminharParaPagina(request, response);
    }

    private void confirmarAlterar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        objTransacao.setId_transacao(
                Integer.valueOf(idTransacao));

        objTransacao.setValor(
                Double.valueOf(valorTransacao));

        objTransacao.setTipo(
                tipoTransacao);

        objTransacao.setData(
                Date.valueOf(dataTransacao));

        objTransacaoDao.alterar(objTransacao);

        encaminharParaPagina(request, response);
    }

    private void confirmarExcluir(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        objTransacao.setId_transacao(
                Integer.valueOf(idTransacao));

        objTransacaoDao.excluir(objTransacao);

        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Transacao> listaTransacao =
                objTransacaoDao.buscarTodasTransacoes();

        request.setAttribute(
                "listaTransacao",
                listaTransacao);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/CadastroTransacao.jsp");

        dispatcher.forward(request, response);
    }

    private void cancelar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "idTransacao",
                "0");

        request.setAttribute(
                "opcao",
                "cadastrar");

        request.setAttribute(
                "valorTransacao",
                "");

        request.setAttribute(
                "tipoTransacao",
                "");

        request.setAttribute(
                "dataTransacao",
                "");

        encaminharParaPagina(request, response);
    }
}