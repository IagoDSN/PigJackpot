<%-- 
    Document   : CadastroUsuarioConquista
    Created on : 21 de jun. de 2026, 17:54:25
    Author     : Iagod
--%>

<%-- 
    Document   : CadastroUsuarioConquista
    Created on : 21 de jun. de 2026
    Author     : Iagod
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="Latin1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Latin1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/forms.css">
        <title>Cadastro Usuario Conquista</title>
    </head>

    <%@include file="Menu.jsp" %>

    <body>

        <h1>Cadastro Usuario Conquista</h1>

        <form name="cadastro"
              method="get"
              action="${pageContext.request.contextPath}${URL_BASE}/UsuarioConquistaControlador">

            <input type="hidden" name="opcao" value="${opcao}">
            <input type="hidden" name="idUsuarioConquista" value="${idUsuarioConquista}">

            <p>
                <label>Data Conquista:</label>
                <input type="date"
                       name="dataConquista"
                       required=""
                       value="${dataConquista}"
                       size="10"/>
            </p>

            <p>
                <label>Usuário:</label>

                <select name="usuarioConquista">

                    <c:forEach var="usuarios" items="${listaUsuario}">

                        <c:choose>

                            <c:when test="${usuarios.id_usuario eq usuarioConquista}">
                                <option selected=""
                                        value="${usuarios.id_usuario}">
                                    ${usuarios.id_usuario} - ${usuarios.nome}
                                </option>
                            </c:when>

                            <c:otherwise>
                                <option value="${usuarios.id_usuario}">
                                    ${usuarios.id_usuario} - ${usuarios.nome}
                                </option>
                            </c:otherwise>

                        </c:choose>

                    </c:forEach>

                </select>

            </p>

            <p>
                <label>Conquista:</label>

                <select name="conquistaUsuario">

                    <c:forEach var="conquistas" items="${listaConquista}">

                        <c:choose>

                            <c:when test="${conquistas.id_conquista eq conquistaUsuario}">
                                <option selected=""
                                        value="${conquistas.id_conquista}">
                                    ${conquistas.id_conquista} - ${conquistas.nome}
                                </option>
                            </c:when>

                            <c:otherwise>
                                <option value="${conquistas.id_conquista}">
                                    ${conquistas.id_conquista} - ${conquistas.nome}
                                </option>
                            </c:otherwise>

                        </c:choose>

                    </c:forEach>

                </select>

            </p>

            <div class="area-botoes">

                <input type="submit"
                       value="Salvar"
                       name="Salvar">

                <a class="btn-link"
                   href="${pageContext.request.contextPath}${URL_BASE}/UsuarioConquistaControlador?opcao=cancelar">
                    Cancelar
                </a>

            </div>

        </form>

        <h3>${mensagem}</h3>

        <table border="1">

            <c:if test="${not empty listaUsuarioConquista}">
                <tr>
                    <th>ID</th>
                    <th>DATA</th>
                    <th>USUARIO</th>
                    <th>CONQUISTA</th>
                    <th>ALTERAR</th>
                    <th>EXCLUIR</th>
                </tr>
            </c:if>

            <c:forEach var="uc" items="${listaUsuarioConquista}">

                <tr>

                    <td>${uc.id_usuarioConquista}</td>
                    <td>${uc.data_conquista}</td>
                    <td>${uc.usuario.nome}</td>
                    <td>${uc.conquista.nome}</td>

                    <td>

                        <form method="get"
                              action="${pageContext.request.contextPath}${URL_BASE}/UsuarioConquistaControlador">

                            <input type="hidden"
                                   name="idUsuarioConquista"
                                   value="${uc.id_usuarioConquista}">

                            <input type="hidden"
                                   name="dataConquista"
                                   value="${uc.data_conquista}">

                            <input type="hidden"
                                   name="usuarioConquista"
                                   value="${uc.usuario.id_usuario}">

                            <input type="hidden"
                                   name="conquistaUsuario"
                                   value="${uc.conquista.id_conquista}">

                            <input type="hidden"
                                   name="opcao"
                                   value="enviarAlterar">

                            <button type="submit">
                                Alterar
                            </button>

                        </form>

                    </td>

                    <td>

                        <form method="get"
                              action="${pageContext.request.contextPath}${URL_BASE}/UsuarioConquistaControlador">

                            <input type="hidden"
                                   name="idUsuarioConquista"
                                   value="${uc.id_usuarioConquista}">

                            <input type="hidden"
                                   name="dataConquista"
                                   value="${uc.data_conquista}">

                            <input type="hidden"
                                   name="usuarioConquista"
                                   value="${uc.usuario.id_usuario}">

                            <input type="hidden"
                                   name="conquistaUsuario"
                                   value="${uc.conquista.id_conquista}">

                            <input type="hidden"
                                   name="opcao"
                                   value="enviarExcluir">

                            <button type="submit">
                                Excluir
                            </button>

                        </form>

                    </td>

                </tr>

            </c:forEach>

        </table>

    </body>
</html>