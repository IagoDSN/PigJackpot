/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.controlador;

import br.edu.ifsuldeminas.infoh2026.servico.WebConstante;
import br.edu.ifsuldeminas.infoh2026.modelo.dao.JogoDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Jogo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 13410289682
 */
@WebServlet(WebConstante.BASE_PATH + "/JogoControlador")
public class JogoControlador extends HttpServlet {

    Jogo objJogo = new Jogo();
    JogoDAO objJogoDAO = new JogoDAO();
    
    String id_jogo = "";
    String nome = "";
    String tipo = "";
    String descricao = "";
    String opcao = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            if (opcao == null || opcao.isEmpty()) {
                opcao = "cadastrar";
            }
            
            id_jogo = request.getParameter("id_jogo");
            nome = request.getParameter("nome");
            tipo = request.getParameter("tipo");
            descricao = request.getParameter("descricao");

            switch (opcao) {
                case "cadastrar":
                    cadastrar(request, response);
                    break;
                case "enviarAlterar":
                    enviarAlterar(request, response);
                    break;
                case "confirmarAlterar":
                    confirmarAlterar(request, response);
                    break;
                case "cancelar":
                    cancelar(request, response);
                    break;
                case "enviarExcluir":
                    enviarExcluir(request, response);
                    break;
                case "confirmarExcluir":
                    confirmarExcluir(request, response);
                    break;
                default:
                    throw new IllegalArgumentException("Opção inválida: " + opcao);
            }

        } catch (NumberFormatException e) {
            response.getWriter().println("Erro: Parâmetro numérico inválido - " + e.getMessage());
        } catch (IllegalArgumentException ex) {
            response.getWriter().println("Erro: " + ex.getMessage());
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        objJogo.setNome(nome);
        objJogo.setTipo(tipo);
        objJogo.setDescricao(descricao);
        
        objJogoDAO.salvar(objJogo);
        request.setAttribute("mensagem", "Jogo cadastrado com sucesso!");
        encaminharParaPagina(request, response);
    }

    private void enviarAlterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id_jogo", id_jogo);
        request.setAttribute("nome", nome);
        request.setAttribute("tipo", tipo);
        request.setAttribute("descricao", descricao);
        
        request.setAttribute("opcao", "confirmarAlterar");
        request.setAttribute("mensagem", "Edite os dados do jogo");
        encaminharParaPagina(request, response);
    }

    private void confirmarAlterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        objJogo.setId_jogo(Integer.valueOf(id_jogo));
        objJogo.setNome(nome);
        objJogo.setTipo(tipo);
        objJogo.setDescricao(descricao);
        
        objJogoDAO.alterar(objJogo);
        encaminharParaPagina(request, response);
    }

    private void enviarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id_jogo", id_jogo);
        request.setAttribute("nome", nome);
        request.setAttribute("tipo", tipo);
        request.setAttribute("descricao", descricao);
        
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("mensagem", "Confirme os dados e clique em salvar para excluir");
        encaminharParaPagina(request, response);
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        objJogo.setId_jogo(Integer.valueOf(id_jogo));
        objJogoDAO.excluir(objJogo);
        encaminharParaPagina(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id_jogo", "0");
        request.setAttribute("nome", "");
        request.setAttribute("tipo", "");
        request.setAttribute("descricao", "");
        request.setAttribute("opcao", "cadastrar");
        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Jogo> jogos = objJogoDAO.buscarTodosJogos();
        request.setAttribute("jogos", jogos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroJogo.jsp");
        dispatcher.forward(request, response);
    }
}