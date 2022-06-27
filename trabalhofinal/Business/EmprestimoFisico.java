package Business;

public class EmprestimoFisico extends Emprestimo {
	protected boolean temLivro;

	public EmprestimoFisico() {

		this.temLivro = false;
	}

	public void realizarEmprestimo(Usuario usuario, LivroFisico livro) {

		usuario.addEmprestimo(livro);
		this.temLivro = true;
		livro.status = true;

	}

	public void renovarEmprestimo(Usuario usuario, LivroFisico livro, Data atual) {
		if (this.temLivro) {
			if (usuario.atrasado(usuario.dataDeRealizacao, atual)) {
				System.out.println("nao e possivel renovar");
			} else {
				realizarEmprestimo(usuario, livro);

			}

		}
	}

	public void devolverEmprestimo(Usuario usuario, LivroFisico livro, Data atual) {
		if (this.temLivro) {
			this.temLivro = false;
			livro.status = false;
			usuario.datas.add(atual);
			usuario.atrasado(usuario.dataDeRealizacao, atual);
		}
	}

}
