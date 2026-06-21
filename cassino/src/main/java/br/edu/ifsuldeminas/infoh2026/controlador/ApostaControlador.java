/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.controlador;

import br.edu.ifsuldeminas.infoh2026.modelo.dao.ApostaDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.dao.PartidaDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Aposta;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Partida;
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

@WebServlet(WebConstante.BASE_PATH + "/ApostaControlador")
public class ApostaControlador extends HttpServlet {

    Aposta objAposta;
    PartidaDAO objPartidaDao;
    ApostaDAO objApostaDao;

    String idAposta = "";
    String valorAposta = "";
    String resultadoAposta = "";
    String partidaAposta = "";
    String opcao = "";

    @Override
    public void init() throws ServletException {

        objPartidaDao = new PartidaDAO();
        objAposta = new Aposta();
        objApostaDao = new ApostaDAO();

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

            idAposta = request.getParameter("idAposta");
            valorAposta = request.getParameter("valorAposta");
            resultadoAposta = request.getParameter("resultadoAposta");
            partidaAposta = request.getParameter("partidaAposta");

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

        objAposta.setValor(Double.valueOf(valorAposta));
        objAposta.setResultado(resultadoAposta);
        objAposta.getPartida().setId_partida(Integer.valueOf(partidaAposta));

        objApostaDao.salvar(objAposta);

        request.setAttribute("mensagem",
                "Aposta cadastrada com sucesso!");

        encaminharParaPagina(request, response);

    }

    private void enviarAlterar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("idAposta", idAposta);
        request.setAttribute("valorAposta", valorAposta);
        request.setAttribute("resultadoAposta", resultadoAposta);
        request.setAttribute("partidaAposta", partidaAposta);

        request.setAttribute("opcao", "confirmarAlterar");
        request.setAttribute("mensagem",
                "Edite os dados e clique em Salvar");

        encaminharParaPagina(request, response);

    }

    private void enviarExcluir(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("idAposta", idAposta);
        request.setAttribute("valorAposta", valorAposta);
        request.setAttribute("resultadoAposta", resultadoAposta);
        request.setAttribute("partidaAposta", partidaAposta);

        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("mensagem",
                "Confirme os dados e clique em Salvar para excluir");

        encaminharParaPagina(request, response);

    }

    private void confirmarAlterar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        objAposta.setId_aposta(Integer.valueOf(idAposta));
        objAposta.setValor(Double.valueOf(valorAposta));
        objAposta.setResultado(resultadoAposta);
        objAposta.getPartida().setId_partida(Integer.valueOf(partidaAposta));

        objApostaDao.alterar(objAposta);

        encaminharParaPagina(request, response);

    }

    private void confirmarExcluir(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        objAposta.setId_aposta(Integer.valueOf(idAposta));

        objApostaDao.excluir(objAposta);

        encaminharParaPagina(request, response);

    }

    private void encaminharParaPagina(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Partida> listaPartida =
                objPartidaDao.buscarTodasPartidas();
        request.setAttribute("listaPartida", listaPartida);

        List<Aposta> listaAposta =
                objApostaDao.buscarTodasApostas();
        request.setAttribute("listaAposta", listaAposta);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/CadastroAposta.jsp");

        dispatcher.forward(request, response);

    }

    private void cancelar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("idAposta", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("valorAposta", "");
        request.setAttribute("resultadoAposta", "");
        request.setAttribute("partidaAposta", "");

        encaminharParaPagina(request, response);

    }

}
