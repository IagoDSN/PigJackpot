<%-- 
    Document   : CadastroSaque
    Created on : 8 de jun de 2026, 13:53:18
    Author     : 12409864678
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="Latin1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Latin1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/forms.css">
        <title>Cadastro de Saque</title>
    </head>

    <%@include file="Menu.jsp" %>

    <body>

        <h1>Cadastro Saque</h1>

        <form name="cadastro" method="get"
              action="${pageContext.request.contextPath}${URL_BASE}/SaqueControlador">

            <input type="hidden" name="opcao" value="${opcao}">
            <input type="hidden" name="idSaque" value="${idSaque}">

            <p>
                <label>Data:</label>
                <input type="date"
                       name="dataSaque"
                       required=""
                       value="${dataSaque}" />
            </p>

            <p>
                <label>Valor Total:</label>
                <input type="text"
                       name="valorTotalSaque"
                       required=""
                       value="${valorTotalSaque}"
                       size="10"/>
            </p>

            <p>
                <label>Usuário:</label>

                <select name="usuarioSaque">

                    <c:forEach var="usuarios" items="${listaUsuario}">

                        <c:choose>

                            <c:when test="${usuarios.id_usuario eq usuarioSaque}">
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

                <input type="submit" value="Salvar" name="Salvar">

                <a class="btn-link"
                   href="${pageContext.request.contextPath}${URL_BASE}/UsuarioControlador?opcao=cancelar">
                    Cancelar
                </a>

            </div>

        </form>

        <h3>${mensagem}</h3>

        <table border="1">

            <c:if test="${not empty listaSaque}">
                <tr>
                    <th>ID</th>
                    <th>DATA</th>
                    <th>VALOR TOTAL</th>
                    <th>USUÁRIO</th>
                    <th>ALTERAR</th>
                    <th>EXCLUIR</th>
                </tr>
            </c:if>

            <c:forEach var="saques" items="${listaSaque}">

                <tr>

                    <td>${saques.id_saque}</td>
                    <td>${saques.data}</td>
                    <td>${saques.valor_total}</td>
                    <td>${saques.usuario.nome}</td>

                    <td>

                        <form name="cadastro"
                              method="get"
                              action="${pageContext.request.contextPath}${URL_BASE}/SaqueControlador">

                            <input type="hidden"
                                   name="idSaque"
                                   value="${saques.id_saque}">

                            <input type="hidden"
                                   name="dataSaque"
                                   value="${saques.data}">

                            <input type="hidden"
                                   name="valorTotalSaque"
                                   value="${saques.valor_total}">

                            <input type="hidden"
                                   name="usuarioSaque"
                                   value="${saques.usuario.id_usuario}">

                            <input type="hidden"
                                   name="opcao"
                                   value="enviarAlterar">

                            <button type="submit">
                                Alterar
                            </button>

                        </form>

                    </td>

                    <td>

                        <form name="cadastro"
                              method="get"
                              action="${pageContext.request.contextPath}${URL_BASE}/SaqueControlador">

                            <input type="hidden"
                                   name="idSaque"
                                   value="${saques.id_saque}">

                            <input type="hidden"
                                   name="dataSaque"
                                   value="${saques.data}">

                            <input type="hidden"
                                   name="valorTotalSaque"
                                   value="${saques.valor_total}">

                            <input type="hidden"
                                   name="usuarioSaque"
                                   value="${saques.usuario.id_usuario}">

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