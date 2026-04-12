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
        <style>
            label { display: inline-block; width: 120px; }
            form { margin-bottom: 20px; }
            table { width: 100%; margin-top: 20px; border-collapse: collapse; }
            th, td { padding: 8px; text-align: left; }
        </style>
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

            <input type="submit" value="Salvar" name="Salvar" style="float:left; margin-right: 3px">
        </form>
            
        <%-- BOTÃO CANCELAR --%>
        <form id="cadastroForm" name="cancelar" method="get" action="${pageContext.request.contextPath}${URL_BASE}/ConquistaControlador">
            <input type="hidden" name="opcao" value="cancelar">
            <input type="submit" value="Cancelar" name="btnCancelar">
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
    </body>
</html>