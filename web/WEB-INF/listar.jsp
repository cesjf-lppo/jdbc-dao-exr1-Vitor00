
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de anuncios</title>
    </head>
    <body>
        <h1>Lista de anuncios</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>PREÇO</th>
                    <th>NOME</th>
                    <th>DESCRIÇÃO</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${anuncios}" var="anuncio">
                    <tr>
                        <td>${anuncio.id}</td>
                        <td>${anuncio.preco}</td>
                        <td>${anuncio.nome}</td>
                        <td>${anuncio.descricao}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
