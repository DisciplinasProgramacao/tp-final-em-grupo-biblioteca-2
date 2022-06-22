package Business;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {

	protected String nome;
	protected List<Livro> livros;
	protected List<Data> datas;
	protected static int codigo;
	protected int matricula;
	public Usuario(String nome) {

		this.nome = nome;
		this.matricula=++codigo;
		this.livros = new ArrayList<>();
		this.datas = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}

	public abstract boolean atrasado(Data dataAtual, Data devolucao);

	public List<Data> getDatas() {
		return datas;
	}

}
