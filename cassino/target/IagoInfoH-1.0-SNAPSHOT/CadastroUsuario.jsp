<%--
Document : CadastroCidade
Created on : 2 de mar de 2026, 14:17:10
Author : 02338079698
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="Latin1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Latin1">
        <title>Cadastro de Usuários</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
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
        <h1>Cadastro de Usuários</h1>

        <form name="cadastro" method="get" 
              action="${pageContext.request.contextPath}${URL_BASE}/UsuarioControlador">

            <input type="hidden" id="opcao" name="opcao" value="${opcao}">
            <input type="hidden" name="id_usuario" value="${id_usuario}">

            <p><label>Nome:</label> <input type="text" name="nome" required value="${nome}" size="40"></p>
            <p><label>Senha:</label> <input type="password" name="senha" required value="${senha}" size="20"></p>
            <p><label>Email:</label> <input type="email" name="email" required value="${email}" size="40"></p>
            <p><label>Endereço:</label> <input type="text" name="endereco" required value="${endereco}" size="50"></p>
            <p><label>CPF:</label> <input type="text" name="cpf" required value="${cpf}" size="15"></p>
            <p><label>Nascimento:</label> <input type="date" name="dataNascimento" required value="${dataNascimento}"></p>
            <p><label>Data Cadastro:</label> <input type="date" name="data_cadastro" required value="${data_cadastro}"></p>

            <input type="submit" value="Salvar" name="Salvar" style="float:left; margin-right: 3px">
        </form>

        <form id="cadastroForm" name="cancelar" method="get" action="${pageContext.request.contextPath}${URL_BASE}/UsuarioControlador">
            <input type="hidden" name="opcao" value="cancelar">
            <input type="submit" value="Cancelar" name="btnCancelar">
        </form>    

        <hr>
        <h3>${mensagem}</h3>
        <table border="1">
            <c:if test="${not empty usuarios}">
                <tr bgcolor="#eeeeee">
                    <th>ID</th>
                    <th>NOME</th>
                    <th>SENHA</th>
                    <th>EMAIL</th>
                    <th>CPF</th>
                    <th>ENDEREÇO</th>
                    <th>NASCIMENTO</th>
                    <th>CADASTRO</th>
                    <th>ALTERAR</th>
                    <th>EXCLUIR</th>
                </tr>
            </c:if>

            <c:forEach var="u" items="${usuarios}">
                <tr>
                    <td>${u.id_usuario}</td>
                    <td>${u.nome}</td>
                    <td>${u.senha}</td>
                    <td>${u.email}</td>
                    <td>${u.cpf}</td>
                    <td>${u.endereco}</td>
                    <td>${u.dataNascimento}</td>
                    <td>${u.data_cadastro}</td>

                    <td>
                        <form method="get" action="${pageContext.request.contextPath}${URL_BASE}/UsuarioControlador">
                            <input type="hidden" name="id_usuario" value="${u.id_usuario}">
                            <input type="hidden" name="nome" value="${u.nome}">
                            <input type="hidden" name="senha" value="${u.senha}">
                            <input type="hidden" name="email" value="${u.email}">
                            <input type="hidden" name="endereco" value="${u.endereco}">
                            <input type="hidden" name="cpf" value="${u.cpf}">
                            <input type="hidden" name="dataNascimento" value="${u.dataNascimento}">
                            <input type="hidden" name="data_cadastro" value="${u.data_cadastro}">
                            <input type="hidden" name="opcao" value="enviarAlterar">
                            <button type="submit">Alterar</button>
                        </form>
                    </td>

                    <td>
                        <form method="get" action="${pageContext.request.contextPath}${URL_BASE}/UsuarioControlador">
                            <input type="hidden" name="id_usuario" value="${u.id_usuario}">
                            <input type="hidden" name="nome" value="${u.nome}">
                            <input type="hidden" name="senha" value="${u.senha}">
                            <input type="hidden" name="email" value="${u.email}">
                            <input type="hidden" name="endereco" value="${u.endereco}">
                            <input type="hidden" name="cpf" value="${u.cpf}">
                            <input type="hidden" name="dataNascimento" value="${u.dataNascimento}">
                            <input type="hidden" name="data_cadastro" value="${u.data_cadastro}">
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