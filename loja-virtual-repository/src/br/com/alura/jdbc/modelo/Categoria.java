package br.com.alura.jdbc.modelo;

public class Categoria {

	private Integer id;
	private String nome;
	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	
	}

	public Object getNome() {
		return nome;
	}
	
}
