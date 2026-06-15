<%-- 
    Document   : CadastroPartida
    Created on : 15 de jun de 2026, 13:46:31
    Author     : 13410289682
--%>

<%-- 
    Document   : CadastroPartida
    Created on : 15 de jun de 2026
    Author     : Iago
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="Latin1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Latin1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/forms.css">
        <title>Cadastro de Partida</title>
    </head>

    <%@include file="Menu.jsp" %>

    <body>

        <h1>Cadastro Partida</h1>

        <form name="cadastro" method="get"
              action="${pageContext.request.contextPath}${URL_BASE}/PartidaControlador">

            <input type="hidden" name="opcao" value="${opcao}">
            <input type="hidden" name="idPartida" value="${idPartida}">

            <p>
                <label>Data:</label>
                <input type="date"
                       name="dataPartida"
                       required=""
                       value="${dataPartida}" />
            </p>

            <p>
                <label>Resultado:</label>
                <input type="text"
                       name="resultadoPartida"
                       required=""
                       value="${resultadoPartida}"
                       size="30"/>
            </p>

            <p>
                <label>Usuário:</label>

                <select name="usuarioPartida">

                    <c:forEach var="usuarios" items="${listaUsuario}">

                        <c:choose>

                            <c:when test="${usuarios.id_usuario eq usuarioPartida}">
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

            <p>
                <label>Jogo:</label>

                <select name="jogoPartida">

                    <c:forEach var="jogos" items="${listaJogo}">

                        <c:choose>

                            <c:when test="${jogos.id_jogo eq jogoPartida}">
                                <option selected=""
                                        value="${jogos.id_jogo}">
                                    ${jogos.nome}
                                </option>
                            </c:when>

                            <c:otherwise>
                                <option value="${jogos.id_jogo}">
                                    ${jogos.nome}
                                </option>
                            </c:otherwise>

                        </c:choose>

                    </c:forEach>

                </select>

            </p>

            <div class="area-botoes">

                <input type="submit" value="Salvar" name="Salvar">

                <a class="btn-link"
                   href="${pageContext.request.contextPath}${URL_BASE}/PartidaControlador?opcao=cancelar">
                    Cancelar
                </a>

            </div>

        </form>

        <h3>${mensagem}</h3>

        <table border="1">

            <c:if test="${not empty listaPartida}">
                <tr>
                    <th>ID</th>
                    <th>DATA</th>
                    <th>RESULTADO</th>
                    <th>USUÁRIO</th>
                    <th>JOGO</th>
                    <th>ALTERAR</th>
                    <th>EXCLUIR</th>
                </tr>
            </c:if>

            <c:forEach var="partidas" items="${listaPartida}">

                <tr>

                    <td>${partidas.id_partida}</td>
                    <td>${partidas.data}</td>
                    <td>${partidas.resultado}</td>
                    <td>${partidas.usuario.nome}</td>
                    <td>${partidas.jogo.nome}</td>

                    <td>

                        <form method="get"
                              action="${pageContext.request.contextPath}${URL_BASE}/PartidaControlador">

                            <input type="hidden"
                                   name="idPartida"
                                   value="${partidas.id_partida}">

                            <input type="hidden"
                                   name="dataPartida"
                                   value="${partidas.data}">

                            <input type="hidden"
                                   name="resultadoPartida"
                                   value="${partidas.resultado}">

                            <input type="hidden"
                                   name="usuarioPartida"
                                   value="${partidas.usuario.id_usuario}">

                            <input type="hidden"
                                   name="jogoPartida"
                                   value="${partidas.jogo.id_jogo}">

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
                              action="${pageContext.request.contextPath}${URL_BASE}/PartidaControlador">

                            <input type="hidden"
                                   name="idPartida"
                                   value="${partidas.id_partida}">

                            <input type="hidden"
                                   name="dataPartida"
                                   value="${partidas.data}">

                            <input type="hidden"
                                   name="resultadoPartida"
                                   value="${partidas.resultado}">

                            <input type="hidden"
                                   name="usuarioPartida"
                                   value="${partidas.usuario.id_usuario}">

                            <input type="hidden"
                                   name="jogoPartida"
                                   value="${partidas.jogo.id_jogo}">

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