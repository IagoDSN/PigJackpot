<%-- 
    Document   : CadastroCarteira
    Created on : 14 de jun. de 2026, 17:25:38
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
        <title>Cadastro de Carteira</title>
    </head>

    <%@include file="Menu.jsp" %>

    <body>

        <h1>Cadastro Carteira</h1>

        <form name="cadastro" method="get"
              action="${pageContext.request.contextPath}${URL_BASE}/CarteiraControlador">

            <input type="hidden" name="opcao" value="${opcao}">
            <input type="hidden" name="idCarteira" value="${idCarteira}">

            <p>
                <label>Saldo:</label>
                <input type="number"
                       name="saldoCarteira"
                       required=""
                       value="${saldoCarteira}"
                       size="10"/>
            </p>

            <p>
                <label>Usuário:</label>

                <select name="usuarioCarteira">

                    <c:forEach var="usuarios" items="${listaUsuario}">

                        <c:choose>

                            <c:when test="${usuarios.id_usuario eq usuarioCarteira}">
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
                   href="${pageContext.request.contextPath}${URL_BASE}/CarteiraControlador?opcao=cancelar">
                    Cancelar
                </a>

            </div>

        </form>

        <h3>${mensagem}</h3>

        <table border="1">

            <c:if test="${not empty listaCarteira}">
                <tr>
                    <th>ID</th>
                    <th>SALDO</th>
                    <th>USUÁRIO</th>
                    <th>ALTERAR</th>
                    <th>EXCLUIR</th>
                </tr>
            </c:if>

            <c:forEach var="carteiras" items="${listaCarteira}">

                <tr>

                    <td>${carteiras.id_carteira}</td>
                    <td>${carteiras.saldo}</td>
                    <td>${carteiras.usuario.nome}</td>

                    <td>

                        <form name="cadastro"
                              method="get"
                              action="${pageContext.request.contextPath}${URL_BASE}/CarteiraControlador">

                            <input type="hidden"
                                   name="idCarteira"
                                   value="${carteiras.id_carteira}">

                            <input type="hidden"
                                   name="saldoCarteira"
                                   value="${carteiras.saldo}">

                            <input type="hidden"
                                   name="usuarioCarteira"
                                   value="${carteiras.usuario.id_usuario}">

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
                              action="${pageContext.request.contextPath}${URL_BASE}/CarteiraControlador">

                            <input type="hidden"
                                   name="idCarteira"
                                   value="${carteiras.id_carteira}">

                            <input type="hidden"
                                   name="saldoCarteira"
                                   value="${carteiras.saldo}">

                            <input type="hidden"
                                   name="usuarioCarteira"
                                   value="${carteiras.usuario.id_usuario}">

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