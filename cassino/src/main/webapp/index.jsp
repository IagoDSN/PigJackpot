<%-- 
    Document   : index
    Created on : 9 de fev. de 2026, 14:39:36
    Author     : Tulio Dias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">

<nav class="menu">
    <img class="logo" src="assets/logo.png">
    <ul>
        <li><a class="contex" href="${pageContext.request.contextPath}/index.jsp">HOME</a></li>
        <li><a class="contex" href="${pageContext.request.contextPath}${URL_BASE}/UsuarioControlador?opcao=cancelar">USUÁRIO</a></li>
        <li><a class="contex" href="${pageContext.request.contextPath}${URL_BASE}/ConquistaControlador?opcao=cancelar">CONQUISTA</a></li>
        <li><a class="contex" href="${pageContext.request.contextPath}${URL_BASE}/JogoControlador?opcao=cancelar">JOGO</a></li>
        <li><a class="contex" href="${pageContext.request.contextPath}/login.jsp">LOGIN</a></li>
        <li><a class="contex" href="${pageContext.request.contextPath}/logout.jsp">LOGOUT</a></li>

    </ul>
    <div>
        <a href="https://instagram.com/seuUsuario" target="_blank">
            <img class="redes" src="assets/instagram.png">
        </a>
        <a href="https://github.com/IagoDSN/PigJackpot" target="_blank">
            <img class="redes" src="assets/github.png">   
        </a>
        </div>
</nav>

<div class="banner-cassino">
    <div class="overlay">
        <h1>Bem-vindo ao Cassino Online</h1>
        <p>encontre o poder 💰</p>
    </div>
</div>