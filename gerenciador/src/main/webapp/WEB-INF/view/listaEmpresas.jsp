<%@ page language="java" contentType="text/html; ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:import url="logout-parcial.jsp"/>


<!DOCTYPE hmtl>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>
	Usuario Logado: ${usuarioLogado.login }

	<br>
	<br>
	<c:if test="${not empty empresa}">
            Empresa ${ empresa } cadastrada com sucesso!
        </c:if>

	Lista de empresas:
	<br />

	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.nome}
				-
				<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />
				<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">editar</a>
				<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">remover</a>
			</li>

		</c:forEach>
	</ul>

</body>
</html>