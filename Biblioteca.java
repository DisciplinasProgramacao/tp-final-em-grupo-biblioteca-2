package Business;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	protected List<Livro>livros;
	protected List<Usuario>usuarios;
	
	public Biblioteca()
	{
		livros=new ArrayList<>();
		usuarios=new ArrayList<>();
	}
	public void adicionaLivro(Livro livro) {
		this.livros.add(livro);
	}
	public void cadastraUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
		
	}
	@Override
	public String toString() {
		String aux="";
		String aux2="";
		for (Livro l:livros)
		{
			aux+="("+l.codigo+")"+"-"+l.nome;
		}
		for (Usuario u:usuarios)
		{
			aux2+="("+u.nome+")"+"-"+u.matricula;
		}
		return "Biblioteca [livros=" + aux + ", usuarios=" + usuarios + "]";
	}
	
}
