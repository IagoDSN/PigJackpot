<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">

<nav class="menu">
    <ul>
        <li><a href="${pageContext.request.contextPath}/index.jsp">HOME</a></li>
        <li><a href="${pageContext.request.contextPath}${URL_BASE}/UsuarioControlador?opcao=cancelar">USUÁRIO</a></li>
        <li><a href="${pageContext.request.contextPath}${URL_BASE}/ConquistaControlador?opcao=cancelar">CONQUISTA</a></li>
        <li><a href="${pageContext.request.contextPath}${URL_BASE}/JogoControlador?opcao=cancelar">JOGO</a></li>
        <li><a href="${pageContext.request.contextPath}/login.jsp">LOGIN</a></li>
        <li><a href="${pageContext.request.contextPath}/logout.jsp">LOGOUT</a></li>

    </ul>

</nav>