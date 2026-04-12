/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.controlador;

import br.edu.ifsuldeminas.infoh2026.servico.WebConstante;
import br.edu.ifsuldeminas.infoh2026.modelo.dao.ConquistaDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Conquista;
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
 * @author 13410289682
 */
@WebServlet(WebConstante.BASE_PATH + "/ConquistaControlador")
public class ConquistaControlador extends HttpServlet {

    Conquista objConquista = new Conquista();
    ConquistaDAO objConquistaDAO = new ConquistaDAO();
    
    String id_conquista = "";
    String nome = "";
    String descricao = "";
    String recompensa = "";
    String opcao = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            if (opcao == null || opcao.isEmpty()) {
                opcao = "cadastrar";
            }
            
            id_conquista = request.getParameter("id_conquista");
            nome = request.getParameter("nome");
            descricao = request.getParameter("descricao");
            recompensa = request.getParameter("recompensa");

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
            response.getWriter().println("Erro: Valor numérico inválido - " + e.getMessage());
        } catch (IllegalArgumentException ex) {
            response.getWriter().println("Erro: " + ex.getMessage());
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        objConquista.setNome(nome);
        objConquista.setDescricao(descricao);
        if (recompensa != null && !recompensa.isEmpty()) {
            objConquista.setRecompensa(Double.valueOf(recompensa.replace(",", ".")));
        }
        
        objConquistaDAO.salvar(objConquista);
        request.setAttribute("mensagem", "Conquista cadastrada com sucesso!");
        encaminharParaPagina(request, response);
    }

    private void enviarAlterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id_conquista", id_conquista);
        request.setAttribute("nome", nome);
        request.setAttribute("descricao", descricao);
        request.setAttribute("recompensa", recompensa);
        
        request.setAttribute("opcao", "confirmarAlterar");
        request.setAttribute("mensagem", "Edite os dados da conquista");
        encaminharParaPagina(request, response);
    }

    private void confirmarAlterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        objConquista.setId_conquista(Integer.valueOf(id_conquista));
        objConquista.setNome(nome);
        objConquista.setDescricao(descricao);
        if (recompensa != null && !recompensa.isEmpty()) {
            objConquista.setRecompensa(Double.valueOf(recompensa.replace(",", ".")));
        }
        
        objConquistaDAO.alterar(objConquista);
        encaminharParaPagina(request, response);
    }

    private void enviarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id_conquista", id_conquista);
        request.setAttribute("nome", nome);
        request.setAttribute("descricao", descricao);
        request.setAttribute("recompensa", recompensa);
        
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("mensagem", "Confirme os dados e clique em salvar para excluir");
        encaminharParaPagina(request, response);
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        objConquista.setId_conquista(Integer.valueOf(id_conquista));
        objConquistaDAO.excluir(objConquista);
        encaminharParaPagina(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id_conquista", "0");
        request.setAttribute("nome", "");
        request.setAttribute("descricao", "");
        request.setAttribute("recompensa", "");
        request.setAttribute("opcao", "cadastrar");
        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Conquista> conquistas = objConquistaDAO.buscarTodasConquistas();
        request.setAttribute("conquistas", conquistas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroConquista.jsp");
        dispatcher.forward(request, response);
    }
}
