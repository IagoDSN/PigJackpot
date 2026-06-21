<%-- 
    Document   : Rankin
    Created on : 15 de jun de 2026, 14:29:52
    Author     : 12409864678
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <title>Ranking - Pig Jackpot</title>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    </head>

    <body>

        <%@include file="Menu.jsp"%>

        <section class="jogos-recentes">

            <h1 class="titulo-jogos">🏆 Top 3 Jogadores</h1>

            <div class="linha-jogos">

                <div class="card-jogo">
                    <div class="conteudo-jogo">
                        <h2>🥇 1º Lugar</h2>
                        <p>${ranking[0].nome}</p>
                        <p>${ranking[0].email}</p>
                    </div>
                </div>

                <div class="card-jogo">
                    <div class="conteudo-jogo">
                        <h2>🥈 2º Lugar</h2>
                        <p>${ranking[1].nome}</p>
                        <p>${ranking[1].email}</p>
                    </div>
                </div>

                <div class="card-jogo">
                    <div class="conteudo-jogo">
                        <h2>🥉 3º Lugar</h2>
                        <p>${ranking[2].nome}</p>
                        <p>${ranking[2].email}</p>
                    </div>
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
    </body>

</body>
</html>