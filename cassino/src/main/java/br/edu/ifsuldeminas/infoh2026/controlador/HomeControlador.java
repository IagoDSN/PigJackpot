/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.controlador;

import br.edu.ifsuldeminas.infoh2026.modelo.dao.JogoDAO;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Jogo;
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
 *
**/
@WebServlet(WebConstante.BASE_PATH + "/HomeControlador")
public class HomeControlador extends HttpServlet {

    JogoDAO objJogoDAO = new JogoDAO();

    String opcao = "";

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        opcao = request.getParameter("opcao");

        if(opcao == null || opcao.isEmpty()){
            opcao = "cancelar";
        }

        switch(opcao){

            case "cancelar":
                cancelar(request, response);
                break;
        }
    }

    private void cancelar(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        List<Jogo> recentes =
                objJogoDAO.buscarJogosRecentes();

        request.setAttribute("recentes", recentes);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/index.jsp");

        dispatcher.forward(request, response);
    }
}
