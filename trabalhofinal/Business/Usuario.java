package Business;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {

	protected String nome;
	protected List<Livro> livros;
	protected List<Data> datas;
	protected static int codigo;
	protected int matricula;
	protected Data dataDeRealizacao;
	protected Data dataDeDevolucao;

	public Usuario(String nome, Data dataDeRealizacao) {

		this.nome = nome;
		this.matricula = ++codigo;
		this.livros = new ArrayList<>();
		this.datas = new ArrayList<>();
		this.dataDeRealizacao = dataDeRealizacao;
		this.dataDeDevolucao = dataDeRealizacao;
	}

	public String getNome() {
		return nome;
	}

	public abstract boolean atrasado(Data dataAtual, Data devolucao);

	public List<Data> getDatas() {
		return datas;
	}

	public Data getDataDeRealizacao() {
		return dataDeRealizacao;
	}

	public Data getDataDeDevolucao() {
		return dataDeDevolucao;
	}

	public abstract void addEmprestimo(LivroFisico livro);

	@Override
	public String toString() {
		String aux = "";
		for (Livro l : livros) {
			aux += l.getNome() + ",";
		}
		return "Usuario livros=" + aux;
	}

}
