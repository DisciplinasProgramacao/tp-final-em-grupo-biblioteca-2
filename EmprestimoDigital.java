package Business;

public class EmprestimoDigital extends Emprestimo {

	public EmprestimoDigital(Data dataDeRealizacao) {
		super(dataDeRealizacao);

	}

	public void realizarEmprestimo(Usuario usuario, LivroDigital livro) {
		usuario.livros.add(livro);
	}

}
