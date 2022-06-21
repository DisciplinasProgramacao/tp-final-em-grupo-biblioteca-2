package Business;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {

	protected String nome;
	protected String matricula;
	protected boolean livro;
	protected List <String>listaDeLivroDoUsuario;
	public Usuario(String nome, String matricula) {
	
		this.nome = nome;
		this.matricula = matricula;
		this.livro=false;
		listaDeLivroDoUsuario=new ArrayList<>();
	}
	public abstract boolean atrasado(Data dataAtual,Data devolucao);
	@Override
	public String toString() {
		String aux="";
		for (String a:listaDeLivroDoUsuario)
		{
			aux+=a;
		}
		
		return "Usuario [nome=" + nome + ", matricula=" + matricula + ", listaDeLivroDoUsuario=" + aux
				+ "]";
	}
	
	
}
