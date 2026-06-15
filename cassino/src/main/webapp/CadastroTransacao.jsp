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

        <form name="cadastro" method="get"
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
                       value="${dataTransacao}" />
            </p>

            <p>
                <label>Usuário:</label>

                <select name="usuarioTransacao">

                    <c:forEach var="usuarios" items="${listaUsuario}">

                        <c:choose>

                            <c:when test="${usuarios.id_usuario eq usuarioTransacao}">
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
                    <th>USUÁRIO</th>
                    <th>ALTERAR</th>
                    <th>EXCLUIR</th>
                </tr>
            </c:if>

            <c:forEach var="transacao" items="${listaTransacao}">

                <tr>

                    <td>${transacao.id_transacao}</td>
                    <td>${transacao.valor}</td>
                    <td>${transacao.tipo}</td>
                    <td>${transacao.data}</td>
                    <td>${transacao.usuario.nome}</td>

                    <td>

                        <form method="get"
                              action="${pageContext.request.contextPath}${URL_BASE}/TransacaoControlador">

                            <input type="hidden"
                                   name="idTransacao"
                                   value="${transacao.id_transacao}">

                            <input type="hidden"
                                   name="valorTransacao"
                                   value="${transacao.valor}">

                            <input type="hidden"
                                   name="tipoTransacao"
                                   value="${transacao.tipo}">

                            <input type="hidden"
                                   name="dataTransacao"
                                   value="${transacao.data}">

                            <input type="hidden"
                                   name="usuarioTransacao"
                                   value="${transacao.usuario.id_usuario}">

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
                                   value="${transacao.id_transacao}">

                            <input type="hidden"
                                   name="valorTransacao"
                                   value="${transacao.valor}">

                            <input type="hidden"
                                   name="tipoTransacao"
                                   value="${transacao.tipo}">

                            <input type="hidden"
                                   name="dataTransacao"
                                   value="${transacao.data}">

                            <input type="hidden"
                                   name="usuarioTransacao"
                                   value="${transacao.usuario.id_usuario}">

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

    <footer class="footer-cassino">
            <div class="footer-conteudo">
                <div>
                    <h2>Pig Jackpot</h2>
                </div>
                <div>
                    <ul>
                        <li><a href="#">Home</a></li>
                    </ul>
                </div>
                <div>
                    <div class="footer-redes">
                        <a href="https://instagram.com/seuUsuario" target="_blank">
                            <img class="redes" src="${pageContext.request.contextPath}/assets/instagram.png">
                        </a>
                        <a href="https://github.com/IagoDSN/PigJackpot" target="_blank">
                            <img class="redes" src="${pageContext.request.contextPath}/assets/github.png">
                        </a>
                    </div>
                </div>
            </div>
            <div class="footer-copy">
                © 2026 Pig Jackpot - Todos os direitos reservados.
            </div>
        </footer>
    </body>
</html>