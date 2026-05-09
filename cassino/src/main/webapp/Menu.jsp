<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">

<nav class="menu">
    <img class="logo" src="${pageContext.request.contextPath}/assets/logo.png">
    <ul>
        <li><a class="contex" href="${pageContext.request.contextPath}${URL_BASE}/HomeControlador?opcao=cancelar">HOME</a></li>
        <li><a class="contex" href="${pageContext.request.contextPath}${URL_BASE}/UsuarioControlador?opcao=cancelar">USUÁRIO</a></li>
        <li><a class="contex" href="${pageContext.request.contextPath}${URL_BASE}/ConquistaControlador?opcao=cancelar">CONQUISTA</a></li>
        <li><a class="contex" href="${pageContext.request.contextPath}${URL_BASE}/JogoControlador?opcao=cancelar">JOGO</a></li>
        <li><a class="contex" href="${pageContext.request.contextPath}/login.jsp">LOGIN</a></li>
        <li><a class="contex" href="${pageContext.request.contextPath}/logout.jsp">LOGOUT</a></li>

    </ul>
    <div>
        <a href="https://instagram.com/seuUsuario" target="_blank">
            <img class="redes" src="${pageContext.request.contextPath}/assets/instagram.png">
        </a>
        <a href="https://github.com/IagoDSN/PigJackpot" target="_blank">
            <img class="redes" src="${pageContext.request.contextPath}/assets/github.png">
        </a>
        </div>
</nav>