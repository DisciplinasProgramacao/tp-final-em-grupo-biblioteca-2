package Business;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	protected List<Livro> livros;
	protected List<Usuario> usuarios;

	public Biblioteca() {
		livros = new ArrayList<>();
		usuarios = new ArrayList<>();
	}

	public void adicionaLivro(Livro livro) {
		this.livros.add(livro);
	}

	public void cadastraUsuario(Usuario usuario) {
		this.usuarios.add(usuario);

	}

	@Override
	public String toString() {
		String aux = "";
		for (Usuario a : this.usuarios) {
			aux = "[" + Usuario.codigo + "] " + a.nome;
			for (Livro l : a.livros) {
				aux += "\nLivros do usuario" + l.nome;
			}
			if (a instanceof AlunoDeGraduacao) {
				aux += "\n";
				aux += ((AlunoDeGraduacao) a).diasSuspenso;

			}

		}
		return aux;
	}

}
