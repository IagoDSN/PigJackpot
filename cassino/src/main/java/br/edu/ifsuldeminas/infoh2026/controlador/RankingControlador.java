/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.controlador;

import br.edu.ifsuldeminas.infoh2026.modelo.dao.UsuarioDAO;
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

@WebServlet(WebConstante.BASE_PATH + "/RankingControlador")
public class RankingControlador extends HttpServlet {

    UsuarioDAO objUsuarioDao;

    @Override
    public void init() throws ServletException {
        objUsuarioDao = new UsuarioDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        encaminharParaPagina(request, response);

    }

    private void encaminharParaPagina(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Usuario> listaUsuario =
                objUsuarioDao.buscarTodosUsuarios();

        request.setAttribute(
                "ranking",
                listaUsuario);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/Ranking.jsp");

        dispatcher.forward(request, response);

    }

}