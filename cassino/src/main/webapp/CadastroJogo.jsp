<%-- 
    Document   : CadastroJogo
    Created on : 12 de abr. de 2026, 15:23:01
    Author     : Iagod
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="Latin1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Latin1">
        <title>Cadastro de Jogos</title>
        <style>
            label {
                display: inline-block;
                width: 120px;
            }
            form {
                margin-bottom: 20px;
            }
            table {
                width: 100%;
                margin-top: 20px;
                border-collapse: collapse;
            }
            th, td {
                padding: 8px;
                text-align: left;
            }
        </style>
    </head>
    <body>
        <%@include file="Menu.jsp" %>
        <h1>Cadastro de Jogos</h1>


        <form name="cadastro" method="get" 
              action="${pageContext.request.contextPath}${URL_BASE}/JogoControlador">

            <input type="hidden" id="opcao" name="opcao" value="${opcao}">
            <input type="hidden" name="id_jogo" value="${id_jogo}">

            <p><label>Nome do Jogo:</label> <input type="text" name="nome" required value="${nome}" size="40"></p>
            <p><label>Tipo/Gênero:</label> <input type="text" name="tipo" required value="${tipo}" size="20"></p>
            <p><label>Descrição:</label> <input type="text" name="descricao" required value="${descricao}" size="60"></p>

            <input type="submit" value="Salvar" name="Salvar" style="float:left; margin-right: 3px">
        </form>

        <form id="cadastroForm" name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/JogoControlador">
            <input type="submit" value="Cancelar" name="btnCancelar">
            <input type="hidden" name="opcao" value="cancelar">
        </form>    

        <h3>${mensagem}</h3>

        <table border="1">
            <c:if test="${not empty jogos}">
                <tr>
                    <th>CÓDIGO</th>
                    <th>NOME</th>
                    <th>TIPO</th>
                    <th>DESCRIÇÃO</th>
                    <th>ALTERAR</th>
                    <th>EXCLUIR</th>
                </tr>
            </c:if>

            <c:forEach var="j" items="${jogos}">
                <tr>
                    <td>${j.id_jogo}</td>
                    <td>${j.nome}</td>
                    <td>${j.tipo}</td>
                    <td>${j.descricao}</td>
                    <td>
                        <%-- Formulário de Alterar na Tabela --%>
                        <form name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/JogoControlador">
                            <input type="hidden" name="id_jogo" value="${j.id_jogo}">
                            <input type="hidden" name="nome" value="${j.nome}">
                            <input type="hidden" name="tipo" value="${j.tipo}">
                            <input type="hidden" name="descricao" value="${j.descricao}">
                            <input type="hidden" name="opcao" value="enviarAlterar">
                            <button type="submit">Alterar</button>
                        </form>
                    </td>
                    <td>
                        <form name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/JogoControlador">
                            <input type="hidden" name="id_jogo" value="${j.id_jogo}">
                            <input type="hidden" name="nome" value="${j.nome}">
                            <input type="hidden" name="tipo" value="${j.tipo}">
                            <input type="hidden" name="descricao" value="${j.descricao}">
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
