package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		
//		sessao.removeAttribute("usuarioLogado"); // remove o atributo mas objeto continua na memória
		sessao.invalidate(); // remove o objeto httpsession e todos os objetos associados a ele; destroi o cookie.
		return "redirect:entrada?acao=LoginForm";
	}

}
