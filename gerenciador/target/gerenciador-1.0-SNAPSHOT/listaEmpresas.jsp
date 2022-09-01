<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page
        import="java.util.List, br.com.alura.gerenciador.servlet.Empresa" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Lista de empresas cadastradas</title>
</head>
<body>
<h3>Empresas cadastradas:</h3>
<ul>
    <%
        List<Empresa> lista = (List<Empresa>) request.getAttribute("listaEmpresas");
        for (Empresa empresa : lista) {
    %>
    <li><%=empresa.getNome()%>
    </li>
    <%
        }
    %>
</ul>
</body>
</html>