<%-- 
    Document   : CadastroTransacao
    Created on : 8 de jun de 2026, 14:45:37
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
        <title>Cadastro de Transação</title>
    </head>

    <%@include file="Menu.jsp" %>

    <body>

        <h1>Cadastro Transação</h1>

        <form name="cadastro"
              method="get"
              action="${pageContext.request.contextPath}${URL_BASE}/TransacaoControlador">

            <input type="hidden" name="opcao" value="${opcao}">
            <input type="hidden" name="idTransacao" value="${idTransacao}">

            <p>
                <label>Valor:</label>
                <input type="text"
                       name="valorTransacao"
                       required=""
                       value="${valorTransacao}"
                       size="10"/>
            </p>

            <p>
                <label>Tipo:</label>
                <input type="text"
                       name="tipoTransacao"
                       required=""
                       value="${tipoTransacao}"
                       size="20"/>
            </p>

            <p>
                <label>Data:</label>
                <input type="date"
                       name="dataTransacao"
                       required=""
                       value="${dataTransacao}"/>
            </p>

            <div class="area-botoes">

                <input type="submit"
                       value="Salvar"
                       name="Salvar">

                <a class="btn-link"
                   href="${pageContext.request.contextPath}${URL_BASE}/TransacaoControlador?opcao=cancelar">
                    Cancelar
                </a>

            </div>

        </form>

        <h3>${mensagem}</h3>

        <table border="1">

            <c:if test="${not empty listaTransacao}">
                <tr>
                    <th>ID</th>
                    <th>VALOR</th>
                    <th>TIPO</th>
                    <th>DATA</th>
                    <th>ALTERAR</th>
                    <th>EXCLUIR</th>
                </tr>
            </c:if>

            <c:forEach var="transacoes" items="${listaTransacao}">

                <tr>

                    <td>${transacoes.id_transacao}</td>
                    <td>${transacoes.valor}</td>
                    <td>${transacoes.tipo}</td>
                    <td>${transacoes.data}</td>

                    <td>

                        <form method="get"
                              action="${pageContext.request.contextPath}${URL_BASE}/TransacaoControlador">

                            <input type="hidden"
                                   name="idTransacao"
                                   value="${transacoes.id_transacao}">

                            <input type="hidden"
                                   name="valorTransacao"
                                   value="${transacoes.valor}">

                            <input type="hidden"
                                   name="tipoTransacao"
                                   value="${transacoes.tipo}">

                            <input type="hidden"
                                   name="dataTransacao"
                                   value="${transacoes.data}">

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
                              action="${pageContext.request.contextPath}${URL_BASE}/TransacaoControlador">

                            <input type="hidden"
                                   name="idTransacao"
                                   value="${transacoes.id_transacao}">

                            <input type="hidden"
                                   name="valorTransacao"
                                   value="${transacoes.valor}">

                            <input type="hidden"
                                   name="tipoTransacao"
                                   value="${transacoes.tipo}">

                            <input type="hidden"
                                   name="dataTransacao"
                                   value="${transacoes.data}">

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