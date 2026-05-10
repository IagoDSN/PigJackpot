<%-- 
    Document   : index
    Created on : 9 de fev. de 2026, 14:39:36
    Author     : Tulio Dias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

<%@include file="Menu.jsp" %>

<div class="banner-cassino">
    <div class="overlay">
        <h1>Bem-vindo ao Cassino Online</h1>
        <p>encontre o poder 💰</p>
    </div>
</div>

<section class="jogos-recentes">

    <h1 class="titulo-jogos">Jogos Novos</h1>

    <div class="linha-jogos">

        <div class="card-jogo">

            <img src="${pageContext.request.contextPath}/assets/jogoNovo.jfif">

            <div class="conteudo-jogo">
                <h2>${recentes[0].nome}</h2>

                <p>${recentes[0].descricao}</p>

                <a href="${pageContext.request.contextPath}${URL_BASE}/JogoControlador?opcao=cancelar">Jogar</a>
            </div>

        </div>

        <div class="card-jogo">

            <img src="${pageContext.request.contextPath}/assets/jogoNovo.jfif">

            <div class="conteudo-jogo">
                <h2>${recentes[1].nome}</h2>

                <p>${recentes[1].descricao}</p>

                <a href="${pageContext.request.contextPath}${URL_BASE}/JogoControlador?opcao=cancelar">Jogar</a>
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