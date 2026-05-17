<%-- 
    Document   : CadastroConquista
    Created on : 12 de abr. de 2026, 15:10:32
    Author     : Iagod
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="Latin1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Latin1">
        <title>Cadastro de Conquistas</title>
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/forms.css">
    </head>
    <body>
        <%@include file="Menu.jsp" %>
        <h1>Cadastro de Conquistas</h1>

        <%-- FORMULÁRIO PRINCIPAL --%>
        <form name="cadastro" method="get" 
              action="${pageContext.request.contextPath}${URL_BASE}/ConquistaControlador">

            <input type="hidden" id="opcao" name="opcao" value="${opcao}">
            <input type="hidden" name="id_conquista" value="${id_conquista}">

            <p><label>Nome:</label> <input type="text" name="nome" required value="${nome}" size="40"></p>
            <p><label>Descrição:</label> <input type="text" name="descricao" required value="${descricao}" size="60"></p>
            <p><label>Recompensa:</label> <input type="number" step="0.01" name="recompensa" required value="${recompensa}" size="10"></p>

           <div class="area-botoes">

                <input type="submit" value="Salvar" name="Salvar">

                <a class="btn-link"
                   href="${pageContext.request.contextPath}${URL_BASE}/UsuarioControlador?opcao=cancelar">
                    Cancelar
                </a>

            </div>
        </form>  

        <hr>
        <h3>${mensagem}</h3>

        <%-- TABELA DE LISTAGEM --%>
        <table border="1">
            <c:if test="${not empty conquistas}">
                <tr bgcolor="#eeeeee">
                    <th>ID</th>
                    <th>NOME</th>
                    <th>DESCRIÇÃO</th>
                    <th>RECOMPENSA</th>
                    <th>ALTERAR</th>
                    <th>EXCLUIR</th>
                </tr>
            </c:if>

            <c:forEach var="c" items="${conquistas}">
                <tr>
                    <td>${c.id_conquista}</td>
                    <td>${c.nome}</td>
                    <td>${c.descricao}</td>
                    <td>${c.recompensa}</td>

                    <%-- COLUNA ALTERAR --%>
                    <td>
                        <form method="get" action="${pageContext.request.contextPath}${URL_BASE}/ConquistaControlador">
                            <input type="hidden" name="id_conquista" value="${c.id_conquista}">
                            <input type="hidden" name="nome" value="${c.nome}">
                            <input type="hidden" name="descricao" value="${c.descricao}">
                            <input type="hidden" name="recompensa" value="${c.recompensa}">
                            <input type="hidden" name="opcao" value="enviarAlterar">
                            <button type="submit">Alterar</button>
                        </form>
                    </td>

                    <%-- COLUNA EXCLUIR --%>
                    <td>
                        <form method="get" action="${pageContext.request.contextPath}${URL_BASE}/ConquistaControlador">
                            <input type="hidden" name="id_conquista" value="${c.id_conquista}">
                            <input type="hidden" name="nome" value="${c.nome}">
                            <input type="hidden" name="descricao" value="${c.descricao}">
                            <input type="hidden" name="recompensa" value="${c.recompensa}">
                            <input type="hidden" name="opcao" value="enviarExcluir">
                            <button type="submit">Excluir</button>
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