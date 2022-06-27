package Business;

public class EmprestimoDigital extends Emprestimo {

	public EmprestimoDigital() {

	}

	public void realizarEmprestimo(Usuario usuario, LivroDigital livro) {
		usuario.livros.add(livro);
	}

}
