<%-- 
    Document   : rankin
    Created on : 15 de jun de 2026, 14:20:10
    Author     : 12409864678
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <title>Sobre - Pig Jackpot</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>

<body>

    <%@include file="Menu.jsp" %>

    <section class="cadastros">

        <h1 class="titulo-jogos">Sobre o Pig Jackpot</h1>

        <div class="card-jogo" style="width: 800px; margin: auto;">

            <div class="conteudo-jogo">

                <h2>🎰 Quem Somos</h2>

                <p>
                    O Pig Jackpot é uma plataforma de cassino online desenvolvida
                    para gerenciar usuários, jogos, partidas, depósitos, saques,
                    transações e conquistas.
                </p>

                <h2>🎮 Funcionalidades</h2>

                <p>
                    • Cadastro e gerenciamento de usuários<br>
                    • Controle de jogos e partidas<br>
                    • Sistema de conquistas<br>
                    • Carteiras virtuais<br>
                    • Depósitos e saques<br>
                    • Histórico de transações<br>
                    • Ranking de jogadores
                </p>

                <h2>💻 Tecnologias Utilizadas</h2>

                <p>
                    • Java<br>
                    • JSP e Servlets<br>
                    • JSTL<br>
                    • HTML5 e CSS3<br>
                    • MySQL
                </p>

                <h2>🎯 Objetivo</h2>

                <p>
                    Este projeto foi desenvolvido para aplicar conceitos de
                    programação web, banco de dados e arquitetura MVC,
                    proporcionando uma experiência moderna e organizada
                    para gerenciamento de um cassino online.
                </p>
                
                <h2>Feito Por</h2>

                <p>
                   Iago Diniz Sepini Nunes<br>
                   João Gabriel Prado de Souza
                </p>

            </div>

        </div>

    </section>

<footer class="footer-cassino">
            <div class="footer-conteudo">
                <div>
                    <h2>Pig Jackpot</h2>
                </div>
                <div>
                    <ul>
                        <li><a href="#">Home</a></li>
                    </ul>
                </div>
                <div>
                    <div class="footer-redes">
                        <a href="https://instagram.com/seuUsuario" target="_blank">
                            <img class="redes" src="${pageContext.request.contextPath}/assets/instagram.png">
                        </a>
                        <a href="https://github.com/IagoDSN/PigJackpot" target="_blank">
                            <img class="redes" src="${pageContext.request.contextPath}/assets/github.png">
                        </a>
                    </div>
                </div>
            </div>
            <div class="footer-copy">
                © 2026 Pig Jackpot - Todos os direitos reservados.
            </div>
        </footer>