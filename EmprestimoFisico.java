package Business;

public class EmprestimoFisico extends Emprestimo {
	protected boolean temLivro;

	public EmprestimoFisico(Data dataDeRealizacao) {
		super(dataDeRealizacao);
		this.temLivro = false;
	}

	public void realizarEmprestimo(Usuario usuario, LivroFisico livro) {
		
		
			if (usuario instanceof Professores) {
				this.dataDeDevolucao = this.dataDeDevolucao.acrescentaDias(14);
				this.temLivro = true;
				livro.status = true;
				usuario.livros.add(livro);
				usuario.datas.add(dataDeRealizacao);
			} else if (usuario instanceof AlunoDeGraduacao || usuario instanceof AlunoDePosGraduacao) {
				this.dataDeDevolucao = this.dataDeDevolucao.acrescentaDias(7);
				this.temLivro = true;
				System.out.println("a"+this.dataDeRealizacao.dataFormatada());
				System.out.println("b"+this.dataDeDevolucao.dataFormatada());
				livro.status = true;
				usuario.livros.add(livro);
				usuario.datas.add(dataDeRealizacao);
			}
		
	}

	public void renovarEmprestimo(Usuario usuario, LivroFisico livro, Data atual) {
		if (this.temLivro) {
			if (usuario.atrasado(dataDeRealizacao, atual)) {
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
			usuario.atrasado(this.dataDeRealizacao, atual);
		}
	}

}
