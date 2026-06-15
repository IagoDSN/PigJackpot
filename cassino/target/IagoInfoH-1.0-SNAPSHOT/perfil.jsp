<%-- 
    Document   : perfil
    Created on : 15 de jun de 2026, 14:19:12
    Author     : 12409864678
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

<%@include file="Menu.jsp" %>

<section class="cadastros">

    <h1 class="titulo-jogos">Meu Perfil</h1>

    <div class="card-jogo" style="margin:auto; width:500px;">

        <div class="conteudo-jogo">

            <h2>${usuario.nome}</h2>

            <p><strong>ID:</strong> ${usuario.id}</p>

            <p><strong>Email:</strong> ${usuario.email}</p>

            <p><strong>Saldo:</strong> R$ ${usuario.saldo}</p>

            <p><strong>Conquistas:</strong> ${usuario.totalConquistas}</p>

        </div>

    </div>

</section>