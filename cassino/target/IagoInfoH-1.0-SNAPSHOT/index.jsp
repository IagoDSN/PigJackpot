<%-- 
    Document   : index
    Created on : 9 de fev. de 2026, 14:39:36
    Author     : Tulio Dias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">

<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/index.jsp">HOME</a></li>
        <li><a href="${pageContext.request.contextPath}${URL_BASE}/CidadeControlador?opcao=cancelar">CIDADE</a></li>
        <li><a href="${pageContext.request.contextPath}${URL_BASE}/FuncionarioControlador?opcao=cancelar">FUNCIONÁRIO</a></li>
        <li><a href="${pageContext.request.contextPath}/login.jsp">LOGIN</a></li>
        <li><a href="${pageContext.request.contextPath}/logout.jsp">LOGOUT</a></li>


    </ul>

</nav>
