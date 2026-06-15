/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.controlador;

/**
 *
 * @author 13410289682
 */

import br.edu.ifsuldeminas.infoh2026.modelo.dao.JogoDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.dao.PartidaDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.dao.UsuarioDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Jogo;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Partida;
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

@WebServlet(WebConstante.BASE_PATH + "/PartidaControlador")
public class PartidaControlador extends HttpServlet {

    Partida objPartida;
    UsuarioDAO objUsuarioDao;
    JogoDAO objJogoDao;
    PartidaDAO objPartidaDao;

    String idPartida = "";
    String dataPartida = "";
    String resultadoPartida = "";
    String usuarioPartida = "";
    String jogoPartida = "";
    String opcao = "";

    @Override
    public void init() throws ServletException {

        objUsuarioDao = new UsuarioDAO();
        objJogoDao = new JogoDAO();
        objPartida = new Partida();
        objPartidaDao = new PartidaDAO();

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

            idPartida = request.getParameter("idPartida");
            dataPartida = request.getParameter("dataPartida");
            resultadoPartida = request.getParameter("resultadoPartida");
            usuarioPartida = request.getParameter("usuarioPartida");
            jogoPartida = request.getParameter("jogoPartida");

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

        objPartida.setData(Date.valueOf(dataPartida));
        objPartida.setResultado(resultadoPartida);

        objPartida.getUsuario()
                .setId_usuario(Integer.valueOf(usuarioPartida));

        objPartida.getJogo()
                .setId_jogo(Integer.valueOf(jogoPartida));

        objPartidaDao.salvar(objPartida);

        request.setAttribute("mensagem",
                "Partida cadastrada com sucesso!");

        encaminharParaPagina(request, response);

    }

    private void enviarAlterar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("idPartida", idPartida);
        request.setAttribute("dataPartida", dataPartida);
        request.setAttribute("resultadoPartida", resultadoPartida);
        request.setAttribute("usuarioPartida", usuarioPartida);
        request.setAttribute("jogoPartida", jogoPartida);

        request.setAttribute("opcao", "confirmarAlterar");
        request.setAttribute("mensagem",
                "Edite os dados e clique em Salvar");

        encaminharParaPagina(request, response);

    }

    private void enviarExcluir(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("idPartida", idPartida);
        request.setAttribute("dataPartida", dataPartida);
        request.setAttribute("resultadoPartida", resultadoPartida);
        request.setAttribute("usuarioPartida", usuarioPartida);
        request.setAttribute("jogoPartida", jogoPartida);

        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("mensagem",
                "Confirme os dados e clique em Salvar para excluir");

        encaminharParaPagina(request, response);

    }

    private void confirmarAlterar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        objPartida.setId_partida(Integer.valueOf(idPartida));
        objPartida.setData(Date.valueOf(dataPartida));
        objPartida.setResultado(resultadoPartida);

        objPartida.getUsuario()
                .setId_usuario(Integer.valueOf(usuarioPartida));

        objPartida.getJogo()
                .setId_jogo(Integer.valueOf(jogoPartida));

        objPartidaDao.alterar(objPartida);

        encaminharParaPagina(request, response);

    }

    private void confirmarExcluir(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        objPartida.setId_partida(Integer.valueOf(idPartida));

        objPartidaDao.excluir(objPartida);

        encaminharParaPagina(request, response);

    }

    private void encaminharParaPagina(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Usuario> listaUsuario =
                objUsuarioDao.buscarTodosUsuarios();
        request.setAttribute("listaUsuario", listaUsuario);

        List<Jogo> listaJogo =
                objJogoDao.buscarTodosJogos();
        request.setAttribute("listaJogo", listaJogo);

        List<Partida> listaPartida =
                objPartidaDao.buscarTodasPartidas();
        request.setAttribute("listaPartida", listaPartida);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/CadastroPartida.jsp");

        dispatcher.forward(request, response);

    }

    private void cancelar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("idPartida", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("dataPartida", "");
        request.setAttribute("resultadoPartida", "");
        request.setAttribute("usuarioPartida", "");
        request.setAttribute("jogoPartida", "");

        encaminharParaPagina(request, response);

    }

}
