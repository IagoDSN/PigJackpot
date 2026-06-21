<%-- 
    Document   : CadastroAposta
    Created on : 21 de jun. de 2026, 16:47:42
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
        <title>Cadastro de Aposta</title>
    </head>

    <%@include file="Menu.jsp" %>

    <body>

        <h1>Cadastro Aposta</h1>

        <form name="cadastro"
              method="get"
              action="${pageContext.request.contextPath}${URL_BASE}/ApostaControlador">

            <input type="hidden" name="opcao" value="${opcao}">
            <input type="hidden" name="idAposta" value="${idAposta}">

            <p>
                <label>Valor:</label>
                <input type="number"
                       name="valorAposta"
                       required=""
                       value="${valorAposta}"
                       size="10"/>
            </p>

            <p>
                <label>Resultado:</label>
                <input type="text"
                       name="resultadoAposta"
                       required=""
                       value="${resultadoAposta}"
                       size="30"/>
            </p>

            <p>
                <label>Partida:</label>

                <select name="partidaAposta">

                    <c:forEach var="partidas" items="${listaPartida}">

                        <c:choose>

                            <c:when test="${partidas.id_partida eq partidaAposta}">
                                <option selected=""
                                        value="${partidas.id_partida}">
                                    ${partidas.id_partida} - ${partidas.jogo.nome}
                                </option>
                            </c:when>

                            <c:otherwise>
                                <option value="${partidas.id_partida}">
                                    ${partidas.id_partida} - ${partidas.jogo.nome}
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
                   href="${pageContext.request.contextPath}${URL_BASE}/ApostaControlador?opcao=cancelar">
                    Cancelar
                </a>

            </div>

        </form>

        <h3>${mensagem}</h3>

        <table border="1">

            <c:if test="${not empty listaAposta}">
                <tr>
                    <th>ID</th>
                    <th>VALOR</th>
                    <th>RESULTADO</th>
                    <th>PARTIDA</th>
                    <th>ALTERAR</th>
                    <th>EXCLUIR</th>
                </tr>
            </c:if>

            <c:forEach var="apostas" items="${listaAposta}">

                <tr>

                    <td>${apostas.id_aposta}</td>
                    <td>${apostas.valor}</td>
                    <td>${apostas.resultado}</td>
                    <td>${apostas.partida.id_partida}</td>

                    <td>

                        <form method="get"
                              action="${pageContext.request.contextPath}${URL_BASE}/ApostaControlador">

                            <input type="hidden"
                                   name="idAposta"
                                   value="${apostas.id_aposta}">

                            <input type="hidden"
                                   name="valorAposta"
                                   value="${apostas.valor}">

                            <input type="hidden"
                                   name="resultadoAposta"
                                   value="${apostas.resultado}">

                            <input type="hidden"
                                   name="partidaAposta"
                                   value="${apostas.partida.id_partida}">

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
                              action="${pageContext.request.contextPath}${URL_BASE}/ApostaControlador">

                            <input type="hidden"
                                   name="idAposta"
                                   value="${apostas.id_aposta}">

                            <input type="hidden"
                                   name="valorAposta"
                                   value="${apostas.valor}">

                            <input type="hidden"
                                   name="resultadoAposta"
                                   value="${apostas.resultado}">

                            <input type="hidden"
                                   name="partidaAposta"
                                   value="${apostas.partida.id_partida}">

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
