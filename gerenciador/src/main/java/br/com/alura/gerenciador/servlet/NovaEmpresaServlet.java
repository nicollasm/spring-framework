package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet(urlPatterns = { "/novaEmpresa" })
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");

		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");

		Date dataAbertura;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);

		Banco banco = new Banco();
		banco.adiciona(empresa);

		request.setAttribute("empresa", empresa.getNome());

		// redirecionando pelo navegador(client side)
		response.sendRedirect("listaEmpresas");

		// chamando o .JSP
//        RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//        request.setAttribute("empresa", empresa.getNome());
//        rd.forward(request, response);

	}

}
