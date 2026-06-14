<%-- 
    Document   : CadastroDeposito
    Created on : 14 de jun. de 2026, 17:51:43
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
        <title>Cadastro de Depósito</title>
    </head>

    <%@include file="Menu.jsp" %>

    <body>

        <h1>Cadastro Depósito</h1>

        <form name="cadastro" method="get"
              action="${pageContext.request.contextPath}${URL_BASE}/DepositoControlador">

            <input type="hidden" name="opcao" value="${opcao}">
            <input type="hidden" name="idDeposito" value="${idDeposito}">

            <p>
                <label>Data:</label>
                <input type="date"
                       name="dataDeposito"
                       required=""
                       value="${dataDeposito}" />
            </p>

            <p>
                <label>Valor Total:</label>
                <input type="text"
                       name="valorTotalDeposito"
                       required=""
                       value="${valorTotalDeposito}"
                       size="10"/>
            </p>

            <p>
                <label>Usuário:</label>

                <select name="usuarioDeposito">

                    <c:forEach var="usuarios" items="${listaUsuario}">

                        <c:choose>

                            <c:when test="${usuarios.id_usuario eq usuarioDeposito}">
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
                   href="${pageContext.request.contextPath}${URL_BASE}/DepositoControlador?opcao=cancelar">
                    Cancelar
                </a>

            </div>

        </form>

        <h3>${mensagem}</h3>

        <table border="1">

            <c:if test="${not empty listaDeposito}">
                <tr>
                    <th>ID</th>
                    <th>DATA</th>
                    <th>VALOR TOTAL</th>
                    <th>USUÁRIO</th>
                    <th>ALTERAR</th>
                    <th>EXCLUIR</th>
                </tr>
            </c:if>

            <c:forEach var="depositos" items="${listaDeposito}">

                <tr>

                    <td>${depositos.id_deposito}</td>
                    <td>${depositos.data}</td>
                    <td>${depositos.valor_total}</td>
                    <td>${depositos.usuario.nome}</td>

                    <td>

                        <form name="cadastro"
                              method="get"
                              action="${pageContext.request.contextPath}${URL_BASE}/DepositoControlador">

                            <input type="hidden"
                                   name="idDeposito"
                                   value="${depositos.id_deposito}">

                            <input type="hidden"
                                   name="dataDeposito"
                                   value="${depositos.data}">

                            <input type="hidden"
                                   name="valorTotalDeposito"
                                   value="${depositos.valor_total}">

                            <input type="hidden"
                                   name="usuarioDeposito"
                                   value="${depositos.usuario.id_usuario}">

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
                              action="${pageContext.request.contextPath}${URL_BASE}/DepositoControlador">

                            <input type="hidden"
                                   name="idDeposito"
                                   value="${depositos.id_deposito}">

                            <input type="hidden"
                                   name="dataDeposito"
                                   value="${depositos.data}">

                            <input type="hidden"
                                   name="valorTotalDeposito"
                                   value="${depositos.valor_total}">

                            <input type="hidden"
                                   name="usuarioDeposito"
                                   value="${depositos.usuario.id_usuario}">

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