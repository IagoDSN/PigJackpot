<%-- 
    Document   : CadastroBonus
    Created on : 21 de jun. de 2026, 17:09:00
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
        <title>Cadastro de Bônus</title>
    </head>

    <%@include file="Menu.jsp" %>

    <body>

        <h1>Cadastro Bônus</h1>

        <form name="cadastro"
              method="get"
              action="${pageContext.request.contextPath}${URL_BASE}/BonusControlador">

            <input type="hidden" name="opcao" value="${opcao}">
            <input type="hidden" name="idBonus" value="${idBonus}">

            <p>
                <label>Valor:</label>
                <input type="number"
                       name="valorBonus"
                       required=""
                       value="${valorBonus}"
                       size="10"/>
            </p>

            <p>
                <label>Tipo:</label>
                <input type="text"
                       name="tipoBonus"
                       required=""
                       value="${tipoBonus}"
                       size="30"/>
            </p>

            <p>
                <label>Usuário:</label>

                <select name="usuarioBonus">

                    <c:forEach var="usuarios" items="${listaUsuario}">

                        <c:choose>

                            <c:when test="${usuarios.id_usuario eq usuarioBonus}">
                                <option selected=""
                                        value="${usuarios.id_usuario}">
                                    ${usuarios.nome}
                                </option>
                            </c:when>

                            <c:otherwise>
                                <option value="${usuarios.id_usuario}">
                                    ${usuarios.nome}
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
                   href="${pageContext.request.contextPath}${URL_BASE}/BonusControlador?opcao=cancelar">
                    Cancelar
                </a>

            </div>

        </form>

        <h3>${mensagem}</h3>

        <table border="1">

            <c:if test="${not empty listaBonus}">
                <tr>
                    <th>ID</th>
                    <th>VALOR</th>
                    <th>TIPO</th>
                    <th>USUÁRIO</th>
                    <th>ALTERAR</th>
                    <th>EXCLUIR</th>
                </tr>
            </c:if>

            <c:forEach var="bonus" items="${listaBonus}">

                <tr>

                    <td>${bonus.id_bonus}</td>
                    <td>${bonus.valor}</td>
                    <td>${bonus.tipo}</td>
                    <td>${bonus.usuario.nome}</td>

                    <td>

                        <form method="get"
                              action="${pageContext.request.contextPath}${URL_BASE}/BonusControlador">

                            <input type="hidden"
                                   name="idBonus"
                                   value="${bonus.id_bonus}">

                            <input type="hidden"
                                   name="valorBonus"
                                   value="${bonus.valor}">

                            <input type="hidden"
                                   name="tipoBonus"
                                   value="${bonus.tipo}">

                            <input type="hidden"
                                   name="usuarioBonus"
                                   value="${bonus.usuario.id_usuario}">

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
                              action="${pageContext.request.contextPath}${URL_BASE}/BonusControlador">

                            <input type="hidden"
                                   name="idBonus"
                                   value="${bonus.id_bonus}">

                            <input type="hidden"
                                   name="valorBonus"
                                   value="${bonus.valor}">

                            <input type="hidden"
                                   name="tipoBonus"
                                   value="${bonus.tipo}">

                            <input type="hidden"
                                   name="usuarioBonus"
                                   value="${bonus.usuario.id_usuario}">

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
