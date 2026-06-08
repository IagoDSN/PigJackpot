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
        <title>Cadastro de Saque</title>
    </head>

    <%@include file="Menu.jsp" %>

    <body>
        <h1>Cadastro de Saque</h1>

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
                       size="10" />
            </p>

            <input type="submit"
                   value="Salvar"
                   name="Salvar"
                   style="float:left; margin-right: 3px">
        </form>

        <form id="cadastroForm"
              name="cadastro"
              method="get"
              action="${pageContext.request.contextPath}${URL_BASE}/SaqueControlador">

            <input type="submit" value="Cancelar" name="btnCancelar">
            <input type="hidden" name="opcao" value="cancelar">

        </form>

        <h3>${mensagem}</h3>

        <table border="1">

            <c:if test="${not empty listaSaque}">
                <tr>
                    <th>ID</th>
                    <th>DATA</th>
                    <th>VALOR TOTAL</th>
                    <th>ALTERAR</th>
                    <th>EXCLUIR</th>
                </tr>
            </c:if>

            <c:forEach var="saques" items="${listaSaque}">
                <tr>

                    <td>${saques.id_saque}</td>
                    <td>${saques.data}</td>
                    <td>${saques.valor_total}</td>

                    <td>
                        <form method="get"
                              action="${pageContext.request.contextPath}${URL_BASE}/SaqueControlador">

                            <input type="hidden" name="idSaque"
                                   value="${saques.id_saque}">

                            <input type="hidden" name="dataSaque"
                                   value="${saques.data}">

                            <input type="hidden" name="valorTotalSaque"
                                   value="${saques.valor_total}">

                            <input type="hidden" name="opcao"
                                   value="enviarAlterar">

                            <button type="submit">Alterar</button>

                        </form>
                    </td>

                    <td>
                        <form method="get"
                              action="${pageContext.request.contextPath}${URL_BASE}/SaqueControlador">

                            <input type="hidden" name="idSaque"
                                   value="${saques.id_saque}">

                            <input type="hidden" name="dataSaque"
                                   value="${saques.data}">

                            <input type="hidden" name="valorTotalSaque"
                                   value="${saques.valor_total}">

                            <input type="hidden" name="opcao"
                                   value="enviarExcluir">

                            <button type="submit">Excluir</button>

                        </form>
                    </td>

                </tr>
            </c:forEach>

        </table>
    </body>
</html>