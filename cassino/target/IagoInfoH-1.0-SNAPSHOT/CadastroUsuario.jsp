<%-- 
    Document   : CadastroUsuario
    Created on : 6 de abr de 2026, 14:54:35
    Author     : 13410289682
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Usuário</title>
</head>
<body>

<%@include file="Menu.jsp" %>

<h1>Cadastro de Usuário</h1>

<form method="get" action="${pageContext.request.contextPath}${URL_BASE}/UsuarioControlador">
    
    <!-- Sempre garantir uma opcao padrão -->
    <input type="hidden" name="opcao" value="${empty opcao ? 'cadastrar' : opcao}">
    <input type="hidden" name="id_usuario" value="${id_usuario}">

    <p>
        <label>Nome:</label>
        <input type="text" name="nome" value="${nome}" required size="40">
    </p>

    <p>
        <label>Senha:</label>
        <input type="password" name="senha" size="20">
    </p>

    <p>
        <label>Email:</label>
        <input type="email" name="email" value="${email}" required size="40">
    </p>

    <p>
        <label>Endereço:</label>
        <input type="text" name="endereco" value="${endereco}" size="50">
    </p>

    <p>
        <label>CPF:</label>
        <input type="text" name="cpf" value="${cpf}" size="20">
    </p>

    <p>
        <label>Data Cadastro:</label>
        <input type="date" name="data_cadastro" value="${data_cadastro}">
    </p>

    <p>
        <label>Data Nascimento:</label>
        <input type="date" name="dataNascimento" value="${dataNascimento}">
    </p>

    <input type="submit" value="Salvar">
</form>

<form method="get" action="${pageContext.request.contextPath}${URL_BASE}/UsuarioControlador">
    <input type="hidden" name="opcao" value="cancelar">
    <input type="submit" value="Cancelar">
</form>

<h3>${mensagem}</h3>

<table border="1">

    <c:if test="${not empty usuarios}">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
            <th>CPF</th>
            <th>Alterar</th>
            <th>Excluir</th>
        </tr>
    </c:if>

    <c:forEach var="usuario" items="${usuarios}">
        <tr>
            <td>${usuario.id_usuario}</td>
            <td>${usuario.nome}</td>
            <td>${usuario.email}</td>
            <td>${usuario.cpf}</td>

            <td>
                <form method="get" action="${pageContext.request.contextPath}${URL_BASE}/UsuarioControlador">
                    <input type="hidden" name="id_usuario" value="${usuario.id_usuario}">
                    <input type="hidden" name="nome" value="${usuario.nome}">
                    <input type="hidden" name="email" value="${usuario.email}">
                    <input type="hidden" name="endereco" value="${usuario.endereco}">
                    <input type="hidden" name="cpf" value="${usuario.cpf}">
                    <input type="hidden" name="data_cadastro" value="${usuario.data_cadastro}">
                    <input type="hidden" name="dataNascimento" value="${usuario.dataNascimento}">
                    <input type="hidden" name="opcao" value="enviarAlterar">
                    <button type="submit">Alterar</button>
                </form>
            </td>

            <td>
                <form method="get" action="${pageContext.request.contextPath}${URL_BASE}/UsuarioControlador">
                    <input type="hidden" name="id_usuario" value="${usuario.id_usuario}">
                    <input type="hidden" name="opcao" value="enviarExcluir">
                    <button type="submit">Excluir</button>
                </form>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>